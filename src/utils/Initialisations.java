package utils;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class Initialisations {
    
    public static void initialiser(String titreProgramme) throws LWJGLException {
        Display.setTitle(titreProgramme);
        Display.setDisplayMode(new DisplayMode(800, 600));
        Display.setVSyncEnabled(true);
        Display.create();
    }
    
    public static void initialiser3D(String titreProgramme) throws LWJGLException {
        int largeur = 800;
        int hauteur = 600;
        int angleDeVisionDeLaCamera = 70;
        int distanceMaxAffichageObjet = 1000;
        int distanceMinAffichageObjet = 1;
        float ratioDimensionEcran = (float) largeur / hauteur;
        
        Display.setTitle(titreProgramme);
        Display.setDisplayMode(new DisplayMode(largeur, hauteur));
        Display.setVSyncEnabled(true);
        Display.create();
        
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        
        GLU.gluPerspective(angleDeVisionDeLaCamera, ratioDimensionEcran, distanceMinAffichageObjet, distanceMaxAffichageObjet);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }
    
    public static void cleanUp() {
        Display.destroy();
    }
    
}
