package premierprojet.scene;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import premierprojet.camera.Camera;
import premierprojet.objets3D.Map;
import premierprojet.objets3D.SphereJoueur;

public class ScenePremierProjet {
    
    private Camera camera;
    private SphereJoueur sphere;
    private Map map;
    
    public ScenePremierProjet() {
        this.camera = new Camera();
        this.sphere = new SphereJoueur();
        this.map = new Map();
    }
    
    public void runScene() {
        this.gererLesEvenementsUtilisateurs();
        this.gererLogiqueDeLaScene();
        this.dessinerLaScene();
    }
    
    private void gererLogiqueDeLaScene() {
        // this.camera.setPosition(this.sphere.getPosition());
    }
    
    private void gererLesEvenementsUtilisateurs() {
        while (Mouse.next()) {
            this.camera.onMouseEvent();
        }
        while (Keyboard.next()) {
            this.sphere.onKeyEvent();
        }
    }
    
    private void dessinerLaScene() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        
        this.camera.lookAt(0, 0, 0);
        this.map.render();
        this.sphere.render();
        
        GL11.glFlush();
    }
}
