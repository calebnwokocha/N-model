/*=======================================================================
 Caleai is an open-source framework for comprehensive learning.
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

package caleai;

/**
 * Node class consist of functions and methods for operations on a comprehensive node.
 */
public class Node {
    private String function; private double power;
    private double hypothesis; private double thesis;
    private double meanError = 0.0; // Default
    private double minPower = -1.0; // Default
    private double maxPower = 2.0; // Default

    /**
     * This constructs a comprehensive node without manually setting parameters.
     * The comprehensive function of the constructed node is automatically set to "sum",
     * and the power of the node is automatically configured by setPower().
     */
    public Node () { this.function = "sum"; this.setPower(); }

    /**
     * This constructs a comprehensive node by manually setting its comprehensive function as argument.
     * The power of the constructed node is automatically configured by setPower().
     */
    public Node (String function) { this.function = function; this.setPower(); }

    /**
     * This constructs a comprehensive node by manually setting its power as argument.
     * The comprehensive function of the constructed node is automatically set to "sum".
     */
    public Node (double power) { this.function = "sum"; this.power = power; }

    public Node (double minPower, double maxPower) {
        this.function = "sum"; this.minPower = minPower; this.maxPower = maxPower; this.setPower();
    }

    public Node (String function, double minPower, double maxPower) {
        this.function = function; this.minPower = minPower; this.maxPower = maxPower; this.setPower();
    }

    public Node(String function, double power) { this.function = function; this.power = power; }

    public String getFunction() { return this.function; }

    public void setFunction(String function) { this.function = function; }

    public double getHypothesis() { return this.hypothesis; }

    public double getThesis() { return this.thesis; }

    public double getMeanError() { return this.meanError; }

    public double getMinPower() { return this.minPower; }

    public void setMinPower(double minPower) { this.minPower = minPower; }

    public double getMaxPower() { return this.maxPower; }

    public void setMaxPower(double maxPower) { this.maxPower = maxPower; }

    public double getPower() { return this.power; }

    public void setPower(double power) { this.power = power; }

    public void setPower() {
        // Generates stochastic power for p where minPower=>p<0.0 and 0.0<p<=maxPower
        this.power = ((Math.random() * ((this.maxPower - 1.0) - this.minPower + 1)) + this.minPower) + 0.1;
    }

    public void activate (double parameter) { // Activate neuron, use parameters for comprehensive function.
        CFunction cFunction = new CFunction(this.function, parameter); // Construct comprehensive function.
        this.hypothesis = cFunction.getValue();
        this.thesis = this.hypothesis - meanError; // Subtract the neuron error from it hypothesis.
    }

    public void activate (double... parameters) { // Activate neuron, use parameters for comprehensive function.
        CFunction cFunction = new CFunction(this.function, parameters); // Construct comprehensive function.
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
        return this.function + " at probability " + probability;
    }

    private double dynamicPowerMean(double m, double d, double p, int t) {
        m = (Math.pow((1.0 / (t)) * (Math.pow(d, p) + (Math.pow(m, p) * (t - 1))), 1.0 / p));
        return m;
    }
}