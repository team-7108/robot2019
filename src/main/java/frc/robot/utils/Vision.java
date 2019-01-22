/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableValue;
import edu.wpi.first.networktables.TableEntryListener;
import edu.wpi.first.vision.VisionRunner.Listener;
import edu.wpi.first.wpilibj.DigitalOutput;
import frc.robot.commands.visionStarter;
import edu.wpi.first.networktables.NetworkTable;

/**
 * Add your docs here.
 */
public class Vision{
    public static NetworkTableEntry visionStarter;
    public static NetworkTableEntry angle;
    public static boolean buttonFlag;
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("datatable");
    public static boolean visionTriggerBool;

    public Vision() {
    visionTriggerBool = false;
    angle = table.getEntry("angle");
    visionStarter = table.getEntry("visionTrigger");
    angle.getDouble(0);
    
    }
    public void relayController(int digitalPin){
        DigitalOutput relay;
        relay = new DigitalOutput(digitalPin);

    }
    public static void trueChanger(){
        buttonFlag = true;
        visionStarter.setBoolean(true);
    }
}
