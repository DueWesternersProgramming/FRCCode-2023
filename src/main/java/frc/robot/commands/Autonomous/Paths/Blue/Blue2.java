package frc.robot.commands.Autonomous.Paths.Blue;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

public class Blue2 extends SequentialCommandGroup{
    

    public Blue2(DriveSubsystem m_drive) {
        addCommands(
/**(make sure code is in opisite deriection as red)
 * robot starts with arm backwards 
 * arm extends foward and up toward node 4 or 5 
 * claw opens arm retracts
 * robot moves foward over charge station
 * once over chage station realign with object 2 or 3(make code for both)
 * robot extends arm and down 
 * claw closes on object 
 * arm retracts 
 * robot turns toward charge station 
 *go over charge station
 * extend arm and up toward avilible node 4 or 5 
 * open claw 
 * (!With Out Turning Around!) go back on to charge station  
 * balence on charge station
*/
        );
    }


}
