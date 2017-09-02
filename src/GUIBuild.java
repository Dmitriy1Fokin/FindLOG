import javafx.application.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIBuild {
    JFrame theFrame;
    JPanel backgraund;
    Box backLeft, backRight;
    JTextField whatField, formatField, whereField;
    JRadioButton disk, web;
    JButton findButton;


    public void GUIStart(){

        theFrame = new JFrame("FindLog");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        backgraund = new JPanel(layout);
        backgraund.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        backLeft = new Box(BoxLayout.Y_AXIS);
        backLeft.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        whatField = new JTextField("Enter text to find",20);
        whatField.addMouseListener(clickListener);
        //whatField.addActionListener(new whatFieldListener());
        formatField = new JTextField("*.log",20);

        disk = new JRadioButton("find in PC", true);
        disk.setSelected(true);
        web = new JRadioButton("find in web");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(disk);
        radioGroup.add(web);

        whereField = new JTextField(20);

        backLeft.add(whatField);
        backLeft.add(formatField);
        backLeft.add(disk);
        backLeft.add(web);
        backLeft.add(whereField);

        findButton = new JButton("Find start");
        findButton.addActionListener(new findButtonListener());

        backgraund.add(BorderLayout.WEST, backLeft);
        backgraund.add(BorderLayout.EAST, findButton);


        theFrame.getContentPane().add(backgraund);
        theFrame.setBounds(50,50,400,300);//задать положение и размер
        theFrame.pack();
        theFrame.setVisible(true);

    }

    MouseListener clickListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent me) {
            ((JTextField) me.getSource()).selectAll();
        }
    };


    public class findButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            System.exit(1);

        }
    }

}
