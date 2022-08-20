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

        /*int length = 5;
        int[] width = new int[]{2, 3, 4, 2, 1};
        String[][] functions = new String[][] {
                {"cubic volume" *//* caleai.core.Neuron 1 *//*, "force" *//* caleai.core.Neuron 2 *//*}, // caleai.core.Layer 1
                {"force" *//* caleai.core.Neuron 1 *//*, "cubic volume" *//* caleai.core.Neuron 2 *//*, "cubic volume" *//* caleai.core.Neuron 3 *//*}, // caleai.core.Layer 2
                {"force" *//* caleai.core.Neuron 1 *//*, "cubic volume" *//* caleai.core.Neuron 2 *//*, "force" *//* caleai.core.Neuron 3 *//*, "cubic volume" *//* caleai.core.Neuron 4 *//*},  // caleai.core.Layer 3
                {"force" *//* caleai.core.Neuron 1 *//*, "force" *//* caleai.core.Neuron 5 *//*},  // caleai.core.Layer 4
                {"force" *//* caleai.core.Neuron 1 *//*}, // caleai.core.Layer 5
        };
        String[][] activators = new String[][] {
                {"identity" *//* caleai.core.Neuron 1 *//*, "identity" *//* caleai.core.Neuron 2 *//*}, // caleai.core.Layer 1
                {"identity" *//* caleai.core.Neuron 1 *//*, "identity" *//* caleai.core.Neuron 2 *//*, "identity" *//* caleai.core.Neuron 3 *//*}, // caleai.core.Layer 2
                {"identity" *//* caleai.core.Neuron 1 *//*, "identity" *//* caleai.core.Neuron 2 *//*, "identity" *//* caleai.core.Neuron 3 *//*, "identity" *//* caleai.core.Neuron 4 *//*},  // caleai.core.Layer 3
                {"identity" *//* caleai.core.Neuron 1 *//*, "identity" *//* caleai.core.Neuron 2 *//*},  // caleai.core.Layer 4
                {"identity" *//* caleai.core.Neuron 1 *//*} // caleai.core.Layer 5
        };*/

        Network network = new Network(length, width, functions, activators);

        double[] datasetA = new double[] {100};
        double[] datasetB = new double[] {200, 300};

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

        System.out.println();
        System.out.println("LAYER 1 : caleai.core.Neuron 1: value = " + network.getLayers()[0].getNeurons()[0].getHypothesis());
        System.out.println("LAYER 1 : caleai.core.Neuron 2: value = " + network.getLayers()[0].getNeurons()[1].getHypothesis());
        System.out.println("LAYER 2 : caleai.core.Neuron 1: value = " + network.getLayers()[1].getNeurons()[0].getHypothesis());
        System.out.println("LAYER 2 : caleai.core.Neuron 2: value = " + network.getLayers()[1].getNeurons()[1].getHypothesis());
        System.out.println("LAYER 3 : caleai.core.Neuron 1: value = " + network.getLayers()[2].getNeurons()[0].getHypothesis());

        /*network.feed(new double[][][]{
                {       // caleai.core.Layer 1
                        datasetA,                                                                                                         // caleai.core.Neuron 1
                        datasetB                                                                                                          // caleai.core.Neuron 2
                },
                {        // caleai.core.Layer 2
                        {network.getLayers()[0].getNeurons()[0].getHypothesis(), network.getLayers()[0].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                        {network.getLayers()[0].getNeurons()[0].getHypothesis()},                                                         // caleai.core.Neuron 2
                        {network.getLayers()[0].getNeurons()[1].getHypothesis()}                                                          // caleai.core.Neuron 3
                },
                {       // caleai.core.Layer 3
                        {network.getLayers()[1].getNeurons()[0].getHypothesis(), network.getLayers()[1].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                        {network.getLayers()[1].getNeurons()[0].getHypothesis()},                                                         // caleai.core.Neuron 2
                        {network.getLayers()[1].getNeurons()[1].getHypothesis(), network.getLayers()[1].getNeurons()[2].getHypothesis()}, // caleai.core.Neuron 3
                        {network.getLayers()[1].getNeurons()[2].getHypothesis()}                                                          // caleai.core.Neuron 4
                },
                {       // caleai.core.Layer 4
                        {network.getLayers()[2].getNeurons()[0].getHypothesis(), network.getLayers()[2].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                        {network.getLayers()[2].getNeurons()[2].getHypothesis(), network.getLayers()[2].getNeurons()[3].getHypothesis()}, // caleai.core.Neuron 2
                },
                {       // caleai.core.Layer 5
                        {network.getLayers()[3].getNeurons()[0].getHypothesis(), network.getLayers()[3].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                }
        });*/

        double learningRate = 0.1;
        int iteration = 100;
        double[] objective = new double[] {datasetA[0] * datasetB[0] * datasetB[1]};
        network.learn(objective, null, learningRate,  1);
        double error = network.getNetworkError();

        System.out.println("Objective is " + Arrays.toString(objective));
        System.out.println("Error is " + error);

        double[] errors = new double[iteration];
        errors[0] = error;
        int i = 1;

        while (Math.abs(error) > 0.0 && i < iteration) {
            datasetA[0] = 100;
            datasetB[0] = 200;
            datasetB[1] = 300;
            objective[0] = datasetA[0] * datasetB[0] * datasetB[1];
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

            /*network.feed(new double[][][]{
                    {       // caleai.core.Layer 1
                            datasetA,                                                                                                         // caleai.core.Neuron 1
                            datasetB                                                                                                          // caleai.core.Neuron 2
                    },
                    {        // caleai.core.Layer 2
                            {network.getLayers()[0].getNeurons()[0].getHypothesis(), network.getLayers()[0].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                            {network.getLayers()[0].getNeurons()[0].getHypothesis()},                                                         // caleai.core.Neuron 2
                            {network.getLayers()[0].getNeurons()[1].getHypothesis()}                                                          // caleai.core.Neuron 3
                    },
                    {       // caleai.core.Layer 3
                            {network.getLayers()[1].getNeurons()[0].getHypothesis(), network.getLayers()[1].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                            {network.getLayers()[1].getNeurons()[0].getHypothesis()},                                                         // caleai.core.Neuron 2
                            {network.getLayers()[1].getNeurons()[1].getHypothesis(), network.getLayers()[1].getNeurons()[2].getHypothesis()}, // caleai.core.Neuron 3
                            {network.getLayers()[1].getNeurons()[2].getHypothesis()}                                                          // caleai.core.Neuron 4
                    },
                    {       // caleai.core.Layer 4
                            {network.getLayers()[2].getNeurons()[0].getHypothesis(), network.getLayers()[2].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                            {network.getLayers()[2].getNeurons()[2].getHypothesis(), network.getLayers()[2].getNeurons()[3].getHypothesis()}, // caleai.core.Neuron 2
                    },
                    {       // caleai.core.Layer 5
                            {network.getLayers()[3].getNeurons()[0].getHypothesis(), network.getLayers()[3].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                    }
            });*/

            network.learn(objective, null, learningRate, i + 1);

            System.out.println();
            System.out.println("LAYER 1 : caleai.core.Neuron 1: value = " + network.getLayers()[0].getNeurons()[0].getHypothesis());
            System.out.println("LAYER 1 : caleai.core.Neuron 2: value = " + network.getLayers()[0].getNeurons()[1].getHypothesis());
            System.out.println("LAYER 2 : caleai.core.Neuron 1: value = " + network.getLayers()[1].getNeurons()[0].getHypothesis());
            System.out.println("LAYER 2 : caleai.core.Neuron 2: value = " + network.getLayers()[1].getNeurons()[1].getHypothesis());
            System.out.println("LAYER 3 : caleai.core.Neuron 1: value = " + network.getLayers()[2].getNeurons()[0].getHypothesis());

            /*System.out.println();
            System.out.println("LAYER 1 : caleai.core.Neuron 1: value = " + network.getLayers()[0].getNeurons()[0].getHypothesis());
            System.out.println("LAYER 1 : caleai.core.Neuron 2: value = " + network.getLayers()[0].getNeurons()[1].getHypothesis());
            System.out.println("LAYER 2 : caleai.core.Neuron 1: value = " + network.getLayers()[1].getNeurons()[0].getHypothesis());
            System.out.println("LAYER 2 : caleai.core.Neuron 2: value = " + network.getLayers()[1].getNeurons()[1].getHypothesis());
            System.out.println("LAYER 2 : caleai.core.Neuron 3: value = " + network.getLayers()[1].getNeurons()[2].getHypothesis());
            System.out.println("LAYER 3 : caleai.core.Neuron 1: value = " + network.getLayers()[2].getNeurons()[0].getHypothesis());
            System.out.println("LAYER 3 : caleai.core.Neuron 2: value = " + network.getLayers()[2].getNeurons()[1].getHypothesis());
            System.out.println("LAYER 3 : caleai.core.Neuron 3: value = " + network.getLayers()[2].getNeurons()[2].getHypothesis());
            System.out.println("LAYER 3 : caleai.core.Neuron 4: value = " + network.getLayers()[2].getNeurons()[3].getHypothesis());
            System.out.println("LAYER 4 : caleai.core.Neuron 1: value = " + network.getLayers()[3].getNeurons()[0].getHypothesis());
            System.out.println("LAYER 4 : caleai.core.Neuron 2: value = " + network.getLayers()[3].getNeurons()[1].getHypothesis());
            System.out.println("LAYER 5 : caleai.core.Neuron 1: value = " + network.getLayers()[4].getNeurons()[0].getHypothesis());*/

            error = network.getNetworkError();
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
