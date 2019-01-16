package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

  // Define variables and actuators here as private:
  // private WPI_VictorSPX rearlegExtender;

  public Climber() {
    // Construct objects here
    // rearlegExtender = new WPI_VictorSPX(4);
  }

  @Override
  public void initDefaultCommand() {

  }

  @Override
  public void periodic() {
    // Put code here to be run every loop

  }

    // Emypties the cylinders
    public void turnOffCylinder() { 

    }
  
    // Opens the cylinders
    public void openCylinder() {
  
    }
  
    // Closes the cylinders
    public void closeCylinder() {
  
    }

    public void extendLeg() {
      // Extends the leg of climbing mechanism
    }

    public void retractLeg() {
      // Extends the leg of climbing mechanism
    }
}
