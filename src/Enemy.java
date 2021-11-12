import ky.CollisionEntity;

public class Enemy extends CollisionEntity {

    public Enemy(double x, double y, int collisionBoxWidth, int collisionBoxHeight) {
        super(x, y, collisionBoxWidth, collisionBoxHeight, 2, "enemy");
    }
    
}
