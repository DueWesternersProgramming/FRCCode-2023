// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.VisionCommands;

import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.GrabberSubsystems.TurretSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class TurretTurnTarget extends CommandBase {
  private final VisionSubsystem m_visionSubsystem;
  private final TurretSubsystem m_TurretSubsystem;
  private boolean finished = false;

  /**
   *
   * @param turretSubsystem
   * @param visionSubsystem
   */
  public TurretTurnTarget(TurretSubsystem turretSubsystem, VisionSubsystem visionSubsystem) {
    m_visionSubsystem = visionSubsystem;
    m_TurretSubsystem = turretSubsystem;
    addRequirements(m_TurretSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    finished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    System.out.println(m_visionSubsystem.getyaw());

    if (m_visionSubsystem.getyaw() > 1) {
      //m_TurretSubsystem.TurretTurn(TurretConstants.kTurretSpeed * -1);
      
    }
    else if(m_visionSubsystem.getyaw() < -1) {
      //m_TurretSubsystem.TurretTurn(TurretConstants.kTurretSpeed);
    }
    else {
      finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_TurretSubsystem.TurretTurn(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
    