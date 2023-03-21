package frc.robot.subsystems.GrabberSubsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;;


public class IntakeSubsystem extends SubsystemBase{
    
    CANSparkMax intakeMotor = new CANSparkMax(IntakeConstants.kIntakeMotorPort, MotorType.kBrushless);
    RelativeEncoder intakeEncoder = intakeMotor.getEncoder();

    public IntakeSubsystem(){
        intakeMotor.setIdleMode(IdleMode.kBrake);
        resetEncoder();
    }

    public double getSpeed() {
        return intakeMotor.get();
    }

    public void intakeOn(){
        intakeMotor.set(IntakeConstants.kIntakeMotorSpeed);
    }

    public void intakeReverse(){
        intakeMotor.set(IntakeConstants.kIntakeReverseMotorSpeed);
    }

    public void intakeOff(){
        intakeMotor.set(0);
    }

    public double getEncoderPosition() {
        return intakeEncoder.getPosition();
    }

    public void resetEncoder() {
        intakeEncoder.setPosition(0.0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake Speed", getSpeed());
    }
}