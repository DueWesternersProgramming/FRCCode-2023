package frc.robot.commands.Autonomous.Paths.DistrictVersion;

//import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveCommands.*;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LightSubsystem;
import frc.robot.subsystems.GrabberSubsystems.ArmSubsystem;
import frc.robot.subsystems.GrabberSubsystems.IntakeSubsystem;

public class PathMiddleLow extends SequentialCommandGroup {

    
    /**
     * 
     * @param m_drive
     * @param m_arm
     * @param m_armBase
     * @param m_claw
     * @param m_turret
     */
    public PathMiddleLow(DriveSubsystem m_drive, ArmSubsystem m_arm, IntakeSubsystem m_claw, LightSubsystem m_light) {
        addCommands(
        new CalibrateGyro(m_drive),
        new setCoast(m_drive, m_light),
        //new LEDMatch(m_light, 0),
        /**
         * "robot will start with claw backwards"
         * extend arm towards node 3C*/
        //new ClawClose(m_claw, 1),
        
        //new BaseArmPop(m_armBase),
        //new ArmExtend(m_arm),
        //new TurretTurnAuto(m_turret, (double) 180),
        //  drop cone (open claw),
        //new ClawOpen(m_claw),
        //new WaitCommand(0.5),
        /** retract arm*/
        //new ArmRetract(m_arm),
         /** drive forwarard towards the middle
         */
        new DriveDistance(m_drive, -7, 0.1),
        new WaitCommand(0.5),
        new DriveDistance(m_drive, 10, 0.1),
        new DriveDistance(m_drive, 15, 0.1),
        new DriveChargeBalance(m_drive, m_light, true, true, 1),
        new setBrake(m_drive, m_light),
        new DriveDistance(m_drive, 14, 0.1),
        new TurnDegrees(m_drive, 155, 0.09, 1, 0),
        new DriveDistance(m_drive, 23, 0.13),
        new DriveChargeBalance(m_drive, m_light, false, true, 1)
         /**
         * align robot  with object 1 
         * move robot fowarard 
         */
        
         //new TurnDegrees(m_drive, -5, 20, 0, 0),
        //new DriveDistance(m_drive, 14, 0.5),
       
        /**
         * turn arm towards object 1*/
        //new TurretTurnAuto(m_turret, TurretConstants.k90Degrees), /** turn turret 180*/
         /* extend arm and lower arm down*/
        //new ArmScore(m_arm),/** new base manuel move arm down*/
        //new BaseArmExtend(m_armBase),
         /** close claw on object 1 */
         //new ClawClose(m_claw, 0),
         /** raise arm*/
         //new BaseArmUp(m_armBase),
         
         /* choose either to go to (1) charge station or or(2) head back to community
         *(1) if end on charge station 
         *      turn toward charge station
         *      move robot foward
        //  */ 
        //  new DriveDistance(m_drive,114 ,0.5),

        //  /**     balence on charge station
        //  * (2) if head to  community
        //  *      trun robot 180 degress 
        //  */
        // new DriveDistance(m_drive, 224, 0.5),


        //new ConditionalCommand(new Red1Score(m_drive, m_arm, m_armBase, m_claw, m_turret), new Red1ChargeStation(m_drive, m_arm, m_armBase, m_claw, m_turret), ending)
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
