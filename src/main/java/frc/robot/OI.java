package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

  // Define joysticks and buttons as public
  public Joystick xbox;
  public Joystick logitech;
  // public JoystickButton xboxButton1;

  public OI() {

    xbox = new Joystick(0);
    logitech = new Joystick(1);
    // xboxButton1 = new JoystickButton(xbox, 1);
    // xboxButton1.whenPressed(new ReleaseHatch());

  }

  public Joystick getXbox() {
    return xbox;
  }

  public Joystick getLogitech() {
    return logitech;
  }

}
