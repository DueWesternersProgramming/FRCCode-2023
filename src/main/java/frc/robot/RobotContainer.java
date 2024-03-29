// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autonomous.*;
import frc.robot.commands.Autonomous.Paths.DistrictVersion.PathInner;
import frc.robot.commands.Autonomous.Paths.WorldsVersion.PathAnyScore;
import frc.robot.commands.Autonomous.Paths.WorldsVersion.PathMiddleHigh;
import frc.robot.commands.Autonomous.Paths.WorldsVersion.PathSidesCone;
import frc.robot.commands.Autonomous.Paths.WorldsVersion.PathSidesCube;
import frc.robot.commands.DriveCommands.*;
import frc.robot.commands.GrabberCommands.Arm.*;
import frc.robot.commands.GrabberCommands.Intake.*;
import frc.robot.commands.GrabberCommands.Wrist.WristManuelMove;
import frc.robot.commands.LightCommands.*;
import frc.robot.commands.VisionCommands.SetVisionPipeline;
import frc.robot.commands.VisionCommands.TurnTarget;
import frc.robot.subsystems.*;
import frc.robot.subsystems.GrabberSubsystems.*;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final ArmSubsystem m_armSubsystem = new ArmSubsystem();
  private final LightSubsystem m_lightSubsystem = new LightSubsystem();
  private final VisionSubsystem m_visionSubsystem = new VisionSubsystem();
  private final WristSubsystem m_wristSubsystem = new WristSubsystem();
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

    m_armSubsystem.setDefaultCommand(new ArmManuelMove(m_armSubsystem,
    () -> m_asisstController.getRawAxis(5)));

    m_wristSubsystem.setDefaultCommand(new WristManuelMove(m_wristSubsystem,
    () -> m_asisstController.getRawAxis(1)));

    m_autoPositionChooser.setDefaultOption("PathSides+Cube", new PathSidesCube(m_driveSubsystem, m_armSubsystem, m_intakeSubsystem, m_wristSubsystem, m_lightSubsystem, m_visionSubsystem));
    m_autoPositionChooser.setDefaultOption("PathSides+Cone", new PathSidesCone(m_driveSubsystem, m_armSubsystem, m_intakeSubsystem, m_wristSubsystem, m_lightSubsystem, m_visionSubsystem));
    m_autoPositionChooser.addOption("PathSides", new PathInner(m_driveSubsystem, m_armSubsystem, m_intakeSubsystem, m_wristSubsystem, m_lightSubsystem));
    m_autoPositionChooser.addOption("PathMiddle High", new PathMiddleHigh(m_driveSubsystem, m_armSubsystem, m_intakeSubsystem, m_wristSubsystem, m_lightSubsystem));
    m_autoPositionChooser.addOption("PathAny Score", new PathAnyScore(m_driveSubsystem, m_armSubsystem, m_intakeSubsystem, m_wristSubsystem, m_lightSubsystem));
    m_autoPositionChooser.addOption("Do Nothing", new AutoDoNothing(m_driveSubsystem));
    m_autoPositionChooser.addOption("Calibrate Gryo", new AutoCalibrateGyro(m_driveSubsystem));
    m_autoPositionChooser.addOption("AutoBalanceTest", new AutoDriveBalanceTest(m_driveSubsystem, m_lightSubsystem));
    m_autoPositionChooser.addOption("AutoTest", new AutoTest(m_driveSubsystem, m_visionSubsystem, m_wristSubsystem, m_lightSubsystem, m_intakeSubsystem, m_armSubsystem));

    Shuffleboard.getTab("Autonomous").add(m_autoPositionChooser);

    Shuffleboard.getTab("Power").add(PDP);
    
  }



  private void configureButttonBindings() {
    // The Buttons for the Driver Controller
    /*Trigger yButton =*/ new JoystickButton(m_driverController, 4);
    /*Trigger xButton =*/ new JoystickButton(m_driverController, 3).whileTrue(new TurnTarget(m_driveSubsystem, m_visionSubsystem, 0.0, false));
    /*Trigger aButton =*/ new JoystickButton(m_driverController, 1);
    /*Trigger bButton =*/ new JoystickButton(m_driverController, 2).whileTrue((new TurnTarget(m_driveSubsystem, m_visionSubsystem, 0.0, true)));
    /*Trigger lbButton = */ new JoystickButton(m_driverController, 5).onTrue(new FastSpeed(m_driveSubsystem));
    /*Trigger rbButton =*/ new JoystickButton(m_driverController, 6).whileTrue(new DriveChargeBalance(m_driveSubsystem, m_lightSubsystem, false, true, 0.86));
    /*Trigger uButton =*/ new JoystickButton(m_driverController, 7).onTrue(new ToggleBrake(m_driveSubsystem, m_lightSubsystem)); 
    /*Trigger pButton =*/ new JoystickButton(m_driverController, 8).onTrue(new ToggleSpeeds(m_driveSubsystem));
    // The Buttons For the Asisst Controller will have a 2 after them      
    /*Trigger yButton2 =*/ new JoystickButton(m_asisstController, 4).onTrue(new ParallelCommandGroup(new SetVisionPipeline(m_visionSubsystem, 1), new LEDMatch(m_lightSubsystem, 1))); 
    /*Trigger xButton2 =*/ new JoystickButton(m_asisstController, 3).onTrue(new LEDPitAlternate(m_lightSubsystem));
    /*Trigger aButton2 =*/ new JoystickButton(m_asisstController, 1).onTrue(new ParallelCommandGroup(new SetVisionPipeline(m_visionSubsystem, 0), new LEDMatch(m_lightSubsystem, 2)));
    /*Trigger bButton2 =*/ new JoystickButton(m_asisstController, 2).onTrue(new LEDMatch(m_lightSubsystem, 0));
    /*Trigger lbButton2 =*/ new JoystickButton(m_asisstController, 5);
    /*Trigger rbButton2 =*/ new JoystickButton(m_asisstController, 6); 
    /*Trigger uButton2 =*/ new JoystickButton(m_asisstController, 7); 
    /*Trigger pButton2 =*/ new JoystickButton(m_asisstController, 8); 
    // POV(D-pad) Button for the Driver Controller 
    /*Trigger uPovButton =*/ new POVButton(m_driverController, 0).whileTrue(new TankDrive(m_driveSubsystem, () -> -0.9, () -> -0.9));
    /*Trigger rPovButton =*/ new POVButton(m_driverController, 90).whileTrue(new TankDrive(m_driveSubsystem, () -> -0.7, () -> 0.7));
    /*Trigger lPovButton =*/ new POVButton(m_driverController, 270).whileTrue(new TankDrive(m_driveSubsystem, () -> 0.7, () -> -0.7));
    /*Trigger dPovButton =*/ new POVButton(m_driverController, 180).whileTrue(new TankDrive(m_driveSubsystem, () -> 0.9, () -> 0.9));
    // POV(D-pad) Buttons for the Asisst Controller
    /*Trigger uPovButton2 =*/ new POVButton(m_asisstController, 0).debounce(5).onTrue(new IntakeShoot(m_intakeSubsystem));
    /*Trigger rPovButton2 =*/ new POVButton(m_asisstController, 90).onTrue(new IntakeOn(m_intakeSubsystem));
    /*Trigger lPovButton2 =*/ new POVButton(m_asisstController, 270).onTrue(new IntakeOff(m_intakeSubsystem));
    /*Trigger dPovButton2 =*/ new POVButton(m_asisstController, 180).onTrue(new IntakeReverse(m_intakeSubsystem));
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
