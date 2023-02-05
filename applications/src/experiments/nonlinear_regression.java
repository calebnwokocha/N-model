package experiments;/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

import model.*;

import java.util.Arrays;
import java.util.function.Function;

public class nonlinear_regression {
    public static void main(String[] args) throws Exception {
// Create an instance of Multitask
        Multitask multitask = new Multitask();

        // Create an array of 10 networks
        Network[] networks = new Network[10];

        // Create an array of network objectives
        Double[][] networkObjectives = new Double[10][];

        // Create an array of training sets
        Double[][][] trainSets = new Double[10][8][1];

        // Create an array of test sets
        Double[][][] testSets = new Double[10][20][1];

        // Set network objectives
        for (int i = 1; i < networkObjectives.length; i++) {
            networkObjectives[i] = new Double[]{Math.pow(10.0, i)};
        }

        // Set training sets
        for (int i = 1; i < trainSets.length; i++) {
            for (int j = 0; j < trainSets[i].length; j++) {
                trainSets[i][j][0] = Math.random() + i;
            }
        }

        // Set test sets
        for (int i = 1; i < testSets.length; i++) {
            for (int j = 0; j < testSets[i].length; j++) {
                testSets[i][j][0] = Math.random() + i;
            }
        }

        // Define a square function
        Function<Double[], Double> square = x -> Math.pow(x[0], 2.0);

        // Initialize the networks
        for (int i = 1; i < networks.length; i++) {
            networks[i] = new Network(2, 1);
            networks[i].setCFunction("square", 2.0, square);
            networks[i].setPower(-6.0);
            networks[i].setCoverage(4.0);
        }

        System.out.println("\nNETWORK TRAINING....................................................................");
        System.out.println();
        System.out.println();
        int k = 0;
        for (int i = 1; i < networks.length; i++) {
            // add the current network to the multitask
            multitask.addNetwork(networks[i]);
            for (int j = 0; j < trainSets[i].length; j++, k++) {
                // train the current network with the current train set
                multitask.train(j + 1, networkObjectives[i], trainSets[i][j]);
                System.out.println("Example " + (k + 1) + ":");
                System.out.println();
                // print the network objective
                System.out.println("Network objective is " + Arrays.toString(networkObjectives[i]));
                System.out.println();
                // print the network input
                System.out.println("Network input is " + Arrays.toString(trainSets[i][j]));
                System.out.println();
                // print the network hypothesis
                System.out.println("Network hypothesis is " + Arrays.toString(multitask.getNetworks().get(0).
                        getHypothesis()[networks[i].getLength() - 1]));
                System.out.println();
                // print the network thesis
                System.out.println("Network thesis is " + Arrays.toString(multitask.getNetworks().get(i - 1).
                        getThesis()[networks[i].getLength() - 1]));
                System.out.println();
                // print the network error mean
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
                // test the current network with the current test set
                multitask.test(k, testSets[i][j]);
                System.out.println("Test " + (k + 1) + ":");
                System.out.println();
                // print the network objective
                System.out.println("Network objective is " + Arrays.toString(networkObjectives[i]));
                System.out.println();
                // print the network input
                System.out.println("Network input is " + Arrays.toString(testSets[i][j]));
                System.out.println();
                // print the network thesis
                System.out.println("Network thesis is " + Arrays.deepToString(multitask.getThesis()));
                System.out.println();
                System.out.println();
            }
        }
    }
}