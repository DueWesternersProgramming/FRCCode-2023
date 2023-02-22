// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.LightCommands;

import frc.robot.subsystems.LightSubsystem;

import com.ctre.phoenix.led.ColorFlowAnimation;
import com.ctre.phoenix.led.ColorFlowAnimation.Direction;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class LEDControl extends CommandBase {
  private final LightSubsystem m_lightSubsystem;
  ColorFlowAnimation colorFlowAnimation1, colorFlowAnimation2, colorFlowAnimation3;


  /**
   * Creates a new TankDrive command.
   *
   * @param lightSubsystem The subsystem used by this command.
   */
  public LEDControl(LightSubsystem lightSubsystem) {
    m_lightSubsystem = lightSubsystem; 

    colorFlowAnimation1 = new ColorFlowAnimation(0, 255, 0, 0, 0.5, 100, Direction.Forward, 8);
    colorFlowAnimation2 = new ColorFlowAnimation(255, 0, 0, 0, 0.5, 100, Direction.Forward, 108);
    colorFlowAnimation3 = new ColorFlowAnimation(0, 0, 255, 0, 0.5, 100, Direction.Forward, 208);
    addRequirements(m_lightSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_lightSubsystem.setAnimation(colorFlowAnimation1, 0);
    //m_lightSubsystem.setAnimation(colorFlowAnimation2, 1);
    //m_lightSubsystem.setAnimation(colorFlowAnimation3, 2);
    //m_lightSubsystem.stopAnimation(0);
    //m_lightSubsystem.stopAnimation(1);
    //m_lightSubsystem.stopAnimation(2);
    //m_lightSubsystem.setColor(255, 0, 247);
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