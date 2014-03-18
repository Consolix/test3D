package objets;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Grue2D {
    
    private static final int LARGEUR_BASE = 50;
    private static final int HAUTEUR_BASE = 20;
    private static final int LARGEUR_BRAS_1 = 150;
    private static final int HAUTEUR_BRAS_1 = 15;
    private static final int LARGEUR_BRAS_2 = 50;
    private static final int HAUTEUR_BRAS_2 = 10;
    private static final int TAILLE_CAISSE = 10;
    
    private int angle1 = 45;
    private int angle2 = -20;
    private int longueurFil = 50;
    
    private boolean shiftPressed = false;
    
    public void render() {
        
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        
        // Je déplace mon répère initial (actuellement en bas à gauche de l'écran)
        GL11.glTranslated(20, 20, 0);
        
        // La base
        this.choisirCouleur(254, 128, 1);
        this.dessineRectangle(LARGEUR_BASE, HAUTEUR_BASE);
        
        // Je me place en haut au milieu de la base
        GL11.glTranslated(LARGEUR_BASE / 2, HAUTEUR_BASE / 2, 0);
        
        // Le grand bras
        GL11.glRotated(this.angle1, 0, 0, 1);
        this.choisirCouleur(248, 230, 7);
        this.dessineRectangle(LARGEUR_BRAS_1, HAUTEUR_BRAS_1);
        
        // Je me place au bout du grand bras
        GL11.glTranslated(LARGEUR_BRAS_1, 0, 0);
        
        // Le petit bras
        GL11.glRotated(this.angle2, 0, 0, 1);
        this.choisirCouleur(186, 234, 21);
        this.dessineRectangle(LARGEUR_BRAS_2, HAUTEUR_BRAS_2);
        
        // Je me place au bout du petit bras
        GL11.glTranslated(LARGEUR_BRAS_2, 0, 0);
        
        // J'annule les rotations pour avoir le repère aligné avec le repère d'origine
        GL11.glRotated(-this.angle1 - this.angle2, 0, 0, 1);
        
        // Je dessine le fil
        this.choisirCouleur(255, 255, 255);
        this.dessinerLigne(this.longueurFil);
        
        // Je me déplace au bout du fil
        GL11.glTranslated(0, -this.longueurFil, 0);
        
        // Je me décale pour pouvoir centrer la caisse
        GL11.glTranslated(-TAILLE_CAISSE / 2, 0, 0);
        
        // Je dessine la caisse
        this.choisirCouleur(175, 175, 85);
        this.dessineRectangle(TAILLE_CAISSE, TAILLE_CAISSE);
        
        GL11.glFlush();
        
    }
    
    private void dessinerLigne(int longueurFil) {
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2d(0, 0);
        GL11.glVertex2d(0, -longueurFil);
        GL11.glEnd();
    }
    
    private void choisirCouleur(int red, int green, int blue) {
        GL11.glColor3ub(new Integer(red).byteValue(), new Integer(green).byteValue(), new Integer(blue).byteValue());
    }
    
    private void dessineRectangle(int largeurBase, int hauteurBase) {
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2d(0, -hauteurBase / 2);
        GL11.glVertex2d(0, hauteurBase / 2);
        GL11.glVertex2d(largeurBase, hauteurBase / 2);
        GL11.glVertex2d(largeurBase, -hauteurBase / 2);
        GL11.glEnd();
    }
    
    public void logic() {
        Keyboard.enableRepeatEvents(true);
        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                
                // Detection appuie sur shift
                if (Keyboard.getEventKey() == Keyboard.KEY_LSHIFT) {
                    this.shiftPressed = true;
                    System.out.println("shift pressed");
                }
                
                // Mouvement du fil
                if ((Keyboard.getEventKey() == Keyboard.KEY_UP) && (this.longueurFil > 0)) {
                    this.longueurFil -= 1;
                } else if ((Keyboard.getEventKey() == Keyboard.KEY_DOWN) && (this.longueurFil < 50)) {
                    this.longueurFil += 1;
                }
                
                if (!this.shiftPressed) {
                    // Mouvement du grand bras
                    if ((Keyboard.getEventKey() == Keyboard.KEY_LEFT) && (this.angle1 < 90)) {
                        this.angle1 += 1;
                    } else if ((Keyboard.getEventKey() == Keyboard.KEY_RIGHT) && (this.angle1 > 10)) {
                        this.angle1 -= 1;
                    }
                } else {
                    // Mouvement du petit bras
                    if ((Keyboard.getEventKey() == Keyboard.KEY_LEFT) && (this.angle2 < 45)) {
                        this.angle2 += 1;
                    } else if ((Keyboard.getEventKey() == Keyboard.KEY_RIGHT) && (this.angle2 > -45)) {
                        this.angle2 -= 1;
                    }
                }
            } else {
                
                // Détection on relache shift
                if (Keyboard.getEventKey() == Keyboard.KEY_LSHIFT) {
                    this.shiftPressed = false;
                    System.out.println("shift released");
                }
            }
        }
    }
}
