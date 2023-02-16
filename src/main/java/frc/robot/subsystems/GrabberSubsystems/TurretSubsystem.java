package frc.robot.subsystems.GrabberSubsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.Constants.*;


public class TurretSubsystem extends SubsystemBase{

    CANSparkMax turretMotor = new CANSparkMax(DriveConstants.kTurretMotorPort,CANSparkMax.MotorType.kBrushless);
    RelativeEncoder turretEncoder = turretMotor.getEncoder();

    public TurretSubsystem(){
        
    }

    public void TurretTurn(double speed){
        //TURN TURRET
        turretMotor.set(speed/15);
    }

    public void TurretBrake(){
        turretMotor.setIdleMode(IdleMode.kBrake);

    }

    public double getEncoderPosition() {
        return turretEncoder.getPosition();
    }

    public void resetEncoder() {
        turretEncoder.setPosition(0.0);
    }
    


    @Override
    public void periodic() {
        SmartDashboard.putNumber("TurretPos", getEncoderPosition());
        SmartDashboard.putNumber("Speed", turretMotor.get());
    }
    
}