package frc.robot.commands.Autonomous.Paths.WorldsVersion;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveCommands.*;
import frc.robot.commands.GrabberCommands.Arm.ArmAutoExtendHigh;
import frc.robot.commands.GrabberCommands.Arm.ArmRetract;
import frc.robot.commands.GrabberCommands.Intake.IntakeOff;
import frc.robot.commands.GrabberCommands.Intake.IntakeOn;
import frc.robot.commands.GrabberCommands.Intake.IntakeReverse;
import frc.robot.commands.GrabberCommands.Wrist.WristIn;
import frc.robot.commands.GrabberCommands.Wrist.WristOut;
import frc.robot.commands.GrabberCommands.Wrist.WristUnlatch;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LightSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;
import frc.robot.subsystems.GrabberSubsystems.IntakeSubsystem;
import frc.robot.subsystems.GrabberSubsystems.WristSubsystem;

public class PathAnyScore extends SequentialCommandGroup {

    
    /**
     * 
     * @param m_drive
     * @param m_arm
     * @param m_armBase
     * @param m_claw
     * @param m_turret
     */
    public PathAnyScore(DriveSubsystem m_drive, ArmSubsystem m_arm, IntakeSubsystem m_intake, WristSubsystem m_wrist, LightSubsystem m_light) {
        addCommands(
        new CalibrateGyro(m_drive),

        new IntakeOn(m_intake),
        new WristUnlatch(m_wrist),
        new WaitCommand(0.15),
        new ParallelCommandGroup(new ArmAutoExtendHigh(m_arm), new SequentialCommandGroup(new WaitCommand(0.25), new WristOut(m_wrist))), //new WristOut(m_wrist)
        new setBrake(m_drive, m_light),
        new DriveDistance(m_drive, 10, 0.07),
        new IntakeReverse(m_intake),
        new WaitCommand(0.5),
        new ParallelDeadlineGroup(new DriveDistance(m_drive, -8, 0.05), new ArmAutoExtendHigh(m_arm), new WristIn(m_wrist)),
        new ParallelCommandGroup(new IntakeOff(m_intake), new ArmRetract(m_arm))
        );

    }

}
