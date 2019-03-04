/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	public static final int PWM_driveLeftFront = 2;
	public static final int PWM_driveLeftBack = 1;

	public static final int PWM_driveRightFront = 5;
	public static final int PWM_driveRightBack = 0;
	
	public static final int PWM_ballIntakeMotor = 3;
	public static final int PWM_ballShootingMotor = 4;
	
	public static final int climbButton = 11;
	public static final int ballIntakeButton = 5;
	public static final int ballIntakeReverseButton = 3;
	public static final int ballShootingButton = 6;
	public static final int ballShootingReverseButton = 4;
	public static final int hatchButton = 1;
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
