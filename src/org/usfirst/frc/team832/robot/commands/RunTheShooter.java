package org.usfirst.frc.team832.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team832.robot.*;
import org.usfirst.frc.team832.robot.RobotMap;

import com.ctre.CANTalon;

/**
 *
 */


public class RunTheShooter extends Command {
	public RunTheShooter() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shooter);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
<<<<<<< HEAD
		/*
=======
>>>>>>> e271606286d923c78cc485baaec94d347fbed51b
		RobotMap.shooterMotor1.changeControlMode(CANTalon.TalonControlMode.Speed);
		double throttle = Robot.oi.operatorStick.getRawAxis(2);
		throttle += 1;
		throttle /= 2;
		throttle *= 3500; //CHANGED FROM 4500
		SmartDashboard.putNumber("Throttle", throttle);
<<<<<<< HEAD
*/		
=======
		//RobotMap.shooterMotor1.set(throttle);
>>>>>>> e271606286d923c78cc485baaec94d347fbed51b
		RobotMap.shooterMotor1.set(2000);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
        RobotMap.shooterMotor1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		
		RobotMap.shooterMotor1.set(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
