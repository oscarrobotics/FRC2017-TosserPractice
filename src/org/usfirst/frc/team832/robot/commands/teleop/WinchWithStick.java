package org.usfirst.frc.team832.robot.commands.teleop;

import org.usfirst.frc.team832.robot.Robot;
import org.usfirst.frc.team832.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchWithStick extends Command {

	double operatorStickY = Robot.oi.operatorStick.getRawAxis(1);
//	double operatorStickY = Math.abs(Robot.oi.operatorStick.getRawAxis(1));

	boolean winchButton = Robot.oi.operatorStick.getRawButton(4);
	double throttle = operatorStickY; 
	
    public WinchWithStick() {
        // Use requires() here to declare subsystem dependencies
//        requires(Robot.bigWinch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 if (winchButton&&operatorStickY>0) //-> DELETE
//   double operatorStickY = Math.abs(Robot.oi.operatorStick.getRawAxis(1));
    	RobotMap.bigWinch.set(operatorStickY);
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
    	//end();
    }
}
