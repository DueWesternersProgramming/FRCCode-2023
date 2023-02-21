package frc.robot.subsystems.GrabberSubsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;

import frc.robot.Constants.*;


//import frc.robot.Constants.*;


public class ArmSubsystem extends SubsystemBase{
    
    Servo actuatorServo1 = new Servo(0);
    Servo actuatorServo2 = new Servo(1);
    // CANSparkMax LowerArmMotor = new CANSparkMax(ArmConstants.kLowerArmMotorPort,CANSparkMax.MotorType.kBrushless);
    // CANSparkMax UpperArmMotor = new CANSparkMax(ArmConstants.kUpperArmMotorPort,CANSparkMax.MotorType.kBrushless);
    // RelativeEncoder LowerArmEncoder = LowerArmMotor.getEncoder();
    // RelativeEncoder UppprArmEncoder = UpperArmMotor.getEncoder();

    
    public ArmSubsystem(){
       
    }

    public void setPosition(double position){
        actuatorServo1.set(position);
        actuatorServo2.set(position);
    }

    public void setSpeed(double speed) {
        actuatorServo1.setSpeed(Math.abs(speed));
        actuatorServo2.setSpeed(Math.abs(speed));
    }


    @Override
    public void periodic() {
        SmartDashboard.putNumber("actuator", actuatorServo1.getPosition());
    }
    
}