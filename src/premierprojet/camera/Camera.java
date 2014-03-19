package premierprojet.camera;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.glu.GLU;

import utils.DessinerRepere;

public class Camera {
    
    private float positionX;
    private float positionY;
    private float positionZ;
    
    public Camera() {
        this.positionX = 0;
        this.positionY = -3;
        this.positionZ = 10;
    }
    
    public void lookAt(float coordX, float coordY, float coordZ) {
        GLU.gluLookAt(this.positionX, this.positionY, this.positionZ, coordX, coordY, coordZ, 0, 0, 1);
        DessinerRepere.renderRepere3D(100);
    }
    
    public void onMouseEvent() {
        if (Mouse.hasWheel() && Mouse.isButtonDown(0)) {
            int angleZ = -Mouse.getDX();
            double teta = Math.toRadians(angleZ);
            double xprime = (this.positionX * Math.cos(teta)) + (this.positionY * Math.sin(teta));
            double yprime = (-this.positionX * Math.sin(teta)) + (this.positionY * Math.cos(teta));
            this.positionX = (float) xprime;
            this.positionY = (float) yprime;
            
            int angleX = Mouse.getDY();
            double teta2 = Math.toRadians(angleX);
            double ysec = (this.positionY * Math.cos(teta2)) + (this.positionZ * Math.sin(teta2));
            double zsec = (-this.positionY * Math.sin(teta2)) + (this.positionZ * Math.cos(teta2));
            this.positionY = (float) ysec;
            this.positionZ = (float) zsec;
        }
    }
}
