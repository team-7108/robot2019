/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;



public class visionStarter extends Command {
    long startTime;
    int seconds;
  
  public visionStarter(Integer _seconds) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  //  _seconds = _seconds != null ? _seconds : 5;
    this.seconds = _seconds;

     
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    startTime = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.vision.visionTrigger(true);
    Robot.vision.relayController(0);;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (System.currentTimeMillis() - startTime) > (int) (1000d * this.seconds);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
     Robot.vision.visionTrigger(false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
  

}
