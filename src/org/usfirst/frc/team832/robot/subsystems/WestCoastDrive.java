package org.usfirst.frc.team832.robot.subsystems;

import org.usfirst.frc.team832.robot.Robot;
import org.usfirst.frc.team832.robot.RobotMap;
import org.usfirst.frc.team832.robot.commands.*;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 *
 */
public class WestCoastDrive extends Subsystem {

    public final RobotDrive westCoast = RobotMap.westCoast;
    public final DoubleSolenoid gearshift = RobotMap.gearShiftSol;
  
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void driveManual(double left, double right) {
    	RobotMap.westCoast.tankDrive(left, right);
    }
    
    public void takeJoystickInputs(double left, double right) {
    	RobotMap.westCoast.tankDrive(left, right);
    }
    
 /*   public void setGear(int gear) {    
    	if(gear == 1) {
    	Robot.
    	}else if(gear == 2) {
    		// high gear
    	}
    }
    */
    
    public void stop() {
		RobotMap.westCoast.drive(0,0);
	}
   
}

