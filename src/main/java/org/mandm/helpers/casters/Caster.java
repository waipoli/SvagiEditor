package org.mandm.helpers.casters;

import java.util.Map;

public class Caster {
    public static Map<?, ?> fromObjectToMap(Object object) {
        Map<?, ?> map;
        if (object instanceof Map<?, ?>) {
            map = (Map<?, ?>) object;
        } else {
            throw new RuntimeException("Cannot load correctly Theme");
        }
        return map;
    }
}
