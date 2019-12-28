package tilegame.tiles;


public class WaterTile extends Tile{
    public WaterTile(int id) {
        super(id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
