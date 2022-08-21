package com.icolak;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import static com.icolak.HospitalData.getAll;
import static java.util.Comparator.comparing;


public class StreamHospital {

    public static void main(String[] args) {

        Set<Hospital> allHospital = new HashSet<>(getAll());

        //region Example 1
        Integer[] ambulanceCoordinates = {6, 4};
        boolean patientHasBurnWound = true;
        System.out.println(takeAvailableHospitalList(allHospital, ambulanceCoordinates, patientHasBurnWound));
        //expected output: St. Joseph’s University Medical	10 (distance)
        //endregion

        //region Example 2
        ambulanceCoordinates = new Integer[]{8, 4};
        patientHasBurnWound = true;
        System.out.println(takeAvailableHospitalList(allHospital, ambulanceCoordinates, patientHasBurnWound));
        //expected output: NYC Health Hospital 		11 (distance)
        //endregion

        //region Example 3
        ambulanceCoordinates = new Integer[]{8, 4};
        patientHasBurnWound = false;
        System.out.println(takeAvailableHospitalList(allHospital, ambulanceCoordinates, patientHasBurnWound));
        //expected output: Kings County Hospital Center	2 (distance)
        //endregion

        //region Example 4
        ambulanceCoordinates = new Integer[]{14, 7};
        patientHasBurnWound = false;
        System.out.println(takeAvailableHospitalList(allHospital, ambulanceCoordinates, patientHasBurnWound));
        //expected output: NYC Health Hospital		2 (distance)
        //endregion
    }

    private static Entry<String, Integer> takeAvailableHospitalList(
            Set<Hospital> allHospital, Integer[] ambulanceCoordinates, boolean patientHasBurnWound) {
        LinkedHashMap<String, Integer> availableHospitals = new LinkedHashMap<>();

        Hospital hospital= null;

        if (patientHasBurnWound) {
            hospital = allHospital.stream().filter(h -> h.getRoomCount() > 0 && h.isHasBurnCareUnit()).sorted(
                new Comparator<Hospital>() {
                    @Override
                    public int compare(Hospital o1, Hospital o2) {
                        if (o1.getDistance(ambulanceCoordinates) < o2.getDistance(ambulanceCoordinates))
                            return -1;
                        else if (o1.getDistance(ambulanceCoordinates) > o2.getDistance(ambulanceCoordinates))
                            return 1;
                        else
                            return 0;
                    }
                }).findFirst().get();

        } else {

            hospital = allHospital.stream().filter(h -> h.getRoomCount() > 0).sorted(
                new Comparator<Hospital>() {
                    @Override
                    public int compare(Hospital o1, Hospital o2) {
                        if (o1.getDistance(ambulanceCoordinates) < o2.getDistance(ambulanceCoordinates))
                            return -1;
                        else if (o1.getDistance(ambulanceCoordinates) > o2.getDistance(ambulanceCoordinates))
                            return 1;
                        else
                            return 0;
                    }
                }).findFirst().get();


            /*
            allHospital.stream()
                    .filter(hospital -> hospital.getRoomCount() > 0)
                    .map(hospital -> hospital.getDistance(ambulanceCoordinates))
                    .sorted(comparing(Hospital::getDistance))
                    .limit(1)
                    .forEach(hospital -> System.out.println(hospital.getName() + " " + hospital.getDistance()));*/
        }

        availableHospitals.put(hospital.getName(), hospital.getDistance(ambulanceCoordinates));
        return availableHospitals.entrySet().iterator().next();
    }
}

