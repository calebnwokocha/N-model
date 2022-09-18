/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai;

import caleai.core.Data;
import caleai.core.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        /*int iteration = 100;

        // Initialize dataset
        byte[][] datasetA = new byte[iteration][1];
        byte[][] datasetB = new byte[iteration][1];
        for (int i = 0; i < datasetA.length; i++) {
            datasetA[i][0] = (byte) (Math.random() + Math.random()); // Generates 0 or 1
            datasetB[i][0] = (byte) (Math.random() + Math.random()); // Generates 0 or 1
        }
        //System.out.println("datasetA: " + Arrays.deepToString(datasetA));
        //System.out.println("datasetB: " + Arrays.deepToString(datasetB));

        // Initialize node1
        Node node1 = new Node("force", 1); // Learning rate range from -248 to -0.1 and from 0.1 to 76
        node1.activate(datasetA[0][0], datasetB[0][0]);

        Node node2 = new Node("cublic volume", 1);

        //System.out.println();
        //System.out.println("INPUT LAYER : caleai.core.Neuron 1: value = " + node1.getHypothesis() + " error = " + node1.getErrorMean());
        //System.out.println("INPUT LAYER : caleai.core.Neuron 2: value = " + perceptron.getInputLayer().getNeurons()[1].getHypothesis() + " error = " + perceptron.getInputLayer().getNeurons()[1].getError());
        //System.out.println("OUPUT LAYER : caleai.core.Neuron 1: value = " + perceptron.getOutputNeuron().getHypothesis() + " error = " + perceptron.getOutputNeuron().getError());

        double objective = (datasetA[0][0] + 200 + datasetB[0][0]) - ((datasetA[0][0] * datasetB[0][0]) * (1 + datasetA[0][0] + datasetB[0][0] - (datasetA[0][0] * datasetB[0][0])));
        node1.optimize(objective, 1);
        double error = node1.getErrorMean();

        //System.out.println("Objective is " + objective);
        //System.out.println("Error is " + error);

        double[] errors = new double[iteration];
        errors[0] = error;
        int i = 1;
        int l = 0;

        for (int j = 0; j < 3; j++) {
            while (Math.abs(error) > 0.0 && i < iteration) {
                node1.activate(datasetA[i][0], datasetB[i][0]);
                objective = (datasetA[i][0] + 200 + datasetB[i][0]) - ((datasetA[i][0] * datasetB[i][0]) * (1 + datasetA[i][0] + datasetB[i][0] - (datasetA[i][0] * datasetB[i][0])));
                l += i;
                node1.optimize(objective, l + 1);
                error = node1.getErrorMean();
                //System.out.println();
                //System.out.println("INPUT LAYER : caleai.core.Neuron 1: value = " + node1.getHypothesis() + " error = " + node1.getErrorMean() + " rule = " + node1.getRule());
                //System.out.println("INPUT LAYER : caleai.core.Neuron 2: value = " + perceptron.getInputLayer().getNeurons()[1].getHypothesis() + " error = " + perceptron.getInputLayer().getNeurons()[1].getError());
                //System.out.println("OUPUT LAYER : caleai.core.Neuron 1: value = " + perceptron.getOutputNeuron().getHypothesis() + " error = " + perceptron.getOutputNeuron().getError());

                error = node1.getErrorMean();
                errors[i] = error;
                //System.out.println("Objective is " + objective);
                //System.out.println("Error is " + error);
                i++;
            } //System.out.println("\nRecord of error is:");
            for (double e : errors) { System.out.println( e ); }*/

/*            // Shuffle dataset
            List<double[]> pairA = new ArrayList<double[]>();
            List<double[]> pairB = new ArrayList<double[]>();

            pairA.addAll(Arrays.asList((byte[]) datasetA));
            pairB.addAll(Arrays.asList((byte[]) datasetB));

            Collections.shuffle(pairA);
            Collections.shuffle(pairB);

            datasetA = new byte[iteration][1];
            datasetB = new byte[iteration][1];

            for (int k = 0; k < datasetA.length; k++) {
                datasetA[k] = Arrays.stream(pairA.get(k)).toByte();
                datasetB[k] = Arrays.stream(pairB.get(k)).toArray();
            }*/
/*
            node1.activate(datasetA[0][0], datasetB[0][0]);
            objective = (datasetA[0][0] + 200 + datasetB[0][0]) - ((datasetA[0][0] * datasetB[0][0]) * (1 + datasetA[0][0] + datasetB[0][0] - (datasetA[0][0] * datasetB[0][0])));
            i = 1;
            l += i;
            node1.optimize(objective, l + 1);*/
           // System.out.println("datasetA: " + Arrays.deepToString(datasetA));
            //System.out.println("datasetB: " + Arrays.deepToString(datasetB));

        /*Data data = null;
        {
            try {
                data = new Data("bin/src/caleai/core/Instant Coffee.mp4");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Arrays.toString(data.getData()));*/
    }
}