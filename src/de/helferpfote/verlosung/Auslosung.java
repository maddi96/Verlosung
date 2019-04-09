package de.helferpfote.verlosung;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Auslosung {

    public static ArrayList<String> teilnehmer;
    static ArrayList<String> str;
    static ArrayList<Integer> inte;
    static LinkedHashSet<String> set;
    static StringBuilder sb;
    static List<String> gewinner;
    static StringBuilder kette;
    static File file;

    public Auslosung() {
        teilnehmer = new ArrayList<String>();
        str = new ArrayList<String>();
        inte = new ArrayList<Integer>();
        set = new LinkedHashSet<>();
        sb = new StringBuilder();
        gewinner = new ArrayList<>();
        kette = new StringBuilder();
    }

    public static void Ziehen() {
        Start.drawTextArea.setText("");
        boolean winner = false;
        int count = 0;
        while (!winner) {
            String gewinnerString = "";
            int user = 0;
            if(teilnehmer.size() <= 0) {
                JOptionPane.showMessageDialog(null, "Keine Teilnehmer vorhanden!");
            } else {
                gewinnerString = teilnehmer.get(new Random().nextInt(teilnehmer.size()));
            }
            if(!gewinnerString.isEmpty()) {
                if (!gewinner.contains(gewinnerString)) {
                    gewinner.add(gewinnerString);
                    winner = true;
                }
            }
                count++;
                if (count >= teilnehmer.size()) {
                    break;
                }
        }
        System.out.println(gewinner);
        System.out.println(teilnehmer);
        kette.delete(0, Integer.MAX_VALUE);
        for(String a : gewinner) {
            kette.append(a + " hat gewonnen!! \n");
            Start.drawTextArea.setText("");
        }
        System.out.println(kette);
        Start.drawTextArea.setText(String.valueOf(kette));
    }

    public static void teilnehmerHinzufuegen() {
        Start.textArea.setText("");
        if(!Start.textField.getText().equals("")) {
            Auslosung.teilnehmer.add(Start.textField.getText().toLowerCase());
        }
        Iterator i = Auslosung.teilnehmer.iterator();
        int k = Auslosung.teilnehmer.size()-1;
        int j = 0;
        String strings = new String();
        while (i.hasNext()) {
            String next = i.next().toString();
            if(!str.contains(next) && j == k) {
                str.add(next);
                inte.add(0);
            } else if(str.contains(next) && !(Start.textField.getText().equals("")) && j == k) {
                inte.set(str.indexOf(next), inte.get(str.indexOf(next)) + 1);
            }
            if(j == k) {
                for(int x = 0; x < str.size(); x++) {
                    strings = (str.get(str.indexOf(next)));
                }
                set.add(strings);
                sb.delete(0, Integer.MAX_VALUE);
                System.out.println(set);
                for(String a : set) {
                    sb.append(a + " +" + inte.get(indexOf(a))  + "\n");
                    System.out.println(sb);
                }
            }
            j++;
        }
        Start.textField.setText("");
        Start.textArea.append(String.valueOf(sb));
    }

    public static int indexOf(String value) {
        int count = 0;
        for(String a : set) {
            if(a.equals(value)) return count;
            count++;
        }
        return -1;
    }

    public static void reset(){
        Start.textField.setText("");
        Start.textArea.setText("");
        Start.drawTextArea.setText("");
        str.clear();
        inte.clear();
        sb.delete(0, Integer.MAX_VALUE);
        set.clear();
        teilnehmer.clear();
        Start.drawTextArea.setText("");
        kette.delete(0, Integer.MAX_VALUE);
        gewinner.clear();
        createFile();
    }

    public static void createFile() {
        File theDir = new File("Gewinnspiele");

        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
            boolean result = false;

            try{
                theDir.mkdir();
                result = true;
            }
            catch(SecurityException se){
                //handle it
            }
            if(result) {
                System.out.println("DIR created");
            }
        }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy_HH:mm:ss");
        String fileName = "Gewinnspiele/gs" + date.format((cal.getTime())) + ".txt";
        file = new File(fileName);
        try {
            if(file.createNewFile()) {
                System.out.println(fileName + " was created!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
