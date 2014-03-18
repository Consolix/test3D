package test2d;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glFlush;
import static org.lwjgl.opengl.GL11.glVertex2d;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class PremierProgramme {
    
    private static final int FRAMERATE = 60;
    private static final String TITRE_PROGRAMME = "Mon premier programme OpenGL";
    private static boolean finished = false;
    
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
    
    private static void init() throws LWJGLException {
        Display.setTitle(TITRE_PROGRAMME);
        Display.setDisplayMode(new DisplayMode(800, 600));
        Display.setVSyncEnabled(true);
        Display.create();
    }
    
    private static void cleanup() {
        // TODO Auto-generated method stub
    }
    
    private static void run() throws InterruptedException {
        while (!finished) {
            Display.update();
            if (Display.isCloseRequested()) {
                finished = true;
            } else if (Display.isActive()) {
                Display.sync(FRAMERATE);
                render();
            } else {
                // The window is not in the foreground, so we can allow other stuff to run and
                // infrequently update
                Thread.sleep(100);
                if (Display.isVisible() || Display.isDirty()) {
                    render();
                }
            }
        }
    }
    
    private static void render() {
        glClear(GL_COLOR_BUFFER_BIT);
        glBegin(GL_QUADS);
        glColor3d(0, 0, 255);
        glVertex2d(-0.75, -0.75);
        glVertex2d(-0.75, 0.75);
        glColor3d(255, 0, 0);
        glVertex2d(0.75, 0.75);
        glVertex2d(0.75, -0.75);
        glEnd();
        glFlush();
    }
}
