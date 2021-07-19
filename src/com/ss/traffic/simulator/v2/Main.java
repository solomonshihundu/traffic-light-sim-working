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
    Object[][] data = new Object[][]{{},{}};

    //Display data in JTable
    String [] tableCols = {"Car","X-pos","Y-pos","Speed km/h"};
    JTable trafficDataTable = new JTable(data,tableCols);

    //Displays all components
    Window window = new Window("TRAFFIC SIMULATOR");


    public Main()  {

    }

    private void setupGUI()
    {
        JLabel currentTime = new JLabel("Current Time");
        JLabel intesectionA = new JLabel("Intersection A :");
        JLabel intesectionB = new JLabel("Intersection B :");
        JLabel intesectionC = new JLabel("Intersection C :");

        trafficDataTable.setPreferredScrollableViewportSize(new Dimension(400,70));
        trafficDataTable.setFillsViewportHeight(true);

        JPanel dataPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(trafficDataTable);
        dataPanel.add(scrollPane);
    }

    public static void main(String args[])
    {
        Main simulator = new Main();
    }
}
