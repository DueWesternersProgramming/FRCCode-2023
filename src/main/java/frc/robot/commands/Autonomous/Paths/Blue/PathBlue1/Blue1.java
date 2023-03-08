package frc.robot.commands.Autonomous.Paths.Blue.PathBlue1;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.DriveDistance;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmBaseSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ClawSubsystem;
import frc.robot.subsystems.GrabberSubsystems.TurretSubsystem;

public class Blue1 extends SequentialCommandGroup{
    

    public Blue1(DriveSubsystem m_drive, ArmSubsystem m_arm, ArmBaseSubsystem m_armBase, ClawSubsystem m_claw, TurretSubsystem m_turret, BooleanSupplier ending) {
        addCommands(
            /** (make sure code is in opisite deriection as red)
            /**
         * "robot will start with claw backwards"
         * extend arm towards node 3C
         * drop cone (open claw)
         * retract arm
         * drive forwarard towards the middle 
         */ 
         new DriveDistance(m_drive, 210, 0.5),
         /**
         * align robot  with object 1 
         * move robot fowarard 
         */
        new DriveDistance(m_drive, 14, 0.5),
        /**
         * turn arm towards object 1 
         * extend arm and lower arm
         * close claw on object 1 
         * raise arm
         * choose either to go to (1) charge station or or(2) head back to community
         *(1) if end on charge station 
         *      turn toward charge station
         *      move robot foward
         */ 
         new DriveDistance(m_drive,114 ,0.5),
         /**     balence on charge station
         * (2) if head to  community
         *      trun robot 180 degress 
         */
        new DriveDistance(m_drive, 224, 50),
        /**
         *      stop near node 3 or 2 
         *      lower arm to avalible node 
         *      extend arm toward availble node 
         *     open claw 
         * stop/end of code
         */
        new ConditionalCommand(new Blue1Score(m_drive, m_arm, m_armBase, m_claw, m_turret), new Blue1ChargeStation(m_drive, m_arm, m_armBase, m_claw, m_turret), ending)
        );
    }


}
