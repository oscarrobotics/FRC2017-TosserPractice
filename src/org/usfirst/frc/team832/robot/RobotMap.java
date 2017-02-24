package org.usfirst.frc.team832.robot;

import com.ctre.*;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
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
	public static SerialPort.Port navXSerialPort = SerialPort.Port.kUSB;
	
	public static boolean isPracticeBot = false;

	// shooter
	public static int shooterMotor1ID = 1;
	public static int shooterMotor2ID = 2;
	public static CANTalon shooterMotor1;
	public static CANTalon shooterMotor2;

	// drivetrain
	public static int left1ID = 1;
	public static int left2ID = 2;
	public static int right1ID = 3;
	public static int right2ID = 4;
	public static CANTalon left1;
	public static CANTalon left2;
	public static CANTalon right1;
	public static CANTalon right2;
	public static RobotDrive westCoast;

	// winch
	public static int winchPWMPort = 0;
	public static Spark bigWinch;

	// turntable
	public static int turntableID = 5;
	public static CANTalon turnTable;

	// intake
	public static int intakeID = 6;
	public static CANTalon collectorRoller;

	// pneumatics
	public static int pcmID = 9;
	public static Compressor compressor;
	public static DoubleSolenoid gearShiftSol;
	public static DoubleSolenoid winchTiltSol;

	// electronics
	public static int pdpID = 0;
	public static PowerDistributionPanel powerDP;

	public static void switchRobotConfig() {
		if (isPracticeBot) {

		}
	}

	public static void init() {

		// inits navX IMU
		try {
			navx = new AHRS(navXSerialPort);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX-Micro:  " + ex.getMessage(), true);
		}
		
		// pdp
		powerDP = new PowerDistributionPanel(0);
		powerDP.clearStickyFaults();
		
		// shooter
		shooterMotor1 = new CANTalon(shooterMotor1ID);
		shooterMotor2 = new CANTalon(shooterMotor2ID);
		
		shooterMotor1.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotor1.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotor1.setAllowableClosedLoopErr(20);
		
		shooterMotor2.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotor2.set(shooterMotor1.getDeviceID());

		shooterMotor1.clearStickyFaults();
		shooterMotor2.clearStickyFaults();
		
		// drivetrain
		left1 = new CANTalon(left1ID);
		left2 = new CANTalon(left2ID);
		right1 = new CANTalon(right1ID);
		right2 = new CANTalon(right2ID);
		
		
		left2.changeControlMode(CANTalon.TalonControlMode.Follower);
		right2.changeControlMode(CANTalon.TalonControlMode.Follower);
		left2.set(left1.getDeviceID());
		right2.set(right1.getDeviceID());
		
		left1.clearStickyFaults();
		left2.clearStickyFaults();
		right1.clearStickyFaults();
		right2.clearStickyFaults();
		
		westCoast = new RobotDrive(left1, right1);

		// intake
		collectorRoller = new CANTalon(intakeID);
		collectorRoller.clearStickyFaults();
		
		// turntable
		turnTable = new CANTalon(turntableID);
		turnTable.clearStickyFaults();
		
		// pneumatics
		compressor = new Compressor(pcmID);
		compressor.setClosedLoopControl(true);
		gearShiftSol = new DoubleSolenoid(pcmID,0, 1);
		winchTiltSol = new DoubleSolenoid(pcmID,2, 3);

		// winch
		bigWinch = new Spark(winchPWMPort);

	}
}
