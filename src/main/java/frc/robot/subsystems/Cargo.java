/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Cargo extends Subsystem {

  // Define variables and actuators here as private:
  // private WPI_VictorSPX cargoAngleController;7
  private WPI_VictorSPX snowBlower;
  private SpeedController cargoMotor1;
  private SpeedController cargoMotor2;

  public Cargo() {
    // Construct objects here
    // cargoController = new cargoAngleController(4);
    snowBlower = new WPI_VictorSPX(3);
    cargoMotor1 = new Spark(11);
    cargoMotor1.setInverted(false);
    cargoMotor2 = new Spark(14);
    cargoMotor2.setInverted(false);

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
    cargoMotor1.set(0.5);
    cargoMotor2.set(0.5);
  }

  public void takeCargo() {
    // Intakes the cargo
    cargoMotor2.set(-0.5);
    cargoMotor1.set(-0.5);

  }
  public void cargoStop(){
    snowBlower.set(0);
    cargoMotor1.set(0);
    cargoMotor2.set(0);
  } 
  public void cargoRocketShip(){
    snowBlower.set(-1);
  }
   public void humanPlayer() {
    snowBlower.set(1);
  }




}
