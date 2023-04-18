package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.DriveChargeBalance;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LightSubsystem;

public class AutoDriveBalanceTest extends SequentialCommandGroup{
    
    public AutoDriveBalanceTest(DriveSubsystem m_drive, LightSubsystem m_light) {
        addCommands(
            new DriveChargeBalance(m_drive, m_light, false, true, 1)
        );
    }
}
