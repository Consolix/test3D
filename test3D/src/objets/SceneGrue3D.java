package objets;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class SceneGrue3D {
    
    private ObjetGrue3D grue3D;
    private CameraGrue3D camera;
    
    public SceneGrue3D() {
        this.grue3D = new ObjetGrue3D();
        this.camera = new CameraGrue3D();
    }
    
    public void runScene() {
        this.gestionEvenements();
        this.gestionAnimationsEtMouvements();
        this.dessinerLaScene();
    }
    
    private void gestionEvenements() {
        while (Mouse.next()) {
            this.camera.onMouseMotion();
        }
    }
    
    private void gestionAnimationsEtMouvements() {
        // TODO Auto-generated method stub
    }
    
    private void dessinerLaScene() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        
        this.camera.lookAt();
        this.grue3D.render();
        
        GL11.glFlush();
    }
    
}
