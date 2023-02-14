package frc.robot.commands.Autonomous.Paths.Red;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

public class Red3 extends SequentialCommandGroup{
    

    public Red3(DriveSubsystem m_drive) {
        addCommands(
    /**
     * (arm starts backwards)extend arm toward node 8 or 9
     * open claw 
     * drive foward while retracting arm a little 
     * turn turret toward object 4
     * lower and extend arm toward object 4
     * retract arm
     * option(1)tuen around and head to coummunity node 8 or 9
     *  extend arm toward node 
     *  open claw 
     * option (2) turn toward chargeing station
     * go onto charge station and balence 
     */
        );
    }


}
