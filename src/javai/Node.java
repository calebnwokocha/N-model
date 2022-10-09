/*--------------------------------------------------------------------------------------------------
 Javai is open-source framework for comprehensive learning.
 Copyright (C) 2022 Javai Foundation

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

 Email info@javai.org for technical support and/or special permission to use this framework.
----------------------------------------------------------------------------------------------------*/

package javai;

/**
 * Node class consist of functions and methods for operations on a comprehensive node.
 */
public class Node {
    private String functionName; private double power;
    private double hypothesis; private double thesis;
    private double meanError = 0.0; // Default
    private double minPower = -1.0; // Default
    private double maxPower = 1.0; // Default

    /**
     * This constructs a comprehensive node without manually setting its parameters.
     * The node comprehensive function is automatically set to "sum", and the
     * power of the node is automatically configured by setPower().
     */
    public Node () { this.functionName = "sum"; this.setPower(); }

    /**
     * This constructs a comprehensive node by parametrically setting its comprehensive function.
     * The node power is automatically configured by setPower().
     */
    public Node (String functionName) { this.functionName = functionName; this.setPower(); }

    /**
     * This constructs a comprehensive node by parametrically setting its power.
     * The node comprehensive function is automatically set to "sum".
     */
    public Node (double power) { this.functionName = "sum"; this.power = power; }

    /**
     * This constructs a comprehensive node by parametrically setting its minimum and maximum power.
     * The actual power of the node is automatically configure by setPower(), and the comprehensive
     * function of the node is automatically set to "sum".
     */
    public Node (double minPower, double maxPower) {
        this.functionName = "sum"; this.minPower = minPower; this.maxPower = maxPower; this.setPower();
    }

    /**
     * This constructs a comprehensive node by parametrically setting its comprehensive function,
     * and minimum and maximum power. The power of the constructed node is automatically configure
     * by setPower().
     */
    public Node (String functionName, double minPower, double maxPower) {
        this.functionName = functionName; this.minPower = minPower; this.maxPower = maxPower; this.setPower();
    }

    /**
     * This constructs a comprehensive node by parametrically setting its comprehensive function and power.
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
     * This returns the node rule.
     */
    public String getRule () {
        double probability = this.thesis / (this.thesis + this.meanError);
        return this.functionName + " at probability " + probability;
    }

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

    /**
     * This configures the node maximum power.
     */
    public void setMaxPower(double maxPower) { this.maxPower = maxPower; }

    /**
     * This returns the node actual power.
     */
    public double getPower() { return this.power; }

    /**
     * This configures the node actual power to the argument.
     */
    public void setPower(double power) { this.power = power; }

    /**
     * This configures the node actual power to a stochastic power p, where minPower => p < 0.0 or 0.0 < p <= maxPower.
     * By default, minPower = -1.0 and maxPower = 1.0, in accordance to the Pythagorean means configuration
     * for the power mean. The following are required by the power mean to produce any of the Pythagorean means:
     * For harmonic mean, p approaches -1.0; for geometric mean, p approaches 0; and for arithmetic mean, p approaches 1.0.
     */
    public void setPower() {
        this.power = ((Math.random() * ((this.maxPower - 1.0) - this.minPower + 1)) + this.minPower) + 0.1;
    }

    /**
     * This prompts the node to produce its hypothesis and thesis upon a scalar argument. The result of the
     * node comprehensive function is the node hypothesis, and the node thesis is obtained by subtracting
     * meanError from that hypothesis.
     *
     * @see CFunction
     */
    public void activate (double parameter) {
        CFunction cFunction = new CFunction(this.functionName, parameter);
        this.hypothesis = cFunction.getValue();
        this.thesis = this.hypothesis - this.meanError;
    }

    /**
     * This prompts the node to produce its hypothesis and thesis upon a vector argument. The result of the
     * node comprehensive function is the node hypothesis, and the node thesis is obtained by subtracting
     * meanError from that hypothesis.
     *
     * @see CFunction
     */
    public void activate (double... parameters) {
        CFunction cFunction = new CFunction(this.functionName, parameters);
        this.hypothesis = cFunction.getValue();
        this.thesis = this.hypothesis - this.meanError;
    }

    /**
     * This prompts the node to update its meanError. Given the two arguments: objective and iteration,
     * an intermediate error is calculated, and this error is used to update the node meanError.
     */
    public void optimize (double objective, int iteration) {
        double error = this.thesis - objective;
        this.meanError = this.dynamicPowerMean(this.meanError, error, this.power, iteration);
    }

    /**
     * This prompts the node to update its meanError. The two arguments: iteration and error,
     * are used to update the node meanError.
     */
    public void optimize (int iteration, double error) {
        this.meanError = this.dynamicPowerMean(this.meanError, error, this.power, iteration);
    }

    private double dynamicPowerMean(double m, double d, double p, int t) {
        m = (Math.pow((1.0 / (t)) * (Math.pow(d, p) + (Math.pow(m, p) * (t - 1))), 1.0 / p));
        return m;
    }
}