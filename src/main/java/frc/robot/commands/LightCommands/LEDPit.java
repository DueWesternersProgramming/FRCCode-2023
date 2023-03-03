// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.LightCommands;

import frc.robot.subsystems.LightSubsystem;

import com.ctre.phoenix.led.LarsonAnimation;
import com.ctre.phoenix.led.LarsonAnimation.BounceMode;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class LEDPit extends CommandBase {
  private final LightSubsystem m_lightSubsystem;
  LarsonAnimation larsonAnimation;


  /**
   * Creates a new TankDrive command.
   *
   * @param lightSubsystem The subsystem used by this command.
   */
  public LEDPit(LightSubsystem lightSubsystem) {
    m_lightSubsystem = lightSubsystem; 
    larsonAnimation= new LarsonAnimation(200, 0, 50, 75, 0.5, 230, BounceMode.Back, 7, 8);
    addRequirements(m_lightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_lightSubsystem.setAnimation(larsonAnimation);
    System.out.println("Scheduled");
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