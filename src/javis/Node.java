/*=======================================================================
 Javis is an open-source software framework for comprehensive learning.
 Copyright (C) 2022 Caleb Princewill Nwokocha

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published
 by the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program. If not, see <https://www.gnu.org/licenses/>.

 Contact calebnwokocha@gmail.com for special permission to use this software.
=========================================================================*/

package javis;

/**
 * Node class consist of functions and methods for operations on a comprehensive node.
 */
public class Node {
    private String functionName; private double power;
    private double hypothesis; private double thesis;
    private double meanError = 0.0; // Default
    private double minPower = -1.0; // Default
    private double maxPower = 2.0; // Default

    /**
     * This constructs a comprehensive node without manually setting parameters.
     * The node comprehensive function is automatically set to "sum", and the
     * power of the node is automatically configured by setPower().
     */
    public Node () { this.functionName = "sum"; this.setPower(); }

    /**
     * This constructs a comprehensive node by manually setting its comprehensive function as argument.
     * The node power is automatically configured by setPower().
     */
    public Node (String functionName) { this.functionName = functionName; this.setPower(); }

    /**
     * This constructs a comprehensive node by manually setting its power as argument.
     * The node comprehensive function is automatically set to "sum".
     */
    public Node (double power) { this.functionName = "sum"; this.power = power; }

    /**
     * This constructs a comprehensive node by manually setting its minimum and maximum power as argument.
     * The actual power of the node is automatically configure by setPower(), and the comprehensive
     * function of the node is automatically set to "sum".
     */
    public Node (double minPower, double maxPower) {
        this.functionName = "sum"; this.minPower = minPower; this.maxPower = maxPower; this.setPower();
    }

    /**
     * This constructs a comprehensive node by manually setting its parameters as arguments.
     * The node comprehensive function, and minimum and maximum power are configured manually,
     * and the power of the constructed node is automatically configure by setPower().
     */
    public Node (String functionName, double minPower, double maxPower) {
        this.functionName = functionName; this.minPower = minPower; this.maxPower = maxPower; this.setPower();
    }

    /**
     * This constructs a comprehensive node by manually setting its parameters as argument.
     * The node comprehensive function and power are configured manually.
     */
    public Node(String functionName, double power) { this.functionName = functionName; this.power = power; }

    /**
     * This returns the node comprehensive function name.
     */
    public String getFunctionName() { return this.functionName; }

    /**
     * This configures the node comprehensive function name.
     */
    public void setFunctionName(String functionName) { this.functionName = functionName; }

    /**
     * This returns the node hypothesis.
     */
    public double getHypothesis() { return this.hypothesis; }

    /**
     * This returns the node thesis.
     */
    public double getThesis() { return this.thesis; }

    /**
     * This returns the node mean error.
     */
    public double getMeanError() { return this.meanError; }

    /**
     * This returns the node minimum power.
     */
    public double getMinPower() { return this.minPower; }

    /**
     * This configures the node minimum power.
     */
    public void setMinPower(double minPower) { this.minPower = minPower; }

    /**
     * This returns the node maximum power.
     */
    public double getMaxPower() { return this.maxPower; }

    public void setMaxPower(double maxPower) { this.maxPower = maxPower; }

    public double getPower() { return this.power; }

    public void setPower(double power) { this.power = power; }

    public void setPower() {
        // Generates stochastic power p where minPower=>p<0.0 and 0.0<p<=maxPower
        this.power = ((Math.random() * ((this.maxPower - 1.0) - this.minPower + 1)) + this.minPower) + 0.1;
    }

    public void activate (double parameter) { // Activate neuron, use parameters for comprehensive function.
        CFunction cFunction = new CFunction(this.functionName, parameter); // Construct comprehensive function.
        this.hypothesis = cFunction.getValue();
        this.thesis = this.hypothesis - meanError; // Subtract the neuron error from it hypothesis.
    }

    public void activate (double... parameters) { // Activate neuron, use parameters for comprehensive function.
        CFunction cFunction = new CFunction(this.functionName, parameters); // Construct comprehensive function.
        this.hypothesis = cFunction.getValue();
        this.thesis = this.hypothesis - meanError; // Subtract the neuron error from it hypothesis.
    }

    public void optimize (double objective, int iteration) {
        double error = this.thesis - objective;
        // Update neuron error to average neuron error.
        this.meanError = this.dynamicPowerMean(this.meanError, error, this.power, iteration);
    }

    public void optimize (int iteration, double error) {
        // Update neuron error to average neuron error.
        this.meanError = this.dynamicPowerMean(this.meanError, error, this.power, iteration);
    }

    public String getRule () {
        double probability = this.thesis / (this.thesis + this.meanError);
        return this.functionName + " at probability " + probability;
    }

    private double dynamicPowerMean(double m, double d, double p, int t) {
        m = (Math.pow((1.0 / (t)) * (Math.pow(d, p) + (Math.pow(m, p) * (t - 1))), 1.0 / p));
        return m;
    }
}