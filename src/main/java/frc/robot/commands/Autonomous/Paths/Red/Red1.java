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
         * extend arm towards node 3 
         * drop cone (open claw)
         * drive forwarard towards the middle 
         * align with object 1 move fowarard 
         * turn arm towards object 1 and lower arm
         * close claw on object 1 and raise arm
         * choose either to go to charge station or or head back to couminity
         * 
         */
        );
    }


}
