/*
package caleai.core;

public class Network {
    private Layer[] layers;
    private double networkError;

    // Construct network.
    public Network (int length, int[] width, String[][] functions) throws WrongInitialization {
        */
/* The size of perceptron width, and functions array must equal to the perceptron length, so that all
         * all layer in the perceptron have a width/dimension, and comprehensive functions.*//*

        if (width.length == length && functions.length == length) {
            this.layers = new Layer[length]; // Initialize layers array to store perceptron layers.
            for (int i = 0; i < layers.length; i++) { // Construct perceptron layers.
                layers[i] = new Layer(width[i], functions[i]); }
        } else {throw new WrongInitialization("Wrong initialization of perceptron"); }
    }

    public Layer[] getLayers () { return this.layers; }

    public void setLayer (Layer[] layers) { this.layers = layers; }

    public double getNetworkError() { return this.networkError; }

    public void feed (double[][]... input) { // Activate all perceptron layers.
        for (int i = 0; i < this.layers.length; i++) { this.layers[i].activate(input[i]); }
    }

    public void learn (double[] objective, Double networkError, double learningRate, int iteration)
            throws UndefinedTarget {
        this.setNetworkError(objective, networkError); // Calculate perceptron error.
        for (Layer layer : layers) { // Optimize all perceptron layers.
            layer.optimize(this.networkError, learningRate, iteration); }
    }

    private void setNetworkError(double[] objective, Double networkError) throws UndefinedTarget {
        if (objective == null && networkError != null) { this.networkError = networkError;
        } else if (objective != null && networkError == null) {
            Layer outputLayer = layers[layers.length - 1]; double sum = 0.0;
            for (int i = 0; i < outputLayer.getNeurons().length; i++) {
                double hypothesis = outputLayer.getNeurons()[i].getHypothesis();
                sum += Math.abs(outputLayer.getNeurons()[i].getHypothesis() - objective[i]);
                //sum += outputLayer.getNeurons()[i].getHypothesis() - objective[i];
                //sum += ((objective[i] * hypothesis) - Math.pow(objective[i], 2) - hypothesis) / (objective[i] + 1);
                //sum += Math.abs(((objective[i] * hypothesis) - Math.pow(objective[i], 2) - hypothesis) / (objective[i] + 1));
            } this.networkError = sum / outputLayer.getNeurons().length;
        } else {
            throw new UndefinedTarget("caleai.core.Perceptron target undefined");
            // TODO: Network should begin reinforcement learning.
        }
    }
}
*/
