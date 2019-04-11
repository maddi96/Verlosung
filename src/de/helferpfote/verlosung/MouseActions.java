package de.helferpfote.verlosung;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActions implements MouseListener {

    public MouseActions(){
        Start.button.addMouseListener(this);
        Start.drawButton.addMouseListener(this);
        Start.saveButton.addMouseListener(this);
        Start.resetButton.addMouseListener(this);
        Start.deleteButton.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == Start.button) {
            Start.button.setBackground(Color.white);
        }
        if (e.getSource() == Start.drawButton) {
            Start.drawButton.setBackground(Color.white);
        }
        if (e.getSource() == Start.saveButton) {
            Start.saveButton.setBackground(Color.white);
        }
        if (e.getSource() == Start.resetButton) {
            Start.resetButton.setBackground(Color.white);
        }
        if (e.getSource() == Start.deleteButton) {
            Start.deleteButton.setBackground(Color.white);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == Start.button) {
            Start.button.setBackground(new Color(173,249,255));
        }
        if (e.getSource() == Start.drawButton) {
            Start.drawButton.setBackground(new Color(255,240,149));
        }
        if (e.getSource() == Start.saveButton) {
            Start.saveButton.setBackground(new Color(255,240,149));
        }
        if (e.getSource() == Start.resetButton) {
            Start.resetButton.setBackground(new Color(255,240,149));
        }
        if (e.getSource() == Start.deleteButton) {
            Start.deleteButton.setBackground(new Color(173,249,255));
        }

    }
}
