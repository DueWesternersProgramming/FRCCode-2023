package frc.robot.subsystems.GrabberSubsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClawConstants;

public class ClawSubsystem extends SubsystemBase{

    CANSparkMax clawMotor = new CANSparkMax(ClawConstants.kClawMotorPort, MotorType.kBrushless);

    public ClawSubsystem(){
        clawMotor.setIdleMode(IdleMode.kBrake);
    }

    /**
     * @apiNote Sets claw to closed position
     * @param speed Claw speed
     */
    public void runClaw(double speed){
        clawMotor.set(speed);
    }

    public double getPosition(){
        return clawMotor.get();
    }

    @Override
    public void periodic() {

    }
    
}