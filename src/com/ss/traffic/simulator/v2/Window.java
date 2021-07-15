package com.ss.traffic.simulator.v2;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    public Window(String title) throws HeadlessException {
        super(title);
        setLocationRelativeTo(null);
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
