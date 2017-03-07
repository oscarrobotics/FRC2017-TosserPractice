package org.usfirst.frc.team832.robot.subsystems;
import org.usfirst.frc.team832.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static DoubleSolenoid gearShift = RobotMap.gearShiftSol;
	//public static DoubleSolenoid winchTilt = RobotMap.winchTiltSol;
	//public static Solenoid ballDoor = RobotMap.ballDoorSol;
	public static boolean lowGear;
	
	public void shiftToLow() {
		gearShift.set(Value.kForward);
		lowGear = true;
	}
	public void shiftToHigh() {
		gearShift.set(Value.kReverse);
		lowGear = false;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
   
}

