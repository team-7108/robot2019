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

  private WPI_TalonSRX driveTrainleftFrontTalon;
  private WPI_TalonSRX driveTrainleftRearTalon;
  private WPI_TalonSRX driveTrainrightFrontTalon;
  private WPI_TalonSRX driveTrainrightRearTalon;
  private RobotDrive robotDrive41;

  public DriveTrain() {
    // Construct objects here
    // leftFrontTalon = new WPI_TalonSRX(11);

    driveTrainleftFrontTalon = new WPI_TalonSRX(16);
    driveTrainleftFrontTalon.setInverted(true);
    
    driveTrainleftRearTalon = new WPI_TalonSRX(11);
    driveTrainleftRearTalon.setInverted(true);
    
    driveTrainrightFrontTalon = new WPI_TalonSRX(13);
    driveTrainrightFrontTalon.setInverted(true);
    
    driveTrainrightRearTalon = new WPI_TalonSRX(15);
    driveTrainrightRearTalon.setInverted(true);

    robotDrive41 = new RobotDrive(driveTrainleftFrontTalon, driveTrainleftRearTalon,
        driveTrainrightFrontTalon, driveTrainrightRearTalon);
        
        robotDrive41.setSafetyEnabled(false);
        robotDrive41.setExpiration(0.1);
        robotDrive41.setSensitivity(0.5);
        robotDrive41.setMaxOutput(1.0);

  }

  @Override
  public void initDefaultCommand() {
    Robot.m_driveTrain.setDefaultCommand(new xboxDrive());
  
  }

  @Override
  public void periodic() {
    // Put code here to be run every loop

  }
  public void autonomousTurn(double speed) 
 	{
 		// if speed is - robot goes left, else right
 		driveTrainleftFrontTalon.set(-speed);
 		driveTrainrightFrontTalon.set(-speed);
 		driveTrainleftRearTalon.set(-speed);
 		driveTrainrightRearTalon.set(-speed);
  } 
  public void autonomousStop() 
  {
  // if speed is - robot goes left, else right
  driveTrainleftFrontTalon.set(0);
  driveTrainrightFrontTalon.set(0);
  driveTrainleftRearTalon.set(0);
  driveTrainrightRearTalon.set(0);
  }

  public void driveBase() {
    // Arcade Drive is defined here
    if(RobotState.isAutonomous()) 
    {
       
    }
    else 
    {
      robotDrive41.arcadeDrive(Robot.m_oi.logitech.getY(),Robot.m_oi.logitech.getX());
    }
   
    // robotDrive41.isSafetyEnabled();
  }


}
