package org.usfirst.frc.team832.robot.commands.teleop;

import org.usfirst.frc.team832.robot.Robot;
import org.usfirst.frc.team832.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class CollectorIntake extends Command {

	double collectorPower = Robot.collector.collectorPower;
	
    public CollectorIntake() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.collectorRoller.set(-0.7);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.collectorRoller.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
