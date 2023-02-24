package frc.robot.subsystems.GrabberSubsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClawConstants;

public class ClawSubsystem extends SubsystemBase{

    CANSparkMax clawMotor = new CANSparkMax(ClawConstants.kClawMotorPort, MotorType.kBrushless);
    RelativeEncoder clawEncoder = clawMotor.getEncoder();

    public ClawSubsystem(){
        clawMotor.setIdleMode(IdleMode.kBrake);
        clawEncoder.setPosition(0.0);
    }

    /**
     * @apiNote Sets claw to closed position
     * @param speed Claw speed
     */
    public void runClaw(double speed){
        clawMotor.set(speed);
    }

    public double getSpeed(){
        return clawMotor.get();
    }

    public double getEncoderPosition() {
        return clawEncoder.getPosition();
    }

    public void resetEncoder() {
        clawEncoder.setPosition(0.0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Claw Pos", getEncoderPosition());
        SmartDashboard.putNumber("Claw Speed", getSpeed());
    }
    
}