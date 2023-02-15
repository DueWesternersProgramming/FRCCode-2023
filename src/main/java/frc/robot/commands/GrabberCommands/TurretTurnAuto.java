// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands;

import frc.robot.subsystems.GrabberSubsystems.TurretSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TurretTurnAuto extends CommandBase {
  private final TurretSubsystem m_turretSubsystem;
  private int m_angle, direction;
  private boolean finished = false;
  private int goal = 0;
  private double currentPos;
  private int turretRight = 1;
  private int turretLeft = -1;
  private double goalTolerance = 0.03;


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

    if (currentPos > goal) {
      direction = turretLeft;
    }
    else if (currentPos < goal) {
      direction = turretRight;
    }
  }



  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentPos = m_turretSubsystem.getEncoderPosition();
    SmartDashboard.putNumber(":", direction);
    
    if (direction == turretLeft) {
      if (currentPos > 0) {
        System.out.println("turning L");
        m_turretSubsystem.TurretTurn(-0.5);

        //turn left
      }
      else {
        System.out.println("done");
        m_turretSubsystem.TurretTurn(0);
        finished = true;
    
      }
    }
    else if (direction == turretRight) {
      if (currentPos < 0) {
        // 
        System.out.println("turning R");
        m_turretSubsystem.TurretTurn(0.5);
        //go right
      }
      else {

        System.out.println("done");
        m_turretSubsystem.TurretTurn(0);
        finished = true;
    
      }
    }

    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("TURRETFINISHED");
    m_turretSubsystem.TurretTurn(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}