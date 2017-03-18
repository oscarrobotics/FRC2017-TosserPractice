
package org.usfirst.frc.team832.robot;

import com.ctre.*;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;

import org.usfirst.frc.team832.robot.commands.teleop.*;
import org.usfirst.frc.team832.robot.commands.auto.*;
import org.usfirst.frc.team832.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static Shooter shooter;
	public static WestCoastDrive westCoastDrive;
	public static WestCoastDrivePID westCoastDrivePID;
	public static Pneumatics pneumatics;
	public static Collector collector;
	public static Winch bigWinch;
	public static Turntable turnTable;
	public static OI oi;

	
//	public static double shooterSetRPM = RobotMap.shooterMotor1.getSetpoint(); // what the shooter should be set at
//	public static double shooterActualRPM = RobotMap.shooterMotor1.getSpeed(); // what it is at
//	public static double shooterCurrentDraw = RobotMap.shooterMotor1.getOutputCurrent() + RobotMap.shooterMotor2.getOutputCurrent();

//	public static AHRS navx = RobotMap.navx;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		

	    CameraServer.getInstance().startAutomaticCapture(0).setVideoMode(PixelFormat.kMJPEG, 320, 240, 15);

		try {
			RobotMap.init();
		} catch (ExceptionInInitializerError ex) {
			System.out.println(ex.getMessage());
		}

		shooter = new Shooter();
		turnTable = new Turntable();
		westCoastDrive = new WestCoastDrive();
		westCoastDrivePID = new WestCoastDrivePID();
		pneumatics = new Pneumatics();
		collector = new Collector();
		bigWinch = new Winch();
		oi = new OI();
		autonomousCommand = new AUTOMODE_DriveForward();
		Robot.pneumatics.shiftToLow();
		chooser.addDefault("Drive Forward", new AUTOMODE_DriveForward());
		chooser.addObject("Center Gear", new AUTOMODE_CenterPeg());
		chooser.addObject("Center Peg Distance", new AUTOMODE_CenterPegDistance());
		chooser.addObject("Gyro To Position Test", new AUTOMODE_Spin90Degrees());
		SmartDashboard.putData("Auto mode", chooser);
		
		//RobotMap.navx.reset();
		//RobotMap.navx.zeroYaw();
	}

	public void sendData() {
//		SmartDashboard.putNumber("CLError", RobotMap.shooterMotor1.getClosedLoopError());
//		SmartDashboard.putNumber("RPM Actual", RobotMap.shooterMotor1.getSpeed());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
//		SmartDashboard.putNumber("gyro yaw", RobotMap.navx.getAngle());
//		SmartDashboard.putNumber("gyro roll", RobotMap.navx.getRoll());
//		SmartDashboard.putNumber("gyro pitch", RobotMap.navx.getPitch());
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//RobotMap.gearHolderSol.set(Value.kReverse);
		RobotMap.leftEnc.reset();
		RobotMap.rightEnc.reset();
		RobotMap.ballDoorSol.set(true);
		//autonomousCommand = chooser.getSelected();
		
//		RobotMap.navx.reset();
//		RobotMap.navx.zeroYaw();
		
//		
//		 String autoSelected = SmartDashboard.getString("Auto Selector", "Default"); 
//		 switch(autoSelected) {
//		 	case "My Auto": 
//		 		autonomousCommand = new();
//		 		break; 
//		 	case "Default Auto": default:
//		 autonomousCommand = new ExampleCommand(); break; }
//		 

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand = chooser.getSelected();
			autonomousCommand.start();
			
			RobotMap.navx.reset();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		double leftEncPos = RobotMap.leftEnc.get();
		double rightEncPos = RobotMap.rightEnc.get();
		SmartDashboard.putNumber("leftenc", leftEncPos);
		SmartDashboard.putNumber("rightenc", rightEncPos);
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("NavX Yaw", RobotMap.navx.getAngle() % 360);
	}

	@Override
	public void teleopInit() {
		RobotMap.leftEnc.reset();
		RobotMap.rightEnc.reset();
//		RobotMap.navx.reset();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		//RobotMap.gearHolderSol.set(Value.kReverse);
		RobotMap.ballDoorSol.set(true);
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		double leftEncPos = RobotMap.leftEnc.get();
		double rightEncPos = RobotMap.rightEnc.get();
		SmartDashboard.putNumber("leftenc", leftEncPos);
		SmartDashboard.putNumber("rightenc", rightEncPos);
		
		Scheduler.getInstance().run();
		if(Robot.shooter.shooterMotor.getSpeed()>1800) {
			RobotMap.ballDoorSol.set(false);
		}
		else {
			RobotMap.ballDoorSol.set(true);
		}
		
		SmartDashboard.putNumber("gyro yaw", RobotMap.navx.getAngle());
		SmartDashboard.putNumber("gyro roll", RobotMap.navx.getRoll());
		SmartDashboard.putNumber("gyro pitch", RobotMap.navx.getPitch());
		// sendData();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

	// This is the end of all methods

}
