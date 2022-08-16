/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

public class Layer {
    private Neuron[] neurons;

    public Layer (int dimension, String[] functions, String[] activations) throws WrongInitialization {
        if (functions.length == dimension && activations.length == dimension) {
            this.neurons = new Neuron[dimension];
            for (int i = 0; i < this.neurons.length; i++) { this.neurons[i] = new Neuron(functions[i], activations[i]); }
        } else {throw new WrongInitialization("Wrong initialization of layer"); }
    }

    public Neuron[] getNeurons() { return this.neurons; }

    public void setNeurons(Neuron[] neurons) { this.neurons = neurons; }

    public void activate (double[]... parameters) {
        for (int i = 0; i < this.neurons.length; i++) { this.neurons[i].activate(parameters[i]); }
    }

    public void optimize (double error) { for (Neuron neuron : this.neurons) { neuron.optimize(error); } }
}
