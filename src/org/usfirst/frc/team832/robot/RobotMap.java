package org.usfirst.frc.team832.robot;

import com.ctre.*;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
		
	public static AHRS navx;
	
	// shooter
	public static int shooterRight = 2;
	public static int shooterLeft = 1;
	public static CANTalon shooterMotor1;
	public static CANTalon shooterMotor2;
	
	// drivetrain
	public static int leftDrivePWMPort = 0;
	public static int rightDrivePWMPort = 1;
	public static Victor left6WheelTank;
	public static Victor right6WheelTank;
	public static RobotDrive westCoast;
	
	// winch
	public static Spark bigWinch;
	
	//intake
	public static Victor collectorRoller;
	
	// turntable
	public static Victor turnTable;
	
	// pneumatics
	public static Compressor compressor;
	public static DoubleSolenoid gearShift;
	
	// electronics
	 public static PowerDistributionPanel powerDP;
	 
	 
	
	public static void init() {
		
		// inits navX IMU
		try {
	          navx = new AHRS(I2C.Port.kOnboard); 
	      } catch (RuntimeException ex ) {
	          DriverStation.reportError("Error instantiating navX-Micro:  " + ex.getMessage(), true);	          
	      }
		powerDP = new PowerDistributionPanel(0);
		// shooter
		shooterMotor1 = new CANTalon(shooterRight);
        shooterMotor2 = new CANTalon(shooterLeft);
        shooterMotor1.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
        shooterMotor1.changeControlMode(CANTalon.TalonControlMode.Speed);
        shooterMotor2.changeControlMode(CANTalon.TalonControlMode.Follower);
        shooterMotor2.set(shooterMotor1.getDeviceID());
        
        // drivetrain
        left6WheelTank = new Victor(0);
        right6WheelTank = new Victor(1);
        westCoast = new RobotDrive(left6WheelTank, right6WheelTank);
        
        //pneumatics
        compressor = new Compressor(3);
        compressor.setClosedLoopControl(true);
        gearShift = new DoubleSolenoid(0,1);
        
        // mechanisms
        collectorRoller = new Victor(2);
        bigWinch = new Spark(3);
        turnTable = new Victor(4);
        
	}
}
