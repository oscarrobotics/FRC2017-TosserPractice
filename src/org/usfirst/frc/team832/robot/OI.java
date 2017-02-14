package org.usfirst.frc.team832.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team832.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public final Joystick driverPad = new Joystick(0);
	public final Joystick operatorStick = new Joystick(1);
	
	// flywheel
	public final JoystickButton flywheelSpinUp;
	// gear shifter
	public final JoystickButton highGear;
	public final JoystickButton lowGear;
	// winch
	public final JoystickButton winchPull;
	// intake
	public final JoystickButton collectIn;
    public final JoystickButton spitOut;
	// turntable
    public final JoystickButton tableCW;
    
	public OI() {
		//flywheel
		flywheelSpinUp = new JoystickButton(operatorStick, 2);
		flywheelSpinUp.whileHeld(new RunTheShooter());
		//drivetrain
		highGear = new JoystickButton(driverPad, 6);
		highGear.whenPressed(new UpShift());
		lowGear = new JoystickButton(driverPad, 5);
		lowGear.whenPressed(new DownShift());
		// winch
		winchPull = new JoystickButton(driverPad, 1);
		winchPull.whileHeld(new WinchPull());
		//collector
		spitOut = new JoystickButton(operatorStick, 4);
		spitOut.whileHeld( new CollectorEject());
		collectIn = new JoystickButton(operatorStick, 5);
		collectIn.whileHeld(new CollectorIntake());
		//turntable
		tableCW = new JoystickButton(operatorStick, 5);
		tableCW.whileHeld( new TurnTableCW());
	
		
		
		
		
		
		
		
	}
}
