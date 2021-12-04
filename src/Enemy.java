import java.util.ArrayList;
import java.math.*;

import ky.Asset;
import ky.CollisionEntity;
import ky.Vector2D;

public class Enemy extends CollisionEntity {

    Asset enemySprite;
    double movementSpeed=600;

    public Enemy(Vector2D position, int collisionBoxWidth, int collisionBoxHeight) {
        super(position, collisionBoxWidth, collisionBoxHeight, 2, "enemy");
        enemySprite = new Asset("assets/enemy.png", new Vector2D(0, 0), 3);
        enemySprite.setVisible(true);
        add(enemySprite);
        setVisible(true);
    }

    double moveX;
    double moveY;

    @Override
    public void update (double dt, ArrayList<Integer> kc) {
        double angle = Math.atan2(Main.player.getX()-getX(), Main.player.getY()-getY());
        setVel(new Vector2D(Math.sin(angle)*movementSpeed, Math.cos(angle) * movementSpeed));
    }

    @Override
    public void onCollision (CollisionEntity e) {
        if (e.getName().equals("bullet") && isVisible()) {
            Main.score++;
            enemySprite=null;
            setVisible(false);
            e.setVisible(false);
        }
    }
    
}
