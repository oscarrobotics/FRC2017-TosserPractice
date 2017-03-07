package org.usfirst.frc.team832.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team832.robot.*;

public class RunTheShooter extends Command {
	public RunTheShooter() {
		requires(Robot.shooter);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shooter.runShooter();
		//RobotMap.shooterMotor1.set(3000);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
        Robot.shooter.stopShooter();
        //RobotMap.shooterMotor1.set();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
