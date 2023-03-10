// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Claw;

import frc.robot.Constants.ClawConstants;
import frc.robot.subsystems.GrabberSubsystems.ClawSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ClawOpen extends CommandBase {
  private final ClawSubsystem m_clawSubsystem;
  /**
   * Creates a new ClawClose command.
   *
   * @param driveSubsystem The subsystem used by this command.
   */
  public ClawOpen(ClawSubsystem clawSubsystem) {
    m_clawSubsystem = clawSubsystem;
    addRequirements(m_clawSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_clawSubsystem.setPosition(ClawConstants.kOpenPosition);
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