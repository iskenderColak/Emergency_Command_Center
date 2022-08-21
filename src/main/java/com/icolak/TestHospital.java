package com.icolak;

import java.util.*;

import static com.icolak.HospitalData.getAll;

public class TestHospital {

    public static void main(String[] args) {

        Set<Hospital> allHospital = new HashSet<>(getAll());

        Integer[] ambulanceCoordinates = {14, 7};
        boolean patientHasBurnWound = false;

        System.out.println(getAvailableHospitalList(allHospital, ambulanceCoordinates, patientHasBurnWound));
    }
    private static Map.Entry<String, Integer> getAvailableHospitalList
            (Set<Hospital> allHospital, Integer[] ambulanceCoordinates, boolean patientHasBurnWound) {
        int minDistanceToAmbulance = Integer.MAX_VALUE;
        String closerHospitalName = "";
        if (patientHasBurnWound) {
            for (Hospital hospital : allHospital) {
                if (hospital.getRoomCount() > 0 && hospital.isHasBurnCareUnit()) {
                    int distanceToAmbulance = distanceToAmbulance(hospital.getCoordinates(),ambulanceCoordinates);
                    if (distanceToAmbulance < minDistanceToAmbulance) {
                        minDistanceToAmbulance = distanceToAmbulance;
                        closerHospitalName = hospital.getName();
                    }
                }
            }
        }else {
            for (Hospital hospital : allHospital) {
                if (hospital.getRoomCount() > 0) {
                    int distanceToAmbulance = distanceToAmbulance(hospital.getCoordinates(),ambulanceCoordinates);
                    if (distanceToAmbulance < minDistanceToAmbulance) {
                        minDistanceToAmbulance = distanceToAmbulance;
                        closerHospitalName = hospital.getName();
                    }
                }
            }

        }
        return new AbstractMap.SimpleEntry<>(closerHospitalName, minDistanceToAmbulance);
    }

    private static int distanceToAmbulance(Integer[] arr1, Integer[] arr2) {
        return Math.abs(arr1[0] - arr2[0]) + Math.abs(arr1[1] - arr2[1]);
    }
}

