package frc.robot.subsystems;

import java.util.List;

import org.photonvision.PhotonCamera;
import org.photonvision.common.hardware.VisionLEDMode;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase{
 
    PhotonCamera camera;
    
    public VisionSubsystem(){

        try{
            camera = new PhotonCamera("Limelight");
            camera.setDriverMode(false);
            setLedMode(VisionLEDMode.kOn);
        }
        catch (Exception e){
            System.out.println("Vision Error: " + e);
        }

    }

    /**
     * @param pipeline 0 is apriltag 1 is reflective 2 is shape
     */
    public void SetActivePipeline(int pipeline){
        camera.setPipelineIndex(pipeline);
    }

    public int getActivePipeline(){
        return camera.getPipelineIndex();
    }

    public void setLedMode(VisionLEDMode ledmode){
        camera.setLED(ledmode);
    }

    public VisionLEDMode getLedMode(){
        return camera.getLEDMode();
    }

    public PhotonPipelineResult cameraResult(){
        return camera.getLatestResult();
    } 

    public boolean hasTarget(){
        if (cameraResult().hasTargets()){
            return true;
        }
        return false;
    }

    public List<PhotonTrackedTarget> getTargets(){
        try{
            if (hasTarget()){
                return cameraResult().getTargets();
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public PhotonTrackedTarget getBestTarget(){
        try{
            if (hasTarget()){
                return cameraResult().getBestTarget();
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
        return null;
    }

    public double getyaw(){
        try{
            if (hasTarget()){
                return getBestTarget().getYaw();
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
        return 0;
    }

    public double getpitch() {
        try{
            if (hasTarget()){
                return getBestTarget().getPitch();
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
        return 0;
    }

    public double getarea() {
        try{
            if (hasTarget()){
                return getBestTarget().getArea();
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
        return 0;
    }

    public double getskew(){
        try{
            if (hasTarget()){
                return getBestTarget().getSkew();
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
        return 0;
    }

    public int getTargetID(){
        try{
            if (hasTarget()){
                return getBestTarget().getFiducialId();
            }
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
        return 0;
    }


    @Override
    public void periodic() {
        SmartDashboard.putNumber("yaw", getyaw());
        SmartDashboard.putNumber("pitch", getpitch());
        SmartDashboard.putNumber("skew", getskew());
        SmartDashboard.putNumber("targetid", getTargetID());
        SmartDashboard.putNumber("pipeline", getActivePipeline());
    }
}