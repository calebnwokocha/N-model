/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

public class Node {
    private String function;
    private double power;
    private double hypothesis = 1.0;
    private double errorMean = 0.0;
    private final String rule = null;

    // Construct neuron.
    public Node(String function, double power) {
        this.function = function; // The name of neuron comprehensive function.
        this.power = power;
    }

    public String getFunction() { return this.function; }

    public void setFunction(String function) { this.function = function; }

    public double getPower() { return this.power; }

    public void setPower(double power) { this.power = power; }

    public double getHypothesis() { return this.hypothesis; }

    public String getRule() { return this.rule; }

    public double getErrorMean() { return this.errorMean; }

    public void activate (double parameter) { // Activate neuron, use parameters for comprehensive function.
        Function function = new Function(this.function, parameter); // Construct comprehensive function.
        this.hypothesis = function.getValue() - errorMean; // Subtract the neuron error from it hypothesis.
    }

    public void activate (double... parameters) { // Activate neuron, use parameters for comprehensive function.
        Function function = new Function(this.function, parameters); // Construct comprehensive function.
        this.hypothesis = function.getValue() - errorMean; // Subtract the neuron error from it hypothesis.
    }

    public void optimize (double objective, int iteration) {
        double error = Math.abs(this.hypothesis - objective);
        // Update neuron error to average neuron error.
        this.errorMean = this.powerMean(this.errorMean, error, this.power, iteration) * 0.1;
    }

    public void optimize (int iteration, double error) {
        // Update neuron error to average neuron error.
        this.errorMean = this.powerMean(this.errorMean, error, this.power, iteration);
    }

    private double powerMean (double m, double d, double p, int t) {
        m = (Math.pow((1.0 / (t)) * (Math.pow(d, p) + (Math.pow(m, p) * (t - 1))), 1.0 / p));
        return m;
    }
}