/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

public class Perceptron {
    private final Layer inputLayer;
    private final Neuron outputNeuron;
    private double error;

    // Construct network.
    public Perceptron(int inputDimension, String[] inputFunctions, String outputFunction) throws WrongInitialization {
        /* The size of perceptron inputDimension, and inputFunctions array must equal to 2, so that all
         * layers in the perceptron have a inputDimension/dimension and comprehensive function.*/
        if (inputFunctions.length == inputDimension) {
            this.inputLayer = new Layer(inputDimension, inputFunctions); // Initialize layers array to store perceptron layers.
            this.outputNeuron = new Neuron(outputFunction);
        } else {throw new WrongInitialization("Wrong initialization of perceptron"); }
    }

    public Layer getInputLayer() { return this.inputLayer; }

    public Neuron getOutputNeuron() { return this.outputNeuron; }

    public double getError() { return this.error; }

    public void feed (double[][] inputParameter, double[] outputParameter) { // Activate all perceptron layers.
        // TODO: Add wrong input exception. i.e., if input size is more than 2.
       this.inputLayer.activate(inputParameter);
       this.outputNeuron.activate(outputParameter);
    }

    public void learn (double objective, Double networkError, double learningRate, int iteration)
            throws UndefinedTarget {
        this.setError(objective, networkError); // Calculate perceptron error.
        outputNeuron.optimize(1.0, this.error, learningRate, iteration);
        inputLayer.optimize(this.outputNeuron.getHypothesis(), this.error, learningRate, iteration);
    }

    private void setError(Double objective, Double error) throws UndefinedTarget {
        if (objective == null && error != null) { this.error = error;
        } else if (objective != null && error == null) {
            this.error = Math.pow(this.outputNeuron.getHypothesis() - objective, 2);
        } else {
            throw new UndefinedTarget("caleai.core.Perceptron target undefined");
            // TODO: Perceptron should begin reinforcement learning.
        }
    }
}