package frc.robot.commands.Autonomous.Paths.WorldsVersion;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveCommands.*;
import frc.robot.commands.GrabberCommands.Arm.ArmAutoExtendHigh;
import frc.robot.commands.GrabberCommands.Arm.ArmAutoExtendLow;
import frc.robot.commands.GrabberCommands.Arm.ArmRetract;
import frc.robot.commands.GrabberCommands.Intake.IntakeOff;
import frc.robot.commands.GrabberCommands.Intake.IntakeOn;
import frc.robot.commands.GrabberCommands.Intake.IntakeReverse;
import frc.robot.commands.GrabberCommands.Wrist.WristIn;
import frc.robot.commands.GrabberCommands.Wrist.WristOut;
import frc.robot.commands.GrabberCommands.Wrist.WristUnlatch;
import frc.robot.commands.VisionCommands.TurnTarget;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LightSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;
import frc.robot.subsystems.GrabberSubsystems.IntakeSubsystem;
import frc.robot.subsystems.GrabberSubsystems.WristSubsystem;

public class PathSides extends SequentialCommandGroup {

    
    /**
     * 
     * @param m_drive
     * @param m_arm
     * @param m_armBase
     * @param m_claw
     * @param m_turret
     * @param ending true = score, false = chargestation
     */
    public PathSides(DriveSubsystem m_drive, ArmSubsystem m_arm, IntakeSubsystem m_intake, WristSubsystem m_wrist, LightSubsystem m_light, VisionSubsystem m_vision) {
        addCommands(
            new CalibrateGyro(m_drive),

            new ParallelCommandGroup(new IntakeOn(m_intake), new WristUnlatch(m_wrist), new SequentialCommandGroup(new setBrake(m_drive, m_light), new AutoSpeed(m_drive))),
            new WaitCommand(0.25),
            new ParallelCommandGroup(new ArmAutoExtendHigh(m_arm), new WristOut(m_wrist)),
            new DriveDistance(m_drive, 10, 0.05),
            new IntakeReverse(m_intake),
            new WaitCommand(0.5),
            new ParallelCommandGroup(new IntakeOff(m_intake), new ArmAutoExtendHigh(m_arm), new DriveDistance(m_drive, -12, 0.05)),
            new ParallelCommandGroup(new WristIn(m_wrist), new ArmRetract(m_arm), new DriveDistance(m_drive, -46, 0.1)),
            //new WaitCommand(0.5),
            new ParallelCommandGroup(new TurnDegrees(m_drive, 132, 0.09, 1, 0),new ArmAutoExtendLow(m_arm)),
            new ParallelDeadlineGroup(new WristOut(m_wrist), new TurnTarget(m_drive, m_vision, 0.0, false), new IntakeOn(m_intake)),
            new DriveDistance(m_drive, 12, 0.1),
            new ToggleSpeeds(m_drive)
            
            // new DriveDistance(m_drive, -7, 0.1),
            // new WaitCommand(0.5),
            // new ParallelCommandGroup(new DriveDistance(m_drive, 54, 0.15), new SetVisionPipeline(m_vision, 0), new SequentialCommandGroup(new IntakeOn(m_intake), new WristUnlatch(m_wrist), new WaitCommand(0.15),
            // new ParallelCommandGroup(new ArmAutoExtendLow(m_arm), new SequentialCommandGroup(new WaitCommand(0.25), new WristOut(m_wrist))))),
            // new TurnDegrees(m_drive, 10, 0.05, 1, 0),
            // new ParallelRaceGroup(new TurnTarget(m_drive, m_vision, 0.0), new WaitCommand(1)),
            // new DriveDistance(m_drive, 12, 0.1),

            //new WristIn(m_wrist),
            //new TurnDegrees(m_drive, m_drive.getTurnTargetMovementResult(), 0.1, m_drive.getTurnTargetMovementDirection(), 0), // Turn to original heading
            // new TurnDegrees(m_drive, 132.5, 0.1, 1, 0),
            // new ParallelCommandGroup(new DriveDistance(m_drive, 42, 0.2), new ArmAutoExtendHigh(m_arm), new WristOut(m_wrist)),
            // new DriveDistance(m_drive, 10, 0.1),
            // new IntakeReverse(m_intake),
            // new WaitCommand(0.5),
            // new IntakeOff(m_intake),
            // new ParallelDeadlineGroup(new DriveDistance(m_drive, -8, 0.05), new ArmAutoExtendHigh(m_arm), new WristIn(m_wrist)),
            // new ParallelRaceGroup(new ArmRetract(m_arm), new TurnDegrees(m_drive, 132.5, 0.1, 1, 0))

        // new IntakeOn(m_intake),
        // new WristUnlatch(m_wrist),
        // new WaitCommand(0.5),
        // new ParallelCommandGroup(new ArmAutoExtendHigh(m_arm), new WristOut(m_wrist)),
        // new setBrake(m_drive, m_light),
        // new DriveDistance(m_drive, 10, 0.05),
        // new IntakeReverse(m_intake),
        // new WaitCommand(1),
        // new IntakeOff(m_intake),
        // new ParallelCommandGroup(new ArmAutoExtendHigh(m_arm), new DriveDistance(m_drive, -12, 0.05)),
        // new ParallelCommandGroup(new WristIn(m_wrist), new ArmRetract(m_arm), new DriveDistance(m_drive, -46, 0.1)),
        // new WaitCommand(0.5),
        // new TurnDegrees(m_drive, 132, 0.09, 1, 0),
        // new ParallelCommandGroup(new ArmAutoExtendLow(m_arm), new WristOut(m_wrist))
        //new setCoast(m_drive, m_light)
        
        );

    }

}
