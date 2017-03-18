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
	
    public WestCoastDrivePID() {
    	super("AutoDrive", kP, kI, kD);
    	setAbsoluteTolerance(0.5);
    	setInputRange(-180, 180); // navx.pidGet() outputs the yaw with a range of -180deg to 180deg
    	setOutputRange(0.4, 0.8); // THIS PROBABLY WON'T WORK NOW, 
    	getPIDController().setContinuous(true); // false for no wrap-around
    	enable();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
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
