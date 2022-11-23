package handwritten_digits;

import cml.Dataset;
import cml.Network;

import java.util.Arrays;
import java.util.function.Function;

public class digit_classifier {
    public static void main(String[] args) throws Exception {
        Dataset zeroDataset = new Dataset("C:\\Users\\Caleb P. Nwokocha\\Documents\\CML\\experiments\\src\\handwritten_digits\\dataset\\10000\\0");
        Dataset oneDataset = new Dataset("C:\\Users\\Caleb P. Nwokocha\\Documents\\CML\\experiments\\src\\handwritten_digits\\dataset\\10000\\1");
        Dataset twoDataset = new Dataset("C:\\Users\\Caleb P. Nwokocha\\Documents\\CML\\experiments\\src\\handwritten_digits\\dataset\\10000\\2");
        Dataset threeDataset = new Dataset("C:\\Users\\Caleb P. Nwokocha\\Documents\\CML\\experiments\\src\\handwritten_digits\\dataset\\10000\\3");
        Dataset fourDataset = new Dataset("C:\\Users\\Caleb P. Nwokocha\\Documents\\CML\\experiments\\src\\handwritten_digits\\dataset\\10000\\4");
        Dataset fiveDataset = new Dataset("C:\\Users\\Caleb P. Nwokocha\\Documents\\CML\\experiments\\src\\handwritten_digits\\dataset\\10000\\5");
        Dataset sixDataset = new Dataset("C:\\Users\\Caleb P. Nwokocha\\Documents\\CML\\experiments\\src\\handwritten_digits\\dataset\\10000\\6");
        Dataset sevenDataset = new Dataset("C:\\Users\\Caleb P. Nwokocha\\Documents\\CML\\experiments\\src\\handwritten_digits\\dataset\\10000\\7");
        Dataset eightDataset = new Dataset("C:\\Users\\Caleb P. Nwokocha\\Documents\\CML\\experiments\\src\\handwritten_digits\\dataset\\10000\\8");
        Dataset nineDataset = new Dataset("C:\\Users\\Caleb P. Nwokocha\\Documents\\CML\\experiments\\src\\handwritten_digits\\dataset\\10000\\9");

        int numOfTrainingSet = 500;
        int numOfTestingSet = 500;

        Double[][][] splitZeroDataset = zeroDataset.split(new int[]{numOfTrainingSet, numOfTestingSet});
        Double[][][] splitOneDataset = zeroDataset.split(new int[]{numOfTrainingSet, numOfTestingSet});
        Double[][][] splitTwoDataset = zeroDataset.split(new int[]{numOfTrainingSet, numOfTestingSet});
        Double[][][] splitThreeDataset = zeroDataset.split(new int[]{numOfTrainingSet, numOfTestingSet});
        Double[][][] splitFourDataset = zeroDataset.split(new int[]{numOfTrainingSet, numOfTestingSet});
        Double[][][] splitFiveDataset = zeroDataset.split(new int[]{numOfTrainingSet, numOfTestingSet});
        Double[][][] splitSixDataset = zeroDataset.split(new int[]{numOfTrainingSet, numOfTestingSet});
        Double[][][] splitSevenDataset = zeroDataset.split(new int[]{numOfTrainingSet, numOfTestingSet});
        Double[][][] splitEightDataset = zeroDataset.split(new int[]{numOfTrainingSet, numOfTestingSet});
        Double[][][] splitNineDataset = zeroDataset.split(new int[]{numOfTrainingSet, numOfTestingSet});

        Double[][] zeroTrainingSet = splitZeroDataset[0];
        Double[][] zeroTestingSet = splitZeroDataset[1];

        Double[][] oneTrainingSet = splitOneDataset[0];
        Double[][] oneTestingSet = splitOneDataset[1];

        Double[][] twoTrainingSet = splitTwoDataset[0];
        Double[][] twoTestingSet = splitTwoDataset[1];

        Double[][] threeTrainingSet = splitThreeDataset[0];
        Double[][] threeTestingSet = splitThreeDataset[1];

        Double[][] fourTrainingSet = splitFourDataset[0];
        Double[][] fourTestingSet = splitFourDataset[1];

        Double[][] fiveTrainingSet = splitFiveDataset[0];
        Double[][] fiveTestingSet = splitFiveDataset[1];

        Double[][] sixTrainingSet = splitSixDataset[0];
        Double[][] sixTestingSet = splitSixDataset[1];

        Double[][] sevenTrainingSet = splitSevenDataset[0];
        Double[][] sevenTestingSet = splitSevenDataset[1];

        Double[][] eightTrainingSet = splitEightDataset[0];
        Double[][] eightTestingSet = splitEightDataset[1];

        Double[][] nineTrainingSet = splitNineDataset[0];
        Double[][] nineTestingSet = splitNineDataset[1];

        Function<Double[], Double> sum = x -> {
            Double s = 0.0;
            for (Double d : x) { s += d; }
            return Math.pow(s, 0.5);
        };
        
        Network network = new Network(10, new int[]{1000, 1000, 1000, 1000, 1000, 1, 1, 1, 1, 1});
        network.setCFunction("sum", 0.5, sum);
        network.setPower(5.0);
        //network.setCoverage(7.0);

        for (int i = 0; i < 50; i++) {
            network.train(i + 1, new Double[]{3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, 3.0}, convertVectorToMatrix(threeTrainingSet[i]));
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + 0);
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(threeTrainingSet[i]));
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.toString(network.getHypothesis()[network.getLength() - 10]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesis()[network.getLength() - 10]));
            System.out.println();
            System.out.println("Network error mean is " + Arrays.toString(network.getErrorMean()[network.getLength() - 10]));
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.toString(network.getHypothesis()[network.getLength() - 9]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesis()[network.getLength() - 9]));
            System.out.println();
            System.out.println("Network error mean is " + Arrays.toString(network.getErrorMean()[network.getLength() - 9]));
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.toString(network.getHypothesis()[network.getLength() - 8]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesis()[network.getLength() - 8]));
            System.out.println();
            System.out.println("Network error mean is " + Arrays.toString(network.getErrorMean()[network.getLength() - 8]));
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.toString(network.getHypothesis()[network.getLength() - 7]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesis()[network.getLength() - 7]));
            System.out.println();
            System.out.println("Network error mean is " + Arrays.toString(network.getErrorMean()[network.getLength() - 7]));
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.toString(network.getHypothesis()[network.getLength() - 10]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesis()[network.getLength() - 10]));
            System.out.println();
            System.out.println("Network error mean is " + Arrays.toString(network.getErrorMean()[network.getLength() - 10]));
            System.out.println();
            System.out.println();
        }

        System.out.println("NETWORK TESTING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < 50; i++) {
            network.test(convertVectorToMatrix(threeTestingSet[i]));
            System.out.println("Test " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + 0);
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(threeTestingSet[i]));
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
}
