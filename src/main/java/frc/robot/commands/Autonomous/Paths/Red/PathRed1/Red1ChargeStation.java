package frc.robot.commands.Autonomous.Paths.Red.PathRed1;

import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveCommands.DriveDistance;
import frc.robot.commands.DriveCommands.TurnDegrees;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmBaseSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ClawSubsystem;
import frc.robot.subsystems.GrabberSubsystems.TurretSubsystem;

public class Red1ChargeStation extends SequentialCommandGroup {

    /**
     * 
     * @param m_drive
     * @param m_arm
     * @param m_armBase
     * @param m_claw
     * @param m_turret
     */
    public Red1ChargeStation(DriveSubsystem m_drive, ArmSubsystem m_arm, ArmBaseSubsystem m_armBase, ClawSubsystem m_claw, TurretSubsystem m_turret) {
        addCommands(
          new PrintCommand("Red 1 Charge Station")
        );
      new TurnDegrees(m_drive,110,0.5, 0, 0);
      new DriveDistance(m_drive, 110, 0.5);
      new TurnDegrees(m_drive, 15, 0.5, 0, 0);
      new DriveDistance(m_drive, 55, 0.5);
      new WaitCommand(2); 
    }

}
