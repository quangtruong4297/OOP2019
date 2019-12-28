package tilegame.entities.creatures;

import tilegame.Handler;

import java.util.ArrayList;

public class ListMonsters {
    private Handler handler;
    private ArrayList<Monster> monstersMap1;
    private ArrayList<Monster> monstersMap2;
    private ArrayList<Monster> monstersMap3;

    public ListMonsters(Handler handler){
        this.handler = handler;
        setMonstersMap1();
        setMonstersMap2();
        setMonstersMap3();
    }

    private void setMonstersMap1(){
        monstersMap1 = new ArrayList<>();

        monstersMap1.add(new Diablo(handler, 12 <<6,  6 <<6, 17 <<6,  6 <<6));
        monstersMap1.add(new Monster(handler, 15 <<6,  3 <<6, 21 <<6,  3 <<6));
        monstersMap1.add(new Monster(handler, 26 <<6,  3 <<6, 32 <<6,  3 <<6));
        monstersMap1.add(new Monster(handler, 16 <<6, 14 <<6, 16 <<6,  8 <<6));
        monstersMap1.add(new Monster(handler, 31 <<6, 16 <<6, 31 <<6, 13 <<6));
        monstersMap1.add(new Monster(handler, 31 <<6, 17 <<6, 37 <<6, 17 <<6));
        monstersMap1.add(new Monster(handler, 25 <<6, 23 <<6, 31 <<6, 23 <<6));
        monstersMap1.add(new Monster(handler, 16 <<6, 23 <<6, 16 <<6, 14 <<6));
    }

    private void setMonstersMap2() {
        monstersMap2 = new ArrayList<>();

        monstersMap2.add(new Monster(handler, 13 <<6, 26 <<6, 19 <<6, 26 <<6));
        monstersMap2.add(new Monster(handler, 17 <<6, 14 <<6, 19 <<6, 14 <<6));
        monstersMap2.add(new Monster(handler, 512, 1472, 704, 1472));
        monstersMap2.add(new Diablo(handler, 424, 482, 500, 482));
        monstersMap2.add(new Monster(handler, 1562, 1316, 1562, 1040));
    }

    private void setMonstersMap3() {
        monstersMap3 = new ArrayList<>();

        monstersMap3.add(new Monster(handler, 21 <<6, 8 <<6, 21<<6, 2<<6));
        monstersMap3.add(new Monster(handler, 20 <<6, 18 <<6, 20 <<6, 12 <<6));
        monstersMap3.add(new Monster(handler, 11 <<6, 20 <<6, 17 <<6, 20 <<6));
        monstersMap3.add(new Diablo(handler, 11 <<6, 4 <<6, 11 <<6, 9 <<6));

    }

    public ArrayList<Monster> getMonstersMap1() {
        return monstersMap1;
    }

    public ArrayList<Monster> getMonstersMap2() {
        return monstersMap2;
    }

    public ArrayList<Monster> getMonstersMap3() {
        return monstersMap3;
    }
}
