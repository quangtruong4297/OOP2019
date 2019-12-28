package tilegame.worlds;

import tilegame.Handler;
import tilegame.entities.creatures.Hero;
import tilegame.entities.creatures.Monster;
import tilegame.entities.statics.Mount;
import tilegame.entities.statics.Tree;
import tilegame.portals.Portal;
import tilegame.tiles.Tile;

import java.util.ArrayList;


public class World2 extends World{

    int[][] treeLoc = {
            {3, 1},{4, 1},{8, 1},{12, 1},{13, 1},{15, 1},{16, 1},{17, 1},{20, 1},{21, 1},{22, 1},{24, 1},{25, 1},{29, 1},{30, 1},{2, 2},{3, 2},{4, 2},{8, 2},{12, 2},{17, 2},{20, 2},{25, 2},{29, 2},{30, 2},{31, 2},{1, 3},{2, 3},{11, 3},{17, 3},{18, 3},{19, 3},{25, 3},{26, 3},{27, 3},{28, 3},{30, 3},{31, 3},{32, 3},{1, 4},{10, 4},{17, 4},{18, 4},{19, 4},{25, 4},{26, 4},{31, 4},{32, 4},{8, 5},{9, 5},{10, 5},{18, 5},{24, 5},{25, 5},{31, 5},{32, 5},{1, 6},{7, 6},{10, 6},{11, 6},{18, 6},{23, 6},{24, 6},{30, 6},{31, 6},{32, 6},{6, 7},{11, 7},{18, 7},{29, 7},{30, 7},{32, 7},{5, 8},{2, 9},{3, 9},{14, 9},{15, 9},{21, 9},{1, 10},{5, 10},{32, 10},{1, 11},{5, 11},{9, 11},{23, 11},{30, 11},{31, 11},{32, 11},{1, 12},{29, 12},{30, 12},{1, 13},{2, 13},{28, 13},{29, 13},{30, 13},{1, 14},{2, 14},{3, 14},{4, 14},{26, 14},{27, 14},{29, 14},{30, 14},{31, 14},{32, 14},{4, 15},{25, 15},{31, 15},{32, 15},{32, 16},{3, 17},{4, 17},{1, 18},{2, 18},{15, 18},{16, 18},{1, 19},{19, 19},{20, 19},{21, 19},{22, 19},{1, 20},{12, 20},{13, 20},{15, 20},{17, 20},{21, 20},{22, 20},{23, 20},{29, 20},{30, 20},{32, 20},{3, 21},{11, 21},{12, 21},{13, 21},{14, 21},{15, 21},{22, 21},{23, 21},{28, 21},{30, 21},{31, 21},{3, 22},{4, 22},{23, 22},{25, 22},{26, 22},{2, 23},{4, 23},{5, 23},{12, 23},{23, 23},{31, 23},{1, 24},{11, 24},{12, 24},{22, 24},{31, 24},{1, 25},{2, 25},{5, 25},{6, 25},{10, 25},{31, 25},{32, 25},{1, 26},{2, 26},{6, 26},{7, 26},{20, 26},{24, 26},{26, 26},{30, 26},{31, 26},{32, 26},{2, 27},{3, 27},{5, 27},{6, 27},{12, 27},{16, 27},{17, 27},{18, 27},{21, 27},{25, 27},{26, 27},{27, 27},{28, 27},{29, 27},{30, 27},{31, 27},{4, 28},{8, 28},{12, 28},{13, 28},{14, 28},{15, 28},{16, 28},{17, 28},{18, 28},{21, 28},{22, 28},{23, 28},{24, 28},{25, 28},{26, 28},{27, 28},{28, 28},{29, 28},{30, 28}
    };

    int[][] mountLoc = {
            {9, 1},{10, 1},{18, 1},{26, 1},{27, 1},{9, 2},{8, 3},{31, 12},{1, 15},{2, 15},{1, 16},{10, 26},{9, 27},{10, 27},{19, 27}
    };

    public World2(Handler handler, String path, Hero hero, ArrayList<Monster> monsters) {
        super(handler, path, hero, monsters);
        loadWorld(path);
        createEntity();
    }

    @Override
    public void createPortal() {
        //world 1
        portalManager.addPortal(new Portal(handler, Tile.TILE_WIDTH * 20, Tile.TILE_HEIGHT * 3, Tile.TILE_WIDTH * 20, Tile.TILE_HEIGHT * 25, handler.getWorldManager().getWorlds().get(0)));
        //world 3
        portalManager.addPortal(new Portal(handler, Tile.TILE_WIDTH * 2, Tile.TILE_HEIGHT * 24, Tile.TILE_WIDTH * 16, Tile.TILE_HEIGHT * 19, handler.getWorldManager().getWorlds().get(2)));
    }

    @Override
    public void createEntity() {
        for(int[] i : treeLoc) {
            entityManager.addEntity(new Tree(handler, Tile.TILE_WIDTH * i[0], Tile.TILE_HEIGHT * (i[1] - 1) ));
        }

        for(int[] i : mountLoc) {
            entityManager.addEntity(new Mount(handler, Tile.TILE_WIDTH * i[0], Tile.TILE_HEIGHT * i[1] ) );
        }
    }

}
