/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.xboxDrive;


public class DriveTrain extends Subsystem {

  // Define variables and actuators here as private:
  // private WPI_TalonSRX leftRearTalon;

  private final WPI_TalonSRX driveTrainleftFrontTalon;
  private final WPI_TalonSRX driveTrainleftRearTalon;
  private final WPI_TalonSRX driveTrainrightFrontTalon;
  private final WPI_TalonSRX driveTrainrightRearTalon;
  private final RobotDrive robotDrive41 = Robot.driveTrainRobotDrive41;

  public DriveTrain() {
    // Construct objects here
    // leftFrontTalon = new WPI_TalonSRX(11);

    driveTrainleftFrontTalon = new WPI_TalonSRX(12);
    driveTrainleftFrontTalon.setInverted(true);
    
    driveTrainleftRearTalon = new WPI_TalonSRX(16);
    driveTrainleftRearTalon.setInverted(true);
    
    driveTrainrightFrontTalon = new WPI_TalonSRX(15);
    driveTrainrightFrontTalon.setInverted(true);
    
    driveTrainrightRearTalon = new WPI_TalonSRX(13);
    driveTrainrightRearTalon.setInverted(true);

    RobotDrive driveTrainRobotDrive41 = new RobotDrive(driveTrainleftFrontTalon, driveTrainleftRearTalon,
        driveTrainrightFrontTalon, driveTrainrightRearTalon);
        
        driveTrainRobotDrive41.setSafetyEnabled(false);
        driveTrainRobotDrive41.setSensitivity(0.5);
        driveTrainRobotDrive41.setMaxOutput(1.0);

  }

  @Override
  public void initDefaultCommand() {
    Robot.m_driveTrain.setDefaultCommand(new xboxDrive());
  
  }

  @Override
  public void periodic() {
    // Put code here to be run every loop

  }

  public void driveBase() {
    // Arcade Drive is defined here
    if(RobotState.isAutonomous()) 
    {
       
    }
    else 
    {
      robotDrive41.arcadeDrive(Robot.m_oi.xbox.getY(),Robot.m_oi.xbox.getX());
    }
   
    // robotDrive41.isSafetyEnabled();
  }


}
