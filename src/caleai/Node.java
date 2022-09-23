package caleai;/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

public class Node {
    private String functionName;
    private double power;
    private double hypothesis = 1.0;
    private double errorMean = 1.0;
    private String rule = null;

    // Construct neuron.
    public Node () {
        this.functionName = "sum";
        this.setPower();
    }

    public Node (String functionName) {
        this.functionName = functionName;
        this.setPower();
    }

    public Node (double power) {
        this.functionName = "sum";
        this.power = power;
    }

    public Node (double minimumPower, double maximumPower) {
        this.functionName = "sum";
        this.setPower(minimumPower, maximumPower);
    }

    public Node (String functionName, double minimumPower, double maximumPower) {
        this.functionName = functionName;
        this.setPower(minimumPower, maximumPower);
    }

    public Node(String functionName, double power) {
        this.functionName = functionName; // The name of neuron comprehensive function.
        this.power = power;
    }

    public String getFunctionName() { return this.functionName; }

    public void setFunctionName(String functionName) { this.functionName = functionName; }

    public double getPower() { return this.power; }

    public double getHypothesis() { return this.hypothesis; }

    public String getRule() { setRule(); return this.rule; }

    public double getErrorMean() { return this.errorMean; }

    public void setPower(double power) { this.power = power; }

    public void setPower() {
        // Generates stochastic power for -1.0=>p<0.0 and 0.0<p<=2.0
        this.power = ((Math.random() * (1.0 - (-1.0) + 1)) + (-1.0)) + 0.1;
    }

    public void setPower(double minimumPower, double maximumPower) {
        // Generates stochastic power for minimumPower=>p<0.0 and 0.0<p<=maximumPower
        this.power = ((Math.random() * (maximumPower - minimumPower + 1)) + minimumPower) + 0.1;
    }

    public void activate (byte parameter) { // Activate neuron, use parameters for comprehensive function.
        CFunction cFunction = new CFunction(this.functionName, parameter); // Construct comprehensive function.
        this.hypothesis = Math.abs(cFunction.getValue() - errorMean); // Subtract the neuron error from it hypothesis.
    }

    public void activate (byte... parameters) { // Activate neuron, use parameters for comprehensive function.
        CFunction cFunction = new CFunction(this.functionName, parameters); // Construct comprehensive function.
        this.hypothesis = Math.abs(cFunction.getValue() - errorMean); // Subtract the neuron error from it hypothesis.
    }

    public void optimize (double objective, int iteration) {
        double error = Math.abs(this.hypothesis - objective);
        // Update neuron error to average neuron error.
        this.errorMean = this.powerMean(this.errorMean, error, this.power, iteration);
    }

    public void optimize (int iteration, double error) {
        // Update neuron error to average neuron error.
        this.errorMean = this.powerMean(this.errorMean, error, this.power, iteration);
    }

    private void setRule () {
        double probability = this.hypothesis / (this.hypothesis + this.errorMean);
        this.rule = this.functionName + " at probability " + probability;
    }

    private double powerMean (double m, double d, double p, int t) {
        m = (Math.pow((1.0 / (t)) * (Math.pow(d, p) + (Math.pow(m, p) * (t - 1))), 1.0 / p));
        return m;
    }
}