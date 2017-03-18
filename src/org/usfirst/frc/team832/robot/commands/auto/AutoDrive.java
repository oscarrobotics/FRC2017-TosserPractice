package org.usfirst.frc.team832.robot.commands.auto;

import org.usfirst.frc.team832.robot.Robot;
import org.usfirst.frc.team832.robot.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {

	boolean isDone = false;
	double power, runTime, startDelay, distance;
	public long startTime;
//	double startedTime = System.currentTimeMillis();
	//double timeToRun = startedTime + (runTime * 1000);
	
    public AutoDrive(double power, double startDelay, double runTime) { 
        // Use requires() here to declare subsystem dependencies
        requires(Robot.westCoastDrive);   
        this.power = power;           
        this.startDelay = startDelay;
        this.runTime = runTime * 1000;
    
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	//Timer.delay(4);
    	//Robot.westCoastDrive.takeAutoInput(0.5, 0.5);
    	Robot.westCoastDrive.changeMode(TalonControlMode.PercentVbus);
    	
    	startTime = System.currentTimeMillis();
    	isDone = false;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(System.currentTimeMillis() >= startTime + runTime)
    	{
    		isDone = true;
    	}
    	else
    	{
    		double power2 = power + .007;
    		Robot.westCoastDrive.takeAutoInput(power, power2);
    		isDone=false;
    		
    	}
   // 	while(timeToRu)
    	//RobotMap.left1.set(0.5);
    	//RobotMap.right1.set(0.5);
    //	Robot.westCoastDrive.takeAutoInput(0.5, 0.5);
    	//Timer.delay(runTime);
    	//isDone = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.westCoastDrive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
}
