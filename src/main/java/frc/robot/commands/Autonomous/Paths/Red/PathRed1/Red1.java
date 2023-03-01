package frc.robot.commands.Autonomous.Paths.Red.PathRed1;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.*;
import frc.robot.commands.GrabberCommands.Arm.ArmExtend;
import frc.robot.commands.GrabberCommands.Arm.ArmRetract;
import frc.robot.commands.GrabberCommands.BaseArm.BaseArmManuelMove;
import frc.robot.commands.GrabberCommands.Claw.ClawClose;
import frc.robot.commands.GrabberCommands.Claw.ClawOpen;
import frc.robot.commands.GrabberCommands.Turret.TurretTurnAuto;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmBaseSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ClawSubsystem;
import frc.robot.subsystems.GrabberSubsystems.TurretSubsystem;

public class Red1 extends SequentialCommandGroup {

    /**
     * @param m_drive
     */
    public Red1(DriveSubsystem m_drive, ArmSubsystem m_arm, ArmBaseSubsystem m_armBase, ClawSubsystem m_claw, TurretSubsystem m_turret) {
        addCommands(
      
        /**
         * "robot will start with claw backwards"
         * extend arm towards node 3C*/
         new ArmExtend(m_arm),
         /* new BaseArmManuelMove(m_armBase, null) lift arm
         * drop cone (open claw)*/
         new ClawOpen(m_claw),
        /** retract arm*/
        new ArmRetract(m_arm),
         /** drive forwarard towards the middle 
         */ 
        new DriveDistance(m_drive, 210, 14),

         /**
         * align robot  with object 1 
         * move robot fowarard 
         */
        new TurnDegrees(m_drive, -5, 20, 0, 0),
        new DriveDistance(m_drive, 14, 0.5),
        
        
               

        /**
         * turn arm towards object 1*/
        new TurretTurnAuto(m_turret, 10.0), /** turn turret 180*/
         /* extend arm and lower arm down*/
        new ArmExtend(m_arm),/** new base manuel move arm down*/
         /** close claw on object 1 */
         new ClawClose(m_claw, 0),
         /** raise arm
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
        new DriveDistance(m_drive, 224, 50)

        /**
         *      stop near node 3 or 2 
         *      lower arm to avalible node 
         *      extend arm toward availble node 
         *     open claw 
         * stop/end of code
         */
        );

    }

}
