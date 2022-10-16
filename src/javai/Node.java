/*------------------------------------------------------------------------------
 Javai is open-source framework for comprehensive learning, produced and
 maintained by the Javai Foundation.

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

 Email info@javai.org for technical support and/or special permission
 to use this framework.
---------------------------------------------------------------------------- */

package javai;

/**
 * Node class consist of functions and methods for operations on a comprehensive node.
 */
public class Node {
    private String functionName;
    private Double hypothesis, thesis, coverage = null;
    private double minPower, maxPower, power, errorMean = 0.0;
    private double[] inputMean, upperBound, lowerBound;

    /**
     * This constructs a comprehensive node without manually setting its input.
     * The node comprehensive function is automatically set to "sum", and the
     * power of the node is automatically configured by setPower().
     */
    public Node () {}

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
    public Double getHypothesis() { return this.hypothesis; }

    /**
     * This returns the node thesis.
     */
    public Double getThesis() { return this.thesis; }

    /**
     * This returns the node rule.
     */
    public String getRule () {
        double probability = this.thesis / (this.thesis + this.errorMean);
        return this.functionName + " at probability " + probability;
    }

    /**
     * This returns the node mean error.
     */
    public double getErrorMean() { return this.errorMean; }

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

    public void setCoverage (Double coverage) { this.coverage = coverage; }

    public Double getCoverage() { return this.coverage; }

    public void test (Double... input) {
        if (coverage == null) { this.activate(input); }
        else {
            if (this.isOutlier(input)) { this.thesis = null; }
            else { this.activate(input); }
        }
    }

    /**
     * This prompts the node to update its meanError. Given the two arguments: objective and iteration,
     * an intermediate error is calculated, and this error is used to update the node meanError.
     */
    public void train (double objective, int iteration, Double... input) {
        if (iteration == 1) { this.inputMean = new double[input.length]; }
        if (this.coverage != null) { this.setInputBounds(input, iteration); }
        this.activate(input);
        double error = this.thesis - objective;
        this.errorMean = this.dynamicPowerMean(this.errorMean, error, this.power, iteration);
    }

    /**
     * This prompts the node to update its meanError. The two arguments: iteration and error,
     * are used to update the node meanError.
     */
    public void train (int iteration, Double error, Double... input) {
        if (iteration == 1) { this.inputMean = new double[input.length]; }
        if (this.coverage != null) { this.setInputBounds(input, iteration); }
        if (error == null) { this.errorMean = 0.0; } // Unsupervised learning
        else { this.errorMean = this.dynamicPowerMean(this.errorMean, error, this.power, iteration); }
        this.activate(input);
    }

    /**
     * This prompts the node to produce its hypothesis and thesis upon a vector argument. The result of the
     * node comprehensive function is the node hypothesis, and the node thesis is obtained by subtracting
     * meanError from that hypothesis.
     *
     * @see CFunction
     * @param input
     */
    private void activate (Double[] input) {
        CFunction cFunction = new CFunction(this.functionName, input);
        this.hypothesis = cFunction.getValue();
        this.thesis = this.hypothesis - this.errorMean;
    }

    private boolean isOutlier (Double[] input) {
        for (int i = 0; i < input.length; i++) {
            try { if (this.isBetween(input[i], this.lowerBound[i],
                    this.upperBound[i])) { return false; }
            } catch (NullPointerException e) { return true; }
        } return true;
    }

    private void setInputBounds (Double[] input, Integer iteration) {
        this.inputMean = this.dynamicPowerMean(this.inputMean,
                input, this.power, iteration + 1);
        this.upperBound = new double[inputMean.length];
        this.lowerBound = new double[inputMean.length];
        for (int i = 0; i < inputMean.length; i++) {
            double inputDeviation = this.standardDeviation(input, inputMean[i]);
            this.upperBound[i] = inputMean[i] + (this.coverage * inputDeviation);
            this.lowerBound[i] = inputMean[i] - (this.coverage * inputDeviation);
        }
    }

    private boolean isBetween (Double data, Double minimum, Double maximum) {
        return minimum <= data && data <= maximum;
    }

    private double dynamicPowerMean (double mean, Double datum, double power, int time) {
        mean = (Math.pow((1.0 / (time)) * (Math.pow(datum, power) +
                (Math.pow(mean, power) * (time - 1))), 1.0 / power));
        return mean;
    }

    private double[] dynamicPowerMean (double[] mean, Double[] data, double power, int time) {
        for (int i = 0; i < data.length; i++) {
            mean[i] = this.dynamicPowerMean(mean[i], data[i], power, time);
        } return mean;
    }

    private double variance (Double[] data, double expectedValue) {
        double squaredSum = 0.0;
        double variance;
        for (double datum : data) { squaredSum += Math.pow(datum - expectedValue, 2); }
        if (squaredSum == 0 || (data.length - 1) == 0) { variance = squaredSum; }
        else { variance = squaredSum / (data.length - 1); }
        return variance;
    }

    private double standardDeviation (Double[] data, double expectedValue) {
        return Math.sqrt(this.variance(data, expectedValue));
    }
}