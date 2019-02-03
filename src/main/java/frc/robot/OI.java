package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

public class OI {

  // Define joysticks and buttons as public
  public Joystick xbox;
  public Joystick logitech;
  // public JoystickButton xboxButton1;

  public OI() {

    xbox = new Joystick(1);
    logitech = new Joystick(0);
    // xboxButton1 = new JoystickButton(xbox, 1);
    // xboxButton1.whenPressed(new ReleaseHatch());

    Button button1 = new JoystickButton(logitech, 1); // Cargo Joint Up
    Button button2 = new JoystickButton(logitech, 2); // Cargo Joint Down 
    Button button3 = new JoystickButton(logitech, 3); // Release Cargo
    Button button4 = new JoystickButton(logitech, 4); // Take Cargo
    Button button5 = new JoystickButton(logitech, 5); // Relesase Hatch
    Button button6 = new JoystickButton(logitech, 6); // Take Hatch 
    Button button7 = new JoystickButton(logitech, 7); // Open Compressor
    Button button8 = new JoystickButton(logitech, 8); // Close Compressor
    
    Button button9  = new JoystickButton(xbox, 1); // Lift Down
    Button button10 = new JoystickButton(xbox, 2); // Lift Up
    Button button11 = new JoystickButton(xbox, 3); // Lift Forward
    Button button12 = new JoystickButton(xbox, 4); // Lift Backward
    Button button13 = new JoystickButton(xbox, 7); // Extend Arm
    Button button14 = new JoystickButton(xbox, 8); // Retract Arm

    button1.whileHeld(new cargoJointDown());
    button2.whileHeld(new cargoJointUp());
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


  }

  public Joystick getXbox() {
    return xbox;
  }

  public Joystick getLogitech() {
    return logitech;
  }

}
