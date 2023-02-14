package frc.robot.subsystems.GrabberSubsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.Constants.*;


public class TurretSubsystem extends SubsystemBase{

    CANSparkMax turretMotor = new CANSparkMax(DriveConstants.kTurretMotorPort,CANSparkMax.MotorType.kBrushless);

    public TurretSubsystem(){
        //CANSparkMax turretMotor = new CANSparkMax(DriveConstants.kTurretMotorPort,CANSparkMax.MotorType.kBrushless);

    }

    public void TurretTurn(double speed){
        //TURN TURRET
        turretMotor.set(speed/2);
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