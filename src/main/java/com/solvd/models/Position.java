package com.solvd.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "position")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "positionName"})
public class Position {

    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name = "positionName")
    private String positionName;

    public Position() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                '}';
    }
}
