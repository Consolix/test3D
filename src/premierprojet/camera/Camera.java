package premierprojet.camera;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.glu.GLU;

import premierprojet.autres.Position;
import utils.DessinerRepere;

public class Camera {
    
    private Position position;
    
    public Camera() {
        this.position = new Position();
        this.position.setPositionX(0);
        this.position.setPositionY(-5);
        this.position.setPositionZ(10);
    }
    
    public void lookAt(float coordX, float coordY, float coordZ) {
        GLU.gluLookAt(this.position.getPositionX(), this.position.getPositionY(), this.position.getPositionZ(), coordX, coordY, coordZ, 0, 0, 1);
        DessinerRepere.renderRepere3D(100);
    }
    
    public void onMouseEvent() {
        if (Mouse.hasWheel() && Mouse.isButtonDown(0)) {
            int angleZ = -Mouse.getDX();
            double teta = Math.toRadians(angleZ);
            double xprime = (this.position.getPositionX() * Math.cos(teta)) + (this.position.getPositionY() * Math.sin(teta));
            double yprime = (-this.position.getPositionX() * Math.sin(teta)) + (this.position.getPositionY() * Math.cos(teta));
            this.position.setPositionX((float) xprime);
            this.position.setPositionY((float) yprime);
            
            int angleX = Mouse.getDY();
            double teta2 = Math.toRadians(angleX);
            double ysec = (this.position.getPositionY() * Math.cos(teta2)) + (this.position.getPositionZ() * Math.sin(teta2));
            double zsec = (-this.position.getPositionY() * Math.sin(teta2)) + (this.position.getPositionZ() * Math.cos(teta2));
            this.position.setPositionY((float) ysec);
            this.position.setPositionZ((float) zsec);
        }
    }
    
    public void setPosition(float x, float y, float z) {
        this.position.setPositionX(x);
        this.position.setPositionY(y);
        this.position.setPositionZ(z);
    }
}
