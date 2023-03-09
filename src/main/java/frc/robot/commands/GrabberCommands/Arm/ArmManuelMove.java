// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Arm;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArmManuelMove extends CommandBase {
  private final ArmSubsystem m_armSubsystem;
  boolean isFinished = false;
  DoubleSupplier m_speed;
  double m_speedModified;

  /**
   * Creates a new TankDrive command.
   *
   * @param armsubsystem The subsystem used by this command.
   */
  public ArmManuelMove(ArmSubsystem armSubsystem, DoubleSupplier speed) {
    m_armSubsystem = armSubsystem;
    m_speed = speed;
    addRequirements(m_armSubsystem);
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
    m_armSubsystem.runArm(m_speedModified);
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
    