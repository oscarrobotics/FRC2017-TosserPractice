package org.usfirst.frc.team832.robot.commands.auto;

import org.usfirst.frc.team832.robot.Robot;
import org.usfirst.frc.team832.robot.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class AutoDriveDistance extends Command {

	double power,delay,distance,leftPower,rightPower;
	double gyroTarget;
    public AutoDriveDistance(double power, double delay,double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.power=power;
    	this.delay=delay;
    	this.distance=distance;
    	requires(Robot.westCoastDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//RobotMap.left1
    	Robot.westCoastDrive.changeMode(TalonControlMode.PercentVbus);
 
    //	RobotMap.left1.setEncPosition(0);
    	//RobotMap.right1.setEncPosition(0);
		leftPower=power;
		rightPower = power;
		//rightPower=power+.0225; - previously corrected code
		//RobotMap.navx.reset();
    	gyroTarget = 0; // RobotMap.navx.pidGet();
    	Robot.westCoastDrivePID.setSetpoint(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    	
    	//SmartDashboard.putNumber("Gyro Heading", RobotMap.navx.getAngle());
    	SmartDashboard.putNumber("Gyro target", gyroTarget);
    	SmartDashboard.putNumber("power", power);
    	
//    	double leftDiffRight = RobotMap.left1.getEncPosition() - RobotMap.right1.getEncPosition();
//    	double rightDiffLeft = RobotMap.right1.getEncPosition() - RobotMap.left1.getEncPosition();;
    	double leftEnc = RobotMap.leftEnc.get();
    	double rightEnc = RobotMap.rightEnc.get();
    	double rotation = Robot.westCoastDrivePID.pidOutputVal;
   
    	SmartDashboard.putNumber("ActualYaw", RobotMap.navx.pidGet());
    	SmartDashboard.putNumber("Error", Robot.westCoastDrivePID.getPIDController().getError());
    	
    	if(gyroTarget > RobotMap.navx.getAngle() % 360)
    		Robot.westCoastDrive.autoDriveArcade(0, limit(-Robot.westCoastDrivePID.pidOutputVal));
    	else if(gyroTarget < RobotMap.navx.getAngle() % 360)
    		Robot.westCoastDrive.autoDriveArcade(0, limit(Robot.westCoastDrivePID.pidOutputVal));

	
    	
//    	if(Math.signum(power)==-1)
//    	{
//    		if(!(leftEnc<distance || rightEnc<distance))
//    			Robot.westCoastDrive.autoDriveArcade(power, limit(rotation));
//    		else
//    			Robot.westCoastDrive.autoDriveArcade(0, limit(rotation));
//    	}
//	
    	
//    	if(power - mod < -.7)
//    		mod = -.7 - power;
//    	
//    	
//    	SmartDashboard.putNumber("EncoderGoal", distance);
//    	if(Math.signum(power)==-1){
//    		if(leftEnc<distance)
//    			leftPower=0;
//    		else 
//    			leftPower = power;
//
//    	
//    		
//    		if(rightEnc<distance)
//    			rightPower=0;
//    		else
//    			rightPower = power;
//        }
//    	if(Math.signum(power)==1){
//    		if(leftEnc<-distance)
//    			leftPower=0;
//    		else 
//    			leftPower=power;
//
//    	
//    		
//    		if(rightEnc>-distance)
//    			rightPower=0;
//    		else
//    			rightPower=rightPower;
//        }
    	
    	
//    	leftPower-=0.05*(leftDiffRight);
//    	rightPower-=0.05*(RobotMap.right1.getEncPosition()-RobotMap.left1.getEncPosition());
//    	Robot.westCoastDrive.takeAutoInput(leftPower, rightPower);
    	
    	
    
    	
    }
    
    protected double limit(double input)
    {
    	if(input > 1)
    		return 1;
    	else if(input < .4)
    		return .4;
    	else return input;
    	
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
