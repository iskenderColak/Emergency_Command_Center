package com.icolak;

import java.util.Arrays;
import java.util.List;

public class HospitalData {

    public static List<Hospital> getAll() {
        return Arrays.asList(
                new Hospital("St. Joseph’s University Medical", new Integer[]{1, 9}, 3, true),
                new Hospital("Saint Michael’s Medical Center", new Integer[]{6, 7},8, false),
                new Hospital("Woodhull Hospital", new Integer[]{9,7},8, false),
                new Hospital("The Mount Sinai Hospital", new Integer[]{13, 7},0, false),
                new Hospital("NYC Health Hospital", new Integer[]{14, 9},1, true),
                new Hospital("Staten Island University Hospital", new Integer[]{2, 2},5, false),
                new Hospital("Care Well Health Medical Center", new Integer[]{5, 4},0, true),
                new Hospital("Kings County Hospital Center", new Integer[]{8, 2},14, false),
                new Hospital("Brookdale University Hospital", new Integer[]{11, 3},1, false)
        );

    }
}
