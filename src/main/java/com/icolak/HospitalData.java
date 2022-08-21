package com.icolak;

import java.util.Arrays;
import java.util.List;

public class HospitalData {

    public static List<Hospital> getAll() {
        return Arrays.asList(
                new Hospital("St. Joseph’s University Medical", new Integer[]{1, 9},0, 3, true),
                new Hospital("Saint Michael’s Medical Center", new Integer[]{6, 7},0,8, false),
                new Hospital("Woodhull Hospital", new Integer[]{9,7},0,8, false),
                new Hospital("The Mount Sinai Hospital", new Integer[]{13, 7},0,0, false),
                new Hospital("NYC Health Hospital", new Integer[]{14, 9},0,1, true),
                new Hospital("Staten Island University Hospital", new Integer[]{2, 2},0,5, false),
                new Hospital("Care Well Health Medical Center", new Integer[]{5, 4},0,0, true),
                new Hospital("Kings County Hospital Center", new Integer[]{8, 2},0,14, false),
                new Hospital("Brookdale University Hospital", new Integer[]{11, 3},0,1, false)
        );

    }
}
