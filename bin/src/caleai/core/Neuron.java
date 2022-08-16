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
    private double error;
    private String rule;

    public Neuron(String function, String activator) {
        this.function = function;
        this.activator = activator;
        this.error = 0.0;
    }

    public String getFunction() { return this.function; }

    public void setFunction(String function) { this.function = function; }

    public String getActivator() { return this.activator; }

    public void setActivator(String activator) { this.activator = activator; }

    public double getHypothesis() { return this.hypothesis; }

    public String getRule() { return this.rule; }

    public double getError() { return this.error; }

    public void setError(double error) { this.error = error; }

    public void activate (double... parameters) { // Activate neuron, use parameters for comprehensive function.
        Function function = new Function(this.function, parameters);
        double value = function.getValue(); // Result of comprehensive function.
        switch (this.activator) { // Find activation function, and initialize neuron value.
            case "identity" -> this.hypothesis = this.identity(value);
            case "tanh" -> this.hypothesis = this.tanh(value);
        } this.hypothesis -= this.error;
    }

    public void optimize (double error) { this.error += this.hypothesis / error; }

    private double identity (double x) { return x; }

    private double tanh (double x) { return (2 / (1 + Math.pow(Math.E, -(2 * x)))) - 1; }
}
