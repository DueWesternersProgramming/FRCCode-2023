package frc.robot.subsystems.GrabberSubsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import frc.robot.Constants.*;


public class ArmBaseSubsystem extends SubsystemBase{

    CANSparkMax BaseArmMotorL = new CANSparkMax(BaseArmConstants.kBaseArmMotorPortL,CANSparkMax.MotorType.kBrushless);
    CANSparkMax BaseArmMotorR = new CANSparkMax(BaseArmConstants.kBaseArmMotorPortR,CANSparkMax.MotorType.kBrushless);
    RelativeEncoder BaseArmEncoderL = BaseArmMotorL.getEncoder();
    RelativeEncoder BaseArmEncoderR = BaseArmMotorR.getEncoder();
    MotorControllerGroup BaseArmMotors = new MotorControllerGroup(BaseArmMotorL, BaseArmMotorR);

    public ArmBaseSubsystem(){
        resetEncoders();
        ArmBrake();
    }

    public void ArmBaseMove(double speed){
        BaseArmMotors.set(speed * BaseArmConstants.kBaseArmSpeedMultiplier);
    }

    public void ArmBrake(){
        BaseArmMotorR.setIdleMode(IdleMode.kBrake);
        BaseArmMotorL.setIdleMode(IdleMode.kBrake);
    }

    public double getEncoderLPosition() {
        return BaseArmEncoderL.getPosition();
    }

    public double getEncoderRPosition() {
        return BaseArmEncoderR.getPosition();
    }

    public void resetEncoders() {
        BaseArmEncoderL.setPosition(0.0);
        BaseArmEncoderR.setPosition(0.0);
    }

    public void BaseArmManuelMove(double m_leftModified, double m_rightModified) {
        
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("ArmBase Position L", getEncoderLPosition());
        SmartDashboard.putNumber("ArmBase Position R", getEncoderRPosition());
        SmartDashboard.putNumber("ArmBase Speed", BaseArmMotors.get());
    }
    
}