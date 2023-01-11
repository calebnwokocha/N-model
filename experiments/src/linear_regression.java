/*------------------------------------------------------------------------------
 Open-source framework for comprehensive machine learning.

 Copyright (C) 2022 Caleb Princewill Nwokocha

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published
 by the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program. If not, see <https://www.gnu.org/licenses/>.

 Email calebnwokocha@gmail.com for technical support and/or special
 permission to use this framework.
---------------------------------------------------------------------------- */

import model.*;

import java.util.Arrays;
import java.util.function.Function;

public class linear_regression {
    public static void main(String[] args) throws Exception {
        Multitask multitask = new Multitask();
        Network[] network = new Network[10];
        Double[][] networkObjective = new Double[10][];
        Double[][][] trainSet = new Double[10][8][1];
        Double[][][] testSet = new Double[10][20][1];

        for (int i = 1; i < networkObjective.length; i++) {
            networkObjective[i] = new Double[]{i * 10.0};
        }

        for (int i = 1; i < trainSet.length; i++){
            for (int j = 0; j < trainSet[i].length; j++) {
                trainSet[i][j][0] = Math.random() + i;
            }
        }

        for (int i = 1; i < testSet.length; i++){
            for (int j = 0; j < testSet[i].length; j++) {
                testSet[i][j][0] = Math.random() + i;
            }
        }

        Function<Double[], Double> sum = x -> {
            Double s = 0.0;
            for (Double d : x) { s += d; }
            return s;
        };

        for (int i = 1; i < network.length; i++){
            network[i] = new Network(2, 1);
            network[i].setCFunction("sum", 1.0, sum);
            network[i].setPower(-6.0);
            network[i].setCoverage(4.0);
        }

        System.out.println("\nNETWORK TRAINING....................................................................");
        System.out.println();
        System.out.println();
        int k = 0;
        for (int i = 1; i < network.length; i++) {
            multitask.addNetwork(network[i]);
            for (int j = 0; j < trainSet[i].length; j++, k++) {
                multitask.train(j + 1, networkObjective[i], trainSet[i][j]);
                System.out.println("Example " + (k + 1) + ":");
                System.out.println();
                System.out.println("Network objective is " + Arrays.toString(networkObjective[i]));
                System.out.println();
                System.out.println("Network input is " + Arrays.toString(trainSet[i][j]));
                System.out.println();
                System.out.println("Network hypothesis is " + Arrays.toString(multitask.getNetworks().get(0).
                        getHypothesis()[network[i].getLength() - 1]));
                System.out.println();
                System.out.println("Network thesis is " + Arrays.deepToString(multitask.getThesis()));
                System.out.println();
                System.out.println("Network error mean is " + Arrays.toString(multitask.getNetworks().get(0)
                        .getErrorMean()[network[i].getLength() - 1]));
                System.out.println();
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("NETWORK TESTING.......................................................................");
        System.out.println();
        System.out.println();
        k = 0;
        for (int i = 1; i < network.length; i++) {
            for (int j = 0; j < testSet[i].length; j++, k++) {
                multitask.test(testSet[i][j]);
                System.out.println("Test " + (k + 1) + ":");
                System.out.println();
                System.out.println("Network objective is " + Arrays.toString(networkObjective[i]));
                System.out.println();
                System.out.println("Network input is " + Arrays.toString(testSet[i][j]));
                System.out.println();
                System.out.println("Network thesis is " + Arrays.deepToString(multitask.getThesis()));
                System.out.println();
                System.out.println();
            }
        }
    }
}
