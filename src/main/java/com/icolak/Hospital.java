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
    private Integer roomCount;
    private boolean hasBurnCareUnit;



}

