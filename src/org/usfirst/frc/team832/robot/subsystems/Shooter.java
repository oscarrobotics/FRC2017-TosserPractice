package org.usfirst.frc.team832.robot.subsystems;

import org.usfirst.frc.team832.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	public static CANTalon shooterMotor = RobotMap.shooterMotor1;
	public int shooterRPM = 2200;
	
	public void stopShooter() {
		shooterMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotor.set(0);
	}
	
	public void setActualRPM(int rpm) {
		shooterRPM = rpm;
	}
	
	public int getActualRPM() {
		return shooterRPM;
	}
	
	public void runShooter() {
		shooterMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotor.set(shooterRPM);
	}
	

	public void initDefaultCommand() {
	}
}
