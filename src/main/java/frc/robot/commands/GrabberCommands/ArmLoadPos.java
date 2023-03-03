package frc.robot.commands.GrabberCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class ArmLoadPos extends SequentialCommandGroup{
    
    public ArmLoadPos() {
        addCommands(
            new WaitCommand(14));
      }
}