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
  private boolean m_justChecking, m_direction;
  private boolean finished, started = false;
  private double tolerance, m_speedMultiplier;


  /**
   * 
   * @param driveSubsystem
   * @param lightSubsystem
   * @param justChecking Stops running when has reached top
   * @param direction true = forward, false = bacward
   */
  public DriveChargeBalance(DriveSubsystem driveSubsystem, LightSubsystem lightSubsystem, boolean justChecking, boolean direction, double speedMultiplier) {
    m_driveSubsystem = driveSubsystem;
    m_lightSubsystem = lightSubsystem;
    m_justChecking = justChecking;
    m_direction = direction;
    m_speedMultiplier = speedMultiplier;
    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (!m_justChecking){
      m_driveSubsystem.setBrake();
    }
    finished = false;
    started = false;
    
    if (m_direction){
      m_lightSubsystem.setColor(0, 255, 0);
    }
    else {
      m_lightSubsystem.setColor(0, 0, 255);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_direction){
      if (!m_justChecking){
        if (started) {
          tolerance = DriveConstants.kChargeForwardModifiedStartTolerance;
        }
        else {
          tolerance = DriveConstants.kChargeForwardInitialStartTolerance;
        }
        if (m_driveSubsystem.getRotation() > tolerance){
          m_driveSubsystem.TankDrive(-0.45 * m_speedMultiplier, -0.45 * m_speedMultiplier);
          System.out.println("Moving 1");
        }
        else if (m_driveSubsystem.getRotation() < DriveConstants.kChargeForwardBalanceTolerance){
          m_driveSubsystem.TankDrive(0.47 * m_speedMultiplier, 0.47 * m_speedMultiplier);
          System.out.println("Moving 2");
          started = true;
        }
        else {
          m_driveSubsystem.TankDrive(0, 0);
          System.out.println("Stopping");
        }
      }
      else {
        if (m_driveSubsystem.getRotation() > 3){
          m_driveSubsystem.TankDrive(-0.75 * m_speedMultiplier, -0.75 * m_speedMultiplier);
        }
        else {
          finished = true;
        }
      }
    }
    else {
      if (!m_justChecking){
        if (started) {
          tolerance = DriveConstants.kChargeBackwardModifiedStartTolerance;
        }
        else {
          tolerance = DriveConstants.kChargeBackwardInitialStartTolerance;
        }
        if (m_driveSubsystem.getRotation() < tolerance){
          m_driveSubsystem.TankDrive(0.45 * m_speedMultiplier, 0.45 * m_speedMultiplier);
          System.out.println("Moving 1 Backwards");
        }
        else if (m_driveSubsystem.getRotation() > DriveConstants.kChargeBackwardBalanceTolerance){
          m_driveSubsystem.TankDrive(-0.425 * m_speedMultiplier,-0.425 * m_speedMultiplier);   // If issues, slow down
          System.out.println("Moving 2 Backwards");
          started = true;
        }
        else {
          m_driveSubsystem.TankDrive(0, 0);
          System.out.println("Stopping Backwards");
        }
      }
      else {
        if (m_driveSubsystem.getRotation() < -3){
          m_driveSubsystem.TankDrive(0.85 * m_speedMultiplier, 0.85 * m_speedMultiplier);
        }
        else {
          finished = true;
        }
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