// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GrabberSubsystem;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Turret extends CommandBase {
  private final GrabberSubsystem m_grabberSubsystem;
  static DoubleSupplier m_left, m_right;
  private double m_leftModified, m_rightModified;

  /**
   * Creates a new TankDrive command.
   *
   * @param driveSubsystem The subsystem used by this command.
   */
  public Turret(GrabberSubsystem grabberSubsystem, DoubleSupplier left, DoubleSupplier right) {
    m_grabberSubsystem = grabberSubsystem;
    m_left = left;
    m_right = right;

    System.out.print("left: ");
    System.out.println(left);

    System.out.print("right: ");
    System.out.println(right);



    addRequirements(m_grabberSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (m_left.getAsDouble() > 0.2) {
      m_grabberSubsystem.TurretTurn((m_left.getAsDouble() - m_right.getAsDouble())*-1);
    }
    else if (m_right.getAsDouble() > 0.2) {
      m_grabberSubsystem.TurretTurn(m_right.getAsDouble() - m_left.getAsDouble());
    }
    else {
      m_grabberSubsystem.TurretTurn(0);
    }
    
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