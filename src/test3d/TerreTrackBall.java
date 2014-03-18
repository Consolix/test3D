package test3d;

import objets.Scene;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;

import utils.Initialisations;

public class TerreTrackBall {
    
    private static final String TITRE_PROGRAMME = "Fake Google Earth";
    
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
        Scene scene = new Scene();
        scene.runScene();
    }
    
    private static void cleanup() {
        Initialisations.cleanUp();
    }
    
    private static void init() throws LWJGLException {
        Initialisations.initialiser3D(TITRE_PROGRAMME);
    }
}
