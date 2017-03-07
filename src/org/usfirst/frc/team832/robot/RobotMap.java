package org.usfirst.frc.team832.robot;

import com.ctre.*;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Solenoid;
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

	//public static AHRS navx;
	//public static SerialPort.Port navXSerialPort = SerialPort.Port.kUSB;

	//public static boolean isPracticeBot = true;

	// shooter
	public static int shooterMotor1ID = 1;
	public static int shooterMotor2ID = 2;
	public static CANTalon shooterMotor1;
	public static CANTalon shooterMotor2;

	// drivetrain
	public static int leftDrivePWMPort = 0;
	public static int rightDrivePWMPort = 1;
	public static Victor left1;
	public static Victor right1;
	public static RobotDrive westCoast;

	// winch
	public static int winchPWMPort = 4;
	public static Spark bigWinch;

	// collector
	public static int collectorPWMPort = 3;
	public static Victor collectorRoller;

	// turntable
	public static int turnTablePWMPort = 2;
	public static Victor turnTable;

	// pneumatics
	public static int pcmID = 9;
	public static int gearShiftSolLow = 0;
	public static int gearShiftSolHigh = 1;
	public static int ballDoorSolPort = 2;
	public static Compressor compressor;
	public static DoubleSolenoid gearShiftSol;
	public static DoubleSolenoid winchTiltSol; // practice bot does not have
												// winch, so this is kinda
												// useless
	public static Solenoid ballDoorSol;

	// electronics
	public static int pdpID = 0;
	public static PowerDistributionPanel powerDP;

	public static void init() {

		// inits navX IMU
		/*
		try {
			navx = new AHRS(navXSerialPort);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX-Micro:  " + ex.getMessage(), true);
		}
		*/
		
		// electronics
		powerDP = new PowerDistributionPanel(pdpID);
		powerDP.clearStickyFaults();
		
		// shooter
		shooterMotor1 = new CANTalon(shooterMotor1ID);
		shooterMotor2 = new CANTalon(shooterMotor2ID);
		shooterMotor1.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotor1.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotor1.setAllowableClosedLoopErr(20);
		
		shooterMotor2.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotor2.set(shooterMotor1ID);
		shooterMotor1.clearStickyFaults();
		shooterMotor2.clearStickyFaults();

		// drivetrain
		left1 = new Victor(leftDrivePWMPort);
		right1 = new Victor(rightDrivePWMPort);
		westCoast = new RobotDrive(left1, right1);

		// pneumatics
		
		compressor = new Compressor(pcmID);
		compressor.setClosedLoopControl(true);
		compressor.clearAllPCMStickyFaults();
		gearShiftSol = new DoubleSolenoid(pcmID, gearShiftSolLow, gearShiftSolHigh);
		winchTiltSol = new DoubleSolenoid(pcmID, 6, 7); // not on practice bot, useless
		ballDoorSol = new Solenoid(pcmID, ballDoorSolPort);
		ballDoorSol.set(true); // door closed by default
		
		// winch
		bigWinch = new Spark(winchPWMPort);  // not on practice bot, useless
		
		// intake
		collectorRoller = new Victor(collectorPWMPort);
		
		// turntable
		turnTable = new Victor(turnTablePWMPort);

	}
}
