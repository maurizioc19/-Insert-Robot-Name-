package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearIntakeCommand extends Command {

    public GearIntakeCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gear);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gear.intakeGear();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.gear.getGearIntakeTime() + 5000 <= System.currentTimeMillis()){
    		
    	} else {
    		Robot.gear.gearWheelsOff();
    		Robot.gear.clawUp();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.gear.getLastActuation() + 1000 <= System.currentTimeMillis()){
    		return true;
    	} else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gear.clawPistonOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.gear.clawPistonOff();
    }
}
