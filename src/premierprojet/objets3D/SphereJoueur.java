package premierprojet.objets3D;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

import utils.GLUtils;

public class SphereJoueur {
    
    int positionX;
    int positionY;
    Sphere sphere;
    
    public SphereJoueur() {
        this.positionX = 1;
        this.positionY = 1;
        this.sphere = new Sphere();
    }
    
    public void render() {
        GL11.glPushMatrix();
        Map.MapGlTranslated(this.positionX, this.positionY, 0.5);
        GLUtils.glColor3ub(255, 255, 255);
        this.sphere.draw(Map.UNITE_MESURE, 50, 50);
        GL11.glPopMatrix();
    }
}
