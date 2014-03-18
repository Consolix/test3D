package utils;

import org.lwjgl.opengl.GL11;

public class GLUtils {
    
    public static void glColor3ub(int red, int green, int blue) {
        GL11.glColor3ub(new Integer(red).byteValue(), new Integer(green).byteValue(), new Integer(blue).byteValue());
    }
}
