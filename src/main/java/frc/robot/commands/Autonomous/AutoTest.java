package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.DriveDistance;
import frc.robot.subsystems.DriveSubsystem;

public class AutoTest extends SequentialCommandGroup{
    
    public AutoTest(DriveSubsystem m_drive) {
        addCommands(
            new DriveDistance(m_drive, 48, 0.5, 0)
        );
    }


}
