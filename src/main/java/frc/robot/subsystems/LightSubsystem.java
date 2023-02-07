package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.led.CANdle;

import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.ColorFlowAnimation;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.CANdle.LEDStripType;

public class LightSubsystem extends SubsystemBase {

    CANdle candle;
    CANdleConfiguration candleConfig;
    ColorFlowAnimation colorFlowAnimation;
    
    public LightSubsystem(){

        try{
            candle = new CANdle(25);
            candleConfig = new CANdleConfiguration();
            candleConfig.stripType = LEDStripType.RGB;
            candleConfig.brightnessScalar = 0.5;
            candle.configAllSettings(candleConfig);


            colorFlowAnimation = new ColorFlowAnimation(100, 0, 0, 0,0.1, 8, ColorFlowAnimation.Direction.Forward);
            candle.animate(colorFlowAnimation);

        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }

    }


    @Override
    public void periodic() {
        
    }
    
}