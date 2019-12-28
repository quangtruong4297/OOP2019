package tilegame.portals;

import tilegame.Handler;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;
import tilegame.tiles.Tile;
import tilegame.worlds.World;

import java.awt.*;


public class Portal {

    private float x, y;
    private Animation animation;
    private float spawnX, spawnY;
    private World world;
    private Handler handler;
    private Rectangle bounds;

    public Portal(Handler handler, float x, float y, float spawnX, float spawnY, World world) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
        this.world = world;
        animation = new Animation(120, Assets.portal);
        bounds = new Rectangle(Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
    }

    public void tick(){
        animation.tick();

        checkWalkOver();
    }

    private void checkWalkOver() {

        if(getCollisionBounds(0, 0).contains(handler.getWorldManager().getWorld().getEntityManager().getHero().getCollisionBounds(0, 0))
                && handler.getKeyManager().travel){
            travel();
        }
    }

    private void travel() {
        handler.getWorldManager().getWorld().setHeroSpawn((int)spawnX, (int)spawnY);
        handler.getWorldManager().setWorld(world);
    }

    public void render(Graphics g) {
        g.drawImage(animation.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), Tile.TILE_WIDTH*2, Tile.TILE_HEIGHT*2, null);
    }
  
    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int)(x+bounds.x+xOffset), (int)(y+bounds.y+yOffset), bounds.width, bounds.height);
    }
}
