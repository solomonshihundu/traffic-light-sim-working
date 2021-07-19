package com.ss.traffic.simulator.v2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main
{
    //Control Buttons
    private JButton startBtn = new JButton("START");
    private JButton pauseBtn = new JButton("PAUSE");
    private JButton stopBtn = new JButton("STOP");

    //Display current time
    public static JLabel timeTxt = new JLabel();

    private static boolean isRunning;
    private static final AtomicBoolean simIsRunning = new AtomicBoolean(false);

    //Intersections labels
    private JLabel intersectionAColor = new JLabel();
    private JLabel intersectionBColor = new JLabel();
    private JLabel intersectionCColor = new JLabel();

    /**
     * Three car objects running a thread each
     */
    Car car1 = new Car("Car1Thread", 200, 0);
    Car car2 = new Car("Car2Thread", 1000, 0);
    Car car3 = new Car("Car3Thread", 2000, 1000);

    /**
     * Array to loop through all the cars
     */
    Car[] carArray = {car1, car2, car3};

    //Stores initial traffic data
    private Object[][] data = new Object[][]{
                                    {"Car 1", car1.getPosition(), 0, 0},
                                    {"Car 2", car2.getPosition(), 0, 0},
                                    {"Car 3", car3.getPosition(), 0, 0},
                                    };

    //Display data in JTable
    private String [] tableCols = {"Car","X-pos","Y-pos","Speed km/h"};
    private JTable trafficDataTable = new JTable(data,tableCols);

    //Displays all components
    private Window window;


    public Main()  {
        window = new Window("TRAFFIC SIMULATOR");
        setupGUI();
        onClick();
    }

    private void setupGUI()
    {
        startBtn.setBackground(new Color(48,57,135));
        startBtn.setForeground(new Color(255,178,127));
        startBtn.setSize(120,40);

        pauseBtn.setBackground(new Color(48,57,135));
        pauseBtn.setForeground(new Color(255,178,127));
        pauseBtn.setSize(120,40);

        stopBtn.setBackground(new Color(48,57,135));
        stopBtn.setForeground(new Color(255,178,127));
        stopBtn.setSize(120,40);


        JLabel currentTime = new JLabel("Current Time : ");
        JLabel intersectionA = new JLabel("Intersection A : ");
        JLabel intersectionB = new JLabel("Intersection B : ");
        JLabel intersectionC = new JLabel("Intersection C : ");

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
                .addContainerGap(60, 60) //Container gap on left side
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
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
                                        .addContainerGap(40, 40)
                                        .addComponent(intersectionB)
                                        .addComponent(intersectionBColor)
                                        .addContainerGap(40, 40)
                                        .addComponent(intersectionC)
                                        .addComponent(intersectionCColor))
                                        .addComponent(dataPanel)))
                .addContainerGap(60, 60) //Container gap on right side

        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
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

    private void onClick()
    {
        startBtn.addActionListener((ActionEvent e) ->
        {
            if(!simIsRunning.get())
            {
                car1.start();
                car2.start();
                car3.start();
            }

            simIsRunning.set(true);
        });
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(()->new Main());

        Thread clock = new Thread(new CurrentTime());
        clock.start();
    }
}
