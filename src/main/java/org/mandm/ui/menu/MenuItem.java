package org.mandm.ui.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    String value;
    List<MenuItem> nexts = new ArrayList<>();

    public MenuItem add(MenuItem item) {
        nexts.add(item);
        return this;
    }


    public MenuItem add(String name) {
        var item = new MenuItem(name);
        nexts.add(item);
        return this;
    }


    public MenuItem(String s) {
        value = s;
    }
}