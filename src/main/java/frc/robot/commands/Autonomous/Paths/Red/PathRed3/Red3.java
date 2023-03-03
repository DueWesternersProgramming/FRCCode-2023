package frc.robot.commands.Autonomous.Paths.Red.PathRed3;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.DriveDistance;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmBaseSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ClawSubsystem;
import frc.robot.subsystems.GrabberSubsystems.TurretSubsystem;

public class Red3 extends SequentialCommandGroup{
    

    public Red3(DriveSubsystem m_drive, ArmSubsystem m_arm, ArmBaseSubsystem m_armBase, ClawSubsystem m_claw, TurretSubsystem m_turret, BooleanSupplier ending) {
        addCommands(
            /** (make sure code is in opisite deriection as red)
             * (arm starts backwards)extend arm toward node 8 or 9
             * open claw 
             * drive foward while retracting arm a little 
             */
            new DriveDistance(m_drive, 210, 0.5),
            /**
             * turn turret toward object 4
             * lower and extend arm toward object 4
             * retract arm
             * option(1)turn around and head to coummunity node 8 or 9
             */ new DriveDistance(m_drive, 210, 0.5),
            /**
             *  extend arm toward node 
             *  open claw 
             * option (2) turn toward charging station
             * go onto charge station
             */ new DriveDistance(m_drive, 114, 0.5)
            /**  balence 
             */
        );
    }


}
