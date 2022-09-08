/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai;

import caleai.core.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int iteration = 10;

        // Initialize dataset
        double[][] datasetA = new double[iteration][1];
        double[][] datasetB = new double[iteration][1];
        for (int i = 0; i < datasetA.length; i++) {
            datasetA[i][0] = Math.round(Math.random() + 9.987654321); // Generates 0 or 1
            datasetB[i][0] = Math.round(Math.random() + 9.987654321); // Generates 0 or 1
        }
        //System.out.println("datasetA: " + Arrays.deepToString(datasetA));
        //System.out.println("datasetB: " + Arrays.deepToString(datasetB));

        // Initialize node
        Node node = new Node("force", 1);
        node.activate(datasetA[0][0], datasetB[0][0]);

        //System.out.println();
        //System.out.println("INPUT LAYER : caleai.core.Neuron 1: value = " + node.getHypothesis() + " error = " + node.getErrorMean());
        //System.out.println("INPUT LAYER : caleai.core.Neuron 2: value = " + perceptron.getInputLayer().getNeurons()[1].getHypothesis() + " error = " + perceptron.getInputLayer().getNeurons()[1].getError());
        //System.out.println("OUPUT LAYER : caleai.core.Neuron 1: value = " + perceptron.getOutputNeuron().getHypothesis() + " error = " + perceptron.getOutputNeuron().getError());

        double objective = (datasetA[0][0] + datasetB[0][0]) - ((datasetA[0][0] * datasetB[0][0]) * (1 + datasetA[0][0] + datasetB[0][0] - (datasetA[0][0] * datasetB[0][0])));
        node.optimize(objective, 1);
        double error = node.getErrorMean();

        //System.out.println("Objective is " + objective);
        ///System.out.println("Error is " + error);

        double[] errors = new double[iteration];
        errors[0] = error;
        int i = 1;
        int l = 0;

        for (int j = 0; j < 3; j++) {
            while (Math.abs(error) > 0.0 && i < iteration) {
                node.activate(datasetA[i][0], datasetB[i][0]);
                objective = (datasetA[0][0] + datasetB[0][0]) - ((datasetA[0][0] * datasetB[0][0]) * (1 + datasetA[0][0] + datasetB[0][0] - (datasetA[0][0] * datasetB[0][0])));
                l += i;
                node.optimize(objective, l + 1);
                error = node.getErrorMean();
                System.out.println();
                System.out.println("INPUT LAYER : caleai.core.Neuron 1: value = " + node.getHypothesis() + " error = " + node.getErrorMean() + " rule = " + node.getRule());
                //System.out.println("INPUT LAYER : caleai.core.Neuron 2: value = " + perceptron.getInputLayer().getNeurons()[1].getHypothesis() + " error = " + perceptron.getInputLayer().getNeurons()[1].getError());
                //System.out.println("OUPUT LAYER : caleai.core.Neuron 1: value = " + perceptron.getOutputNeuron().getHypothesis() + " error = " + perceptron.getOutputNeuron().getError());

                error = node.getErrorMean();
                errors[i] = error;
                //System.out.println("Objective is " + objective);
                //System.out.println("Error is " + error);
                i++;
            } //System.out.println("\nRecord of error is:");
            for (double e : errors) { System.out.println( e ); }

            // Shuffle dataset
            List<double[]> pairA = new ArrayList<double[]>();
            List<double[]> pairB = new ArrayList<double[]>();

            pairA.addAll(Arrays.asList(datasetA));
            pairB.addAll(Arrays.asList(datasetB));

            Collections.shuffle(pairA);
            Collections.shuffle(pairB);

            datasetA = new double[iteration][1];
            datasetB = new double[iteration][1];

            for (int k = 0; k < datasetA.length; k++) {
                datasetA[k] = Arrays.stream(pairA.get(k)).toArray();
                datasetB[k] = Arrays.stream(pairB.get(k)).toArray();
            }

            node.activate(datasetA[0][0], datasetB[0][0]);
            objective = (datasetA[0][0] + datasetB[0][0]) - ((datasetA[0][0] * datasetB[0][0]) * (1 + datasetA[0][0] + datasetB[0][0] - (datasetA[0][0] * datasetB[0][0])));
            i = 1;
            l += i;
            node.optimize(objective, l + 1);
           // System.out.println("datasetA: " + Arrays.deepToString(datasetA));
            //System.out.println("datasetB: " + Arrays.deepToString(datasetB));
        }
    }
}