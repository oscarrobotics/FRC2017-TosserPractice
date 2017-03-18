package org.usfirst.frc.team832.robot.commands.auto;

import org.usfirst.frc.team832.robot.commands.teleop.getGear;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class AUTOMODE_CenterPegDistance extends CommandGroup {

    public AUTOMODE_CenterPegDistance() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	//addSequential(new AutoDriveDistance(0.5, 0.0, 3170));
    	// addSequential(new AutoDriveDistance(-0.625, 0.0, -750));
    	 
    	 addSequential(new AutoDriveDistance(-0.5, 0.0, -2000));
    	 addSequential(new getGear());
    }
}
