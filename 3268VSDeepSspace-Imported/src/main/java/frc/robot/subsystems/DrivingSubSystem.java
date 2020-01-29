/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotMap;
import frc.robot.commands.DrivingCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.TimedRobot;
/**
 * The motors which drive the robot, and their methods of control.
 */
public class DrivingSubSystem extends Subsystem {

	Talon driveLeftFront;
	Talon driveLeftBack;
	Talon driveRightFront;
	Talon driveRightBack;
	SpeedControllerGroup driveLeft;
	SpeedControllerGroup driveRight;
	DifferentialDrive drive;
	public boolean invert = false;	//	Tracker to track the current state of whether or not the robot is inverted or not.

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public DrivingSubSystem() {
		driveLeftFront = new Talon(RobotMap.PWM_driveLeftFront);
		driveLeftBack = new Talon(RobotMap.PWM_driveLeftBack);
		driveRightFront = new Talon(RobotMap.PWM_driveRightFront);
		driveRightBack = new Talon(RobotMap.PWM_driveRightBack);
		driveLeft = new SpeedControllerGroup(driveLeftFront, driveLeftBack);
		driveRight = new SpeedControllerGroup(driveRightFront, driveRightBack);
		driveLeft.setInverted(true);
		driveRight.setInverted(true);
		drive = new DifferentialDrive(driveLeft, driveRight);
	}
	public void SwapControls()
	{
		driveLeft.setInverted(!(driveLeft.getInverted()));
		driveRight.setInverted(!(driveRight.getInverted()));
		
	}
	public void tankDrive(Joystick joy) {	
		if( invert == true )
		{
			driveLeft.setInverted(false);
			driveRight.setInverted(false);
		}
		else
		{
			driveLeft.setInverted(true);
			driveRight.setInverted(true);	
		}
		drive.arcadeDrive(-joy.getRawAxis(1) * 0.75, 	
						-joy.getRawAxis(0) * 0.75);


	}
	public void tankDriveInv(Joystick joy) {	
	}
	public void tankDrive(double xSpeed) {	
		drive.arcadeDrive(xSpeed, 0);
	}
	/**
	 * Tank drive using individual joystick axes.
	 *
	 * @param leftAxis  Left sides value
	 * @param rightAxis Right sides value
	 */

	public void stop() {
		drive.stopMotor();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DrivingCommand());
	}
}
