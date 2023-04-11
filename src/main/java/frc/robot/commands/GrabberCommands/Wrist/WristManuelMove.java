// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Wrist;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.GrabberSubsystems.WristSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class WristManuelMove extends CommandBase {
  private final WristSubsystem m_wristSubsystem;
  boolean isFinished = false;
  DoubleSupplier m_speed;
  double m_speedModified;

  /**
   * Creates a new TankDrive command.
   *
   * @param armsubsystem The subsystem used by this command.
   */
  public WristManuelMove(WristSubsystem wristSubsystem, DoubleSupplier speed) {
    m_wristSubsystem = wristSubsystem;
    m_speed = speed;
    addRequirements(m_wristSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_speedModified = m_speed.getAsDouble();
    if (Math.abs(m_speed.getAsDouble()) < OperatorConstants.kControllerDeadZone){
      m_speedModified = 0.0;
    }
    m_wristSubsystem.runWrist(m_speedModified * 1.4);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
    