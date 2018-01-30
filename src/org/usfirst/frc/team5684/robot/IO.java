package org.usfirst.frc.team5684.robot;

import org.usfirst.frc.team5684.robot.commands.driveByDistance;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class IO {

	Joystick leftStick = new Joystick(0);
	Joystick rightStick = new Joystick(1);
	Button rightFire = new JoystickButton(rightStick, 1);
	Button leftFire = new JoystickButton(leftStick, 1);
	Button radTest = new JoystickButton(rightStick,11);
	
	public IO() {
		radTest.whenPressed(new driveByDistance(6*Math.PI));
	}
	
}