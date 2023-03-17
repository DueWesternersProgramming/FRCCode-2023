package frc.robot.subsystems.GrabberSubsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClawConstants;


public class ClawSubsystem extends SubsystemBase{
    
    CANSparkMax intakeMotor = new CANSparkMax(ClawConstants.kClawMotorPort, MotorType.kBrushless);
    RelativeEncoder intakeEncoder = intakeMotor.getEncoder();

    public ClawSubsystem(){
       
    }

    public double getSpeed() {
        return intakeMotor.get();
    }

    public void IntakeOn(){
        intakeMotor.set(ClawConstants.kIntakeMotorSpeed);
    }

    public void IntakeOff(){
        intakeMotor.set(ClawConstants.kIntakeMotorSpeed);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake Speed", getSpeed());
    }
}