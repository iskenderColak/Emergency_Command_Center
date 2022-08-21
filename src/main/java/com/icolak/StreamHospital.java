package com.icolak;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.icolak.HospitalData.getAll;
import static java.util.Comparator.comparing;


public class StreamHospital {

    public static void main(String[] args) {

        Set<Hospital> allHospital = new HashSet<>(getAll());

        Integer[] ambulanceCoordinates = {6, 4};
        boolean patientHasBurnWound = true;

        System.out.println(takeAvailableHospitalList(allHospital, ambulanceCoordinates, patientHasBurnWound));

    }

    private static Map.Entry<String, Integer> takeAvailableHospitalList(
            Set<Hospital> allHospital, Integer[] ambulanceCoordinates, boolean patientHasBurnWound) {

        /*

        if (patientHasBurnWound) {
            allHospital.stream()
                    .filter(Hospital::isHasBurnCareUnit)
                    .filter(hospital -> hospital.getRoomCount() > 0)
               // so far so good:))
              // in Hospital Class i added new field "distance" and setDistance(int[] arr)
             // and here i want to use it but it doesn't work :((
            //if it worked, after it find the distance between hospital and ambulance it would sort according to distance
           // and than after getting only the lowest distance (Limit(1)) would print the name and distance
                    .map(hospital -> hospital.setDistance(ambulanceCoordinates))
                    .sorted(comparing(Hospital::getDistance))
                    .limit(1)
                    .forEach(hospital -> System.out.println(hospital.getName() + " " + hospital.getDistance()));

        } else {
            allHospital.stream()
                    .filter(hospital -> hospital.getRoomCount() > 0)
                    .map(hospital -> hospital.setDistance(ambulanceCoordinates))
                    .sorted(comparing(Hospital::getDistance))
                    .limit(1)
                    .forEach(hospital -> System.out.println(hospital.getName() + " " + hospital.getDistance()));
        }

        */
        return null;
    }
}

