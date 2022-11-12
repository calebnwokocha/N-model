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

import cml.core.Network;

import java.util.Arrays;
import java.util.function.Function;

public class outlier_detection_experiment {
    public static void main(String[] args) throws Exception {
        double[] networkObjective = new double[]{200.0};

        double[] trainSet = new double[100];
        for (int i = 0; i < trainSet.length; i++) {
            trainSet[i] = Math.random() + 10;
        }

        double[] outlierTestSet = new double[100];
        for (int i = 0; i < outlierTestSet.length; i++) {
            outlierTestSet[i] = Math.random() + 8;
        }

        Function<Double[], Double> sum = x -> {
            double s = 0.0;
            for (Double aDouble : x) { s += aDouble; }
            return s;
        };

        Network network = new Network(2, 1);
        network.setCFunction("sum", 1, sum);
        network.setPower(40);
        network.setCoverage(5.0);

        System.out.println("\nNETWORK TRAINING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < trainSet.length; i++) {
            network.train(i + 1, networkObjective, new Double[]{trainSet[i]});
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective));
            System.out.println();
            System.out.println("Network input is " + trainSet[i]);
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.toString(network.getHypothesisMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesisMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println("Network error mean is " + Arrays.toString(network.getErrorMeanMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println();
        }

        System.out.println("NETWORK TESTING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < outlierTestSet.length; i++) {
            network.test(new Double[]{outlierTestSet[i]});
            System.out.println("Outlier Test " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective));
            System.out.println();
            System.out.println("Network input is " + outlierTestSet[i]);
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesisMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println();
        }
    }
}
