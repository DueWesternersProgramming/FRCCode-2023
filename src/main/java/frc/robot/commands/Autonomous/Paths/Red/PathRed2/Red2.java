package frc.robot.commands.Autonomous.Paths.Red.PathRed2;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.DriveDistance;
import frc.robot.commands.GrabberCommands.Arm.ArmExtend;
import frc.robot.commands.GrabberCommands.Arm.ArmRetract;
import frc.robot.commands.GrabberCommands.BaseArm.BaseArmUp;
import frc.robot.commands.GrabberCommands.Claw.ClawClose;
import frc.robot.commands.GrabberCommands.Claw.ClawOpen;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmBaseSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ClawSubsystem;
import frc.robot.subsystems.GrabberSubsystems.TurretSubsystem;

public class Red2 extends SequentialCommandGroup{
    

    public Red2(DriveSubsystem m_drive, ArmSubsystem m_arm, ArmBaseSubsystem m_armBase, ClawSubsystem m_claw, TurretSubsystem m_turret) {
        addCommands(
           /** robot starts with arm backwards 
            * arm ext retractsends foward and up toward node 4 or 5 
            * claw opens arm
            * robot moves foward over charge station
            */
            new ClawClose(m_claw, 0),
            new BaseArmUp(m_armBase),
            new ArmExtend(m_arm),
            new ClawOpen(m_claw),
           new DriveDistance(m_drive, 210, 0.5),
           new ArmRetract(m_arm),
           /**
            * once over chage station realign with object 2 or 3(make code for both)
            * robot extends arm and down */
            new ArmExtend(m_arm),
            
            /* claw closes on object 
            * arm retracts 
            * robot turns toward charge station 
            *go over charge station
            */ 
            new DriveDistance(m_drive, 210, 0.5),
            /**
           * extend arm and up toward avilible node 4 or 5 
           * open claw 
           * (!With Out Turning Around!) go back on to charge station 
           */    
            new DriveDistance(m_drive, 96, 0.5)
           /** balence on charge station
           */
        );
    }


}
