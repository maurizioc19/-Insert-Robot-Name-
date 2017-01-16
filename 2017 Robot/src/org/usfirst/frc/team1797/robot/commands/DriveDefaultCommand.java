package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDefaultCommand extends Command {
	Drivetrain drivetrain;
	
    public DriveDefaultCommand() {
    	drivetrain = Drivetrain.INSTANCE;
        this.requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.teleopDrive();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	interrupted();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.resetDriveMotors();
    }
}