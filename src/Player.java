import java.awt.event.KeyEvent;
import java.util.ArrayList;
import ky.Asset;
import ky.CollisionEntity;
import ky.Vector2D;
import java.lang.Math;

public class Player extends CollisionEntity {

    static int hp = 10;
    static int bullets = 20;
    static Asset playerSprite;
    final static double maxVelocity = 1000;

    public Player(Vector2D position, int collisionBoxWidth, int collisionBoxHeight) {
        super(position, collisionBoxWidth, collisionBoxHeight, 3, "player");
        setCollision(true);
        playerSprite = new Asset("assets/gun.png", new Vector2D(0, 0), 3);
        playerSprite.rescale(collisionBoxHeight/playerSprite.getHeight());
        playerSprite.setVisible(true);
        add(playerSprite);
        setVisible(true);
    }

    @Override
    public void update(double dt, ArrayList<Integer> keyCodes) {
        // add velocity
        addVel((keyCodes.contains(KeyEvent.VK_D) ? 10000*dt : 0), 0);
        addVel((keyCodes.contains(KeyEvent.VK_A) ? -10000*dt : 0), 0);
        addVel(0, (keyCodes.contains(KeyEvent.VK_W) ? -10000*dt: 0));
        addVel(0, (keyCodes.contains(KeyEvent.VK_S) ? 10000*dt: 0));

        setVel((Math.abs(getVel().getX()) > maxVelocity) 
                ? ((getVel().getX()>0) ? 1 : -1) * maxVelocity : getVel().getX(),
                (Math.abs(getVel().getY()) > maxVelocity) 
                ? ((getVel().getY()>0) ? 1 : -1) * maxVelocity : getVel().getY());


        // reduce velocity
        addVel(-getVel().getX()*dt*10, -getVel().getY()*dt*10);

        // shooting
        if (keyCodes.contains(KeyEvent.VK_SPACE) && bullets > 0) {
            bullets--;
            
        }
    }

    @Override
    public void onCollision (CollisionEntity e) {

    }

    public void shoot () {
    }

    public int getBullets () { return bullets; }

}
