package de.helferpfote.verlosung;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class Start extends JFrame {

    public static JButton button;
    public static JButton drawButton;
    public static JButton resetButton;
    public static JButton saveButton;
    public static JButton deleteButton;
    public static JTextField textField;
    public static JTextArea textArea;
    public static JTextPane drawTextArea;
    public static JPanel rightEndPanel;
    public static JPanel leftEndPanel;
    public static StyledDocument doc;
    public static JPanel leftPanel;

    public Start() {
        super("Verlosung");
        Font f = new Font("Calibri", Font.PLAIN, 20);
        StyleContext.NamedStyle centerStyle = StyleContext.getDefaultStyleContext().new NamedStyle();
        StyleConstants.setAlignment(centerStyle,StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontFamily(centerStyle, "Calibri");
        StyleConstants.setFontSize(centerStyle, 20);
        StyleConstants.setForeground(centerStyle, new Color(179,95,144));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel pageEndPanel = new JPanel();
        pageEndPanel.setLayout(new GridLayout(1,2));
        //JPanel centerPanel = new JPanel();
        //centerPanel.setLayout(new GridLayout(1,2));
        //Border padding = BorderFactory.createEmptyBorder(0,10,0,10);
        //centerPanel.setBorder(padding);
        rightEndPanel = new JPanel();
        rightEndPanel.setLayout(new GridLayout(1, 3));
        leftEndPanel = new JPanel();
        leftEndPanel.setLayout(new GridLayout(1,2));

        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());

        textField = new JTextField();
        textArea = new JTextArea();
        textArea.setText("");
        textArea.setFont(f);
        textArea.setEditable(false);
        textArea.setBackground(new Color(255,240,149));
        textArea.setForeground(new Color(179,95,144));
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        drawTextArea = new JTextPane();
        doc = drawTextArea.getStyledDocument();
        drawTextArea.setLogicalStyle(centerStyle);
        drawTextArea.setFont(f);
        drawTextArea.setEditable(false);
        drawTextArea.setBackground(new Color(173,249,255));
        JScrollPane scroll1 = new JScrollPane(drawTextArea);
        scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textField.setSize(100,100);

        Border line = new LineBorder(Color.BLACK, 1, true);
        Border margin = new EmptyBorder(5,15,5,15);
        Border compount = new CompoundBorder(line, margin);

        button = new JButton("add");
        button.addActionListener(new ButtonActions());
        button.setBackground(new Color(173,249,255));
        button.setForeground(new Color(179,95,144));
        button.setBorder(compount);
        button.setSize(100, 20);

        drawButton = new JButton("draw");
        drawButton.addActionListener(new ButtonActions());
        drawButton.setBackground(new Color(255,240,149));
        drawButton.setForeground(new Color(179,95,144));
        drawButton.setBorder(compount);
        drawButton.setSize(100, 20);

        resetButton = new JButton("reset");
        resetButton.addActionListener(new ButtonActions());
        resetButton.setBackground(new Color(255,240,149));
        resetButton.setForeground(new Color(179,95,144));
        resetButton.setBorder(compount);
        resetButton.setSize(100, 20);

        saveButton = new JButton("save");
        saveButton.addActionListener(new ButtonActions());
        saveButton.setBackground(new Color(255,240,149));
        saveButton.setForeground(new Color(179,95,144));
        saveButton.setBorder(compount);
        saveButton.setSize(100, 20);

        deleteButton = new JButton("delete");
        deleteButton.addActionListener(new ButtonActions());
        deleteButton.setBackground(new Color(173,249,255));
        deleteButton.setForeground(new Color(179,95,144));
        deleteButton.setBorder(compount);
        deleteButton.setSize(100, 20);




        pageEndPanel.add(leftEndPanel);
        pageEndPanel.add(rightEndPanel);

        leftEndPanel.add(button);
        leftEndPanel.add(deleteButton);
        rightEndPanel.add(drawButton);
        rightEndPanel.add(saveButton);
        rightEndPanel.add(resetButton);

        leftPanel.add(textField, BorderLayout.PAGE_START);
        leftPanel.add(scroll);

        //centerPanel.add(scroll);
        //centerPanel.add(scroll1);

        //panel.add(centerPanel);

        panel.add(leftPanel);
        panel.add(scroll1);

        JPanel l = new JPanel(new GridLayout(1,2));
        l.add(leftPanel);
        l.add(scroll1);

        panel.add(l);
        panel.add(pageEndPanel, BorderLayout.PAGE_END);
        //panel.add(button);
        //panel.add(rightEndPanel);



        //panel.add(pageEndPanel);

        this.add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1280,720);
        setVisible(true);



    }

}
