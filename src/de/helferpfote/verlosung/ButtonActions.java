package de.helferpfote.verlosung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActions implements ActionListener {

    public ButtonActions() {

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Start.button){
            Auslosung.teilnehmerHinzufuegen();
        }
        else if (e.getSource() == Start.drawButton){
            Auslosung.Ziehen();
        }
        else if(e.getSource() == Start.saveButton){
            Auslosung.save();
        }
        else if(e.getSource() == Start.resetButton){
            Auslosung.reset();
        }
        else if(e.getSource() == Start.deleteButton){
            Auslosung.delet();
        }
    }



}
