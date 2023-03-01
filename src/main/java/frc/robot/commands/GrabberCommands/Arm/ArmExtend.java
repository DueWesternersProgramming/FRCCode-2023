// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Arm;

import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArmExtend extends CommandBase {
  private final ArmSubsystem m_armSubsystem;
  static double m_extention;

  /**
   * Creates a new TankDrive command.
   *
   * @param armsubsystem The subsystem used by this command.
   */
  public ArmExtend(ArmSubsystem armSubsystem) {
    m_armSubsystem = armSubsystem;
    addRequirements(m_armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //m_armSubsystem.setSpeed(1);
    //m_armSubsystem.setPosition(ArmConstants.kArmUp);
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
    