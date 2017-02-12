package org.usfirst.frc.team832.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team832.robot.commands.CollectorEject;
import org.usfirst.frc.team832.robot.commands.CollectorIntake;
import org.usfirst.frc.team832.robot.commands.DownShift;
import org.usfirst.frc.team832.robot.commands.RunTheShooter;
import org.usfirst.frc.team832.robot.commands.TurnTableLoad;
import org.usfirst.frc.team832.robot.commands.UpShift;
import org.usfirst.frc.team832.robot.commands.WinchPull;
import org.usfirst.frc.team832.robot.commands.WinchRelease;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public final Joystick driverPad = new Joystick(0);
	public final Joystick operatorStick = new Joystick(1);
	public final JoystickButton spin;
	public final JoystickButton upShift;
	public final JoystickButton downShift;
	public final JoystickButton gearIn;
	public final JoystickButton gearOut;
	public final JoystickButton winchPull;	
	//public final JoystickButton winchRelease;
	public final JoystickButton collectIn;
     public final JoystickButton spitOut;
	public final JoystickButton loadBall;
	
	public OI() {
		spin = new JoystickButton(operatorStick, 2);
		spin.whileHeld(new RunTheShooter());
		upShift = new JoystickButton(driverPad, 6);
		upShift.whenPressed(new UpShift());
		downShift = new JoystickButton(driverPad, 5);
		downShift.whenPressed(new DownShift());
		gearIn = new JoystickButton(operatorStick, 6);
		gearOut = new JoystickButton(operatorStick, 7);
		winchPull = new JoystickButton(driverPad, 1);
		winchPull.whileHeld(new WinchPull());
		//winchRelease = new JoystickButton(driverPad, 3);
		//winchRelease.whileHeld(new WinchRelease());
		spitOut = new JoystickButton(operatorStick, 4);
		spitOut.whileHeld( new CollectorEject());
		collectIn = new JoystickButton(operatorStick, 5);
		collectIn.whileHeld(new CollectorIntake());
		loadBall = new JoystickButton(operatorStick,9 );
		loadBall.whileHeld(new TurnTableLoad());
		
		
		
		
		
		
		
		
	}
}
