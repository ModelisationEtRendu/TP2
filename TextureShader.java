/**
 * Simple shader that just copy the interpolated color to the screen,
 * taking the depth of the fragment into acount.
 * @author: cdehais
 */

import algebra.*;
import java.awt.*;

public class TextureShader extends Shader {
    
    DepthBuffer depth;
    Texture texture;
    boolean combineWithBaseColor;

    public TextureShader (GraphicsWrapper screen) {
        super (screen);
        depth = new DepthBuffer (screen.getWidth (), screen.getHeight ());
        texture = null;
    }

    public void setTexture (String path) {
        try {
            texture = new Texture (path);
        } catch (Exception e) {
            System.out.println ("Could not load texture " + path);
            e.printStackTrace ();
            texture = null;
        }
    }

    public void setCombineWithBaseColor (boolean combineWithBaseColor) {
        this.combineWithBaseColor = combineWithBaseColor;
    }

    public void shade (Fragment fragment) {
        if (depth.testFragment (fragment)) {
            /* The Fragment may not have texture coordinates */
            try {



		/* à compléter */



            } catch (ArrayIndexOutOfBoundsException e) {
                screen.setPixel (fragment.getX (), fragment.getY (), fragment.getColor ());
            }
            depth.writeFragment (fragment);
        }
    }

    public void reset () {
        depth.clear ();
    }
}

