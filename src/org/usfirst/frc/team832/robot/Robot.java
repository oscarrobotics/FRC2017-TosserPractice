
package org.usfirst.frc.team832.robot;

import com.ctre.*;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;

import org.usfirst.frc.team832.robot.commands.*;
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
	public static Pneumatics pneumatics;
	public static Collector collector;
	public static Winch bigWinch;
	public static Turntable turnTable;
	public static OI oi;

	//public static double shooterSetRPM = RobotMap.shooterMotor1.getSetpoint(); // what the shooter should be at
	//double shooterActualRPM = RobotMap.shooterMotor1.getSpeed(); // what it is at
	//double shooterCurrentDraw = RobotMap.shooterMotor1.getOutputCurrent() + RobotMap.shooterMotor2.getOutputCurrent();
	

	//public static AHRS navx = RobotMap.navx;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

		try {
		RobotMap.init();
		}
		catch (Exception ex) {
			String err = ex.getMessage().toString();
			DriverStation.reportError(err, true);
		}
		shooter = new Shooter();
		turnTable = new Turntable();
		westCoastDrive = new WestCoastDrive();
		pneumatics = new Pneumatics();
		collector = new Collector();
		bigWinch = new Winch();
		oi = new OI();
		chooser.addDefault("Default Auto", new RunTheShooter());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * 
	 */
	
	public void stallPrevention() {
		if (true) {
			
		}
	}
	
	public void sendData() {
		
		try {
			
//			SmartDashboard.putBoolean("IMU_Connected", navx.isConnected());
//			SmartDashboard.putBoolean("IMU_IsCalibrating", navx.isCalibrating());
//			SmartDashboard.putNumber("IMU_Yaw", navx.getYaw());
//			SmartDashboard.putNumber("IMU_Pitch", navx.getPitch());
//			SmartDashboard.putNumber("IMU_Roll", navx.getRoll());
//
//			/* Display tilt-corrected, Magnetometer-based heading (requires */
//			/* magnetometer calibration to be useful) */
//
//			SmartDashboard.putNumber("IMU_CompassHeading", navx.getCompassHeading());
//
//			/*
//			 * Display 9-axis Heading (requires magnetometer calibration to be
//			 * useful)
//			 */
//			SmartDashboard.putNumber("IMU_FusedHeading", navx.getFusedHeading());
//
//			/*
//			 * These functions are compatible w/the WPI Gyro Class, providing a
//			 * simple
//			 */
//			/* path for upgrading from the Kit-of-Parts gyro to the navx-MXP */
//
//			SmartDashboard.putNumber("IMU_TotalYaw", navx.getAngle());
//			SmartDashboard.putNumber("IMU_YawRateDPS", navx.getRate());
//
//			/*
//			 * Display Processed Acceleration Data (Linear Acceleration, Motion
//			 * Detect)
//			 */
//
//			SmartDashboard.putNumber("IMU_Accel_X", navx.getWorldLinearAccelX());
//			SmartDashboard.putNumber("IMU_Accel_Y", navx.getWorldLinearAccelY());
//			SmartDashboard.putBoolean("IMU_IsMoving", navx.isMoving());
//			SmartDashboard.putBoolean("IMU_IsRotating", navx.isRotating());
//
//			/*
//			 * Display estimates of velocity/displacement. Note that these
//			 * values are
//			 */
//			/*
//			 * not expected to be accurate enough for estimating robot position
//			 * on a
//			 */
//			/*
//			 * FIRST FRC Robotics Field, due to accelerometer noise and the
//			 * compounding
//			 */
//			/*
//			 * of these errors due to single (velocity) integration and
//			 * especially
//			 */
//			/* double (displacement) integration. */
//
//			SmartDashboard.putNumber("Velocity_X", navx.getVelocityX());
//			SmartDashboard.putNumber("Velocity_Y", navx.getVelocityY());
//
//			/* Display Raw Gyro/Accelerometer/Magnetometer Values */
//			/*
//			 * NOTE: These values are not normally necessary, but are made
//			 * available
//			 */
//			/*
//			 * for advanced users. Before using this data, please consider
//			 * whether
//			 */
//			/* the processed data (see above) will suit your needs. */
//
//			/* Omnimount Yaw Axis Information */
//			/*
//			 * For more info, see
//			 * http://navx-mxp.kauailabs.com/installation/omnimount
//			 */
//			AHRS.BoardYawAxis yaw_axis = navx.getBoardYawAxis();
//			SmartDashboard.putString("YawAxisDirection", yaw_axis.up ? "Up" : "Down");
//			SmartDashboard.putNumber("YawAxis", yaw_axis.board_axis.getValue());
			//SmartDashboard.putNumber("CLError", RobotMap.shooterMotor1.getClosedLoopError());
			//SmartDashboard.putNumber("RPM Actual", RobotMap.shooterMotor1.getSpeed());
		} catch (NullPointerException e) {
			DriverStation.reportError(e.getMessage(), true);
			System.out.println(e.getMessage());
		}
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
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		sendData();
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
