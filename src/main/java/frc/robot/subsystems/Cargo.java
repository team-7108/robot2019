/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Cargo extends Subsystem {

  // Define variables and actuators here as private:
  // private WPI_VictorSPX cargoAngleController;7
  private SpeedController cargoJointMotor;
  private SpeedController leftCargoMotor;
  private SpeedController rightCargoMotor;
  private DigitalInput limitUp;
  private DigitalInput limitDown;
  private Counter counterUp;
  private Counter counterDown;
  public boolean upLimitSwStatus = false;
  public boolean downLimitSwStatus = false;
  NetworkTableInstance inst = NetworkTableInstance.getDefault();
  NetworkTable table = inst.getTable("datatable");
  static NetworkTableEntry upSwitch;
  static NetworkTableEntry downSwitch;
  
  public Cargo() {
    // Construct objects here
    // cargoController = new cargoAngleController(4);
    leftCargoMotor  = new Spark(1);
    rightCargoMotor = new Spark(2);
    cargoJointMotor = new Spark(0);
    limitUp = new DigitalInput(1);
    limitDown = new DigitalInput(2);
    counterUp = new Counter(limitUp);
    counterDown = new Counter(limitDown);

    upSwitch = table.getEntry("upSwitch");
    downSwitch = table.getEntry("downSwitch");

    if(counterUp.get()>0){
      upSwitch.setBoolean(true);
      upLimitSwStatus = true;
      counterUp.reset();
      upLimitSwStatus = false;
    }

    if(counterDown.get()>0){
      downSwitch.setBoolean(true);
      downLimitSwStatus = true;
      counterDown.reset();
      downLimitSwStatus = false;
    }

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
    leftCargoMotor.set(1);
    rightCargoMotor.set(1);
  }

  public void takeCargo() {
    // Intakes the cargo
    leftCargoMotor.set(-1);
    rightCargoMotor.set(-1);
 
  }

  public void cargoStop(){
    leftCargoMotor.set(0);
    rightCargoMotor.set(0);
  }

  public void cargoJointStop() {
    cargoJointMotor.set(0);
  }

  public void cargoRocketShip(){
    cargoJointMotor.set(-1);
  }
   public void humanPlayer() {
    cargoJointMotor.set(1);
  }

}
