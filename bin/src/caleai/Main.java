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
                {"force" /* caleai.core.Neuron 1 */}                                             // caleai.core.Layer 3
        };
        String[][] activators = new String[][] {
                {"identity" /* caleai.core.Neuron 1 */, "identity" /* caleai.core.Neuron 2 */}, // caleai.core.Layer 1
                {"identity" /* caleai.core.Neuron 1 */, "identity" /* caleai.core.Neuron 2 */}, // caleai.core.Layer 2
                {"identity" /* caleai.core.Neuron 1 */}                                         // caleai.core.Layer 3
        };

        Network network = new Network(length, width, functions, activators);

        double[] datasetA = new double[] {1};
        double[] datasetB = new double[] {1, 1};

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

        int iteration = 100000000;
        double[] objective = new double[] {datasetA[0] + datasetB[0] + datasetB[1]};
        network.learn(objective, null, 1);
        double error = network.getError();
        double[] errors = new double[iteration];
        errors[0] = error;
        int i = 1;

        while (error > 0.0 && i < iteration) {
            datasetA[0] = 1;
            datasetB[0] = 1;
            datasetB[1] = 1;
            objective[0] = datasetA[0] + datasetB[0] + datasetB[1];
            network.feed(new double[][][]{
                    {       // caleai.core.Layer 1
                            datasetA,                                                                                                         // caleai.core.Neuron 1
                            datasetB                                                                                                           // caleai.core.Neuron 2
                    },
                    {        // caleai.core.Layer 2
                            {network.getLayers()[0].getNeurons()[0].getHypothesis(), network.getLayers()[0].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                            {network.getLayers()[0].getNeurons()[0].getHypothesis()}                                                          // caleai.core.Neuron 2
                    },
                    {       // caleai.core.Layer 3
                            {network.getLayers()[1].getNeurons()[0].getHypothesis(), network.getLayers()[1].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                    }
            });

            network.learn(objective, null, i + 1);

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

     /*   int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] objective = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        train(data, objective);*/
    }

    /*static double agent(int x, double error) {
        return x / (error + 1); // Hypothesis.
    }

    static void train(int[] data, int[] objectives) {
        double error = 0;
        double hypothesis;

        for (int i = 0; i < data.length; i++) {
            hypothesis = agent(data[i], error);
            double error0 = Math.abs(hypothesis - objectives[i]); *//*((error * ((i + 1) - 1)) + (hypothesis - objectives[i])) / (i + 1)*//*;
            double error1 = hypothesis / objectives[i];
            error = Math.abs(error0 + error1);
            System.out.println("Agent hypothesis is " + hypothesis + ", error is " + error);
        }
    }*/
}
