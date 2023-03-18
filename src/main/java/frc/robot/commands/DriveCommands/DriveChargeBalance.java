// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveCommands;

import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LightSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveChargeBalance extends CommandBase {
  private final DriveSubsystem m_driveSubsystem;
  private final LightSubsystem m_lightSubsystem;
  private boolean m_justChecking;
  private boolean finished = false;

  /**
   * Creates a new TankDrive command.
   *
   * @param driveSubsystem The subsystem used by this command.
   */
  public DriveChargeBalance(DriveSubsystem driveSubsystem, LightSubsystem lightSubsystem, boolean justChecking) {
    m_driveSubsystem = driveSubsystem;
    m_lightSubsystem = lightSubsystem;
    m_justChecking = justChecking;
    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (!m_justChecking){
      m_driveSubsystem.setBrake();
    }
    finished = false;
    m_lightSubsystem.setColor(0, 255, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!m_justChecking){
      System.out.println("Looping");
      if (m_driveSubsystem.getRotation() < -3){
        m_driveSubsystem.TankDrive(-0.55, -0.55);
        System.out.println("Moving 1");
      }
      else if (m_driveSubsystem.getRotation() > DriveConstants.kChargeBalanceTolerance){
        m_driveSubsystem.TankDrive(0.45, 0.45);   // If issues, slow down
        System.out.println("Moving 2");
      }
      else {
        m_driveSubsystem.TankDrive(0, 0);
        System.out.println("Stopping");
      }
    }
    else {
      if (m_driveSubsystem.getRotation() < -3){
        m_driveSubsystem.TankDrive(-0.55, -0.55);
      }
      else {
        finished = true;
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //m_driveSubsystem.TankDrive(0.0, 0.0);
    m_driveSubsystem.setCoast();
    m_lightSubsystem.setColor(255, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}