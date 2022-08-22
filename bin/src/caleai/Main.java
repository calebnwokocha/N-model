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
        int length = 2;
        int[] width = new int[]{2, 1};
        String[][] functions = new String[][] {
                {"cubic volume" /* caleai.core.Neuron 1 */, "force" /* caleai.core.Neuron 2 */}, // caleai.core.Layer 1
                {"force" /* caleai.core.Neuron 1 *//*, "cubic volume" *//* caleai.core.Neuron 2 */}, // caleai.core.Layer 2
                //{"force" /* caleai.core.Neuron 1 */}                                             // caleai.core.Layer 3
        };

        Network network = new Network(length, width, functions);

        double[] datasetA = new double[] {106};
        double[] datasetB = new double[] {207, 308};

        network.feed(new double[][][]{
                {       // caleai.core.Layer 1
                        datasetA,                                                                                                         // caleai.core.Neuron 1
                        datasetB                                                                                                          // caleai.core.Neuron 2
                },
                {        // caleai.core.Layer 2
                        {network.getLayers()[0].getNeurons()[0].getHypothesis(), network.getLayers()[0].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                        //{network.getLayers()[0].getNeurons()[0].getHypothesis()}                                                          // caleai.core.Neuron 2
                },
                /*{       // caleai.core.Layer 3
                        {network.getLayers()[1].getNeurons()[0].getHypothesis(), network.getLayers()[1].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                }*/
        });

        System.out.println();
        System.out.println("LAYER 1 : caleai.core.Neuron 1: value = " + network.getLayers()[0].getNeurons()[0].getHypothesis() + " error = " + network.getLayers()[0].getNeurons()[0].getNeuronError());
        System.out.println("LAYER 1 : caleai.core.Neuron 2: value = " + network.getLayers()[0].getNeurons()[1].getHypothesis() + " error = " + network.getLayers()[0].getNeurons()[1].getNeuronError());
        System.out.println("LAYER 2 : caleai.core.Neuron 1: value = " + network.getLayers()[1].getNeurons()[0].getHypothesis() + " error = " + network.getLayers()[1].getNeurons()[0].getNeuronError());
        //System.out.println("LAYER 2 : caleai.core.Neuron 2: value = " + network.getLayers()[1].getNeurons()[1].getHypothesis() + " error = " + network.getLayers()[1].getNeurons()[1].getNeuronError());
        //System.out.println("LAYER 3 : caleai.core.Neuron 1: value = " + network.getLayers()[2].getNeurons()[0].getHypothesis() + " error = " + network.getLayers()[2].getNeurons()[0].getNeuronError());

        double learningRate = 0.01;
        int iteration = 10000;
        double[] objective = new double[] {datasetA[0] * datasetB[0] * datasetB[1]};
        network.learn(objective, null, learningRate,  1);
        double error = network.getNetworkError();

        System.out.println("Objective is " + Arrays.toString(objective));
        System.out.println("Error is " + error);

        double[] errors = new double[iteration];
        errors[0] = error;
        int i = 1;

        while (Math.abs(error) > 0.0 && i < iteration) {
            datasetA[0] = 106;
            datasetB[0] = 207;
            datasetB[1] = 308;
            objective[0] = datasetA[0] * datasetB[0] * datasetB[1];
            network.feed(new double[][][]{
                    {       // caleai.core.Layer 1
                            datasetA,                                                                                                         // caleai.core.Neuron 1
                            datasetB                                                                                                          // caleai.core.Neuron 2
                    },
                    {        // caleai.core.Layer 2
                            {network.getLayers()[0].getNeurons()[0].getHypothesis(), network.getLayers()[0].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                            //{network.getLayers()[0].getNeurons()[0].getHypothesis()}                                                          // caleai.core.Neuron 2
                    },
                    /*{       // caleai.core.Layer 3
                            {network.getLayers()[1].getNeurons()[0].getHypothesis(), network.getLayers()[1].getNeurons()[1].getHypothesis()}, // caleai.core.Neuron 1
                    }*/
            });

            network.learn(objective, null, learningRate, i + 1);

            System.out.println();
            System.out.println("LAYER 1 : caleai.core.Neuron 1: value = " + network.getLayers()[0].getNeurons()[0].getHypothesis() + " error = " + network.getLayers()[0].getNeurons()[0].getNeuronError());
            System.out.println("LAYER 1 : caleai.core.Neuron 2: value = " + network.getLayers()[0].getNeurons()[1].getHypothesis() + " error = " + network.getLayers()[0].getNeurons()[1].getNeuronError());
            System.out.println("LAYER 2 : caleai.core.Neuron 1: value = " + network.getLayers()[1].getNeurons()[0].getHypothesis() + " error = " + network.getLayers()[1].getNeurons()[0].getNeuronError());
            //System.out.println("LAYER 2 : caleai.core.Neuron 2: value = " + network.getLayers()[1].getNeurons()[1].getHypothesis() + " error = " + network.getLayers()[1].getNeurons()[1].getNeuronError());
            //System.out.println("LAYER 3 : caleai.core.Neuron 1: value = " + network.getLayers()[2].getNeurons()[0].getHypothesis() + " error = " + network.getLayers()[2].getNeurons()[0].getNeuronError());

            error = network.getNetworkError();
            errors[i] = error;
            System.out.println("Objective is " + Arrays.toString(objective));
            System.out.println("Error is " + error);
            i++;
        } System.out.println("\nRecord of error is:");
        for (double e : errors) { System.out.println( e ); }
    }
}
