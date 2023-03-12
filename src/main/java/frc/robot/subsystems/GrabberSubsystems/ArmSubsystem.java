package frc.robot.subsystems.GrabberSubsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase{

    CANSparkMax armMotor = new CANSparkMax(ArmConstants.kArmMotorPort, MotorType.kBrushless);
    RelativeEncoder armEncoder = armMotor.getEncoder();

    public ArmSubsystem(){
        armMotor.setIdleMode(IdleMode.kBrake); // -290
        armMotor.setSoftLimit(SoftLimitDirection.kReverse, -290);
        armMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);
        resetEncoder();
    }

    /**
     * @apiNote Sets claw to closed position
     * @param speed Claw speed
     */
    public void runArm(double speed){
        armMotor.set(speed*ArmConstants.kArmSpeedMultiplier);
    }

    public double getSpeed(){
        return armMotor.get();
    }

    public double getEncoderPosition() {
        return armEncoder.getPosition();
    }

    public void resetEncoder() {
        armEncoder.setPosition(0.0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Arm Pos", getEncoderPosition());
        SmartDashboard.putNumber("Arm Speed", getSpeed());
        SmartDashboard.putNumber("Arm Current", armMotor.getOutputCurrent());
    }
    
}