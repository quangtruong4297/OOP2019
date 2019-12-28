package tilegame.entities.creatures;

import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.tiles.Tile;


public abstract class Creature extends Entity {

    public static final float DEFAULT_SPEED = 3;
    public static final int DEFAULT_MANA = 3;
    public static final int DEFAULT_CREATURE_WIDTH = Tile.TILE_WIDTH;
    public static final int DEFAULT_CREATURE_HEIGHT = Tile.TILE_HEIGHT;

    public enum CreatureDir{
        left, right, up, down
    }

    protected float speed;
    protected float xMove;
    protected float yMove;
    protected CreatureDir dir;

    protected int damage = 1;
    protected int mana = 3;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        mana = DEFAULT_MANA;
    }

    public void move() {
        if(!checkEntityCollisions(xMove, 0f))
            moveX();
        if(!checkEntityCollisions(0f, yMove))
            moveY();
    }

    private void moveY() {
        if(!this.isSolid()){
            y += yMove;
            return;
        }
        if(yMove > 0) {
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

            if(!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                y += yMove;
            }else {
                y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
            }
        }else if(yMove < 0) {
            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;

            if(!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                y += yMove;
            }else {
                y = ty * Tile.TILE_HEIGHT  + Tile.TILE_HEIGHT - bounds.y ;
            }
        }
    }

    private void moveX() {
        if(!this.isSolid()) {
            x += xMove;
            return;
        }

        if(xMove > 0) {
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;

            if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            }else {
                x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
            }
        }else if(xMove < 0) {
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;

            if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            }else {
                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorldManager().getWorld().getTile(x, y).isSolid();
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getDamage() {
        return damage;
    }

}
