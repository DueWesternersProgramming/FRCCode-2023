package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveCommands.DriveDistance;
import frc.robot.commands.GrabberCommands.Arm.ArmAutoExtendHigh;
import frc.robot.commands.GrabberCommands.Intake.IntakeOn;
import frc.robot.commands.GrabberCommands.Wrist.WristOut;
import frc.robot.commands.GrabberCommands.Wrist.WristUnlatch;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LightSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;
import frc.robot.subsystems.GrabberSubsystems.IntakeSubsystem;
import frc.robot.subsystems.GrabberSubsystems.WristSubsystem;

public class AutoTest extends SequentialCommandGroup{
    
    public AutoTest(DriveSubsystem m_drive, VisionSubsystem m_vision, WristSubsystem m_wrist, LightSubsystem m_light, IntakeSubsystem m_intake, ArmSubsystem m_arm) {
        addCommands(
            new DriveDistance(m_drive, 12, 0.10)
            //new TurnDegrees(m_drive, 132, 0.09, 1, 0)
        );
    }
}
