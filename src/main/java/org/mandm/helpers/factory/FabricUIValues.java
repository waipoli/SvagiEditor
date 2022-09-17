package org.mandm.helpers.factory;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import javax.swing.*;
import java.awt.*;

public class FabricUIValues {

    public static Object creteUIObject(String name, String value) {
        return switch (name) {
            case "border" -> createBorder(value);
            case "background", "selectionBackground", "foreground", "selectionForeground" -> createColor(value);
            default -> throw new RuntimeException("Cannot resolve name of reference");
        };
    }


    @Contract("_ -> new")
    static @NotNull @Unmodifiable Object createColor(String s) {
        return Color.decode(s);
    }

    static Object createBorder(@NotNull String s) {
        return switch (s) {
            case "null" -> BorderFactory.createEmptyBorder();
            case "etchedBorder" -> BorderFactory.createEtchedBorder();
            default -> throw new RuntimeException("Cannot resolve type of border");
        };
    }

}
