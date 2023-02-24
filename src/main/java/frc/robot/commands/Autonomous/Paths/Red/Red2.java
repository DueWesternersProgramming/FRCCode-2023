package frc.robot.commands.Autonomous.Paths.Red;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.DriveDistance;
import frc.robot.subsystems.DriveSubsystem;

public class Red2 extends SequentialCommandGroup{
    

    public Red2(DriveSubsystem m_drive) {
        addCommands(
           /** robot starts with arm backwards 
            * arm ext retractsends foward and up toward node 4 or 5 
            * claw opens arm
            * robot moves foward over charge station
            */
           new DriveDistance(m_drive, 210, 0.5),
           /**
            * once over chage station realign with object 2 or 3(make code for both)
            * robot extends arm and down 
            * claw closes on object 
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
