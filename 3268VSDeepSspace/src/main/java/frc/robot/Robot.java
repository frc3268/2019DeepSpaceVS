/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.DrivingSubSystem;
import frc.robot.subsystems.HatchSubSystem;
import frc.robot.subsystems.LiftSubSystem;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.BallIntakeSubSystem;
//import frc.robot.subsystems.BallShootingSubSystem;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static DrivingSubSystem driveTrain = new DrivingSubSystem();
	public static OI m_oi;
	public static BallIntakeSubSystem ballIntake = new BallIntakeSubSystem();
//	public static BallShootingSubSystem ballShooting = new BallShootingSubSystem();
	public static HatchSubSystem hatch = new HatchSubSystem();
	public static LiftSubSystem lift = new LiftSubSystem();
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		m_chooser.setDefaultOption("Auto",  new ExampleCommand()); 
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		CameraServer.getInstance().startAutomaticCapture(0);
		CameraServer.getInstance().startAutomaticCapture(1);
		lift.SetCompressor(0);
		lift.ExtendPiston(0);
		lift.ExtendPiston(1);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */ 
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//	If the second button on the controller is pressed, swap the main camera
		// if(OI.rightStick.getRawButton(2))
		// {
		// 	// if(CameraServer.getInstance().getServer().getSource() == FrontCam)
		// 	// {
		// 	// 	CameraServer.getInstance().getServer().setSource(BackCam);
		// 	// }
		// 	// else if(CameraServer.getInstance().getServer().getSource() == BackCam)
		// 	// {
		// 	// 	CameraServer.getInstance().getServer().setSource(FrontCam);
		// 	// }
		// }
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
