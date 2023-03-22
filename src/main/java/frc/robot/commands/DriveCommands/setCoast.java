package frc.robot.commands.DriveCommands;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LightSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An intake command that uses the driveSubsystem. */
public class setCoast extends CommandBase {
  private final DriveSubsystem m_driveSubsystem;
  private final LightSubsystem m_lightSubsystem;

  /**
   * Creates a new StartIntake command.
   *
   * @param intakeSubsystem The subsystem used by this command.
   */
  public setCoast(DriveSubsystem driveSubsystem, LightSubsystem lightSubsystem) {
    m_driveSubsystem = driveSubsystem;
    m_lightSubsystem = lightSubsystem;
    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_driveSubsystem.setCoast();
    m_lightSubsystem.setColor(255, 0, 0);
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