package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveCommands.DriveDistance;
import frc.robot.commands.DriveCommands.TurnDegrees;
import frc.robot.commands.DriveCommands.setBrake;
import frc.robot.commands.GrabberCommands.Wrist.WristUnlatch;
import frc.robot.commands.VisionCommands.TurnTarget;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LightSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.GrabberSubsystems.WristSubsystem;

public class AutoTest extends SequentialCommandGroup{
    
    public AutoTest(DriveSubsystem m_drive, VisionSubsystem m_vision, WristSubsystem m_wrist, LightSubsystem m_light) {
        addCommands(
            new setBrake(m_drive, m_light),
            new DriveDistance(m_drive, -48, 0.07, 0),
            new WaitCommand(0.5),
            new TurnDegrees(m_drive, 132, 0.09, 1, 0)
        );
    }
}
