/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ClimbAutoComand extends Command {
  public Timer t = new Timer();
  public ClimbAutoComand() {
    // Use requires() here to declare subsystem dependencies
   // requires(Robot.m_subsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   // NOT TESTED, MAY NOT WORK
    t.start();
    Robot.lift.ReversePiston(0);
    Robot.driveTrain.tankDrive(0.5);
   // t.delay(0.5);
    Robot.lift.ExtendPiston(0);
    Robot.lift.ReversePiston(1);
    //t.delay(0.5);
    Robot.lift.ExtendPiston(1);
   // t.delay(1);
    Robot.driveTrain.tankDrive(0.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
