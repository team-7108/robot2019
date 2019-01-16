/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;


public class Cargo extends Subsystem {

  // Define variables and actuators here as private:
  // private WPI_VictorSPX cargoAngleController;


  public Cargo() {
    // Construct objects here
    // cargoController = new cargoAngleController(4);
  }
  @Override
  public void initDefaultCommand() {

  }

  @Override
  public void periodic() {

  }

  // All subsytem functions are defined here

  public void setCargoPosition(double _angle) {
    // Moves the cargo to specific angle

  }

  public void releaseCargo() {
    // Releases the cargo
  }

  public void takeCargo() {
    // Intakes the cargo

  }




}
