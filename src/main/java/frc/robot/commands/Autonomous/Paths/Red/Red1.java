package frc.robot.commands.Autonomous.Paths.Red;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

public class Red1 extends SequentialCommandGroup{
    

    /**
     * @param m_drive
     */
    public Red1(DriveSubsystem m_drive) {
        addCommands(
        /**
         * "robot will start with claw backwards"
         * extend arm towards node 3 
         * drop cone (open claw)
         * retract arm
         * drive forwarard towards the middle 
         * align robot  with object 1 
         * move robot fowarard 
         * turn arm towards object 1 
         * extend arm and lower arm
         * close claw on object 1 
         * raise arm
         * choose either to go to (1) charge station or or(2) head back to community
         *(1) if end on charge station 
         *      turn toward charge station
         *      move robot foward
         *      balence on charge station
         * (2) if head to  community
         *      trun robot 180 degress 
         *       move robot foward
         *      stop near node 3 or 2 
         *      lower arm to avalible node 
         *      extend arm toward availble node 
         *     open claw 
         * stop/end of code
         */
        );
    }


}
