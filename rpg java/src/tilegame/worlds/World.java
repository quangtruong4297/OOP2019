package tilegame.worlds;

import tilegame.Handler;
import tilegame.entities.EntityManager;
import tilegame.entities.creatures.Hero;
import tilegame.entities.creatures.Monster;
import tilegame.items.ItemManager;
import tilegame.portals.PortalManager;
import tilegame.tiles.Tile;
import tilegame.utils.Utils;

import java.awt.*;
import java.util.ArrayList;


public abstract class World {

    protected Handler handler;
    protected int width, height, spawnX, spawnY;
    protected int[][] tiles;
    protected Hero hero;
    protected ArrayList<Monster> monsters;
    //ENTITIES
    protected EntityManager entityManager;
    //ITEMS
    protected ItemManager itemManager;
    //PORTALs
    protected PortalManager portalManager;

    public World(Handler handler, String path, Hero hero, ArrayList<Monster> monsters) {
        this.hero = hero;
        this.monsters = monsters;
        this.handler = handler;
        entityManager = new EntityManager(handler, hero, monsters);
        itemManager = new ItemManager(handler);
        portalManager = new PortalManager();

        loadWorld(path);
    }

    public abstract void createEntity();
    public abstract void createPortal();

    public void setHeroSpawn() {
        hero.setX(spawnX * Tile.TILE_WIDTH);
        hero.setY(spawnY * Tile.TILE_HEIGHT);
    }

    public void setHeroSpawn(int x, int y) {
        hero.setX(x);
        hero.setY(y);
    }

    public void tick() {
        itemManager.tick();
        entityManager.tick();
        portalManager.tick();
    }

    public void render(Graphics g) {
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH),
            xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1),
            yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT),
            yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

        for(int y = yStart; y < yEnd; ++y) {
            for(int x = xStart; x < xEnd; ++x){
                getTile(x, y).render(g, (int)(x*Tile.TILE_WIDTH- handler.getGameCamera().getxOffset()),
                                        (int)(y*Tile.TILE_HEIGHT- handler.getGameCamera().getyOffset()));
            }
        }
        //PORTALS
        portalManager.render(g);
        //ITEMS
        itemManager.render(g);
        //ENTITIES
        entityManager.render(g);
    }

    public Tile getTile(int x, int y) {
        if(x < 0 || y < 0 || x >= width || y >=height)
            return Tile.waterTile_4;

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null) {
            return Tile.tiles[1];
        }
        return t;
    }

    protected void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");

        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);

        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0; y < height; ++y) {
            for(int x = 0; x < width; ++x) {
                tiles[x][y] = Utils.parseInt(tokens[(x+y*width) + 4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }
}
