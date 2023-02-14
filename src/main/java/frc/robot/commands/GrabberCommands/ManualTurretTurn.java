// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands;

import frc.robot.Constants.TurretConstants;
import frc.robot.subsystems.GrabberSubsystems.TurretSubsystem;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ManualTurretTurn extends CommandBase {
  private final TurretSubsystem m_turretSubsystem;
  static DoubleSupplier m_left, m_right;

  /**
   * Creates a new TankDrive command.
   *
   * @param driveSubsystem The subsystem used by this command.
   */
  public ManualTurretTurn(TurretSubsystem turretSubsystem, DoubleSupplier left, DoubleSupplier right) {
    m_turretSubsystem = turretSubsystem;
    m_left = left;
    m_right = right;
    addRequirements(m_turretSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_turretSubsystem.TurretBrake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (m_left.getAsDouble() > TurretConstants.kBumperDeadZone) {
      m_turretSubsystem.TurretTurn((m_left.getAsDouble() - m_right.getAsDouble())*-1);
    }
    else if (m_right.getAsDouble() > TurretConstants.kBumperDeadZone) {
      m_turretSubsystem.TurretTurn(m_right.getAsDouble() - m_left.getAsDouble());
    }
    else {
      m_turretSubsystem.TurretTurn(0);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_turretSubsystem.TurretTurn(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}