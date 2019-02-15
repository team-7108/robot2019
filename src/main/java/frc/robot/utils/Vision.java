/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.networktables.NetworkTable;

/**
 * Add your docs here.
 */
public class Vision {
    public static NetworkTableEntry visionStarter;
    public static NetworkTableEntry angle;
    public static boolean buttonFlag;
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("datatable");
    public static boolean visionTriggerBool;
    public static DigitalOutput relay;

    public Vision() {
    relay = new DigitalOutput(8); // this pin needs to be changed
    visionTriggerBool = false;
    angle = table.getEntry("angle");
    visionStarter = table.getEntry("visionTrigger");
    angle.getDouble(0);
    
    }

    public static void trueChanger(Boolean status){
        // Do we need this ? perhaps...
        buttonFlag = status;
        visionStarter.setBoolean(status);
        relay.set(status);
    }
}
