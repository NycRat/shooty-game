import java.util.ArrayList;

import ky.Asset;
import ky.CollisionEntity;
import ky.Vector2D;

public class Enemy extends CollisionEntity {

    Asset enemySprite;
    double movementSpeed=50000;

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
        moveX = Main.player.getX() - getX();
        moveY = Main.player.getY() - getY();
        if (Math.abs(moveX)>Math.abs(moveY)) {
            moveY/=Math.abs(moveX);
            moveX=((moveX>0) ? 1 : -1);
        } else if (Math.abs(moveX)<Math.abs(moveY)) {
            moveX/=Math.abs(moveY);
            moveY=((moveY>0) ? 1 : -1);
        }
        setVel(new Vector2D(moveX*movementSpeed*dt, moveY*movementSpeed*dt));


        /*
        moveX = Main.player.getX()-getX();
        moveY = (Main.player.getY()-getY()) * movementSpeed/moveX;
        moveX=((moveX>0) ? 1 : -1) * movementSpeed;
        setVel(moveX*dt, moveY*dt);*/
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
