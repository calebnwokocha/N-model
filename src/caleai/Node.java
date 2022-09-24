package caleai;/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

public class Node {
    private String function;
    private double power;
    private double hypothesis /*= 1.0*/;
    private double thesis /*= 1.0*/;
    private double errorMean = 1.0;

    // Construct neuron.
    public Node () {
        this.function = "sum";
        this.setPower();
    }

    public Node (String function) {
        this.function = function;
        this.setPower();
    }

    public Node (double power) {
        this.function = "sum";
        this.power = power;
    }

    public Node (double minimumPower, double maximumPower) {
        this.function = "sum";
        this.setPower(minimumPower, maximumPower);
    }

    public Node (String function, double minimumPower, double maximumPower) {
        this.function = function;
        this.setPower(minimumPower, maximumPower);
    }

    public Node(String function, double power) {
        this.function = function; // The name of neuron comprehensive function.
        this.power = power;
    }

    public String getFunction() { return this.function; }

    public void setFunction(String function) { this.function = function; }

    public double getPower() { return this.power; }

    public double getHypothesis() { return this.hypothesis; }

    public double getThesis() { return this.thesis; }

    public double getErrorMean() { return this.errorMean; }

    public void setPower(double power) { this.power = power; }

    public void setPower() {
        double maximumPower = 2.0;
        double minimumPower = -1.0;
        // Generates stochastic power for p where -1.0=>p<0.0 and 0.0<p<=2.0
        this.power = ((Math.random() * ((maximumPower - 1.0) - minimumPower + 1)) + minimumPower) + 0.1;
    }

    public void setPower(double minimumPower, double maximumPower) {
        // Generates stochastic power for p where minimumPower=>p<0.0 and 0.0<p<=maximumPower
        this.power = ((Math.random() * ((maximumPower - 1.0) - minimumPower + 1)) + minimumPower) + 0.1;
    }

    public void activate (byte parameter) { // Activate neuron, use parameters for comprehensive function.
        CFunction cFunction = new CFunction(this.function, parameter); // Construct comprehensive function.
        this.hypothesis = cFunction.getValue();
        this.thesis = Math.abs(this.hypothesis - errorMean); // Subtract the neuron error from it hypothesis.
    }

    public void activate (byte... parameters) { // Activate neuron, use parameters for comprehensive function.
        CFunction cFunction = new CFunction(this.function, parameters); // Construct comprehensive function.
        this.hypothesis = cFunction.getValue();
        this.thesis = Math.abs(this.hypothesis - errorMean); // Subtract the neuron error from it hypothesis.
    }

    public void optimize (double objective, int iteration) {
        double error = Math.abs(this.thesis - objective);
        // Update neuron error to average neuron error.
        this.errorMean = this.powerMean(this.errorMean, error, this.power, iteration);
    }

    public void optimize (int iteration, double error) {
        // Update neuron error to average neuron error.
        this.errorMean = this.powerMean(this.errorMean, error, this.power, iteration);
    }

    private String getRule () {
        double probability = this.thesis / (this.thesis + this.errorMean);
        return this.function + " at probability " + probability;
    }

    private double powerMean (double m, double d, double p, int t) {
        m = (Math.pow((1.0 / (t)) * (Math.pow(d, p) + (Math.pow(m, p) * (t - 1))), 1.0 / p));
        return m;
    }
}