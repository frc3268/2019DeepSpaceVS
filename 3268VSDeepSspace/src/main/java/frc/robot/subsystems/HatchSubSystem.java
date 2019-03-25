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
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class HatchSubSystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	Compressor compressor;
	DoubleSolenoid piston;
	
	public HatchSubSystem() {
		compressor = new Compressor();
		//	Initialize the double solenoid, forward and reverse channels
		piston = new DoubleSolenoid(1, 0);
	}
	
	public void setCompressor(int type) {
		if(type == 0) {
			compressor.start();
		}
		else {
			compressor.stop();
		}
	}
	
	public void extendPiston() {
		piston.set(DoubleSolenoid.Value.kForward);	//	Extend piston
	}
	
	public void reversePiston() {
		piston.set(DoubleSolenoid.Value.kReverse);	//	Retract piston
	}
	
	public void stopPiston() {
		piston.set(DoubleSolenoid.Value.kOff);	//	Stop piston
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
