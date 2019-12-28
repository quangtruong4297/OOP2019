package tilegame.worlds;

import tilegame.Handler;
import tilegame.entities.creatures.Hero;
import tilegame.entities.creatures.Monster;
import tilegame.entities.statics.Mount;
import tilegame.entities.statics.Tree;
import tilegame.portals.Portal;
import tilegame.tiles.Tile;

import java.util.ArrayList;


public class World3 extends World {

    int[][] treeLoc = {
            {10, 1},{11, 1},{12, 1},{18, 1},{19, 1},{11, 2},{12, 2},{18, 2},{19, 2},{20, 2},{22, 2},{12, 3},{18, 3},{19, 3},{20, 3},{22, 3},{13, 4},{18, 4},{13, 5},{18, 5},{23, 5},{13, 6},{17, 6},{23, 6},{7, 7},{9, 7},{13, 7},{17, 7},{22, 7},{23, 7},{6, 8},{17, 8},{23, 8},{9, 9},{14, 9},{16, 9},{17, 9},{14, 10},{16, 10},{23, 10},{11, 11},{14, 11},{15, 11},{22, 11},{23, 11},{4, 12},{23, 12},{9, 14},{4, 15},{9, 15},{17, 16},{22, 16},{23, 16},{17, 17},{18, 17},{2, 18},{7, 18},{8, 18},{7, 19},{9, 19},{13, 19},{14, 19},{15, 19},{1, 20},{2, 20},{1, 21},{2, 21},{7, 21},{8, 21},{9, 21},{10, 21},{11, 21},{12, 21},{13, 21},{14, 21},{15, 21},{16, 21},{17, 21},{18, 21},{19, 21},{23, 21}
    };

    int[][] mountLoc = {
            {13, 1},{15, 1},{16, 1},{13, 2},{14, 2},{16, 2},{14, 3},{15, 3},{16, 3},{14, 4},{15, 4},{16, 4},{14, 5},{15, 5},{14, 6},{14, 7},{15, 7}
    };

    public World3(Handler handler, String path, Hero hero, ArrayList<Monster> monsters) {
        super(handler, path, hero, monsters);
        loadWorld(path);
        createEntity();
    }

    public void createPortal() {
        //world 1
        portalManager.addPortal(new Portal(handler, Tile.TILE_WIDTH * 19, Tile.TILE_HEIGHT * 4, Tile.TILE_WIDTH * 36, Tile.TILE_HEIGHT * 7, handler.getWorldManager().getWorlds().get(0)));
        //world 2
        portalManager.addPortal(new Portal(handler, Tile.TILE_WIDTH * 16, Tile.TILE_HEIGHT * 19, Tile.TILE_WIDTH * 2, Tile.TILE_HEIGHT * 24, handler.getWorldManager().getWorlds().get(1)));

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
