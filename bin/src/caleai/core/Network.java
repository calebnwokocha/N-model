/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

public class Network {
    private Layer[] layers;
    private double networkError;

    // Construct network.
    public Network (int length, int[] width, String[][] functions, String[][] activators) throws WrongInitialization {
        /* The size of network width, functions and activators arrays, must equal to the network length, so that all
         * all layer in the network have a width/dimension, comprehensive functions, and activators.*/
        if (width.length == length && functions.length == length && activators.length == length) {
            this.layers = new Layer[length]; // Initialize layers array to store network layers.
            for (int i = 0; i < layers.length; i++) { // Construct network layers.
                layers[i] = new Layer(width[i], functions[i], activators[i]); }
        } else {throw new WrongInitialization("Wrong initialization of network"); }
    }

    public Layer[] getLayers () { return this.layers; }

    public void setLayer (Layer[] layers) { this.layers = layers; }

    public double getNetworkError() { return this.networkError; }

    public void feed (double[][]... input) { // Activate all network layers.
        for (int i = 0; i < this.layers.length; i++) { this.layers[i].activate(input[i]); }
    }

    public void learn (double[] objective, Double networkError, int iteration) throws UndefinedTarget {
        this.setError(objective, networkError); // Calculate network error.
        for (Layer layer : layers) { // Optimize all network layers.
            layer.optimize(this.networkError, iteration); }
    }

    private void setError(double[] objective, Double networkError) throws UndefinedTarget {
        if (objective == null && networkError != null) { this.networkError = networkError;
        } else if (objective != null && networkError == null) {
            Layer outputLayer = layers[layers.length - 1]; double sum = 0.0;
            for (int i = 0; i < outputLayer.getNeurons().length; i++) {
                sum += Math.abs(outputLayer.getNeurons()[i].getHypothesis() - objective[i]);
            } this.networkError = sum / outputLayer.getNeurons().length;
        } else { throw new UndefinedTarget("caleai.core.Network target undefined"); }
    }
}
