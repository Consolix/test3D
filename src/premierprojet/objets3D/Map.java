package premierprojet.objets3D;

import org.lwjgl.opengl.GL11;

import utils.GLUtils;

public class Map {
    private Double tab[][];
    
    public Map() {
        this.tab = new Double[1000][1000];
    }
    
    public void render() {
        this.dessinerSurface();
        this.dessinerGrilleMap();
    }
    
    private void dessinerSurface() {
        for (int coordMapX = 0; coordMapX < this.tab.length; coordMapX++) {
            for (int coordMapY = 0; coordMapY < this.tab[coordMapX].length; coordMapY++) {
                GL11.glPushMatrix(); // Départ depuis le point d'origine
                GL11.glTranslated(coordMapX, coordMapY, 0);
                GLUtils.glColor3ub(0, 255, 0);
                GL11.glBegin(GL11.GL_QUADS);
                GL11.glVertex3d(0, 0, 0);
                GL11.glVertex3d(0, 1, 0);
                GL11.glVertex3d(1, 1, 0);
                GL11.glVertex3d(1, 0, 0);
                GL11.glEnd();
                GL11.glPopMatrix();
            }
        }
    }
    
    private void dessinerGrilleMap() {
        for (int coordMapX = 0; coordMapX < this.tab.length; coordMapX++) {
            for (int coordMapY = 0; coordMapY < this.tab[coordMapX].length; coordMapY++) {
                GL11.glPushMatrix(); // Départ depuis le point d'origine
                GL11.glTranslated(coordMapX, coordMapY, 0);
                GLUtils.glColor3ub(0, 0, 0);
                GL11.glBegin(GL11.GL_LINE_LOOP);
                GL11.glVertex3d(0, 0, 0.1);
                GL11.glVertex3d(0, 1, 0.1);
                GL11.glVertex3d(1, 1, 0.1);
                GL11.glVertex3d(1, 0, 0.1);
                GL11.glEnd();
                GL11.glPopMatrix();
            }
        }
    }
}
