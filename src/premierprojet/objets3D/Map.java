package premierprojet.objets3D;

import org.lwjgl.opengl.GL11;

public class Map {
    private int largeur;
    private int longueur;
    
    public Map() {
        this.largeur = 500;
        this.longueur = 1000;
    }
    
    public void render() {
        this.dessinerSurface();
    }
    
    private void dessinerSurface() {
        
        GL11.glPushMatrix();
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(0, this.largeur, 0);
        GL11.glVertex3d(this.longueur, this.largeur, 0);
        GL11.glVertex3d(this.longueur, 0, 0);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
}
