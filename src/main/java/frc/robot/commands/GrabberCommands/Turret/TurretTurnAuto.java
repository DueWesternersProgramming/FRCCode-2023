// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Turret;

import frc.robot.Constants.TurretConstants;
import frc.robot.subsystems.GrabberSubsystems.TurretSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TurretTurnAuto extends CommandBase {
  private final TurretSubsystem m_turretSubsystem;
  private int m_angle, direction;
  private boolean finished = false;
  private double currentPos;


  /** 
   * Creates a new TankDrive command.
   *
   * @param driveSubsystem The subsystem used by this command.
   */
  public TurretTurnAuto(TurretSubsystem turretSubsystem, int angle) {
    m_turretSubsystem = turretSubsystem;
    m_angle = angle;
    addRequirements(m_turretSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    finished = false;
    currentPos = m_turretSubsystem.getEncoderPosition();
    if (currentPos > m_angle) {
      direction = TurretConstants.kTurnLeft;
    }
    else if (currentPos < m_angle) {
      direction = TurretConstants.kTurnRight;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Running");
    currentPos = m_turretSubsystem.getEncoderPosition();    
    System.out.println("Current Position: " + currentPos);
    System.out.println("Direction: " + direction);
    System.out.println("m_angle: " + m_angle);

    if (direction == TurretConstants.kTurnLeft) {
      System.out.println("Left");
      if (currentPos > m_angle) {
        m_turretSubsystem.TurretTurn(-0.10);
        System.out.println("Turing left");
      }
      else {
        System.out.println("Finishing left");
        finished = true;
      }
    }
    else if (direction == TurretConstants.kTurnRight) {
      System.out.println("Right");
      if (currentPos < m_angle) {
        m_turretSubsystem.TurretTurn(0.10);
        System.out.println("Turing right");
      }
      else {
        System.out.println("Finishing right");
        finished = true;
      }
    }
    else {
      System.out.println("You shouldn't be here.");
      finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Stopped PERMANENTLY " + finished);
    m_turretSubsystem.TurretTurn(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}