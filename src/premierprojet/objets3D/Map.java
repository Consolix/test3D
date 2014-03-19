package premierprojet.objets3D;

import org.lwjgl.opengl.GL11;

import utils.GLUtils;

public class Map {
    public static final int UNITE_MESURE = 2;
    private Double tab[][];
    
    public Map() {
        this.tab = new Double[20][20];
    }
    
    public void render() {
        
        this.dessinerSurface();
        this.dessinerGrilleMap();
        
    }
    
    private void dessinerSurface() {
        for (int coordMapX = 0; coordMapX < this.tab.length; coordMapX++) {
            for (int coordMapY = 0; coordMapY < this.tab[coordMapX].length; coordMapY++) {
                GL11.glPushMatrix(); // Départ depuis le point d'origine
                GL11.glTranslated(coordMapX * UNITE_MESURE, coordMapY * UNITE_MESURE, 0);
                GLUtils.glColor3ub(0, 255, 0);
                GL11.glBegin(GL11.GL_QUADS);
                GL11.glVertex3d(0, 0, 0);
                GL11.glVertex3d(0, UNITE_MESURE, 0);
                GL11.glVertex3d(UNITE_MESURE, UNITE_MESURE, 0);
                GL11.glVertex3d(UNITE_MESURE, 0, 0);
                GL11.glEnd();
                GL11.glPopMatrix();
            }
        }
    }
    
    private void dessinerGrilleMap() {
        for (int coordMapX = 0; coordMapX < this.tab.length; coordMapX++) {
            for (int coordMapY = 0; coordMapY < this.tab[coordMapX].length; coordMapY++) {
                GL11.glPushMatrix(); // Départ depuis le point d'origine
                GL11.glTranslated(coordMapX * UNITE_MESURE, coordMapY * UNITE_MESURE, 0);
                GLUtils.glColor3ub(0, 0, 0);
                GL11.glBegin(GL11.GL_LINE_LOOP);
                GL11.glVertex3d(0, 0, 0.1);
                GL11.glVertex3d(0, UNITE_MESURE, 0.1);
                GL11.glVertex3d(UNITE_MESURE, UNITE_MESURE, 0.1);
                GL11.glVertex3d(UNITE_MESURE, 0, 0.1);
                GL11.glEnd();
                GL11.glPopMatrix();
            }
        }
    }
    
    public static void MapGlTranslated(double x, double y, double z) {
        GL11.glTranslated((x * UNITE_MESURE) + (UNITE_MESURE / 2), (y * UNITE_MESURE) + (UNITE_MESURE / 2), z * UNITE_MESURE);
    }
}
