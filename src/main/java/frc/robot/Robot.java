package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.Autonomous;
import frc.robot.commands.releaseHatch;
import frc.robot.commands.takeHatch;
import frc.robot.subsystems.Cargo;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hatch;
import frc.robot.utils.SoundTrigger;


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
  NetworkTableInstance inst = NetworkTableInstance.getDefault();
  NetworkTable table = inst.getTable("datatable");
  NetworkTableEntry roboState;
  NetworkTableEntry matchTime;
  NetworkTableEntry tymeButton;
  public static SoundTrigger sound_trigger;  
  @Override
  public void robotInit() {
    
    // Construct Subsytems
    m_cargo = new Cargo();
    m_hatch = new Hatch();
    m_climber = new Climber();
    m_driveTrain = new DriveTrain();
    sound_trigger = new SoundTrigger();
    // Construct OI
    m_oi = new OI();
    
    Robot.m_hatch.closeCompressor();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
    roboState = table.getEntry("roboState");
    roboState.setString("no");
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {



  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    
    roboState = table.getEntry("roboState");
    roboState.setString("teleop");
    // matchTime.setDouble(0);
    m_hatch.openCompressor();

  }

  @Override
  public void teleopPeriodic() {
    
    Scheduler.getInstance().run();
  
    // System.out.println(matchTime);
    
    }

  @Override
  public void testPeriodic() {
  }
}
