package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Soundworks;
import frc.robot.commands.cargoJoint;
import frc.robot.commands.closeCompressor;
import frc.robot.commands.humanPlayer;
import frc.robot.commands.openCompressor;
import frc.robot.commands.releaseCargo;
import frc.robot.commands.releaseHatch;
import frc.robot.commands.takeCargo;
import frc.robot.commands.takeHatch;

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
    Button button4 = new JoystickButton(logitech,5); // open Compressor
    Button button5 = new JoystickButton(logitech,6); // close Compressor
    Button button6 = new JoystickButton(logitech,7); // turnOff Cylinder
    Button button7 = new JoystickButton(logitech,8); // turnOn Cylinder
    Button button69 = new JoystickButton(logitech , 10);

    button.whileHeld(new cargoJoint());
    button1.whileHeld(new humanPlayer());
    button2.whileHeld(new releaseCargo());   
    button3.whileHeld(new takeCargo());
    button4.whenPressed(new openCompressor());
    button5.whenPressed(new closeCompressor());
    button6.whenPressed(new takeHatch());
    button7.whenPressed(new releaseHatch());
    button69.whenPressed(new Soundworks());

  }

  public Joystick getXbox() {
    return xbox;
  }

  public Joystick getLogitech() {
    return logitech;
  }

}
