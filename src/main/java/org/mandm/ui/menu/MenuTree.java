package org.mandm.ui.menu;


import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MenuTree {

    public MenuItem root;

    public MenuTree() {
        root = new MenuItem(null);
    }

    JMenuItem ConfigureItem(String name) {
        var item = new JMenuItem(name);
        item.setFont(new Font("sans-serif", Font.BOLD, 40));
        return item;
    }

    JMenu ConfigureMenu(String name) {
        var item = new JMenu(name);
        item.setFont(new Font("sans-serif", Font.BOLD, 40));
        return item;
    }

    JMenuItem dfs(@NotNull MenuItem menuItem) {
        if (menuItem.nexts.size() == 0) {
            return ConfigureItem(menuItem.value);
        } else {
            var item = ConfigureMenu(menuItem.value);
            for (var item_ : menuItem.nexts) {
                item.add(dfs(item_));
            }
            return item;
        }
    }

    public JMenuBar build() {
        var menuBar = new JMenuBar();

        for (var next : root.nexts) {
            menuBar.add(dfs(next));
        }
        return menuBar;
    }
}

