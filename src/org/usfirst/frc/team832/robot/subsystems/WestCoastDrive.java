package org.usfirst.frc.team832.robot.subsystems;

import org.usfirst.frc.team832.robot.RobotMap;
import org.usfirst.frc.team832.robot.commands.teleop.*;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


public class WestCoastDrive extends Subsystem {

    public final RobotDrive westCoast = RobotMap.westCoast;
    public final boolean kadeDriving = false;
    public void initDefaultCommand() {
    	if (kadeDriving) {
    		setDefaultCommand(new KadeDrive());
    		
    	} else {
    		setDefaultCommand(new DriveWithJoysticks());
    	}
    }
    
    public void kadeDriveInputs(double drive, double rotation) {
    	RobotMap.westCoast.arcadeDrive(drive, rotation);
    }
    
    public void takeJoystickInputs(double left, double right) {
//    	double leftCubed = left * left * left;
//    	double rightCubed = right * right * right;
    	double leftCubed = left;
    	double rightCubed = right;
    	RobotMap.westCoast.tankDrive(leftCubed, rightCubed);
    }
    
    public void takeAutoInput(double left, double right) {
    	RobotMap.westCoast.tankDrive(left, right);
    }
    public void autoDriveArcade(double power, double rotation) {
    	double correctedRot = 0;
    	
    	RobotMap.westCoast.arcadeDrive(power, rotation);
    }
    public void changeMode(TalonControlMode controlMode){
      
    	//RobotMap.left1.changeControlMode(controlMode);
    	//RobotMap.right1.changeControlMode(controlMode);
       
       
    }
    public void stop() {
		RobotMap.westCoast.tankDrive(0,0);
	}
   
}

