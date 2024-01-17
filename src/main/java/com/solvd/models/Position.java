package com.solvd.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "position")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "positionName"})
public class Position {

    @XmlAttribute(name = "id")
    @JsonProperty("id")
    private final int id;
    @XmlElement(name = "positionName")
    @JsonProperty("positionName")
    private final String positionName;

    private Position(Builder builder) {
        this.id = builder.id;
        this.positionName = builder.positionName;
    }

    public int getId() {
        return id;
    }

    public String getPositionName() {
        return positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private String positionName;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setPositionName(String positionName) {
            this.positionName = positionName;
            return this;
        }

        public Position build() {
            return new Position(this);
        }
    }
}
