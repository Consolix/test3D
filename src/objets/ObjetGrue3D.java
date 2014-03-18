package objets;

import org.lwjgl.opengl.GL11;

import utils.GLUtils;

public class ObjetGrue3D {
    
    private static final double LONGUEUR_BASE = 50;
    private static final double HAUTEUR_BASE = 20;
    private static final double LARGEUR_BASE = 20;
    
    private static final double LONGUEUR_GRAND_BRAS = 100;
    private static final double HAUTEUR_GRAND_BRAS = 10;
    private static final double LARGEUR_GRAND_BRAS = 10;
    
    private static final double LONGUEUR_PETIT_BRAS = 50;
    private static final double HAUTEUR_PETIT_BRAS = 5;
    private static final double LARGEUR_PETIT_BRAS = 5;
    
    private double angleGrandBras = 45;
    private double anglePetitBras = -40;
    private double longueurFil = 50;
    
    public void render() {
        
        GL11.glPushMatrix();
        
        // la base
        this.dessinerCube(LONGUEUR_BASE, HAUTEUR_BASE, LARGEUR_BASE, 254, 128, 1);
        
        // le grand bras, situé au milieu de la base
        GL11.glTranslated(LONGUEUR_BASE / 2, HAUTEUR_BASE, 0);
        GL11.glRotated(this.angleGrandBras, 0, 0, 1);
        this.dessinerCube(LONGUEUR_GRAND_BRAS, HAUTEUR_GRAND_BRAS, LARGEUR_GRAND_BRAS, 248, 230, 7);
        
        // le petit bras, au bout du grand bras
        GL11.glTranslated(LONGUEUR_GRAND_BRAS, HAUTEUR_GRAND_BRAS / 2, 0);
        GL11.glRotated(this.anglePetitBras, 0, 0, 1);
        this.dessinerCube(LONGUEUR_PETIT_BRAS, HAUTEUR_PETIT_BRAS, LARGEUR_PETIT_BRAS, 186, 234, 21);
        
        // le fil au bout du petit bras
        GL11.glTranslated(LONGUEUR_PETIT_BRAS, HAUTEUR_PETIT_BRAS / 2, LARGEUR_PETIT_BRAS / 2);
        GL11.glRotated(-this.angleGrandBras - this.anglePetitBras, 0, 0, 1); // annulation des 2 rotations pour revenir aligné au repère initial
        this.dessinerLigneVerticale(this.longueurFil, 255, 255, 255);
        
        GL11.glPopMatrix();
    }
    
    private void dessinerLigneVerticale(double longeurLigne, int red, int green, int blue) {
        GL11.glBegin(GL11.GL_LINES);
        GLUtils.glColor3ub(red, green, blue);
        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(0, -longeurLigne, 0);
        GL11.glEnd();
    }
    
    public void dessinerCube(double xlenght, double ylength, double zlength, int red, int green, int blue) {
        
        GL11.glBegin(GL11.GL_QUADS);
        
        // Couleur
        GLUtils.glColor3ub(red, green, blue);
        
        // face 1
        GL11.glVertex3d(0, ylength, zlength / 2);
        GL11.glVertex3d(xlenght, ylength, zlength / 2);
        GL11.glVertex3d(xlenght, 0, zlength / 2);
        GL11.glVertex3d(0, 0, zlength / 2);
        
        // face 2
        GL11.glVertex3d(0, ylength, -zlength / 2);
        GL11.glVertex3d(0, ylength, zlength / 2);
        GL11.glVertex3d(0, 0, zlength / 2);
        GL11.glVertex3d(0, 0, -zlength / 2);
        
        // face 3
        GL11.glVertex3d(xlenght, ylength, -zlength / 2);
        GL11.glVertex3d(0, ylength, -zlength / 2);
        GL11.glVertex3d(0, 0, -zlength / 2);
        GL11.glVertex3d(xlenght, 0, -zlength / 2);
        
        // face 4
        GL11.glVertex3d(xlenght, ylength, -zlength / 2);
        GL11.glVertex3d(xlenght, ylength, zlength / 2);
        GL11.glVertex3d(xlenght, 0, zlength / 2);
        GL11.glVertex3d(xlenght, 0, -zlength / 2);
        
        // face 5
        GL11.glVertex3d(xlenght, ylength, -zlength / 2);
        GL11.glVertex3d(xlenght, ylength, zlength / 2);
        GL11.glVertex3d(0, ylength, zlength / 2);
        GL11.glVertex3d(0, ylength, -zlength / 2);
        
        // face 6
        GL11.glVertex3d(xlenght, 0, -zlength / 2);
        GL11.glVertex3d(xlenght, 0, zlength / 2);
        GL11.glVertex3d(0, 0, zlength / 2);
        GL11.glVertex3d(0, 0, -zlength / 2);
        
        GL11.glEnd();
    }
}
