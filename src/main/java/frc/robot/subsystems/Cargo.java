/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;


public class Cargo extends Subsystem {

  // Define variables and actuators here as private:
  // private WPI_VictorSPX cargoAngleController;
  private static final WPI_VictorSPX snowBlower = new WPI_VictorSPX(4);
  private static final WPI_TalonSRX cargoMotor1 = new WPI_TalonSRX(11);
  private static final WPI_TalonSRX cargoMotor2 = new WPI_TalonSRX(13);

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

  public static void setCargoPosition(double _angle) {
    // Moves the cargo to specific angle

  }

  public static void releaseCargo() {
    // Releases the cargo
    cargoMotor1.set(0.5);
    cargoMotor2.set(0.5);
  }

  public static void takeCargo() {
    // Intakes the cargo
    cargoMotor2.set(-0.5);
    cargoMotor1.set(-0.5);

  }
  public static void cargoStop(){
    snowBlower.set(0);
    cargoMotor1.set(0);
    cargoMotor2.set(0);
  } 
  public static void cargoRocketShip(){
    snowBlower.set(-1);
  }
   public static void humanPlayer() {
    snowBlower.set(1);
  }




}
