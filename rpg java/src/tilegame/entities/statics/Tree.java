package tilegame.entities.statics;

import tilegame.Handler;
import tilegame.gfx.Assets;
import tilegame.items.Item;
import tilegame.tiles.Tile;

import java.awt.*;


public class Tree extends StaticEntity{


    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT*2);

        bounds.x = width/4;
        bounds.y = height/3*2;
        bounds.width = width/2;
        bounds.height = height/7*2;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    public void die() {
        handler.getWorldManager().getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x, (int)y + height/2, 5));
    }

}
