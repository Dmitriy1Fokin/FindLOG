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
        //whatField.addMouseListener(whatFieldListener);
        formatField = new JTextField("*.log",20);


        disk = new JRadioButton("find in PC", true);
        disk.addActionListener(new diskListener());
        disk.setSelected(true);
        web = new JRadioButton("find in web");
        web.addActionListener(new webListener());
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(disk);
        radioGroup.add(web);

        whereField = new JTextField("Click here to choose a folder",20);
        whereField.addMouseListener(whereFieldListener);

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

    MouseListener whatFieldListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent me) {
            System.out.println(me.getButton());
            if((me.getButton() == 1) || (whatField.getText() == "Enter text to find")){
                ((JTextField) me.getSource()).selectAll();

            }
        }
    };

    MouseListener whereFieldListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (disk.isSelected()){
                whereField.setText("1");
            }
            if (web.isSelected()){
                whereField.setText("2");
            }
        }
    };


    public class findButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            System.exit(1);

        }
    }

    public class diskListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            whereField.setText("Click here to choose a folder");
        }
    }

    public class webListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            whereField.setText("Click here to choose a web");
        }
    }

}
