package org.mandm.ui;


import org.mandm.helpers.casters.Caster;
import org.mandm.helpers.factory.FabricUIValues;
import org.mandm.helpers.loaders.YAMLLoader;
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
        var data = YAMLLoader.load("src/main/resources/Theme.yaml");
        for (var chapter : data.keySet()) {
            var settingsList = Caster.fromObjectToMap(data.get(chapter));
            for (var settingsName : settingsList.keySet()) {
                String nameOfSettings = chapter + "." + settingsName;
                String valueOfSettings = (String) settingsList.get(settingsName);
                UIManager.put(nameOfSettings, FabricUIValues.creteUIObject((String) settingsName, valueOfSettings));
            }
        }
    }

    private void configureMenuBar() {
        tree = new MenuTree();
        tree.root
                .add(new MenuItem("File")
                        .add(new MenuItem("New")
                                .add("Project"))
                        .add("Open")
                        .add("Open Recent")
                        .add("Exit")
                );
        this.setJMenuBar(tree.build());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }


}
