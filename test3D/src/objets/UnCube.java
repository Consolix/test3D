package objets;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import utils.GLUtils;

public class UnCube {
    
    private int dX = 0;
    private int dY = 0;
    
    public void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        
        GLU.gluLookAt(0, 0, 10, 0, 0, 0, 0, 1, 0);
        
        GL11.glPushMatrix();
        GL11.glRotated(this.dX, 1, 0, 0);
        GL11.glRotated(this.dY, 0, 1, 0);
        this.dessinerCube();
        GL11.glPopMatrix();
        
        GL11.glTranslated(5, 5, 0);
        this.dessinerCube();
        
        GL11.glFlush();
    }
    
    private void dessinerCube() {
        GL11.glBegin(GL11.GL_QUADS);
        
        GLUtils.glColor3ub(255, 0, 0); // face rouge
        GL11.glVertex3d(1, 1, 1);
        GL11.glVertex3d(1, 1, -1);
        GL11.glVertex3d(-1, 1, -1);
        GL11.glVertex3d(-1, 1, 1);
        
        GLUtils.glColor3ub(0, 255, 0); // face verte
        GL11.glVertex3d(1, -1, 1);
        GL11.glVertex3d(1, -1, -1);
        GL11.glVertex3d(1, 1, -1);
        GL11.glVertex3d(1, 1, 1);
        
        GLUtils.glColor3ub(0, 0, 255); // face bleue
        GL11.glVertex3d(-1, -1, 1);
        GL11.glVertex3d(-1, -1, -1);
        GL11.glVertex3d(1, -1, -1);
        GL11.glVertex3d(1, -1, 1);
        
        GLUtils.glColor3ub(255, 255, 0); // face jaune
        GL11.glVertex3d(-1, 1, 1);
        GL11.glVertex3d(-1, 1, -1);
        GL11.glVertex3d(-1, -1, -1);
        GL11.glVertex3d(-1, -1, 1);
        
        GLUtils.glColor3ub(0, 255, 255); // face cyan
        GL11.glVertex3d(1, 1, -1);
        GL11.glVertex3d(1, -1, -1);
        GL11.glVertex3d(-1, -1, -1);
        GL11.glVertex3d(-1, 1, -1);
        
        GLUtils.glColor3ub(255, 0, 255); // face magenta
        GL11.glVertex3d(1, -1, 1);
        GL11.glVertex3d(1, 1, 1);
        GL11.glVertex3d(-1, 1, 1);
        GL11.glVertex3d(-1, -1, 1);
        GL11.glEnd();
    }
    
    public void logic() {
        while (Mouse.next()) {
            if (Mouse.hasWheel() && Mouse.isButtonDown(0)) {
                this.dX += Mouse.getEventDX();
                this.dY -= Mouse.getEventDY();
            }
        }
    }
}
