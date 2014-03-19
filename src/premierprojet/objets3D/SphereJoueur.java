package premierprojet.objets3D;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

import premierprojet.autres.Position;
import utils.GLUtils;

public class SphereJoueur {
    
    private Position position;
    
    private float taille;
    private Sphere sphere;
    
    public SphereJoueur() {
        this.position = new Position();
        this.position.setPositionX(1f);
        this.position.setPositionY(1f);
        this.position.setPositionZ(0f);
        this.taille = Map.UNITE_MESURE / 2;
        this.sphere = new Sphere();
    }
    
    public Position getPosition() {
        return this.position;
    }
    
    public void render() {
        GL11.glPushMatrix();
        Map.MapGlTranslated(this.position.getPositionX(), this.position.getPositionY(), this.position.getPositionZ() + (this.taille / 2));
        GLUtils.glColor3ub(255, 255, 255);
        this.sphere.draw(this.taille, 50, 50);
        GL11.glPopMatrix();
    }
    
    public void onKeyEvent() {
        if (Keyboard.getEventKeyState()) {
            if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
                this.position.setPositionX(this.position.getPositionX() - 1);
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
                this.position.setPositionX(this.position.getPositionX() + 1);
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_UP) {
                this.position.setPositionY(this.position.getPositionY() + 1);
            }
            if (Keyboard.getEventKey() == Keyboard.KEY_DOWN) {
                this.position.setPositionY(this.position.getPositionY() - 1);
            }
        }
    }
}
