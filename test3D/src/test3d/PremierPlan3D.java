package test3d;

import objets.UnCube;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

import utils.Initialisations;

public class PremierPlan3D {
    
    private static final String TITRE_PROGRAMME = "Mon premier plan 3d";
    private static boolean finished = false;
    private static int FRAMERATE = 60;
    
    private static UnCube cube = new UnCube();
    
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
    
    private static void cleanup() {
        Display.destroy();
    }
    
    private static void init() throws LWJGLException {
        Initialisations.initialiser3D(TITRE_PROGRAMME);
    }
    
    private static void run() throws InterruptedException {
        while (!finished) {
            Display.update();
            if (Display.isCloseRequested()) {
                finished = true;
            } else if (Display.isActive()) {
                Display.sync(FRAMERATE);
                logic();
                render();
            } else {
                Thread.sleep(100);
                if (Display.isVisible() || Display.isDirty()) {
                    logic();
                    render();
                }
            }
        }
    }
    
    private static void logic() {
        cube.logic();
    }
    
    private static void render() {
        cube.render();
    }
    
}
