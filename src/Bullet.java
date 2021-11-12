import java.util.ArrayList;

import ky.CollisionEntity;
import ky.Vector2D;

public class Bullet extends CollisionEntity {

    public Bullet(Vector2D position, int collisionBoxWidth, int collisionBoxHeight) {
        super(position, collisionBoxWidth, collisionBoxHeight, 2, "bullet");
    }

    @Override
    public void update (double dt, ArrayList<Integer> kc) {

    }

    
}
