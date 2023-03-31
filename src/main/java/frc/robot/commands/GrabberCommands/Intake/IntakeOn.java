// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Intake;

import frc.robot.Constants.IntakeConstants;
import frc.robot.subsystems.GrabberSubsystems.IntakeSubsystem;

import java.time.LocalTime;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class IntakeOn extends CommandBase {
  private final IntakeSubsystem m_intakeSubsystem;
  private double previousPosition;
  //private boolean finished = false;
  private int startStallTime, nextStallTick, currentTime;
  /**
   * Creates a new ClawClose command.
   *
   * @param driveSubsystem The subsystem used by this command.
   * 
   */

  public IntakeOn(IntakeSubsystem intakeSubsystem) {
    m_intakeSubsystem = intakeSubsystem;
    addRequirements(m_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //finished = true;
    m_intakeSubsystem.intakeOn();
    // previousPosition = Math.abs(m_intakeSubsystem.getEncoderPosition());
    // startStallTime = (LocalTime.now().getSecond() + 1);
    // nextStallTick = (LocalTime.now().getSecond() + 1);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // currentTime = LocalTime.now().getSecond();
    // if (currentTime > startStallTime){
    //   if (currentTime > nextStallTick){
    //     if (m_intakeSubsystem.getSpeed() > 0){
    //       if (Math.abs(m_intakeSubsystem.getEncoderPosition()) < (previousPosition + IntakeConstants.kIntakeStallTolerance)){
    //         finished = true;
    //       }
    //       else {
    //         previousPosition = Math.abs(m_intakeSubsystem.getEncoderPosition());
    //         nextStallTick = (currentTime + 1);
    //       }
    //     }
    //   }
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //m_intakeSubsystem.intakeOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}