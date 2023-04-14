// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.VisionCommands;

import frc.robot.subsystems.VisionSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class SetVisionPipeline extends CommandBase {
  private final VisionSubsystem m_visionSubsystem;
  private int m_pipeline;

  /**
   *
   * @param driveSubsystem The subsystem used by this command.
   * @param pipeline 0 = Cube, 1 = Cone, 2 = Apriltag
   */
  public SetVisionPipeline(VisionSubsystem visionSubsystem, int pipeline) {
    m_visionSubsystem = visionSubsystem;
    m_pipeline = pipeline;
    addRequirements(m_visionSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_visionSubsystem.SetActivePipeline(m_pipeline);
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
    