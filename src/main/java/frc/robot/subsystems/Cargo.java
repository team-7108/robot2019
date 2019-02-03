/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Cargo extends Subsystem {

  // Define variables and actuators here as private:
  // private WPI_VictorSPX cargoAngleController;7
  private SpeedController cargoJointMotor;
  private SpeedController leftCargoMotor;
  private SpeedController rightCargoMotor;

  public Cargo() {
    // Construct objects here
    // cargoController = new cargoAngleController(4);
    leftCargoMotor  = new Spark(1);
    rightCargoMotor = new Spark(2);
    cargoJointMotor = new Spark(0);

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
    leftCargoMotor.set(0.5);
    rightCargoMotor.set(0.5);
  }

  public void takeCargo() {
    // Intakes the cargo
    leftCargoMotor.set(-0.5);
    rightCargoMotor.set(-0.5);
 
  }

  public void cargoStop(){
    leftCargoMotor.set(0);
    rightCargoMotor.set(0);
  }

  public void cargoJointStop() {
    cargoJointMotor.set(0);
  }

  public void cargoRocketShip(){
    cargoJointMotor.set(-0.5);
  }
   public void humanPlayer() {
    cargoJointMotor.set(0.5);
  }

}
