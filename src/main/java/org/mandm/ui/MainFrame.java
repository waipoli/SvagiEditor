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
        configureFrame();
        configureUIManager();
        configureMenuBar();
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void configureFrame() {
        this.setSize(1000, 1000);
        this.setTitle("Svagi Editor");
        this.getContentPane().setBackground(new Color(0x252424));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void configureUIManager() {
        UIManager.put("MenuItem.background", new Color(0x212121));
        UIManager.put("MenuItem.selectionBackground", new Color(0x323232));
        UIManager.put("MenuItem.foreground", new Color(0xFDC96A));
        UIManager.put("MenuItem.selectionForeground", new Color(0xFDC96A));
        UIManager.put("MenuItem.border",BorderFactory.createEmptyBorder());

        UIManager.put("PopupMenu.background", new Color(0x212121));
        UIManager.put("Menu.selectionBackground", new Color(0x323232));
        UIManager.put("Menu.foreground", new Color(0xFDC96A));
        UIManager.put("Menu.selectionForeground", new Color(0xFDC96A));
        UIManager.put("PopupMenu.border",BorderFactory.createEmptyBorder());
        UIManager.put("Menu.border",BorderFactory.createEmptyBorder());


        UIManager.put("MenuBar.background", new Color(0x212121));
        UIManager.put("MenuBar.border",BorderFactory.createEmptyBorder());


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
                );
        this.setJMenuBar(tree.build());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }


}
