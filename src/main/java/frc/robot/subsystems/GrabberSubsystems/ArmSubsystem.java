package frc.robot.subsystems.GrabberSubsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

//import frc.robot.Constants.*;


public class ArmSubsystem extends SubsystemBase{
    
    Servo actuatorServo1 = new Servo(ArmConstants.kLeftArmMotorPort);
    Servo actuatorServo2 = new Servo(ArmConstants.kRightArmMotorPort);

    
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