package frc.robot.commands.Autonomous.Paths.Blue.PathBlue3;

import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmBaseSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ClawSubsystem;
import frc.robot.subsystems.GrabberSubsystems.TurretSubsystem;

public class Blue3Score extends SequentialCommandGroup {

    /**
     * 
     * @param m_drive
     * @param m_arm
     * @param m_armBase
     * @param m_claw
     * @param m_turret
     */
    public Blue3Score(DriveSubsystem m_drive, ArmSubsystem m_arm, ArmBaseSubsystem m_armBase, ClawSubsystem m_claw, TurretSubsystem m_turret) {
        addCommands(
            new PrintCommand("Blue 3 Score")
        );

    }

}
