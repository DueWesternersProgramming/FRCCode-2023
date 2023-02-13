package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.Constants.*;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class GrabberSubsystem extends SubsystemBase{

    CANSparkMax turretMotor = new CANSparkMax(DriveConstants.kTurretMotorPort,CANSparkMax.MotorType.kBrushless);

    public GrabberSubsystem(){
        //CANSparkMax turretMotor = new CANSparkMax(DriveConstants.kTurretMotorPort,CANSparkMax.MotorType.kBrushless);

    }

    public void TurretTurn(double speed){
        //TURN TURRET
        turretMotor.set(speed/15);
    }

    public void brakeTheturret(){
        turretMotor.setIdleMode(IdleMode.kBrake);

    }
    public void Grabber(){
        //GRABBER CODE


    }

    public void ArmPosition(){
        //ARM POS
        System.out.println("");
      }


    @Override
    public void periodic() {

    }
    
}