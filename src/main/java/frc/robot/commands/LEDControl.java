// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LightSubsystem;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.led.LarsonAnimation;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class LEDControl extends CommandBase {
  private final LightSubsystem m_lightSubsystem;
  LarsonAnimation larsonAnimation;

  /**
   * Creates a new TankDrive command.
   *
   * @param lightSubsystem The subsystem used by this command.
   */
  public LEDControl(LightSubsystem lightSubsystem) {
    m_lightSubsystem = lightSubsystem; 
    larsonAnimation = new LarsonAnimation(255, 0, 0);
    addRequirements(m_lightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_lightSubsystem.setAnimation(larsonAnimation);
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