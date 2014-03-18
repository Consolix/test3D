package objets;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.glu.GLU;

public class CameraGrue3D {
    
    private float positionX = 50;
    private float positionY = 50;
    private float positionZ = 120;
    private double angle = 0;
    
    public void lookAt() {
        GLU.gluLookAt(this.positionX, this.positionY, this.positionZ, 50, 50, 0, 0, 1, 0);
    }
    
    public void onMouseMotion() {
        this.angle = 0;
        if (Mouse.hasWheel() && Mouse.isButtonDown(0)) {
            this.angle += Mouse.getDX();
            double teta = Math.toRadians(this.angle);
            double xprime = (this.positionX * Math.cos(teta)) + (this.positionZ * Math.sin(teta));
            double zprime = (-this.positionX * Math.sin(teta)) + (this.positionZ * Math.cos(teta));
            this.positionX = (float) xprime;
            this.positionZ = (float) zprime;
        }
        this.positionZ += Mouse.getDWheel();
    }
}
