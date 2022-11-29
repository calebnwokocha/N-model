package handwritten_digits;

import model.Network;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;

public class digit_classification {
    public static void main(String[] args) throws Exception {
        File trainSetFile = new File("C:\\Users\\Caleb P. Nwokocha\\Documents\\Automaton\\experiments\\" +
                "src\\handwritten_digits\\dataset\\mnist_train.csv");
        File testSetFile = new File("C:\\Users\\Caleb P. Nwokocha\\Documents\\Automaton\\experiments\\" +
                "src\\handwritten_digits\\dataset\\mnist_test.csv");

        Scanner trainSetScanner = new Scanner(trainSetFile);
        Scanner testSetScanner = new Scanner(testSetFile);

        ArrayList<Double[]> trainDataset = new ArrayList<>();
        ArrayList<Double[]> testDataset = new ArrayList<>();

        while (trainSetScanner.hasNextLine()) { trainSetScanner.nextLine();
            String[] lineArray; try {
                lineArray = trainSetScanner.nextLine().replace(",", "").split("");
            } catch (NoSuchElementException e) {break;}
            Double[] data = new Double[lineArray.length]; for (int j = 0; j < data.length; j++)
            { data[j] = Double.valueOf(lineArray[j]); } trainDataset.add(data);
        } trainSetScanner.close();

        while (testSetScanner.hasNextLine()) { testSetScanner.nextLine();
            String[] lineArray; try {
                lineArray = testSetScanner.nextLine().replace(",", "").split("");
            } catch (NoSuchElementException e) {break;}
            Double[] data = new Double[lineArray.length]; for (int j = 0; j < data.length; j++)
            { data[j] = Double.valueOf(lineArray[j]); } testDataset.add(data);
        } trainSetScanner.close();


        ArrayList<Double[]> zeroTrainingSet = new ArrayList<>();
        ArrayList<Double[]> zeroTestingSet = new ArrayList<>();

        ArrayList<Double[]> oneTrainingSet = new ArrayList<>();
        ArrayList<Double[]> oneTestingSet = new ArrayList<>();

        ArrayList<Double[]> twoTrainingSet = new ArrayList<>();
        ArrayList<Double[]> twoTestingSet = new ArrayList<>();

        ArrayList<Double[]> threeTrainingSet = new ArrayList<>();
        ArrayList<Double[]> threeTestingSet = new ArrayList<>();

        ArrayList<Double[]> fourTrainingSet = new ArrayList<>();
        ArrayList<Double[]> fourTestingSet = new ArrayList<>();

        ArrayList<Double[]> fiveTrainingSet = new ArrayList<>();
        ArrayList<Double[]> fiveTestingSet = new ArrayList<>();

        ArrayList<Double[]> sixTrainingSet = new ArrayList<>();
        ArrayList<Double[]> sixTestingSet = new ArrayList<>();

        ArrayList<Double[]> sevenTrainingSet = new ArrayList<>();
        ArrayList<Double[]> sevenTestingSet = new ArrayList<>();

        ArrayList<Double[]> eightTrainingSet = new ArrayList<>();
        ArrayList<Double[]> eightTestingSet = new ArrayList<>();

        ArrayList<Double[]> nineTrainingSet = new ArrayList<>();
        ArrayList<Double[]> nineTestingSet = new ArrayList<>();

        for (Double[] dataset : trainDataset) {
            if (dataset[0] == 0.0) { zeroTrainingSet.add(dataset); }
            else if (dataset[0] == 1.0) { oneTrainingSet.add(dataset); }
            else if (dataset[0] == 2.0) { twoTrainingSet.add(dataset); }
            else if (dataset[0] == 3.0) { threeTrainingSet.add(dataset); }
            else if (dataset[0] == 4.0) { fourTrainingSet.add(dataset); }
            else if (dataset[0] == 5.0) { fiveTrainingSet.add(dataset); }
            else if (dataset[0] == 6.0) { sixTrainingSet.add(dataset); }
            else if (dataset[0] == 7.0) { sevenTrainingSet.add(dataset); }
            else if (dataset[0] == 8.0) { eightTrainingSet.add(dataset); }
            else if (dataset[0] == 9.0) { nineTrainingSet.add(dataset); }
        }

        for (Double[] dataset : testDataset) {
            if (dataset[0] == 0.0) { zeroTestingSet.add(dataset); }
            else if (dataset[0] == 1.0) { oneTestingSet.add(dataset); }
            else if (dataset[0] == 2.0) { twoTestingSet.add(dataset); }
            else if (dataset[0] == 3.0) { threeTestingSet.add(dataset); }
            else if (dataset[0] == 4.0) { fourTestingSet.add(dataset); }
            else if (dataset[0] == 5.0) { fiveTestingSet.add(dataset); }
            else if (dataset[0] == 6.0) { sixTestingSet.add(dataset); }
            else if (dataset[0] == 7.0) { sevenTestingSet.add(dataset); }
            else if (dataset[0] == 8.0) { eightTestingSet.add(dataset); }
            else if (dataset[0] == 9.0) { nineTestingSet.add(dataset); }
        }

        Function<Double[], Double> sum = x -> {
            Double s = 0.0;
            for (Double d : x) { s += d; }
            return Math.pow(s, 2);
        };
        
        Network network = new Network(5, 812);
        network.setCFunction("sum", 3.0, sum);
        network.setPower(10.0);
        network.setCoverage(2.0);

        Double[] networkObjective = new Double[900];
        Arrays.fill(networkObjective, 4.0);

        for (int i = 0; i < 10; i++) {
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network error mean is " + Arrays.toString(network.getErrorMean()[network.getLength() - 1]));
            network.train(i + 1, networkObjective, convertVectorToMatrix(fourTrainingSet.get(i)));
            System.out.println();
            System.out.println("Network objective is " + networkObjective[i]);
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(fourTrainingSet.get(i)));
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.toString(network.getHypothesis()[network.getLength() - 1]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesis()[network.getLength() - 1]));
            System.out.println();
        }

        System.out.println("NETWORK TESTING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < 10; i++) {
            network.test(convertVectorToMatrix(fourTestingSet.get(i)));
            System.out.println("Test " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + 0);
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(fourTestingSet.get(i)));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesis()[network.getLength() - 1]));
            System.out.println();
            System.out.println();
        }
    }

    public static Double[][] convertVectorToMatrix(Double[] vector) {
        Double[][] matrix = new Double[vector.length][1];
        for (int i = 0; i < matrix.length; i++) { matrix[i][0] = vector[i]; }
        return matrix;
    }

    public static Double[][] convertBasisScalarToMatrix (Double basis, Double[][] dataset) {
        Double[][] basisMatrix = new Double[dataset.length][];
        for (int i = 0; i < basisMatrix.length; i++) {
            try { basisMatrix[i] = new Double[dataset[i].length];
                Arrays.fill(basisMatrix[i], basis);
            } catch (NullPointerException e) { break; }
        } return basisMatrix;
    }
}
