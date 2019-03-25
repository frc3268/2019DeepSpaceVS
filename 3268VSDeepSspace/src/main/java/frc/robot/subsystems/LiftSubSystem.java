/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The motors which drive the robot, and their methods of control.
 */
public class LiftSubSystem extends Subsystem {
	
	Compressor c;
	DoubleSolenoid frontPiston;
	DoubleSolenoid backPiston;
	
	public static final double TRAVEL_TIME = 2.0;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public LiftSubSystem() {
		c = new Compressor();
		//	Initialize pistons, forward & reverse channels
		frontPiston  = new DoubleSolenoid (3, 2);
		backPiston = new DoubleSolenoid(5, 4);

	}
	
	public void SetCompressor(int type) 
	{
		switch (type) 
		{
			case 0:
				c.start();
				break;
			
			case 1:
				c.stop();
				break;
		}
	}
	
	public void ExtendPiston(int type) 
	{
		switch (type) 
		{
			case 0:
				frontPiston.set(DoubleSolenoid.Value.kForward);
				break;
			case 1:
				backPiston.set(DoubleSolenoid.Value.kForward);
				break;
		}
	}
	
	public void ReversePiston(int type) 
	{
		switch (type)
		{
			case 0:
				frontPiston.set(DoubleSolenoid.Value.kReverse);
				break;
			
			case 1:
				backPiston.set(DoubleSolenoid.Value.kReverse);
				break;
		}
	}
	

	public void stopPiston(int type) {
		switch (type)
		{
			case 0:
				frontPiston.set(DoubleSolenoid.Value.kOff);
				break;
			
			case 1:
				backPiston.set(DoubleSolenoid.Value.kOff);
				break;
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
