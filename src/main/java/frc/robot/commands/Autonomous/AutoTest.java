package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.CalibrateGyro;
import frc.robot.commands.DriveCommands.DriveDistance;
import frc.robot.commands.DriveCommands.TurnDegrees;
import frc.robot.subsystems.DriveSubsystem;

public class AutoTest extends SequentialCommandGroup{
    
    public AutoTest(DriveSubsystem m_drive) {
        addCommands(
            new CalibrateGyro(m_drive),
            new DriveDistance(m_drive, 48, 0.5, 0),
            new DriveDistance(m_drive, 24, 0.2),
            new DriveDistance(m_drive, -24, 0.5),
            new TurnDegrees(m_drive, 90, 0.1, 1, 0)
        );
    }
}
