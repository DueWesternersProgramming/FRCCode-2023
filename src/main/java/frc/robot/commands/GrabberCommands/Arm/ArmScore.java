// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Arm;

import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArmScore extends CommandBase {
  private final ArmSubsystem m_armSubsystem;
  private double currentPos;
  private int direction;
  private boolean finished = false;


  /** 
   * Creates a new TankDrive command.
   *
   * @param driveSubsystem The subsystem used by this command.
   */
  public ArmScore(ArmSubsystem armSubsystem) {
    m_armSubsystem = armSubsystem;
    addRequirements(m_armSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    finished = false;
    currentPos = m_armSubsystem.getEncoderPosition();
    if (currentPos < ArmConstants.kScorePosition) {
      direction = ArmConstants.kMoveDown;
    }
    else if (currentPos > ArmConstants.kScorePosition) {
      direction = ArmConstants.kMoveUp;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentPos = m_armSubsystem.getEncoderPosition();    

    if (direction == ArmConstants.kMoveUp) {
      if (currentPos > ArmConstants.kScorePosition) {
        m_armSubsystem.runArm(-ArmConstants.kArmSpeed);
      }
      else {
        finished = true;
      }
    }
    else if (direction == ArmConstants.kMoveDown) {
      if (currentPos < ArmConstants.kScorePosition) {
        m_armSubsystem.runArm(ArmConstants.kArmSpeed);
      }
      else {
        finished = true;
      }
    }
    else {
      finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_armSubsystem.runArm(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}