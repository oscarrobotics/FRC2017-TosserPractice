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
	public final JoystickButton winchTilt;
	
	// intake
	public final JoystickButton rollerIn;
    public final JoystickButton rollerOut;
	// turntable
    public final JoystickButton tableCW;
    
    // shooter RPM setters
    public final JoystickButton shooter2000;
    public final JoystickButton shooter2500;
    public final JoystickButton shooter3000;
    
	public OI() {
		//flywheel
		flywheelSpinUp = new JoystickButton(operatorStick, 1);
		flywheelSpinUp.whileHeld(new RunTheShooter());
		//drivetrain
		highGear = new JoystickButton(driverPad, 6);
		highGear.whenPressed(new ShiftHigh());
		lowGear = new JoystickButton(driverPad, 5);
		lowGear.whenPressed(new ShiftLow());
		// winch
		winchPull = new JoystickButton(driverPad, 1);
		winchPull.whileHeld(new WinchPull());
		//collector
		rollerOut = new JoystickButton(operatorStick, 4);
		rollerOut.whileHeld( new CollectorEject());
		rollerIn = new JoystickButton(operatorStick, 5);
		rollerIn.whileHeld(new CollectorIntake());
		//turntable
		tableCW = new JoystickButton(operatorStick, 2);
		tableCW.whileHeld(new TurnTableCW());
		
		// winch
		winchTilt = new JoystickButton(operatorStick, 6);
		winchTilt.whileHeld(new WinchTilt());
		
		
		// shooter RPM setters
		shooter2000 = new JoystickButton(operatorStick, 7);
		shooter2000.whileHeld(new RPMTo2000());
		
		shooter2500 = new JoystickButton(operatorStick, 9);
		shooter2500.whileHeld(new RPMTo2500());
		
		shooter3000 = new JoystickButton(operatorStick, 11);
		shooter3000.whileHeld(new RPMTo3000());
		
		
		
		
		
		
	}
}
