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
  private boolean finished, m_finish = false;
  private double beforeAngle, afterAngle, m_offset;
  private int beforeSpeed;

  /**
   *
   * @param turretSubsystem
   * @param visionSubsystem
   */
  public TurnTarget(DriveSubsystem driveSubsystem, VisionSubsystem visionSubsystem, Double offset, boolean finish) {
    m_visionSubsystem = visionSubsystem;
    m_driveSubsystem = driveSubsystem;
    m_offset = offset;
    m_finish = finish;
    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    finished = false;
    beforeAngle = m_driveSubsystem.getGyroAngle();
    beforeSpeed = m_driveSubsystem.getSpeed();
    if (m_driveSubsystem.getSpeed() != 1){
      m_driveSubsystem.normalSpeed();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    System.out.println(m_visionSubsystem.GetTargetHorizontalOffset());
    if (m_visionSubsystem.HasValidTarget()){
      if (m_visionSubsystem.GetTargetHorizontalOffset() > (1.5 + m_offset)) {
        m_driveSubsystem.TankDrive(-0.42, 0.42);
        System.out.println("Left");
      }
      else if(m_visionSubsystem.GetTargetHorizontalOffset() < (-1.5 + m_offset)) {
        m_driveSubsystem.TankDrive(0.42, -0.42);
        System.out.println("Right");
      }
      else {
        m_driveSubsystem.TankDrive(0, 0);
        if (m_finish){
          finished = true;
        }
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveSubsystem.TankDrive(0, 0);
    m_driveSubsystem.setSpeed(beforeSpeed);
    afterAngle = m_driveSubsystem.getGyroAngle();
    if (afterAngle > beforeAngle) {
      m_driveSubsystem.setTurnTargetMovementResult(-(afterAngle - beforeAngle));  // What needs to happen to reallign after running
    }
    else if (afterAngle < beforeAngle){
      m_driveSubsystem.setTurnTargetMovementResult(beforeAngle - afterAngle);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
    