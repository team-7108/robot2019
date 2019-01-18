package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

  // Define variables and actuators here as private:
  // private WPI_VictorSPX rearlegExtender;
  private WPI_TalonSRX liftMotor1;
  private WPI_TalonSRX liftMotor2;
  private WPI_TalonSRX liftWheelMotor;

  public Climber() {
    // Construct objects here
    // rearlegExtender = new WPI_VictorSPX(4);
    liftMotor1 = new WPI_TalonSRX(11);
    liftMotor2 = new WPI_TalonSRX(12);
    liftWheelMotor = new WPI_TalonSRX(13);

  }

  @Override
  public void initDefaultCommand() {

  }

  @Override
  public void periodic() {
    // Put code here to be run every loop

  }

  public void extendLeg() {
    // Extends the leg of climbing mechanism
    liftMotor1.set(0.5);
    liftMotor2.set(0.5);

  }

  public void retractLeg() {
    // Extends the leg of climbing mechanism
    liftMotor1.set(-0.5);
    liftMotor2.set(-0.5);

  }

  public void stopLeg(){

    liftMotor1.set(0);
    liftMotor2.set(0);
  }

  public void liftWheelForward(){

    liftWheelMotor.set(0.5);

  }

  public void liftWheelRelease(){

    liftWheelMotor.set(-0.5);

  }

  public void liftWheelStop(){

    liftWheelMotor.set(0);
    
  }

}

