package org.usfirst.frc.team832.robot.commands;

import org.usfirst.frc.team832.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team832.robot.*;

/**
 *
 */
public class DriveWithJoysticks extends Command {

	double leftStick = Robot.oi.driverPad.getRawAxis(1);
	double rightStick = Robot.oi.driverPad.getRawAxis(5);
	
    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.westCoastDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.westCoastDrive.takeJoystickInputs(-Robot.oi.driverPad.getRawAxis(1), -Robot.oi.driverPad.getRawAxis(5));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.westCoastDrive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
