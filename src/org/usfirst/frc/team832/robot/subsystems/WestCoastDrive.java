package org.usfirst.frc.team832.robot.subsystems;

import org.usfirst.frc.team832.robot.RobotMap;
import org.usfirst.frc.team832.robot.commands.*;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


public class WestCoastDrive extends Subsystem {

    public final RobotDrive westCoast = RobotMap.westCoast;
  
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void takeJoystickInputs(double left, double right) {
    	RobotMap.westCoast.tankDrive(left, right);
    }
    
    public void stop() {
		RobotMap.westCoast.drive(0,0);
	}
   
}

