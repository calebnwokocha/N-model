/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

public class Neuron {
    private String function;
    private double hypothesis;
    private double error;
    private final String rule;

    // Construct neuron.
    public Neuron(String function/*, String activator*/) {
        this.function = function; // The name of neuron comprehensive function.
        this.error = 0.0; // Initial neuron error is zero.
        this.hypothesis = 1.0; // Initial hypothesis is zero.
        this.rule = null; // Initial rule is null.
    }

    public String getFunction() { return this.function; }

    public void setFunction(String function) { this.function = function; }

    public double getHypothesis() { return this.hypothesis; }

    public String getRule() { return this.rule; }

    public double getError() { return this.error; }

    public void setError(double error) { this.error = error; }

    public void activate (double... parameters) { // Activate neuron, use parameters for comprehensive function.
        Function function = new Function(this.function, parameters); // Construct comprehensive function.
        this.hypothesis = function.getValue() - error; // Subtract the neuron error from it hypothesis.
    }

    public void optimize (double perceptronHypothesis, double perceptronError, double learningRate, int iteration) { // Update neuron error to average neuron error.
        this.error = Math.pow((1.0 / (iteration)) * (Math.pow((this.hypothesis * perceptronError) / perceptronError, learningRate) +
                (Math.pow(this.error, learningRate) * (iteration - 1))), 1.0 / learningRate);
        //this.error = (((this.error * (iteration - 1)) + ((this.hypothesis * perceptronError) / perceptronError)) / iteration) * learningRate;
    }
}