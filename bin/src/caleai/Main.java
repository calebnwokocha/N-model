/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai;

import caleai.core.Perceptron;
import caleai.core.UndefinedTarget;
import caleai.core.WrongInitialization;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws WrongInitialization, UndefinedTarget {
        int inputDimension = 2;
        String[] inputFunctions = new String[]{"cubic volume" /* caleai.core.Neuron 1 */, "force" /* caleai.core.Neuron 2 */}; // caleai.core.Layer 1
        String outputFunction = "sum";

        Perceptron perceptron = new Perceptron(inputDimension, inputFunctions, outputFunction);

        double[] datasetA = new double[] {106};
        double[] datasetB = new double[] {207, 308};

        perceptron.feed(new double[][]{       // caleai.core.Layer 1
                        datasetA,                                                                                                         // caleai.core.Neuron 1
                        datasetB                                                                                                          // caleai.core.Neuron 2
                },

                new double[] {perceptron.getInputLayer().getNeurons()[0].getHypothesis(), perceptron.getInputLayer().getNeurons()[1].getHypothesis()} // caleai.core.Neuron 1
        );

        System.out.println();
        System.out.println("INPUT LAYER : caleai.core.Neuron 1: value = " + perceptron.getInputLayer().getNeurons()[0].getHypothesis() + " error = " + perceptron.getInputLayer().getNeurons()[0].getError());
        System.out.println("INPUT LAYER : caleai.core.Neuron 2: value = " + perceptron.getInputLayer().getNeurons()[1].getHypothesis() + " error = " + perceptron.getInputLayer().getNeurons()[1].getError());
        System.out.println("OUPUT LAYER : caleai.core.Neuron 1: value = " + perceptron.getOutputNeuron().getHypothesis() + " error = " + perceptron.getOutputNeuron().getError());

        double learningRate = 12;
        int iteration = 10280;
        double objective = datasetA[0] + datasetB[0] + datasetB[1];
        perceptron.learn(objective, null, learningRate,  1);
        double error = perceptron.getError();

        System.out.println("Objective is " + objective);
        System.out.println("Error is " + error);

        double[] errors = new double[iteration];
        errors[0] = error;
        int i = 1;

        while (Math.abs(error) > 1.0 && i < iteration) {
            datasetA[0] = 106;
            datasetB[0] = 207;
            datasetB[1] = 308;
            objective = datasetA[0] + datasetB[0] + datasetB[1];
            perceptron.feed(new double[][]{       // caleai.core.Layer 1
                            datasetA,                                                                                                         // caleai.core.Neuron 1
                            datasetB                                                                                                          // caleai.core.Neuron 2
                    },

                    new double[] {perceptron.getInputLayer().getNeurons()[0].getHypothesis(), perceptron.getInputLayer().getNeurons()[1].getHypothesis()} // caleai.core.Neuron 1
            );

            perceptron.learn(objective, null, learningRate, i + 1);

            System.out.println();
            System.out.println("INPUT LAYER : caleai.core.Neuron 1: value = " + perceptron.getInputLayer().getNeurons()[0].getHypothesis() + " error = " + perceptron.getInputLayer().getNeurons()[0].getError());
            System.out.println("INPUT LAYER : caleai.core.Neuron 2: value = " + perceptron.getInputLayer().getNeurons()[1].getHypothesis() + " error = " + perceptron.getInputLayer().getNeurons()[1].getError());
            System.out.println("OUPUT LAYER : caleai.core.Neuron 1: value = " + perceptron.getOutputNeuron().getHypothesis() + " error = " + perceptron.getOutputNeuron().getError());

            error = perceptron.getError();
            errors[i] = error;
            System.out.println("Objective is " + objective);
            System.out.println("Error is " + error);
            i++;
        } System.out.println("\nRecord of error is:");
        for (double e : errors) { System.out.println( e ); }
    }
}