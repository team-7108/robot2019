/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.xboxDrive;


public class DriveTrain extends Subsystem {

  // Define variables and actuators here as private:
  // private WPI_TalonSRX leftRearTalon;

  public DriveTrain() {
    // Construct objects here
    // leftFrontTalon = new WPI_TalonSRX(11);
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
  }


}
