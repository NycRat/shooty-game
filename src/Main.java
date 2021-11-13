import ky.KYscreen;
import ky.Vector2D;
import ky.AudioPlayer;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Main extends KYscreen{

    public static int score=0;
    static int width = 0;
    static int height = 0;
    public static Player player;
    static double trackTime=0;
    static double enemySpawnTime = 1;
    static AudioPlayer backgroundMusic;
    static double lastShotTime=0;
    static int frames=0;
    static double trackSeconds=0;

    @Override
    public void start() {
        setFullScreen(true);
        setCursorVisible(false);
        // setDebugMode(true);
        backgroundMusic = new AudioPlayer("assets/backgroundMusic.wav");
        backgroundMusic.setLoop(true);
        backgroundMusic.setVolume(-15);

        player = new Player(new Vector2D(0,0), 88, 61);
        add(player);

        add(new Enemy(new Vector2D(
                    getCameraPos().getX()+width+width*0.4,
                    getCameraPos().getY()+new Random().nextDouble(height+height*0.4)-height*0.2), 100, 100));
    }

    @Override
    public void update() {
        frames++;
        lastShotTime+=deltaT;
        trackTime+=deltaT;
        trackSeconds+=deltaT;
        if (trackTime>=enemySpawnTime) {
            trackTime-=enemySpawnTime;
            add(new Enemy(new Vector2D(
                        getCameraPos().getX()+width+width*0.4,
                        getCameraPos().getY()+new Random().nextDouble(height+height*0.4)-height*0.2), 100, 100));
            // add(new Enemy(new Vector2D(300,500),100,100));
        }

        if (trackSeconds>=1) {
            System.out.println(frames);
            trackSeconds-=1;
            frames=0;
        }
        
        setCameraPos(new Vector2D(player.getX()-width/2+width*0.2, player.getY()-height/2));
    }

    @Override
    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_ESCAPE) 
            System.exit(0);

        if (keyCode == KeyEvent.VK_SPACE) {
            if (lastShotTime >= 0 && player.alive && player.bullets>0) {
                player.bullets--;
                add(new Bullet(new Vector2D(player.getX()+40,player.getY()-15)));
                lastShotTime = 0;
            }
        }
    }

    @Override
    public void keyReleased(int keyCode) {
        
    }

    @Override
    public void keyTyped(int keyCode) {
        
    }

    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "1.0");
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