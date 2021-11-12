import ky.CollisionEntity;
import ky.Vector2D;

public class Ground extends CollisionEntity {

    public Ground(Vector2D position, int collisionBoxWidth, int collisionBoxHeight) {
        super(position, collisionBoxWidth, collisionBoxHeight, 2, "ground");
    }
    
}
