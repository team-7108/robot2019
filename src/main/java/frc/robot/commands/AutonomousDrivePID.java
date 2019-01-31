/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class AutonomousDrivePID extends Command{

    double power;
      double distance;
      double current_distance = Robot.encoderPosition;
      double distance_error=distance-current_distance;
      double distance_oldError=distance_error;
      double kP = 0.0014;
      double kD = 0.04;
      double angle_power;
      double right_power;
      double left_power;
      double yawAngle= Robot.m_navx.ahrs.getAngle(); 
      double angle = 0;
      double angle_error= angle-yawAngle;
      double angle_oldError=angle_error;
      int true_flag = 0;
      double accuracy = 3;
      double p=0.05;
      double d=0.12;
   
      public AutonomousDrivePID(double _distance ) 
      {
    	requires(Robot.m_driveTrain);
    	this.distance= _distance;
      }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	
    	current_distance = Robot.encoderPosition;
    	angle = Robot.m_navx.ahrs.getAngle();
		angle_error = angle - yawAngle; 
    	

    	distance_error = distance-current_distance;
    	
    	angle_power = p*angle_error+(d*(angle_error-angle_oldError));
		
	
		if (distance_error<0) 
		{
			power = -0.2 + (kP*distance_error+(kD*(distance_error-distance_oldError)));	
		}
		else 
		{
			power = 0.2 + (kP*distance_error+(kD*(distance_error-distance_oldError)));	
		}
		left_power =power;
		right_power =power;
		
		if (left_power>1)
		{left_power=1;}
		else if(left_power < -1)
		{left_power=-1;}
		if (right_power>1)
		{right_power=1;}
		else if(right_power < -1)
		{right_power=-1;}
        
        Robot.m_driveTrain.driveTrainleftFrontTalon.set(left_power);
        Robot.m_driveTrain.driveTrainleftRearTalon.set(left_power);
        Robot.m_driveTrain.driveTrainrightFrontTalon.set(right_power);
        Robot.m_driveTrain.driveTrainrightRearTalon.set(right_power);
        
        /*
		System.out.println("Measured Distance:");
		System.out.print(current_distance+ "		");
		System.out.print("Error Distance");
		System.out.print(distance_error+ "		");
		System.out.print("Measured Angle:");
		System.out.print(angle+ "		");
		System.out.print("Error Angle");
		System.out.print(angle_error+ "		");
		System.out.print("Left Power :"); 
		System.out.print(left_power + "		");
		System.out.print("Right Power :"); 
		System.out.print(right_power);
		System.out.println("True Flag:       "+ true_flag);
		*/     
		     
		     
		     distance_oldError= distance_error;
	if(current_distance< distance+ accuracy && current_distance > distance-accuracy) 
	{
		System.out.println("arizona kertenkelecik");
		true_flag++;
	}
	else 
	{
		true_flag=0;
	}	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (true_flag>=5) 
    	{
    		return true;
    	}
    	else 
    	{
    		return false;
    	}
    	
    	
}

    // Called once after isFinished returns true
    protected void end() {Robot.m_driveTrain.autonomousStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	

}
}
