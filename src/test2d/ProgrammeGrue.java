package test2d;

import objets.Grue2D;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import utils.Initialisations;

public class ProgrammeGrue {
    
    private static final String TITRE_PROGRAMME = "Une grue";
    private static boolean finished = false;
    private static int FRAMERATE = 60;
    private static final int HAUTEUR_ECRAN = 600;
    private static final int LARGEUR_ECRAN = 800;
    
    private static Grue2D grue = new Grue2D();
    
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
        // TODO Auto-generated method stub
        
    }
    
    private static void run() throws InterruptedException {
        while (!finished) {
            // Always call Window.update(), all the time
            Display.update();
            if (Display.isCloseRequested()) {
                // Check for O/S close requests
                finished = true;
            } else if (Display.isActive()) {
                grue.logic();
                grue.render();
                Display.sync(FRAMERATE);
            } else {
                Thread.sleep(100);
                if (Display.isVisible() || Display.isDirty()) {
                    grue.logic();
                    grue.render();
                }
            }
        }
    }
    
    private static void init() throws LWJGLException {
        Initialisations.initialiser(TITRE_PROGRAMME);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluOrtho2D(0, LARGEUR_ECRAN, 0, HAUTEUR_ECRAN);
    }
}
