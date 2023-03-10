// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final class DriveConstants{

    public static final int kLeft1MotorPort = 2;
    public static final int kLeft2MotorPort = 3;
    public static final int kRight1MotorPort = 4;
    public static final int kRight2MotorPort = 5;

    public static final double kSpeedMultiplier = 0.85;
    public static final double kSlowSpeedMultiplier = 0.4;

    public static final double kChargeBalanceTolerance = 10;

    public static final double kMaxAccel = 12;
    public static final int kLeft = -1;
    public static final int kRight = 1;
    public static final double kDriveWidth = 25;

    //public static final double kDefaultP = .00038;
    // public static final double kDefaultI = .0000011;
    // public static final double kDefaultD = .0001;
    public static final double kDefaultP = .00030;
    public static final double kDefaultI = .00000011;
    public static final double kDefaultD = .0001;
    public static final int kEncoderCPR = 1024;
    public static final double kGearRatio = 1/10.75;
    public static final double kWheelDiameterInches = 6;
    public static final double kMaxRPM = 5676;
    public static final double kEncoderDistancePerPulse = (kWheelDiameterInches * Math.PI) / (double) kEncoderCPR;
    public static final double kMaxRobotSpeed = (kMaxRPM/60) * kGearRatio * (kWheelDiameterInches * Math.PI);

  }

  public static class ArmConstants {  
    
    public static final double kUpPosition = -275;
    public static final double kDownPosition = -110;
    public static final double kScorePosition = -13;
    public static final double kArmSpeed = 0.75;

    public static final int kMoveUp = 1;
    public static final int kMoveDown = -1;
    
    public static final int kArmMotorPort = 17;

    public static final int kArmSpeedMultiplier = 1;
    
  }

  public static class LightConstants {
    public static final int kLightPort = 25;
    public static final int kLightCount = 8;
    public static final double kLightBrightness = 0.5;
  }


  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kAsisstControllerPort = 1;

    public static final double kControllerDeadZone = 0.01;

    public static final int kPDPPort = 16;

  }

  public static class TurretConstants {
    public static final int kTurretMotorPort = 8;
    public static final double kBumperDeadZone = 0.2;

    public static final double k90Degrees = 3.25;
    public static final double kNeg90Degrees = -3.25;
    public static final double k0degrees = 0;

    public static final double kTurretSpeed = 0.275;
    public static final int kTurnRight = 1;
    public static final int kTurnLeft = -1;
    public static final double kTurretSpeedMultiplier = 0.33;
  }

  public static class ClawConstants{
    public static final double kOpenPosition = 0.25;
    public static final double kClosedCube = 0.4;
    public static final double kClosedCone = 0.59;
  }

  public static class BaseArmConstants{
    public static final int kBaseArmMotorPortL = 15;
    public static final int kBaseArmMotorPortR = 55;
    public static final double kBaseArmSpeedMultiplier = 0.45;
    public static final double kBaseArmExtendedPosition = 10;
    public static final double kBaseArmSpeed = 0.5;
    public static final double kBaseArmRetractedPosition = 1;
  }
}
