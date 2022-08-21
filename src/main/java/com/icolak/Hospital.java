package com.icolak;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hospital {
    //each hospital is represented by it’s name, X,Y coordinates,
    // available room count and if it has a burn care unit.
    private String name;
    private Integer[] coordinates;
    private Integer distance;
    private Integer roomCount;
    private boolean hasBurnCareUnit;


    public void setDistance(Integer[] arr) {
        this.distance = Math.abs(arr[0] - coordinates[0]) + Math.abs(arr[1] - coordinates[1]);
    }
}

