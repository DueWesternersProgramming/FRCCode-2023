// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GrabberCommands.Wrist;

import frc.robot.Constants.WristConstants;
import frc.robot.subsystems.GrabberSubsystems.WristSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class WristIn extends CommandBase {
  private final WristSubsystem m_wristSubsystem;
  private boolean finished;

  /**
   * Creates a new TankDrive command.
   *
   * @param armsubsystem The subsystem used by this command.
   */
  public WristIn(WristSubsystem wristSubsystem) {
    m_wristSubsystem = wristSubsystem;
    addRequirements(m_wristSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    finished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_wristSubsystem.getEncoderPosition() > WristConstants.kInPosition){
      m_wristSubsystem.runWrist(-WristConstants.kWristSpeed* 2);
    }
    else{
      finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_wristSubsystem.runWrist(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
    