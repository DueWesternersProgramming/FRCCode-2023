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

    public static final int kTurretMotorPort = 8;  // NOT SET UP
    public static final int kArmJointOneMotorPort = 100000; // NOT SET UP


    public static final double kSpeedMultiplier = 0.45;

    public static final double kControllerDeadZone = 0.01;
    public static final double kDefaultP = 0;
    public static final double kDefaultI = 0;
    public static final double kDefaultD = 0;
    public static final int kEncoderCPR = 1024;
    public static final double kGearRatio = 1/10.75;
    public static final double kWheelDiameterInches = 6;
    public static final double kMaxRPM = 5676;
    public static final double kEncoderDistancePerPulse = (kWheelDiameterInches * Math.PI) / (double) kEncoderCPR;
    public static final double kMaxRobotSpeed = (kMaxRPM/60) * kGearRatio * (kWheelDiameterInches * Math.PI);
  }

  public static class LightConstants {
    public static final int kLightPort = 25;
    public static final int kLightCount = 8;
    public static final double kLightBrightness = 0.5;
  }


  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kAsisstControllerPort = 1;

    public static final int kPDPPort = 15;

  }

  public static class TurretConstants {

    public static final double kBumperDeadZone = 0.2;
    public static final double kRightAngle = 2379;

  }

  public static class ClawConstants{
    public static final double kOpenPosition = 0;
    public static final double kClosedCube = 25;
    public static final double kClosedCone = 27;
  }
}
