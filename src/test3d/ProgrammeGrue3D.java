package test3d;

import objets.SceneGrue3D;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

import utils.Initialisations;

public class ProgrammeGrue3D {
    
    private static final String TITRE_PROGRAMME = "Une grue 3D";
    private static final int FRAMERATE = 60;
    
    public static void main(String[] args) {
        try {
            init();
            run();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            Sys.alert(TITRE_PROGRAMME, "An error occured and the program will exit.");
        } finally {
            cleanup();
        }
        System.exit(0);
    }
    
    private static void run() throws InterruptedException {
        SceneGrue3D scene = new SceneGrue3D();
        while (!Display.isCloseRequested()) {
            Display.update();
            Display.sync(FRAMERATE);
            scene.runScene();
        }
    }
    
    private static void cleanup() {
        Initialisations.cleanUp();
    }
    
    private static void init() throws LWJGLException {
        Initialisations.initialiser3D(TITRE_PROGRAMME);
    }
}
