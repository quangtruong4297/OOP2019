package tilegame.tiles;

import tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static Tile waterTile_0 = new WaterTile(0);
    public static Tile waterTile_1 = new WaterTile(1);
    public static Tile waterTile_2 = new WaterTile(2);
    public static Tile waterTile_3 = new WaterTile(3);
    public static Tile waterTile_4 = new WaterTile(4);
    public static Tile waterTile_5 = new WaterTile(5);
    public static Tile waterTile_6 = new WaterTile(6);
    public static Tile waterTile_7 = new WaterTile(7);
    public static Tile waterTile_8 = new WaterTile(8);
    public static Tile waterTile_9 = new WaterTile(9);
    public static Tile waterTile_10 = new WaterTile(10);
    public static Tile waterTile_11 = new WaterTile(11);
    public static Tile waterTile_12 = new WaterTile(12);

    public static Tile landTile_13 = new LandTile(13);
    public static Tile landTile_14 = new LandTile(14);
    public static Tile landTile_15 = new LandTile(15);
    public static Tile landTile_16 = new LandTile(16);
    public static Tile landTile_17 = new LandTile(17);
    public static Tile landTile_18 = new LandTile(18);
    public static Tile landTile_19 = new LandTile(19);


    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(int id) {
        this.id = id;
        this.texture = Assets.tiles[id];
        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {

        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }
}
