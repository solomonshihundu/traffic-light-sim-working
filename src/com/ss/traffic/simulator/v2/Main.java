package com.ss.traffic.simulator.v2;

import javax.swing.*;
import java.awt.*;

public class Main
{
    //Control Buttons
    private JButton startBtn = new JButton("start");
    private JButton pauseBtn = new JButton("pause");
    private JButton stopBtn = new JButton("stop");

    //Display current time
    static JLabel timeTxt = new JLabel();

    //Intersections labels
    private JLabel intersectionAColor = new JLabel();
    private JLabel intersectionBColor = new JLabel();
    private JLabel intersectionCColor = new JLabel();

    //Thread that runs GUI
    protected static Thread runGUI;

    //Stores initial traffic data
    Object[][] data = new Object[][]{
                                    {"Car 1", 0, 0, 0},
                                    {"Car 2", 0, 0, 0},
                                    {"Car 3", 0, 0, 0},
                                    };

    //Display data in JTable
    String [] tableCols = {"Car","X-pos","Y-pos","Speed km/h"};
    JTable trafficDataTable = new JTable(data,tableCols);

    //Displays all components
    Window window;


    public Main()  {
        window = new Window("TRAFFIC SIMULATOR");
        setupGUI();
    }

    private void setupGUI()
    {
        JLabel currentTime = new JLabel("Current Time");
        JLabel intersectionA = new JLabel("Intersection A :");
        JLabel intersectionB = new JLabel("Intersection B :");
        JLabel intersectionC = new JLabel("Intersection C :");

        trafficDataTable.setPreferredScrollableViewportSize(new Dimension(400,70));
        trafficDataTable.setFillsViewportHeight(true);

        JPanel dataPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(trafficDataTable);
        dataPanel.add(scrollPane);

        //GUI Layout
        GroupLayout layout = new GroupLayout(window.getContentPane());
        window.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addContainerGap(30, 30) //Container gap on left side
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(currentTime)
                                        .addComponent(timeTxt)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(startBtn)
                                        .addComponent(pauseBtn)
                                        .addComponent(stopBtn)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(intersectionA)
                                        .addComponent(intersectionAColor)
                                        .addContainerGap(20, 20)
                                        .addComponent(intersectionB)
                                        .addComponent(intersectionBColor)
                                        .addContainerGap(20, 20)
                                        .addComponent(intersectionC)
                                        .addComponent(intersectionCColor)
                                        .addComponent(dataPanel)))
                .addContainerGap(30, 30) //Container gap on right side

        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(currentTime)
                        .addComponent(timeTxt))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(startBtn)
                        .addComponent(pauseBtn)
                        .addComponent(stopBtn))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(intersectionA)
                        .addComponent(intersectionAColor)
                        .addComponent(intersectionB)
                        .addComponent(intersectionBColor)
                        .addComponent(intersectionC)
                        .addComponent(intersectionCColor))
                .addComponent(dataPanel)

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addGap(20, 20, 20))
                .addGap(20, 20, 20)
        );

        window.pack();

    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(()->new Main());
    }
}
