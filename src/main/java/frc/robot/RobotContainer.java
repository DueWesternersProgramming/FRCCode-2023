// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.TurretConstants;
import frc.robot.commands.Autonomous.AutoDoNothing;
import frc.robot.commands.Autonomous.AutoTest;
import frc.robot.commands.Autonomous.Paths.Red.PathRed1.*;
import frc.robot.commands.Autonomous.Paths.Red.PathRed2.*;
import frc.robot.commands.Autonomous.Paths.Red.PathRed3.*;
import frc.robot.commands.Autonomous.Paths.Blue.PathBlue1.*;
import frc.robot.commands.Autonomous.Paths.Blue.PathBlue2.*;
import frc.robot.commands.Autonomous.Paths.Blue.PathBlue3.*;
import frc.robot.commands.DriveCommands.TankDrive;
import frc.robot.commands.GrabberCommands.Arm.*;
import frc.robot.commands.GrabberCommands.BaseArm.BaseArmManuelMove;
import frc.robot.commands.GrabberCommands.Claw.ClawClose;
import frc.robot.commands.GrabberCommands.Claw.ClawOpen;
import frc.robot.commands.GrabberCommands.Turret.*;
import frc.robot.commands.LightCommands.LEDPitAlternate;
import frc.robot.commands.LightCommands.LEDMatch;
import frc.robot.commands.LightCommands.LEDPit;
import frc.robot.commands.VisionCommands.TurretTurnTarget;
import frc.robot.subsystems.*;
import frc.robot.subsystems.GrabberSubsystems.*;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger; 

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final TurretSubsystem m_turretSubsystem = new TurretSubsystem();
  private final ClawSubsystem m_clawSubsystem = new ClawSubsystem();
  private final ArmSubsystem m_armSubsystem = new ArmSubsystem();
  private final LightSubsystem m_lightSubsystem = new LightSubsystem();
  private final VisionSubsystem m_visionSubsystem = new VisionSubsystem();
  private final ArmBaseSubsystem m_armBaseSubsystem = new ArmBaseSubsystem();
  private final GenericHID m_driverController, m_asisstController;
  
  SendableChooser<Command> m_autoPositionChooser = new SendableChooser<>();
  
  PowerDistribution PDP = new PowerDistribution(16, ModuleType.kCTRE);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    m_driverController = new GenericHID(OperatorConstants.kDriverControllerPort);
    m_asisstController = new GenericHID(OperatorConstants.kAsisstControllerPort);
    
    // Configure the trigger bindings
    configureButttonBindings();
    m_driveSubsystem.setDefaultCommand(new TankDrive(m_driveSubsystem,
    () -> m_driverController.getRawAxis(1),
    () -> m_driverController.getRawAxis(5)));
    
    m_armBaseSubsystem.setDefaultCommand(new BaseArmManuelMove(m_armBaseSubsystem,
    () -> m_asisstController.getRawAxis(1)));

    m_armSubsystem.setDefaultCommand(new ArmManuelMove(m_armSubsystem,
    () -> m_asisstController.getRawAxis(5)));

    m_autoPositionChooser.setDefaultOption("Red 1 Score", new Red1(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> true));
    m_autoPositionChooser.addOption("Red 2 Score", new Red2(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> true));
    m_autoPositionChooser.addOption("Red 3 Score", new Red3(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> true));
    m_autoPositionChooser.addOption("Red 1 Station", new Red1(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> false));
    m_autoPositionChooser.addOption("Red 2 Station", new Red2(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> false));
    m_autoPositionChooser.addOption("Red 3 Station", new Red3(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> false));
    m_autoPositionChooser.addOption("Blue 1 Score", new Blue1(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> true));
    m_autoPositionChooser.addOption("Blue 2 Score", new Blue2(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> true));
    m_autoPositionChooser.addOption("Blue 3 Score", new Blue3(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> true));
    m_autoPositionChooser.addOption("Blue 1 Station", new Blue1(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> false));
    m_autoPositionChooser.addOption("Blue 2 Station", new Blue2(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> false));
    m_autoPositionChooser.addOption("Blue 3 Station", new Blue3(m_driveSubsystem, m_armSubsystem, m_armBaseSubsystem, m_clawSubsystem, m_turretSubsystem, () -> false));
    m_autoPositionChooser.addOption("Do Nothing", new AutoDoNothing());
    m_autoPositionChooser.addOption("AutoTest", new AutoTest(m_driveSubsystem));

    Shuffleboard.getTab("Autonomous").add(m_autoPositionChooser);

    Shuffleboard.getTab("Power").add(PDP);
    
  }



  private void configureButttonBindings() {
    // The Buttons for the Driver Controller
    Trigger yButton = new JoystickButton(m_driverController, 4).onTrue(new LEDMatch(m_lightSubsystem, 1)); 
    Trigger xButton = new JoystickButton(m_driverController, 3).onTrue(new LEDPitAlternate(m_lightSubsystem));
    Trigger aButton = new JoystickButton(m_driverController, 1).onTrue(new LEDMatch(m_lightSubsystem, 2));
    Trigger bButton = new JoystickButton(m_driverController, 2).onTrue(new LEDMatch(m_lightSubsystem, 0));
    Trigger lbButton = new JoystickButton(m_driverController, 5);
    Trigger rbButton = new JoystickButton(m_driverController, 6);
    Trigger uButton = new JoystickButton(m_driverController, 7); 
    Trigger pButton = new JoystickButton(m_driverController, 8); 
    // The Buttons For the Asisst Controller will have a 2 after them      
    Trigger yButton2 = new JoystickButton(m_asisstController, 4).whileTrue(new TurretTurnManual(m_turretSubsystem, () -> m_asisstController.getRawAxis(3), () -> m_asisstController.getRawAxis(2)));
    Trigger xButton2 = new JoystickButton(m_asisstController, 3).onTrue(new LEDPitAlternate(m_lightSubsystem)); 
    Trigger aButton2 = new JoystickButton(m_asisstController, 1); 
    Trigger bButton2 = new JoystickButton(m_asisstController, 2).onTrue(new ArmExtend(m_armSubsystem));
    Trigger lbButton2 = new JoystickButton(m_asisstController, 5);
    Trigger rbButton2 = new JoystickButton(m_asisstController, 6).onTrue(new TurretTurnTarget(m_turretSubsystem, m_visionSubsystem)); 
    Trigger uButton2 = new JoystickButton(m_asisstController, 7); 
    Trigger pButton2 = new JoystickButton(m_asisstController, 8); 
    // POV(D-pad) Button for the Driver Controller 
    Trigger uPovButton = new POVButton(m_driverController, 0).onTrue(new TurretTurnAuto(m_turretSubsystem, TurretConstants.k0degrees));
    Trigger rPovButton = new POVButton(m_driverController, 90).onTrue(new TurretTurnAuto(m_turretSubsystem, TurretConstants.k90Degrees));
    Trigger lPovButton = new POVButton(m_driverController, 270).onTrue(new TurretTurnAuto(m_turretSubsystem, TurretConstants.kNeg90Degrees));
    Trigger dPovButton = new POVButton(m_driverController, 180);
    // POV(D-pad) Buttons for the Asisst Controller 
    Trigger uPovButton2 = new POVButton(m_asisstController, 0).onTrue(new LEDPit(m_lightSubsystem));
    Trigger rPovButton2 = new POVButton(m_asisstController, 90).onTrue(new ClawOpen(m_clawSubsystem));
    Trigger lPovButton2 = new POVButton(m_asisstController, 270).onTrue(new ClawClose(m_clawSubsystem, 0));
    Trigger dPovButton2 = new POVButton(m_asisstController, 180).onTrue(new ClawClose(m_clawSubsystem, 1));
    }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autoPositionChooser.getSelected();
  }
}
