/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai;

import caleai.core.Network;
import caleai.core.UndefinedTarget;
import caleai.core.WrongInitialization;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws WrongInitialization, UndefinedTarget {
        int length = 3;
        int[] width = new int[]{2, 2, 1};
        String[][] functions = new String[][] {
                {"cubic volume" /* caleai.core.Neuron 1 */, "force" /* caleai.core.Neuron 2 */}, // caleai.core.Layer 1
                {"force" /* caleai.core.Neuron 1 */, "cubic volume" /* caleai.core.Neuron 2 */}, // caleai.core.Layer 2
                {"force" /* caleai.core.Neuron 1 */}                                 // caleai.core.Layer 3
        };
        String[][] activators = new String[][] {
                {"identity" /* caleai.core.Neuron 1 */, "identity" /* caleai.core.Neuron 2 */}, // caleai.core.Layer 1
                {"identity" /* caleai.core.Neuron 1 */, "identity" /* caleai.core.Neuron 2 */}, // caleai.core.Layer 2
                {"identity" /* caleai.core.Neuron 1 */}                             // caleai.core.Layer 3
        };

        Network network = new Network(length, width, functions, activators);

        double[] datasetA = new double[] {Math.random()};
        double[] datasetB = new double[] {Math.random(), Math.random()};

        network.feed(new double[][][]{
                {       // caleai.core.Layer 1
                        datasetA,                                                                                                         // caleai.core.Neuron 1
                        datasetB                                                                                                          // caleai.core.Neuron 2
                },
                {        // caleai.core.Layer 2
                        {network.getLayers()[0].getNeurons()[0].getHypothesis(), network.getLayers()[0].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                        {network.getLayers()[0].getNeurons()[0].getHypothesis()}                                                          // caleai.core.Neuron 2
                },
                {       // caleai.core.Layer 3
                        {network.getLayers()[1].getNeurons()[0].getHypothesis(), network.getLayers()[1].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                }
        });

        int iteration = 2000;
        double[] objective = new double[] {datasetA[0] + datasetB[0] + datasetB[1]};
        network.learn(objective, null);
        double error = network.getError();
        double[] errors = new double[iteration];
        errors[0] = error;
        int i = 1;

        while (error > 0.0 && i < iteration) {
            datasetA[0] = Math.random();
            datasetB[0] = Math.random();
            datasetB[1] = Math.random();
            objective[0] = datasetA[0] + datasetB[0] + datasetB[1];
            network.feed(new double[][][]{
                    {       // caleai.core.Layer 1
                            datasetA,                                                                                                         // caleai.core.Neuron 1
                            datasetB                                                                                                          // caleai.core.Neuron 2
                    },
                    {        // caleai.core.Layer 2
                            {network.getLayers()[0].getNeurons()[0].getHypothesis(), network.getLayers()[0].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                            {network.getLayers()[0].getNeurons()[0].getHypothesis()}                                                          // caleai.core.Neuron 2
                    },
                    {       // caleai.core.Layer 3
                            {network.getLayers()[1].getNeurons()[0].getHypothesis(), network.getLayers()[1].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                    }
            });

            network.learn(objective, null);

            System.out.println();
            System.out.println("LAYER 1 : caleai.core.Neuron 1: value = " + network.getLayers()[0].getNeurons()[0].getHypothesis());
            System.out.println("LAYER 1 : caleai.core.Neuron 2: value = " + network.getLayers()[0].getNeurons()[1].getHypothesis());
            System.out.println("LAYER 2 : caleai.core.Neuron 1: value = " + network.getLayers()[1].getNeurons()[0].getHypothesis());
            System.out.println("LAYER 2 : caleai.core.Neuron 2: value = " + network.getLayers()[1].getNeurons()[1].getHypothesis());
            System.out.println("LAYER 3 : caleai.core.Neuron 1: value = " + network.getLayers()[2].getNeurons()[0].getHypothesis());

            error = network.getError();
            errors[i] = error;
            System.out.println("Objective is " + Arrays.toString(objective));
            System.out.println("Error is " + error);
            i++;
        } System.out.println("\nRecord of error is:");
        for (double e : errors) { System.out.println( e ); }
    }
}
