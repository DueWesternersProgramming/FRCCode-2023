// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.TankDrive;
import frc.robot.commands.Turret;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GrabberSubsystem;
import frc.robot.subsystems.LightSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
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
  private final GrabberSubsystem m_grabberSubsystem = new GrabberSubsystem();
  private final LightSubsystem m_lightSubsystem = new LightSubsystem();
  private final VisionSubsystem m_visionSubsystem = new VisionSubsystem();

  private final GenericHID m_driverController, m_asisstController;


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
     
    m_driverController = new GenericHID(OperatorConstants.kDriverControllerPort);
    m_asisstController = new GenericHID(OperatorConstants.kAsisstControllerPort);
    
    // Configure the trigger bindings
    configureButttonBindings();
    m_driveSubsystem.setDefaultCommand(new TankDrive(m_driveSubsystem,
    () -> m_driverController.getRawAxis(1),
    () -> m_driverController.getRawAxis(5)));
    
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureButttonBindings() {
    Trigger yButton = new JoystickButton(m_driverController, 4).onTrue(new Turret(m_grabberSubsystem, () -> m_driverController.getRawAxis(3))); 
    Trigger xButton = new JoystickButton(m_driverController, 3); 
    Trigger aButton = new JoystickButton(m_driverController, 1); 
    Trigger bButton = new JoystickButton(m_driverController, 2); 
    Trigger lbButton = new JoystickButton(m_driverController, 5); 
    Trigger rbButton = new JoystickButton(m_driverController, 6);
    Trigger uButton = new JoystickButton(m_driverController, 7); 
    Trigger pButton = new JoystickButton(m_driverController, 8);     
    Trigger yButton2 = new JoystickButton(m_asisstController, 4); 
    Trigger xButton2 = new JoystickButton(m_asisstController, 3); 
    Trigger aButton2 = new JoystickButton(m_asisstController, 1); 
    Trigger bButton2 = new JoystickButton(m_asisstController, 2); 
    Trigger lbButton2 = new JoystickButton(m_asisstController, 5); 
    Trigger rbButton2 = new JoystickButton(m_asisstController, 6); 
    Trigger uButton2 = new JoystickButton(m_asisstController, 7); 
    Trigger pButton2 = new JoystickButton(m_asisstController, 8); 
    POVButton uPovButton = new POVButton(m_driverController, 0);
    POVButton rPovButton = new POVButton(m_driverController, 90);
    POVButton lPovButton = new POVButton(m_driverController, 270);
    POVButton dPovButton = new POVButton(m_driverController, 180);
    POVButton uPovButton2 = new POVButton(m_asisstController, 0) ;
    POVButton rPovButton2 = new POVButton(m_asisstController, 90);
    POVButton lPovButton2 = new POVButton(m_asisstController, 270);
    POVButton dPovButton2 = new POVButton(m_asisstController, 180);
  };
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An example command will be run in autonomous
  //   return Autos.exampleAuto(m_exampleSubsystem);
  // }
  
