package tilegame.gfx;

import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.tiles.Tile;


public class GameCamera {

    private Handler handler;
    private float xOffset, yOffset;

    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlankSpace() {
        if(xOffset < 0) {
            xOffset = 0;
        }else if(xOffset > handler.getWorldManager().getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth()) {
            xOffset = handler.getWorldManager().getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
        }
        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset > handler.getWorldManager().getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()){
            yOffset = handler.getWorldManager().getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
        }
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
        yOffset = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
        checkBlankSpace();

    }


    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

}
