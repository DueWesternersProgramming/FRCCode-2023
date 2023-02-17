package frc.robot.subsystems.GrabberSubsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;

import frc.robot.Constants.*;


//import frc.robot.Constants.*;


public class ArmSubsystem extends SubsystemBase{
    
    CANSparkMax LowerArmMotor = new CANSparkMax(ArmConstants.kLowerArmMotorPort,CANSparkMax.MotorType.kBrushless);
    CANSparkMax UpperArmMotor = new CANSparkMax(ArmConstants.kUpperArmMotorPort,CANSparkMax.MotorType.kBrushless);
    RelativeEncoder LowerArmEncoder = LowerArmMotor.getEncoder();
    RelativeEncoder UppprArmEncoder = UpperArmMotor.getEncoder();

     


    public ArmSubsystem(){
        

    }

    @Override
    public void periodic() {

    }
    
}