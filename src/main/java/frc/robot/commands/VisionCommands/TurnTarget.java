// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.VisionCommands;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class TurnTarget extends CommandBase {
  private final VisionSubsystem m_visionSubsystem;
  private final DriveSubsystem m_driveSubsystem;
  private boolean finished = false;

  /**
   *
   * @param turretSubsystem
   * @param visionSubsystem
   */
  public TurnTarget(DriveSubsystem driveSubsystem, VisionSubsystem visionSubsystem) {
    m_visionSubsystem = visionSubsystem;
    m_driveSubsystem = driveSubsystem;
    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    finished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    System.out.println(m_visionSubsystem.GetTargetHorizontalOffset());
    if (m_visionSubsystem.HasValidTarget()){
      if (m_visionSubsystem.GetTargetHorizontalOffset() > 0) {
        m_driveSubsystem.TankDrive(-0.25, 0.25);
        System.out.println("Left");
      }
      else if(m_visionSubsystem.GetTargetHorizontalOffset() < -0) {
        m_driveSubsystem.TankDrive(0.25, -0.25);
        System.out.println("Right");
      }
      else {
        m_driveSubsystem.TankDrive(0, 0);
        //finished = true;
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveSubsystem.TankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
    