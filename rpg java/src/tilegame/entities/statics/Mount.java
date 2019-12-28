package tilegame.entities.statics;

import tilegame.Handler;
import tilegame.gfx.Assets;
import tilegame.items.Item;
import tilegame.tiles.Tile;

import java.awt.*;

public class Mount extends  StaticEntity {

    public Mount(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH * 2, Tile.TILE_HEIGHT * 2);

        bounds.x = 0;
        bounds.y = height/2;
        bounds.width = width;
        bounds.height = height/3;

        health = 10;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.mount, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    public void die() {
        handler.getWorldManager().getWorld().getItemManager().addItem(Item.stoneItem.createNew((int)x, (int)y+Tile.TILE_HEIGHT, 4));
        handler.getWorldManager().getWorld().getItemManager().addItem(Item.stoneItem.createNew((int)x+Tile.TILE_WIDTH, (int)y+Tile.TILE_HEIGHT, 4));
    }
}
