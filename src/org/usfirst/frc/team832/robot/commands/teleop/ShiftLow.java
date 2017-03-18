package org.usfirst.frc.team832.robot.commands.teleop;

import org.usfirst.frc.team832.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShiftLow extends Command {

    public ShiftLow() {
       requires(Robot.pneumatics);
    }
    protected void execute() {
    	Robot.pneumatics.shiftToLow();	
    }
    protected boolean isFinished() {
        return false;
    }
}
