// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands;

import frc.robot.subsystems.GrabberSubsystems.TurretSubsystem;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoTurretTurn extends CommandBase {
  private final TurretSubsystem m_turretSubsystem;
  private int m_angle, direction;
  private boolean finished = false;


  /** 
   * Creates a new TankDrive command.
   *
   * @param driveSubsystem The subsystem used by this command.
   */
  public AutoTurretTurn(TurretSubsystem turretSubsystem, int angle) {
    m_turretSubsystem = turretSubsystem;
    m_angle = angle;
    addRequirements(m_turretSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    if (m_turretSubsystem.getEncoderPosition() < 0) {

      direction = -1;

      m_turretSubsystem.TurretTurn(-0.1);
      //turn left
      
    }
    else if (m_turretSubsystem.getEncoderPosition() > 0) {

      m_turretSubsystem.TurretTurn(0.1);

      direction = 1;


      //go right
    }

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (direction == 1) {
      if (m_turretSubsystem.getEncoderPosition() >= 0) {
        m_turretSubsystem.TurretTurn(0);
        finished = true;
      }
    }

    else if (direction == -1) {
      if (m_turretSubsystem.getEncoderPosition() <= 0) {
        m_turretSubsystem.TurretTurn(0);
        finished = true;
      }
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
    return finished;
  }
}