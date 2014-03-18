package objets;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class TrackBallCamera {
    
    private int distance = 1000;
    private int motionSensivity = 5;
    private int scrollSensivity = -1;
    private int angleX;
    private int angleY;
    
    public void render() {
        GLU.gluLookAt(0, 0, this.distance, 0, 0, 0, 0, 1, 0);
        GL11.glRotated(this.angleY, 0, 1, 0);
        GL11.glRotated(this.angleX, 1, 0, 0);
    }
    
    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public int getDistance() {
        return this.distance;
    }
    
    public void onMouseMotion() {
        if (Mouse.hasWheel() && Mouse.isButtonDown(0)) {
            this.angleX += Mouse.getDX() * this.motionSensivity;
            this.angleY += Mouse.getDY() * this.motionSensivity;
            
            this.angleY = this.angleY > 90 ? 90 : this.angleY;
            this.angleY = this.angleY < -90 ? -90 : this.angleY;
        }
        
        if (Mouse.hasWheel() && (Mouse.getEventDWheel() != 0)) {
            this.distance = this.distance + (this.scrollSensivity * Mouse.getEventDWheel());
        }
    }
}
