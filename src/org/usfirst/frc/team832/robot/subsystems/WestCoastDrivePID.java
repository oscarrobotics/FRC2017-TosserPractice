package org.usfirst.frc.team832.robot.subsystems;

import org.usfirst.frc.team832.robot.Robot;
import org.usfirst.frc.team832.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDController.AbsoluteTolerance;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WestCoastDrivePID extends PIDSubsystem {

	AHRS navx = RobotMap.navx;
	private static final double kP = 0.006;
	private static final double kI = 0;
	private static final double kD = 0;
	public double pidOutputVal;
    // Initialize your subsystem here
    public WestCoastDrivePID() {
    	super("AutoDrive", kP, kI, kD);
    	setAbsoluteTolerance(0.5);
    	setInputRange(0, 360);
    	setOutputRange(0.4, 0.8);
    	getPIDController().setContinuous(false);
    	//setOutputRange(-.8, 0.8);
    	enable();
    	
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	
    	0
    	return navx.pidGet();
        
    }

    protected void usePIDOutput(double output) {
    	SmartDashboard.putNumber("PidOut", output);
    	pidOutputVal = Math.abs(output);
    	//Robot.westCoastDrive.autoDriveArcade(0, output);
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
  
    
    
}
