package de.helferpfote.verlosung;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

class Auslosung {

    private static ArrayList<String> teilnehmer;
    private static ArrayList<String> str;
    private static ArrayList<Integer> inte;
    private static LinkedHashSet<String> set;
    private static StringBuilder sb;
    private static ArrayList<String> gewinner;
    private static StringBuilder kette;
    private static File file;
    private static BufferedWriter writer;


    Auslosung() {
        teilnehmer = new ArrayList<>();
        str = new ArrayList<>();
        inte = new ArrayList<>();
        set = new LinkedHashSet<>();
        sb = new StringBuilder();
        gewinner = new ArrayList<>();
        kette = new StringBuilder();
    }

    static void Ziehen() {
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
            kette.append(a).append(" hat gewonnen!! \n");
            Start.drawTextArea.setText("");
        }
        System.out.println(kette);
        Start.drawTextArea.setText(String.valueOf(kette));
    }

    static void teilnehmerHinzufuegen() {
        Start.textArea.setText("");
        String[] teilnehmerListe = Start.textField.getText().split(",");

        str.clear();
        inte.clear();
        set.clear();

        for(String s : teilnehmerListe) {
            s = s.replaceAll("\\s+", "");
            if (!s.equals("")) {
                Auslosung.teilnehmer.add(s.toLowerCase());
            }
        }
            Iterator i = Auslosung.teilnehmer.iterator();
            int k = Auslosung.teilnehmer.size() - 1;
            int j = 0;
            String strings = "";
            while (i.hasNext()) {
                String next = i.next().toString();
                if (!str.contains(next)) {
                    str.add(next);
                    inte.add(0);
                } else if (str.contains(next)) {
                    inte.set(str.indexOf(next), inte.get(str.indexOf(next)) + 1);
                }
                    for (int x = 0; x < str.size(); x++) {
                        strings = (str.get(str.indexOf(next)));
                    }
                    set.add(strings);
                    sb.delete(0, Integer.MAX_VALUE);
                    System.out.println(set);
                    for (String a : set) {
                        sb.append(a).append(" +").append(inte.get(indexOf(a))).append("\n");
                        System.out.println(sb);
                    }
                j++;
            }
        Start.textField.setText("");
            if(Auslosung.teilnehmer.size() != 0) {
                Start.textArea.append(String.valueOf(sb));
            } else {
                Start.textArea.setText("");
            }
        }


    private static int indexOf(String value) {
        int count = 0;
        for(String a : set) {
            if(a.equals(value)) return count;
            count++;
        }
        return -1;
    }

    static void save() {
        try {
            createFile();
            writer = new BufferedWriter(new FileWriter(file));
            writeToFile("Teilnehmer", teilnehmer);
            writeToFile("Gewinner", gewinner);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } JOptionPane.showMessageDialog(null, "Daten gespeichert!");
    }

    static void reset(){

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
    }

    static void delet() {
        if(teilnehmer.size() == 0) {
            JOptionPane.showMessageDialog(null, "Keine Teilnehmer vorhanden!");
        } else {
            String eingabe = JOptionPane.showInputDialog(null, "Geben Sie den Teilnehmernamen ein der gelöscht werden soll!").toLowerCase();
            if(teilnehmer.contains(eingabe)) {
                teilnehmer.remove(teilnehmer.indexOf(eingabe));
            }
            System.out.println(teilnehmer);
            teilnehmerHinzufuegen();
        }
    }

    private static void createFile() {
        File theDir = new File("Gewinnspiele");
        if (!theDir.exists()) {
            System.out.println("creating directory: " + theDir.getName());
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

    private static void writeToFile(String typ, ArrayList<String> listOfStrings) {
        try {

            writer.append(typ).append(":\n");
            writer.append("\n");

            for(String s : listOfStrings) {
                writer.append(s).append("\n");
            }

            writer.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
