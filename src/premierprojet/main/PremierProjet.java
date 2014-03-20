package premierprojet.main;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

import premierprojet.scene.ScenePremierProjet;
import utils.Initialisations;

public class PremierProjet {
    
    private static final String TITRE_PROGRAMME = "Premier projet 3D";
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
        ScenePremierProjet scene = new ScenePremierProjet();
        scene.dessinerCeQuiNeBougePas();
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
