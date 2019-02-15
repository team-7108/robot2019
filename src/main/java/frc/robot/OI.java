package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

public class OI {

  // Define joysticks and buttons as public
  public Joystick xbox;
  public Joystick logitech;
  // public JoystickButton xboxButton1;
  public JoystickButton button1;
  public JoystickButton button2;
  public JoystickButton button3;
  public JoystickButton button4;
  public JoystickButton button5;
  public JoystickButton button6;
  public JoystickButton button7;
  public JoystickButton button8;
  public JoystickButton button9;
  public JoystickButton button10;
  public JoystickButton button11;
  public JoystickButton button12;
  public JoystickButton button13;
  public JoystickButton button14;
  public JoystickButton button15;

  public OI() {

    xbox = new Joystick(1);
    logitech = new Joystick(0);
    // xboxButton1 = new JoystickButton(xbox, 1);
    // xboxButton1.whenPressed(new ReleaseHatch());

    button1 = new JoystickButton(logitech, 1); // Cargo Joint Down
    button2 = new JoystickButton(logitech, 2); // Cargo Joint Up 
    button3 = new JoystickButton(logitech, 3); // Release Cargo
    button4 = new JoystickButton(logitech, 4); // Take Cargo
    button5 = new JoystickButton(logitech, 5); // Relesase Hatch
    button6 = new JoystickButton(logitech, 6); // Take Hatch 
    button7 = new JoystickButton(logitech, 7); // Open Compressor
    button8 = new JoystickButton(logitech, 8); // Close Compressor
    button15 = new JoystickButton(logitech,9);

    button9  = new JoystickButton(xbox, 1); // Lift Down
    button10 = new JoystickButton(xbox, 2); // Lift Up
    button11 = new JoystickButton(xbox, 3); // Lift Forward
    button12 = new JoystickButton(xbox, 4); // Lift Backward
    button13 = new JoystickButton(xbox, 7); // Extend Arm
    button14 = new JoystickButton(xbox, 8); // Retract Arm
    

    button1.whenPressed(new cargoJointDown());
    button2.whenPressed(new cargoJointUp());
    button3.whileHeld(new releaseCargo());
    button4.whileHeld(new takeCargo());
    button5.whenPressed(new takeHatch());
    button6.whenPressed(new releaseHatch());
    button7.whenPressed(new closeCompressor());
    button8.whenPressed(new openCompressor());

    button9.whileHeld(new liftDown());
    button10.whileHeld(new liftUp());
    button11.whileHeld(new liftDriveForward());
    button12.whileHeld(new liftDriveBackward());
    button13.whileHeld(new extendArm());
    button14.whileHeld(new retractArm());
    button15.whenPressed(new visionStarter(5));


  }

  public Joystick getXbox() {
    return xbox;
  }

  public Joystick getLogitech() {
    return logitech;
  }

}
