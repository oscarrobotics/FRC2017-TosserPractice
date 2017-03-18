package org.usfirst.frc.team832.robot.commands.teleop;

import org.usfirst.frc.team832.robot.Robot;
import org.usfirst.frc.team832.robot.RobotMap;
import org.usfirst.frc.team832.robot.subsystems.Pneumatics;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class DriveSpeedWithJoysticks extends Command {
	 double left, right;
	 final double highTicks=(512*15*12/(4*Math.PI)),lowTicks=(512*5*12/(Math.PI*4));
	 
	 
    public DriveSpeedWithJoysticks(double left,double right) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.left=left;
    	this.right=right;
    	requires(Robot.westCoastDrive);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//RobotMap.left1.changeControlMode(TalonControlMode.Speed);
    //	RobotMap.right1.changeControlMode(TalonControlMode.Speed);
    	Robot.westCoastDrive.changeMode(TalonControlMode.Speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Pneumatics.lowGear)
    		Robot.westCoastDrive.takeJoystickInputs(left*lowTicks, right*lowTicks);
    		Robot.westCoastDrive.takeJoystickInputs(left*highTicks, right*highTicks);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
