package org.mandm.ui;


import org.mandm.ui.menu.MenuItem;
import org.mandm.ui.menu.MenuTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    MenuTree tree;

    public MainFrame() {
        configureUIManager();
        configureFrame();
        configureMenuBar();
        SwingUtilities.updateComponentTreeUI(this);

    }

    private void configureFrame() {
        this.setSize(1000, 1000);
        this.setTitle("Svagi Editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void configureUIManager() {
        UIManager.put("MenuItem.selectionBackground", Color.RED);
    }

    private void configureMenuBar() {
        tree = new MenuTree();
        tree.root
                .add(new MenuItem("File")
                        .add(new MenuItem("New")
                                .add("Project"))
                        .add("Open")
                        .add("Open Recent")
                        .add("Close Project")
                )
                .add(new MenuItem("Edit")
                        .add("1"))
                .add(new MenuItem("View")
                        .add("1"))
                .add(new MenuItem("Code")
                        .add("1"))
                .add(new MenuItem("Refactor")
                        .add("1"))
                .add(new MenuItem("Help")
                        .add("1"));
        this.setJMenuBar(tree.build());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }


}
