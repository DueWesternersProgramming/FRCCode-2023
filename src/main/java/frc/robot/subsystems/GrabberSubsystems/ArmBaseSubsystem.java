package frc.robot.subsystems.GrabberSubsystems;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.Constants.*;


public class ArmBaseSubsystem extends SubsystemBase{

    CANSparkMax BaseArmMotor = new CANSparkMax(BaseArmConstants.kBaseArmMotorPort,CANSparkMax.MotorType.kBrushless);
    RelativeEncoder BaseArmEncoder = BaseArmMotor.getEncoder();

    public ArmBaseSubsystem(){
        BaseArmEncoder.setPosition(0.0);
    }

    public void ArmBaseMove(double speed){
        //TURN TURRET
        BaseArmMotor.set(speed/2.5);
    }

    public void ArmBrake(){
        BaseArmMotor.setIdleMode(IdleMode.kBrake);
    }

    public double getEncoderPosition() {
        return BaseArmEncoder.getPosition();
    }

    public void resetEncoder() {
        BaseArmEncoder.setPosition(0.0);
    }

    public void BaseArmManuelMove(double m_leftModified, double m_rightModified) {
        
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("ArmBase Position", getEncoderPosition());
        SmartDashboard.putNumber("ArmBase Speed", BaseArmMotor.get());
    }
    
}