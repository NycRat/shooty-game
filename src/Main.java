import ky.KYscreen;
import ky.Vector2D;
import ky.AudioPlayer;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Main extends KYscreen{

    static int width = 1000;
    static int height = 700;
    static AudioPlayer backgroundMusic;
    static Player player;

    @Override
    public void start() {
        setFullScreen(true);
        setDebugMode(false);
        backgroundMusic = new AudioPlayer("assets/backgroundMusic.wav");
        backgroundMusic.setLoop(true);
        backgroundMusic.setVolume(-15);

        player = new Player(new Vector2D(0, 0), 100, 100);
        add(player);

    }

    @Override
    public void update() {
        
        
    }

    @Override
    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_ESCAPE) 
            System.exit(0);
    }

    @Override
    public void keyReleased(int keyCode) {
        
    }

    @Override
    public void keyTyped(int keyCode) {
        
    }


    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiscale", "1.0");
        GraphicsEnvironment gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gDevice = gEnvironment.getDefaultScreenDevice();
        width = gDevice.getDisplayMode().getWidth();
        height = gDevice.getDisplayMode().getHeight();
        new Main();
    }

    public Main() {
        super(width, height, false);
    }

}