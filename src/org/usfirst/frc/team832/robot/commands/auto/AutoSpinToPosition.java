package org.usfirst.frc.team832.robot.commands.auto;

import org.usfirst.frc.team832.robot.Robot;
import org.usfirst.frc.team832.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoSpinToPosition extends Command {
	
	double target;

    public AutoSpinToPosition(double targetInput) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.westCoastDrive);
    	target = targetInput;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.navx.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double power = .325;
    	double mod = 0;
    	
    	mod = Math.abs(RobotMap.navx.getAngle() - target) * .006;
    	
    	if(power + mod > .8)
    		mod = .8 - power;
    	
    	if(RobotMap.navx.getAngle() < target - .25) // if we're too far left
    		Robot.westCoastDrive.takeAutoInput(power + mod, -power - mod);
    	else if(RobotMap.navx.getAngle() > target + .25) // if we're too far right)
    		Robot.westCoastDrive.takeAutoInput(-power - mod, power + mod);
    	else Robot.westCoastDrive.takeAutoInput(0, 0);	
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
