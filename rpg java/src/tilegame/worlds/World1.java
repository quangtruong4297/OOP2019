package tilegame.worlds;

import tilegame.Handler;
import tilegame.entities.creatures.Hero;
import tilegame.entities.creatures.Monster;
import tilegame.entities.statics.Mount;
import tilegame.entities.statics.Tree;
import tilegame.portals.Portal;
import tilegame.tiles.Tile;

import java.util.ArrayList;


public class World1 extends World {

    int[][] treeLoc = {
            {24, 2},{8, 3},{11, 3},{24, 3},{6, 4},{7, 4},{8, 4},{24, 4},{27, 4},{8, 5},{21, 5},{24, 5},{27, 5},{8, 6},{21, 6},{27, 6},{8, 7},{19, 7},{21, 7},{27, 7},{28, 7},{29, 7},{6, 8},{7, 8},{8, 8},{11, 8},{38, 8},{39, 8},{11, 9},{12, 9},{33, 9},{37, 9},{38, 9},{39, 9},{6, 10},{11, 10},{14, 10},{20, 10},{21, 10},{34, 10},{35, 10},{36, 10},{6, 11},{18, 11},{19, 11},{20, 11},{21, 11},{34, 11},{35, 11},{36, 11},{40, 11},{35, 12},{36, 12},{37, 12},{38, 12},{39, 12},{40, 12},{24, 13},{25, 13},{26, 13},{27, 13},{8, 16},{22, 16},{23, 16},{6, 17},{8, 17},{9, 17},{10, 17},{14, 17},{10, 18},{11, 18},{37, 18},{38, 18},{21, 19},{36, 19},{37, 19},{38, 19},{39, 19},{15, 20},{25, 20},{35, 20},{36, 20},{37, 20},{38, 20},{39, 20},{40, 20},{36, 21},{39, 21},{40, 21},{41, 21},{21, 22},{28, 22},{29, 22},{30, 22},{33, 22},{36, 22},{39, 22},{40, 22},{41, 22},{21, 23},{35, 23},{36, 23},{37, 23},{38, 23},{39, 23},{40, 23},{41, 23},{15, 24},{16, 24},{19, 24},{20, 24},{21, 24},{24, 24},{24, 25},{25, 25},{21, 26},{24, 26},{25, 26},{16, 27},{17, 27},{24, 27},{25, 27},{26, 27},{27, 27},{33, 27}
    };

    int[][] mountLoc = {
            {34, 8},{27, 9},{28, 9},{29, 9},{22, 10},{22, 11},{17, 12},{19, 12},{20, 12},{21, 12},{8, 13},{10, 13},{11, 13},{17, 13},{18, 13},{20, 13},{9, 14},{11, 14},{9, 15},{10, 15},{11, 16},{12, 17},{17, 17},{28, 17},{29, 17},{17, 18},{27, 18},{28, 18},{17, 19},{18, 19},{19, 19},{26, 19},{28, 19},{34, 21},{31, 26}
    };

    public World1(Handler handler, String path, Hero hero, ArrayList<Monster> monsters) {
        super(handler, path, hero, monsters);
        loadWorld(path);
        createEntity();
    }

    public void createPortal() {
        //world 2
        portalManager.addPortal(new Portal(handler, Tile.TILE_WIDTH * 20, Tile.TILE_HEIGHT * 25, Tile.TILE_WIDTH * 20, Tile.TILE_HEIGHT * 3, handler.getWorldManager().getWorlds().get(1)));
        //world 3
        portalManager.addPortal(new Portal(handler, Tile.TILE_WIDTH * 36, Tile.TILE_HEIGHT * 7, Tile.TILE_WIDTH * 19, Tile.TILE_HEIGHT * 4, handler.getWorldManager().getWorlds().get(2)));

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
