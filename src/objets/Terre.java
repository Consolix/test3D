package objets;

import java.awt.image.BufferedImage;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Sphere;

import utils.TextureLoader;

public class Terre {
    
    private Sphere sphere = new Sphere();
    private int dX = 0;
    private int dY = 0;
    private static Integer textureId;
    
    public static int getTextureId() {
        if (textureId == null) {
            BufferedImage image = TextureLoader.loadImage("ressources/earth.jpg");
            textureId = TextureLoader.loadTexture(image);
        }
        return textureId;
    }
    
    public void render() {
        
        GL11.glPushMatrix();
        GL11.glTranslated(0, 0, 0);
        GL11.glColor3f(1f, 1f, 1f);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, Terre.getTextureId());
        this.sphere.setTextureFlag(true);
        this.sphere.draw(500, 50, 50);
        GL11.glPopMatrix();
    }
    
    public void logic() {
        
    }
    
    public int getDX() {
        return this.dX;
    }
    
    public void setDX(int i) {
        this.dX = i;
    }
    
    public int getDY() {
        return this.dY;
    }
    
    public void setDY(int i) {
        this.dY = i;
    }
    
}
