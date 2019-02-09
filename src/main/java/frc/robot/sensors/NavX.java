package frc.robot.sensors;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;

public class NavX {
    public static AHRS ahrs;
    public static boolean zeroFlag;
    public NavX() {
    ahrs = new AHRS(SPI.Port.kMXP);
    }

    public  float yawValue() {
      float yawValue =  ahrs.getYaw();
        return yawValue;
    }
    public static void zeroYaw() {
        zeroFlag = false;
        ahrs.zeroYaw();
        ahrs.reset();
        zeroFlag = true;
    }

}
