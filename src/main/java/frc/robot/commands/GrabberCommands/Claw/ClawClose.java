// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Claw;

import frc.robot.Constants.ClawConstants;
import frc.robot.subsystems.GrabberSubsystems.ClawSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ClawClose extends CommandBase {
  private final ClawSubsystem m_clawSubsystem;
  private int m_item;
  /**
   * Creates a new ClawClose command.
   *
   * @param driveSubsystem The subsystem used by this command.
   * @param item 0 = cube, 1 = cone
   */
  public ClawClose(ClawSubsystem clawSubsystem, int item) {
    m_clawSubsystem = clawSubsystem;
    m_item = item;
    addRequirements(m_clawSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Initialize");
    if (m_item == 0){
      m_clawSubsystem.setPosition(ClawConstants.kClosedCube);
      System.out.println("Cube");
    }
    else if (m_item == 1) {
      m_clawSubsystem.setPosition(ClawConstants.kClosedCone);
      System.out.println("Cone");
    }
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