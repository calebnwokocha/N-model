/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

public class Neuron {
    private String function;
    private String activator;
    private double hypothesis;
    private double neuronError;
    private final String rule;

    // Construct neuron.
    public Neuron(String function, String activator) {
        this.function = function; // The name of neuron comprehensive function.
        this.activator = activator; // Then name of neuron activation function.
        this.neuronError = 0.0; // Initial neuron error is zero.
        this.hypothesis = Math.random(); // Initial hypothesis is random.
        this.rule = null; // Initial rule is null.
    }

    public String getFunction() { return this.function; }

    public void setFunction(String function) { this.function = function; }

    public String getActivator() { return this.activator; }

    public void setActivator(String activator) { this.activator = activator; }

    public double getHypothesis() { return this.hypothesis; }

    public String getRule() { return this.rule; }

    public double getNeuronError() { return this.neuronError; }

    public void setNeuronError(double neuronError) { this.neuronError = neuronError; }

    public void activate (double... parameters) { // Activate neuron, use parameters for comprehensive function.
        Function function = new Function(this.function, parameters); // Construct comprehensive function.
        double value = function.getValue(); // Result of comprehensive function.
        switch (this.activator) { // Find activation function, then update neuron hypothesis.
            case "identity" -> this.hypothesis = this.identity(value);
            case "tanh" -> this.hypothesis = this.tanh(value);
        } this.hypothesis -= this.neuronError; // Subtract error from hypothesis.
    }

    public void optimize (double networkError, int iteration) { // Update neuron error to average neuron error.
        this.neuronError = ((this.neuronError * (iteration - 1)) + (this.hypothesis / networkError)) / iteration;
    }

    private double identity (double x) { return x; }

    private double tanh (double x) { return (2 / (1 + Math.pow(Math.E, -(2 * x)))) - 1; }
}
