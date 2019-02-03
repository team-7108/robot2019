package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

public class Climber extends Subsystem {

  // Define variables and actuators here as private:
  // private WPI_VictorSPX rearlegExtender;
  private WPI_TalonSRX LeftFrontLegExtenderMotor;
  private WPI_TalonSRX RightFrontLegExtenderMotor;
  private WPI_TalonSRX FrontLegMotor;
  private WPI_TalonSRX rearArmExtenderMotor;

  public Climber() {
    // Construct objects here
    
    LeftFrontLegExtenderMotor = new WPI_TalonSRX(14);
    LeftFrontLegExtenderMotor.setInverted(false);
    RightFrontLegExtenderMotor = new WPI_TalonSRX(12);
    RightFrontLegExtenderMotor.setInverted(true);
    FrontLegMotor = new WPI_TalonSRX(15);
    rearArmExtenderMotor = new WPI_TalonSRX(11);

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
    LeftFrontLegExtenderMotor.set(0.5);
    RightFrontLegExtenderMotor.set(0.5);
  }

  public void retractLeg() {
    // Extends the leg of climbing mechanism
    LeftFrontLegExtenderMotor.set(-0.5);
    RightFrontLegExtenderMotor.set(-0.5);
  }

  public void stopLeg() {
    LeftFrontLegExtenderMotor.set(0);
    RightFrontLegExtenderMotor.set(0);
  }

  public void liftWheelForward() {
    FrontLegMotor.set(1);
  }

  public void liftWheelBackward() {
    FrontLegMotor.set(-1);
  }

  public void liftWheelStop() {
    FrontLegMotor.set(0);
  }

  public void extendArm() {
    rearArmExtenderMotor.set(0.5);
  }

  public void retractArm() {
    rearArmExtenderMotor.set(-0.5);
  }

  public void stopArm() {
    rearArmExtenderMotor.set(0);
  }

}

