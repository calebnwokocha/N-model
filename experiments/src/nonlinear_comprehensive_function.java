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

public class nonlinear_comprehensive_function {
    public static void main(String[] args) throws Exception {
        Double[] networkObjective = new Double[]{200.0};

        Double[][] trainSet = new Double[100][2];
        for (int i = 0; i < trainSet.length; i++) {
            trainSet[i][0] = Math.random() + 10;
            trainSet[i][1] = Math.random() + 10;
        }

        Double[][] testSet = new Double[100][2];
        for (int i = 0; i < testSet.length; i++) {
            testSet[i][0] = Math.random() + 10;
            testSet[i][1] = Math.random() + 10;
        }


        Function<Double[], Double> square = x -> Math.pow(x[0], 2.0);

        Network network = new Network(2, 1);
        network.setCFunction("square", 2.0, square);
        network.setPower(-6.0);

        System.out.println("\nNETWORK TRAINING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < trainSet.length; i++) {
            network.train(i + 1, networkObjective, trainSet[i]);
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective));
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(trainSet[i]));
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.toString(network.getHypothesis()[network.getLength() - 1]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesis()[network.getLength() - 1]));
            System.out.println();
            System.out.println("Network error mean is " + Arrays.toString(network.getErrorMean()[network.getLength() - 1]));
            System.out.println();
            System.out.println();
        }

        System.out.println("NETWORK TESTING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < testSet.length; i++) {
            network.test(trainSet[i]);
            System.out.println("Test " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective));
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(testSet[i]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesis()[network.getLength() - 1]));
            System.out.println();
            System.out.println();
        }
    }
}
