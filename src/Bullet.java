import java.util.ArrayList;

import ky.Asset;
import ky.CollisionEntity;
import ky.Vector2D;

public class Bullet extends CollisionEntity {

    static Asset bulletSprite;

    public Bullet(Vector2D position) {
        super(position, 29, 14, 2, "bullet");
        bulletSprite = new Asset("assets/bullet.png", new Vector2D(0, 0), 2);
        bulletSprite.setVisible(true);
        add(bulletSprite);
        setVisible(true);
        setCollision(false);
    }

    @Override
    public void update (double dt, ArrayList<Integer> kc) {
        setVel(new Vector2D(dt*140000, 0));        
    }

    @Override
    public void onCollision (CollisionEntity e) {
        // if (e.getName().equals("enemy")||e.getName().equals("enemyBullet")) {
        //     e.setVisible(false);
        //     bulletSprite = null;
        //     setVisible(false);
        // }
    }

    
}
