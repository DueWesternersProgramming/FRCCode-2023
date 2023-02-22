// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.VisionCommands;

import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class AutoTurnTarget extends CommandBase {
  private final VisionSubsystem m_visionSubsystem;
  private final DriveSubsystem m_DriveSubsystem;
  private boolean finished = false;

  /**
   *
   * @param driveSubsystem The subsystem used by this command.
   */
  public AutoTurnTarget(VisionSubsystem visionSubsystem, DriveSubsystem driveSubsystem) {
    m_visionSubsystem = visionSubsystem;
    m_DriveSubsystem = driveSubsystem;
    addRequirements(m_DriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    System.out.println(m_visionSubsystem.getyaw());

  if (m_visionSubsystem.getyaw() > 2) {
    m_DriveSubsystem.TankDrive(-1, 1);
  }
  else if(m_visionSubsystem.getyaw() < -2) {
    m_DriveSubsystem.TankDrive(1, -1);
  }
  else {
    m_DriveSubsystem.TankDrive(0, 0);
    finished = true;
  }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
    