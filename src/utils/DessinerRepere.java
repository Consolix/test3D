package utils;

import org.lwjgl.opengl.GL11;

public class DessinerRepere {
    
    public static void renderRepere2D(int echelle) {
        GL11.glPushMatrix();
        GL11.glScalef(echelle, echelle, echelle);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor3d(0, 0, 255);
        GL11.glVertex2i(0, 0);
        GL11.glVertex2i(1, 0);
        GL11.glColor3d(0, 255, 0);
        GL11.glVertex2i(0, 0);
        GL11.glVertex2i(0, 1);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
    
    public static void renderRepere3D(int echelle) {
        GL11.glPushMatrix();
        GL11.glTranslated(0, 0, 0.1);
        GL11.glScalef(echelle, echelle, echelle);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor3d(0, 0, 255); // axe X en bleu
        GL11.glVertex3i(0, 0, 0);
        GL11.glVertex3i(1, 0, 0);
        GL11.glColor3d(0, 255, 0); // axe Y en vert
        GL11.glVertex3i(0, 0, 0);
        GL11.glVertex3i(0, 1, 0);
        GL11.glColor3d(255, 0, 0); // axe Z en rouge
        GL11.glVertex3i(0, 0, 0);
        GL11.glVertex3i(0, 0, 1);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
}
