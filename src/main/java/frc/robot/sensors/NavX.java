package frc.robot.sensors;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;

public class NavX {
    public AHRS ahrs;
    
    public NavX(){
        ahrs = new AHRS(SPI.Port.kMXP);


    }

    public  float yawValue() {
      float yawValue =  ahrs.getYaw();
        return yawValue;
    }

}
