package caleai;/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

public class Node {
    private String function;
    private double power;
    private double hypothesis;
    private double thesis;
    private double errorMean = 1.0;
    private double minimumPower = -1.0; // Default
    private double maximumPower = 2.0; // Default

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
        this.minimumPower = minimumPower;
        this.maximumPower = maximumPower;
        this.setPower();
    }

    public Node (String function, double minimumPower, double maximumPower) {
        this.function = function;
        this.minimumPower = minimumPower;
        this.maximumPower = maximumPower;
        this.setPower();
    }

    public Node(String function, double power) {
        this.function = function; // The name of neuron comprehensive function.
        this.power = power;
    }

    public String getFunction() { return this.function; }

    public void setFunction(String function) { this.function = function; }

    public double getHypothesis() { return this.hypothesis; }

    public double getThesis() { return this.thesis; }

    public double getErrorMean() { return this.errorMean; }

    public double getMinimumPower() { return this.minimumPower; }

    public void setMinimumPower(double minimumPower) { this.minimumPower = minimumPower; }

    public double getMaximumPower() { return this.maximumPower; }

    public void setMaximumPower(double maximumPower) { this.maximumPower = maximumPower; }

    public double getPower() { return this.power; }

    public void setPower(double power) { this.power = power; }

    public void setPower() {
        // Generates stochastic power for p where minimumPower=>p<0.0 and 0.0<p<=maximumPower
        this.power = ((Math.random() * ((this.maximumPower - 1.0) - this.minimumPower + 1)) + this.minimumPower) + 0.1;
    }

    public void activate (double parameter) { // Activate neuron, use parameters for comprehensive function.
        CFunction cFunction = new CFunction(this.function, parameter); // Construct comprehensive function.
        this.hypothesis = cFunction.getValue();
        this.thesis = this.hypothesis - errorMean; // Subtract the neuron error from it hypothesis.
    }

    public void activate (double... parameters) { // Activate neuron, use parameters for comprehensive function.
        CFunction cFunction = new CFunction(this.function, parameters); // Construct comprehensive function.
        this.hypothesis = cFunction.getValue();
        this.thesis = this.hypothesis - errorMean; // Subtract the neuron error from it hypothesis.
    }

    public void optimize (double objective, int iteration) {
        double error = this.thesis - objective;
        // Update neuron error to average neuron error.
        this.errorMean = this.dynamicPowerMean(this.errorMean, error, this.power, iteration);
    }

    public void optimize (int iteration, double error) {
        // Update neuron error to average neuron error.
        this.errorMean = this.dynamicPowerMean(this.errorMean, error, this.power, iteration);
    }

    private String getRule () {
        double probability = this.thesis / (this.thesis + this.errorMean);
        return this.function + " at probability " + probability;
    }

    private double dynamicPowerMean(double m, double d, double p, int t) {
        m = (Math.pow((1.0 / (t)) * (Math.pow(d, p) + (Math.pow(m, p) * (t - 1))), 1.0 / p));
        return m;
    }
}