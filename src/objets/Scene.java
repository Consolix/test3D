package objets;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Scene {
    
    private static final int FRAMERATE = 60;
    private Terre planeteTerre;
    private TrackBallCamera camera;
    private boolean finished = false;
    private UserEvent userEvents;
    
    public Scene() {
        this.planeteTerre = new Terre();
        this.camera = new TrackBallCamera();
        this.userEvents = new UserEvent(this.camera, this.planeteTerre);
    }
    
    public void runScene() throws InterruptedException {
        while (!this.finished) {
            Display.update();
            if (Display.isCloseRequested()) {
                this.finished = true;
            } else if (Display.isActive()) {
                Display.sync(FRAMERATE);
                this.traitementsLogiques();
                this.dessinerLaScene();
            }
        }
    }
    
    private void traitementsLogiques() {
        this.userEvents.traiterEvents();
    }
    
    private void dessinerLaScene() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        
        this.camera.render();
        this.planeteTerre.render();
        
        GL11.glFlush();
        
    }
}
