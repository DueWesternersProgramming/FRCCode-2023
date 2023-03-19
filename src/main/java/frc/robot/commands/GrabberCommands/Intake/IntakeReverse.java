// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Intake;

import frc.robot.subsystems.GrabberSubsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class IntakeReverse extends CommandBase {
  private final IntakeSubsystem m_intakeSubsystem;
  /**
   * Creates a new ClawClose command.
   *
   * @param driveSubsystem The subsystem used by this command.
   * 
   */

  public IntakeReverse(IntakeSubsystem intakeSubsystem) {
    m_intakeSubsystem = intakeSubsystem;
    addRequirements(m_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intakeSubsystem.intakeReverse();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}