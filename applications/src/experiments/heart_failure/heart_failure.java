package experiments.heart_failure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class heart_failure {
    static ArrayList<String[]> deathEvent0Set = new ArrayList<String[]>();
    static ArrayList<String[]> deathEvent1Set = new ArrayList<String[]>();
    static Double[][] deathEvent0TrainSet;
    static Double[][] deathEvent1TrainSet;
    static Double[][] deathEvent0TestSet, deathEvent1TestSet;

    public static void main(String[] args) {
        // Read CSV file
        readCSV();

        // Shuffle dataset
        Collections.shuffle(deathEvent0Set);
        Collections.shuffle(deathEvent1Set);

        // Initialize training and testing sets
        deathEvent0TrainSet = new Double[Math.round(deathEvent0Set.size() / 3)][];
        deathEvent1TrainSet = new Double[Math.round(deathEvent1Set.size() / 3)][];
        deathEvent0TestSet = new Double[Math.round(deathEvent0Set.size() - (deathEvent0Set.size() / 3))][];
        deathEvent1TestSet = new Double[Math.round(deathEvent1Set.size() - (deathEvent1Set.size() / 3))][];

        // Populate training and testing sets
        int j = 0;
        for (int i = 0; i < deathEvent0Set.size(); i++) {
            if (i <= deathEvent0TrainSet.length - 1) {
                deathEvent0TrainSet[i] = stringArrayToDoubleArray(deathEvent0Set.get(i));
            } else {
                deathEvent0TestSet[j] = stringArrayToDoubleArray(deathEvent0Set.get(i));
                j += 1;
            }
        } j = 0;
        for (int i = 0; i < deathEvent1Set.size(); i++) {
            if (i <= deathEvent1TrainSet.length - 1) {
                deathEvent1TrainSet[i] = stringArrayToDoubleArray(deathEvent1Set.get(i));
            } else {
                deathEvent1TestSet[j] = stringArrayToDoubleArray(deathEvent1Set.get(i));
                j += 1;
            }
        }

        for (int i = 0; i < deathEvent1TrainSet.length; i++) {
            System.out.println(Arrays.toString(deathEvent1TrainSet[i]));
        }
    }

    private static void readCSV() {
        // Path to the CSV file
        String filePath = "applications/src/experiments/heart_failure/heart_failure_clinical_records_dataset.csv";

        // Create a File object with the CSV file path
        File csvFile = new File(filePath);

        try {
            // Create a Scanner object to read the CSV file
            Scanner csvReader = new Scanner(csvFile);

            // Loop through the CSV file line by line
            while (csvReader.hasNextLine()) {
                // Read the current line and split it into an array of strings
                String[] data = csvReader.nextLine().split(",");
                if (data[data.length - 1].equals("0")) { deathEvent0Set.add(data); }
                else if (data[data.length - 1].equals("1")) { deathEvent1Set.add(data); }
            }

            // Close the Scanner object
            csvReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static Double[] stringArrayToDoubleArray(String[] array) {
        Double[] doubleArray = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            doubleArray[i] = Double.parseDouble(array[i]);
        } return doubleArray;
    }
}
