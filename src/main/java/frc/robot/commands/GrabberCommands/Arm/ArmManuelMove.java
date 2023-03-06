// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Arm;

import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArmManuelMove extends CommandBase {
  private final ArmSubsystem m_armSubsystem;
  static double m_extention;
  boolean isFinished = false;
  DoubleSupplier m_speed;

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
    //m_armSubsystem.setSpeed(1);
    //m_armSubsystem.setPosition(ArmConstants.kArmDown);
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_armSubsystem.runArm(m_speed.getAsDouble());
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
    