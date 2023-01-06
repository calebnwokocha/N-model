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
        Double[] networkObjective1 = new Double[]{100.0};
        Double[] networkObjective2 = new Double[]{200.0};
        Double[][] trainSet1 = new Double[8][1];
        Double[][] trainSet2 = new Double[8][1];
        Double[][] testSet1 = new Double[20][1];
        Double[][] testSet2 = new Double[20][1];

        for (int i = 0; i < trainSet1.length; i++) {
            trainSet1[i][0] = Math.random() + 1;
            trainSet2[i][0] = Math.random() + 100;
        }

        for (int i = 0; i < testSet1.length; i++) {
            testSet1[i][0] = Math.random() + 1;
            testSet2[i][0] = Math.random() + 100;
        }

        Function<Double[], Double> sum = x -> {
            Double s = 0.0;
            for (Double d : x) { s += d; }
            return s;
        };

        Multitask multitask = new Multitask();
        Network networkA = new Network(2, 1);
        networkA.setCFunction("sum", 1.0, sum);
        networkA.setPower(-6.0);
        networkA.setCoverage(10.0);
        multitask.addNetwork(networkA);
        System.out.println("\nNETWORK TRAINING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < trainSet1.length; i++) {
            multitask.train(i + 1, networkObjective1, trainSet1[i]);
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective1));
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(trainSet1[i]));
            System.out.println();
            //System.out.println("Network hypothesis is " + Arrays.toString(networkA.getHypothesis()[networkA.getLength() - 1]));
            //System.out.println();
            System.out.println("Network thesis is " + Arrays.deepToString(multitask.getThesis()));
            System.out.println();
            //System.out.println("Network error mean is " + Arrays.toString(networkA.getErrorMean()[networkA.getLength() - 1]));
            //System.out.println();
            System.out.println();
        }

        for (int i = 0; i < trainSet2.length; i++) {
            multitask.train(i + 1, networkObjective1, trainSet2[i]);
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective1));
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(trainSet2[i]));
            System.out.println();
            //System.out.println("Network hypothesis is " + Arrays.toString(networkA.getHypothesis()[networkA.getLength() - 1]));
            //System.out.println();
            System.out.println("Network thesis is " + Arrays.deepToString(multitask.getThesis()));
            System.out.println();
            //System.out.println("Network error mean is " + Arrays.toString(networkA.getErrorMean()[networkA.getLength() - 1]));
            //System.out.println();
            System.out.println();
        }

        /*Network networkB = new Network(2, 1);
        networkB.setCFunction("sum", 1.0, sum);
        networkB.setPower(-6.0);
        networkB.setCoverage(10.0);
        multitask.addNetwork(networkB);
        for (int i = 0; i < trainSet2.length; i++) {
            multitask.train(i + 1, networkObjective2, trainSet2[i]);
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective2));
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(trainSet2[i]));
            System.out.println();
            //System.out.println("Network hypothesis is " + Arrays.toString(networkB.getHypothesis()[networkB.getLength() - 1]));
            //System.out.println();
            System.out.println("Network thesis is " + Arrays.deepToString(multitask.getThesis()));
            System.out.println();
            //System.out.println("Network error mean is " + Arrays.toString(networkB.getErrorMean()[networkA.getLength() - 1]));
            //System.out.println();
            System.out.println();
        }
*/
        System.out.println("NETWORK TESTING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < testSet1.length; i++) {
            multitask.test(testSet1[i]);
            System.out.println("Test " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective1));
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(testSet1[i]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.deepToString(multitask.getThesis()));
            System.out.println();
            System.out.println();
        }
        for (int i = 0; i < testSet2.length; i++) {
            multitask.test(testSet2[i]);
            System.out.println("Test " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective2));
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(testSet2[i]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.deepToString(multitask.getThesis()));
            System.out.println();
            System.out.println();
        }

    }
}
