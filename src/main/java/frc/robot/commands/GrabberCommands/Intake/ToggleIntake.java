// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Intake;

import frc.robot.subsystems.GrabberSubsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ToggleIntake extends CommandBase {
  private final IntakeSubsystem m_clawSubsystem;
  /**
   * Creates a new ClawClose command.
   *
   * @param driveSubsystem The subsystem used by this command.
   * 
   */

  public ToggleIntake(IntakeSubsystem clawSubsystem) {
    m_clawSubsystem = clawSubsystem;
    addRequirements(m_clawSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (Math.abs(m_clawSubsystem.getSpeed()) > 0){
      m_clawSubsystem.intakeOff();
    }
    else {
      m_clawSubsystem.intakeOn();
    }
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