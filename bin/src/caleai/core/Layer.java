/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

public class Layer {
    private Neuron[] neurons;

    // Construct layer.
    public Layer (int dimension, String[] functions) throws WrongInitialization {
        /* The size of functions array must equal to the layer dimension, so that all
         * all neuron in the layer have a comprehensive function.*/
        if (functions.length == dimension) {
            this.neurons = new Neuron[dimension]; // Initialize neurons array to store layer neurons.
            for (int i = 0; i < this.neurons.length; i++) { // Construct layer neurons.
                this.neurons[i] = new Neuron(functions[i]); }
        } else {throw new WrongInitialization("Wrong initialization of layer"); }
    }

    public Neuron[] getNeurons() { return this.neurons; }

    public void setNeurons(Neuron[] neurons) { this.neurons = neurons; }

    public void activate (double[]... parameters) { // Activate all layer neurons.
        for (int i = 0; i < this.neurons.length; i++) { this.neurons[i].activate(parameters[i]); }
    }

    public void optimize (double networkError, double learningRate, int iteration) { // Optimize all layer neurons.
        for (Neuron neuron : this.neurons) { neuron.optimize(networkError, learningRate, iteration); }
    }
}
