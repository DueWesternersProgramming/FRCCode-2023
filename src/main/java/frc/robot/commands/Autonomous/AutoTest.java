package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.VisionCommands.TurnTarget;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class AutoTest extends SequentialCommandGroup{
    
    public AutoTest(DriveSubsystem m_drive, VisionSubsystem m_vision) {
        addCommands(
            new TurnTarget(m_drive, m_vision)
        );
    }
}
