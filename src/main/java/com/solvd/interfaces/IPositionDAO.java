package com.solvd.interfaces;

import com.solvd.models.Position;

public interface IPositionDAO extends IBaseDAO<Position> {
    Position getPositionByName(String positionName);
}
