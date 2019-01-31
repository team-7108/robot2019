package frc.robot.sensors;

import frc.robot.Robot;

public class Encoder {
     public static double Left_Encoder_Position;
     public static double targetPosition = 500;
     public static double Right_Encoder_Position;
     public static double Perimeter = 48;
     public static double RoundNumber = targetPosition/Perimeter;
    public Encoder(){


    }
    public void Left_Encoder_Position(){
        Left_Encoder_Position = Robot.m_driveTrain.driveTrainleftFrontTalon.getSelectedSensorPosition();
        System.out.println("Encoder Position   : " + Left_Encoder_Position);
        System.out.println("Tur Sayısı : " + RoundNumber);
        
        if (Left_Encoder_Position <= RoundNumber*4100 ){
          
            Robot.m_driveTrain.driveTrainleftFrontTalon.set(0.3);
            Robot.m_driveTrain.driveTrainleftFrontTalon.set(0.3);
        }
        else {
            Robot.m_driveTrain.driveTrainleftFrontTalon.set(0);
            Robot.m_driveTrain.driveTrainleftFrontTalon.set(0);
        }

    }
    public void Right_Encoder_Position(){
        Right_Encoder_Position = Robot.m_driveTrain.driveTrainrightFrontTalon.getSelectedSensorPosition();
        System.out.println("Right Encoder Position   : " + Right_Encoder_Position);
        System.out.println("Round Number : " + RoundNumber);    
        
        if (Right_Encoder_Position <= RoundNumber*4100 ){
          
            Robot.m_driveTrain.driveTrainrightFrontTalon.set(0.3);
            Robot.m_driveTrain.driveTrainrightFrontTalon.set(0.3);
        }
        else {
            Robot.m_driveTrain.driveTrainrightFrontTalon.set(0);
            Robot.m_driveTrain.driveTrainrightFrontTalon.set(0);
        }


    }
}
