package com.solvd.factory;

import com.solvd.models.Position;
public class PositionFactory {

    public static Position createPosition(int id, String name) {
        return new Position.Builder()
                .setId(id)
                .setPositionName(name)
                .build();
    }
}
