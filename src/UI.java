import java.util.ArrayList;

import ky.Entity;
import ky.Text;
import ky.Vector2D;
import java.awt.*;

public class UI extends Entity {

    static Text fpsText;
    static Text ammoText;
    Font textFont;

    public UI() {
        super(new Vector2D(Main.width/2, Main.height/2), 4);
        textFont = new Font("Arial", Font.PLAIN, Main.width/64);
        fpsText = new Text("FPS: ", textFont, Color.black, new Vector2D(0,textFont.getSize()), textFont.getSize()*10, textFont.getSize(), 4);
        ammoText = new Text("AMMO: " + Main.player.ammo, textFont, Color.black, new Vector2D(0,0), textFont.getSize()*10, textFont.getSize(), 4);
        
        fpsText.setVisible(true);
        ammoText.setVisible(true);
        add(fpsText);
        add(ammoText);
        setVisible(true);

    }

    @Override
    public void update (double deltaTime, ArrayList<Integer> kc) {
        setPos(Main.player.getX()-Main.width/2+Main.width*0.3, Main.player.getY()-Main.height/2+40);
    }

    public void updateAmmoCount (int ammo) {
        ammoText.setText("AMMO: " + ammo);
        ammoText.updateText();
    }

    public void updateFpsCount (int fps) {
        fpsText.setText("FPS: " + fps);
        fpsText.updateText();
    }
    
    public void displayDefeat () {

    }
}