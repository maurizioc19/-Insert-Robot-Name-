package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbSystemCommand extends Command {

    public ClimbSystemCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMap.CLIMBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.CLIMBSYSTEM.climb();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.CLIMBSYSTEM.stopClimb();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	RobotMap.CLIMBSYSTEM.stopClimb();
    }
}
