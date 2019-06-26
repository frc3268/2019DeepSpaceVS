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
import edu.wpi.first.wpilibj.drive.MecanumDrive;
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
	MecanumDrive drive;
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
<<<<<<< HEAD
		
		//	We want driving to be inverted
	//	driveLeft.setInverted(true);
	//	driveRight.setInverted(true);
		//	Create a drive to allow use of the driving functions
		drive = new MecanumDrive(driveLeftFront, driveLeftBack,driveRightFront,driveRightBack);
=======
		driveLeft.setInverted(true);
		driveRight.setInverted(true);
		drive = new DifferentialDrive(driveLeft, driveRight);
>>>>>>> parent of 5693ae1... Commented code
	}
	public void SwapControls()
	{
		driveLeft.setInverted(!(driveLeft.getInverted()));
		driveRight.setInverted(!(driveRight.getInverted()));
		
	}
	public void tankDrive(Joystick joy) {	
<<<<<<< HEAD
		// //	Invert or revert the controls, depending on wheter or not we need to do so
		// if( invert == true )
		// {
		// 	driveLeft.setInverted(false);
		// 	driveRight.setInverted(false)/;
		// }
		// else
		// {
		// 	driveLeft.setInverted(true);
		// 	driveRight.setInverted(true);	
		// }
		// //	Drive using the 1st axis on the joystick (Y axis)
		drive.driveCartesian(-joy.getX() * 0.5, joy.getY()*0.5, -joy.getZ()*0.5	);
	}
	//	Variant of tankDrive for auto command
	public void tankDrive(double xSpeed) {	
		//drive.arcadeDrive(xSpeed, 0);
	}
=======
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
>>>>>>> parent of 5693ae1... Commented code
	public void tankDriveInv(Joystick joy) {	
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
