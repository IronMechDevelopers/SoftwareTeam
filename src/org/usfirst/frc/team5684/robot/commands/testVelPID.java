package org.usfirst.frc.team5684.robot.commands;

import org.usfirst.frc.team5684.robot.Robot;
import org.usfirst.frc.team5684.robot.RobotMap;
import org.usfirst.frc.team5684.robot.subsystems.setSpeedPID;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class testVelPID extends Command {
	
	setSpeedPID leftPID;
	setSpeedPID rightPID;
	double speed;
	public testVelPID(double speed) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
		
		//rightPID = new setSpeedPID(Robot.drivetrain.getRightMotor(), Robot.drivetrain.getRightEncoder(), "right", .3, 0, 0,1);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		leftPID = new setSpeedPID(Robot.drivetrain.getLeftMotor(), Robot.drivetrain.getLeftEncoder(), "left", .3, 0, 0,1);
		this.speed=speed;
		leftPID.setAbsoluteTolerance(1.0);
		leftPID.setOutputRange(-1, 1);
		leftPID.enable();
		System.out.println("Hello world");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		leftPID.setSetpoint(speed);
		leftPID.enable();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
	}
}
