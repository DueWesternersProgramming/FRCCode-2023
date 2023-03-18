package frc.robot.subsystems.GrabberSubsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.WristConstants;



public class WristSubsystem extends SubsystemBase{
    
    CANSparkMax wristMotor = new CANSparkMax(WristConstants.kWristMotorPort, MotorType.kBrushless);  // WRIST PORT NOT SET
    RelativeEncoder wristEncoder = wristMotor.getEncoder();

    public WristSubsystem(){
        wristMotor.setIdleMode(IdleMode.kBrake);
        resetEncoder();
    }

    public void runWrist(double speed){
        wristMotor.set(speed*WristConstants.kWristSpeedMultiplier);
    }

    public double getSpeed(){
        return wristMotor.get();
    }

    public double getEncoderPosition() {
        return wristEncoder.getPosition();
    }

    public void resetEncoder() {
        wristEncoder.setPosition(0.0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Arm Pos", getEncoderPosition());
        SmartDashboard.putNumber("Arm Speed", getSpeed());
        SmartDashboard.putNumber("Arm Current", wristMotor.getOutputCurrent());
    }

}
