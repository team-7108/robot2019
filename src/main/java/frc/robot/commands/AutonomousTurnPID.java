/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class AutonomousTurnPID extends Command{
    double measured_angle;
    double target_angle;
    double accuracy=1;
    double error;
    double old_error = error;
    double kP = 0.053;
    double kD = 0.003;
    double power;
    double true_flag;
    

    public AutonomousTurnPID(double _angle) {
        requires(Robot.m_driveTrain);
        this.target_angle=_angle;
    }

protected void initialize() {
       
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {   

        measured_angle= Robot.m_navx.yawValue();
            
            error = target_angle - measured_angle;
            power = kP*error+(kD*(error-old_error));
            

            
            
            if(power>1){
                power=1;
            }
            else if(power<-1)
            {
                power=-1;
            }
         // Robot.m_driveTrain.autonomousTurn(power);
            System.out.println("Measured  :"+" " + measured_angle);
            System.out.println("Error  :"+" " + error);
            System.out.println("Power  :"+" " + power);
            System.out.println("True Flag  :"+" " + true_flag);

            old_error = error;
            if(measured_angle < target_angle+accuracy && measured_angle > target_angle-accuracy) 
		{
			true_flag++;
		}
		else
		{
			true_flag = 0;
}
    }

    // Called once after isFinished returns true
    protected boolean isFinished(){
        if(true_flag>=5){
            return true;}
        else{return false;}
    }
    
    protected void end() {
        Robot.m_driveTrain.autonomousStop();
    }
    

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
    
}
	