package org.usfirst.frc.team5684.robot.commands;

import org.usfirst.frc.team5684.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Climb extends Command {

	public Climb() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.elevator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevator.setMotor(-.8);
		SmartDashboard.putNumber("Elevator distance", Robot.elevator.getDistance());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.elevator.isLimit()) {
			Robot.elevator.resetEncoder();
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevator.stopMotor();
		SmartDashboard.putNumber("Elevator distance", Robot.elevator.getDistance());
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
	}
}