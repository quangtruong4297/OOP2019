package tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener{
    public boolean pressedAnyKey;
    private boolean[] keys, justPressed, cantPress;
    public boolean up, down, left, right, attack, collect, travel, skillShot, exitgame,swapskill;

    public KeyManager() {
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
    }

    public boolean keyJustPressed(int keyCode){
        if(keyCode > -1 && keyCode < 255)
            return justPressed[keyCode];
        return false;
    }

    public void tick() {
        for(int i = 0; i < keys.length; ++i) {
            if(cantPress[i] && !keys[i]) {
                cantPress[i] = false;
            }else if(justPressed[i]) {
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if(!cantPress[i] && keys[i]){
                justPressed[i] = true;
            }
        }
        swapskill = keys[KeyEvent.VK_W];
        exitgame = keys[KeyEvent.VK_E];
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        attack = keys[KeyEvent.VK_X];
        travel = keys[KeyEvent.VK_Z];
        skillShot = keys[KeyEvent.VK_C];
        collect = keys[KeyEvent.VK_B];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedAnyKey = true;
        if(e.getKeyCode() > -1 && e.getKeyCode() < 255)
            keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedAnyKey = false;
        if(e.getKeyCode() > -1 && e.getKeyCode() < 255)
            keys[e.getKeyCode()] = false;

    }
}
