package experiments;

// This experiment is design to check if a 2-layer basic comprehensive network will converge to y.
// The comprehensive function of Node A is f(x) = x, and that of Node B is f(x) = -x.

import model.*;

import java.util.Arrays;
import java.util.function.Function;

public class competing_functions {
    public static void main(String[] args) throws Exception {
        Multitask multitask = new Multitask();
        Network[] networks = new Network[10];
        Double[][] networkObjectives = new Double[10][];
        Double[][][] trainSets = new Double[10][8][1];
        Double[][][] testSets = new Double[10][20][1];

        for (int i = 1; i < networkObjectives.length; i++) {
            networkObjectives[i] = new Double[]{i * 10.0};
        }

        for (int i = 1; i < trainSets.length; i++){
            for (int j = 0; j < trainSets[i].length; j++) {
                trainSets[i][j][0] = Math.random() + i;
            }
        }

        for (int i = 1; i < testSets.length; i++){
            for (int j = 0; j < testSets[i].length; j++) {
                testSets[i][j][0] = Math.random() + i;
            }
        }

        Function<Double[], Double> positiveX = x -> x[0];
        Function<Double[], Double> negativeX = x -> x[0] * -1.0;

        for (int i = 1; i < networks.length; i++){
            networks[i] = new Network(2, 1);
            if (i == 0) { networks[i].setCFunction("positiveX", 1.0, positiveX); }
            else { networks[i].setCFunction("negativeX", 1.0, negativeX); }
            networks[i].setPower(-6.0);
            networks[i].setCoverage(4.0);
        }

        System.out.println("\nNETWORK TRAINING....................................................................");
        System.out.println();
        System.out.println();
        int k = 0;
        for (int i = 1; i < networks.length; i++) {
            multitask.addNetwork(networks[i]);
            for (int j = 0; j < trainSets[i].length; j++, k++) {
                multitask.train(j + 1, networkObjectives[i], trainSets[i][j]);
                System.out.println("Example " + (k + 1) + ":");
                System.out.println();
                System.out.println("Network objective is " + Arrays.toString(networkObjectives[i]));
                System.out.println();
                System.out.println("Network input is " + Arrays.toString(trainSets[i][j]));
                System.out.println();
                System.out.println("Network hypothesis is " + Arrays.toString(multitask.getNetworks().get(0).
                        getHypothesis()[networks[i].getLength() - 1]));
                System.out.println();
                System.out.println("Network thesis is " + Arrays.toString(multitask.getNetworks().get(i - 1).
                        getThesis()[networks[i].getLength() - 1]));
                System.out.println();
                System.out.println("Network error mean is " + Arrays.toString(multitask.getNetworks().get(0)
                        .getErrorMean()[networks[i].getLength() - 1]));
                System.out.println();
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("NETWORK TESTING.......................................................................");
        System.out.println();
        System.out.println();
        k = 0;
        for (int i = 1; i < networks.length; i++) {
            for (int j = 0; j < testSets[i].length; j++, k++) {
                multitask.test(k, testSets[i][j]);
                System.out.println("Test " + (k + 1) + ":");
                System.out.println();
                System.out.println("Network objective is " + Arrays.toString(networkObjectives[i]));
                System.out.println();
                System.out.println("Network input is " + Arrays.toString(testSets[i][j]));
                System.out.println();
                System.out.println("Network thesis is " + Arrays.deepToString(multitask.getThesis()));
                System.out.println();
                System.out.println();
            }
        }
    }
}
