package com.solvd.interfaces;

import com.solvd.models.Position;

public interface iPositionDAO extends IBaseDAO<Position> {
Position getPositionByName(String positionName);
}
