package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.CalibrateGyro;
import frc.robot.subsystems.DriveSubsystem;

public class AutoCalibrateGyro extends SequentialCommandGroup{
    
    public AutoCalibrateGyro(DriveSubsystem m_drive) {
        addCommands(
            new CalibrateGyro(m_drive)
        );
    }
}
