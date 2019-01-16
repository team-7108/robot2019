package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.cargoJoint;
import frc.robot.commands.humanPlayer;
import frc.robot.commands.releaseCargo;
import frc.robot.commands.takeCargo;

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

    Button button = new JoystickButton(logitech,1); // cargoRocketShip
    Button button1 = new JoystickButton(logitech,2); // humanPlayer 
    Button button2 = new JoystickButton(logitech,3); // releaseCargo
    Button button3 = new JoystickButton(logitech,4); // takeCargo


    button.whileHeld(new cargoJoint());
    button1.whileHeld(new humanPlayer());
    button2.whileHeld(new releaseCargo());   
    button3.whileHeld(new takeCargo());

  }

  public Joystick getXbox() {
    return xbox;
  }

  public Joystick getLogitech() {
    return logitech;
  }

}
