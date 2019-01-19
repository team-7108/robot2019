package frc.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.Autonomous;
import frc.robot.commands.ForTurnPIDTest;
import frc.robot.commands.releaseHatch;
import frc.robot.commands.takeHatch;
import frc.robot.sensors.NavX;
import frc.robot.subsystems.Cargo;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hatch;


public class Robot extends TimedRobot {
  Autonomous autoCG;
  
  // Define OI
  public static OI m_oi;
  // Define subsytems
  public static Cargo m_cargo;
  public static Hatch m_hatch;
  public static Climber m_climber;
  // public static RobotDrive driveTrainRobotDrive41;
  public static DriveTrain m_driveTrain;
  public static NavX m_navx;
  
  @Override
  public void robotInit() {
    
    // Construct Subsytems
    m_cargo = new Cargo();
    m_hatch = new Hatch();
    m_climber = new Climber();
    m_driveTrain = new DriveTrain();
    m_navx = new NavX();

    
    // Construct OI
    m_oi = new OI();
    autoCG = new Autonomous();
    
    Robot.m_hatch.closeCompressor();
    

  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    Scheduler.getInstance().removeAll();
    autoCG.addSequential(new ForTurnPIDTest());
    autoCG.start();
    Robot.m_navx.ahrs.reset();
    Robot.m_navx.ahrs.zeroYaw();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    
  }

  @Override
  public void teleopInit() {

   // Robot.m_hatch.openCompressor();

  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
