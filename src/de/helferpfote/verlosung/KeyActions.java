package de.helferpfote.verlosung;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyActions implements KeyListener {

    public KeyActions() {
        Start.textField.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_ENTER) {
            Auslosung.teilnehmerHinzufuegen();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
