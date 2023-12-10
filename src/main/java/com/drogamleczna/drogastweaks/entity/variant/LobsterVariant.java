package com.drogamleczna.drogastweaks.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum LobsterVariant {
    DEFAULT(0),
    BLUE(1);

    private static final LobsterVariant[] BY_ID = Arrays.stream(values())
            .sorted(Comparator.comparingInt(LobsterVariant::getId)).toArray(LobsterVariant[]::new);
    private final int id;

    LobsterVariant(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static LobsterVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
