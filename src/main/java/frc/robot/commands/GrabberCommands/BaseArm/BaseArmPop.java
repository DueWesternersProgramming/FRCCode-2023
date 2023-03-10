// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.BaseArm;

import frc.robot.Constants.BaseArmConstants;
import frc.robot.subsystems.GrabberSubsystems.ArmBaseSubsystem;

import java.time.LocalTime;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class BaseArmPop extends CommandBase {
  private final ArmBaseSubsystem m_armBaseSubsystem;
  private boolean finished = false;
  private int time;

  /**
   * @param ArmBaseSubsystem 
   *
   */
  public BaseArmPop(ArmBaseSubsystem armbaseSubsystem) {
    m_armBaseSubsystem = armbaseSubsystem;
    addRequirements(m_armBaseSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    finished = false;
    time = (LocalTime.now().getSecond()) + 1;
    m_armBaseSubsystem.ArmBaseMove(-0.3);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (LocalTime.now().getSecond() >= time){
      finished = true;
    }
    else {
      m_armBaseSubsystem.ArmBaseMove(BaseArmConstants.kBaseArmSpeed);
      System.out.println("Bumping");
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_armBaseSubsystem.ArmBaseMove(0);
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
    