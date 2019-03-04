/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is. 
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	public static Joystick rightStick = new Joystick(0);
	public static Joystick controller = new Joystick(1);

	public static Button ClimbButton = new JoystickButton(rightStick, RobotMap.climbButton);//Extend Front
	public static Button ClimbButton2 = new JoystickButton(rightStick, 12);	//	Extend Back
	public static Button ClimbButton3 = new JoystickButton(rightStick, 9);	//	Lower Front
	public static Button ClimbButton4 = new JoystickButton(rightStick, 10);	//	Lower Back

	public static Button BallIntakeButton = new JoystickButton(controller, RobotMap.ballIntakeButton);
	public static Button BallIntakeReverseButton = new JoystickButton(controller, RobotMap.ballIntakeReverseButton);

	public static Button BallShootingButton = new JoystickButton(controller, RobotMap.ballShootingButton);
	public static Button BallShootingReverseButton = new JoystickButton(controller, RobotMap.ballShootingReverseButton);

	public static Button HatchButton = new JoystickButton(controller, RobotMap.hatchButton);
	public static Button SwapButton = new JoystickButton(rightStick, 2);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public OI() {
		ClimbButton.whenPressed(new LiftCommand(0));
		ClimbButton2.whenPressed(new LiftCommand(1));

		ClimbButton3.whenPressed(new LowerFrontCommand());
		ClimbButton4.whenPressed(new LowerBackCommand());

		SwapButton.whenPressed(new SwapControlsCommand());
		
		BallIntakeButton.whenPressed(new BallIntakeCommand());
		BallIntakeButton.whenReleased(new StopBallCommand(0));
		
		BallIntakeReverseButton.whenPressed(new ReverseBallIntakeCommand());
		BallIntakeReverseButton.whenReleased(new StopBallCommand(0));

		BallShootingButton.whenPressed(new BallShootingCommand());
		BallShootingButton.whenReleased(new StopBallCommand(1));
		
		BallShootingReverseButton.whenPressed(new ReverseBallShootingCommand());
		BallShootingReverseButton.whenReleased(new StopBallCommand(1));

		HatchButton.whenPressed(new ExtendHatchCommand());
		HatchButton.whenReleased(new ReverseHatchCommand());
	}
}
