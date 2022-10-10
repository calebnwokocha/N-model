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

import java.util.Arrays;

/**
 * Node class consist of functions and methods for operations on a comprehensive node.
 */
public class Node {
    private String functionName;
    private Double hypothesis, thesis, power, meanError = 0.0;
    private double minPower = -1.0, maxPower = 1.0;
    private Double[] parameters, parametersUpperBound, parametersLowerBound;
    double[] meanParameters = new double[]{0.0};
    private boolean wasActive = false;

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
    public Double getHypothesis() { return this.hypothesis; }

    /**
     * This returns the node thesis.
     */
    public Double getThesis() { return this.thesis; }

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
     * This configures the node actual power to a stochastic power p, where minPower => p < 0.0 or
     * 0.0 < p <= maxPower. By default, minPower = -1.0 and maxPower = 1.0, in accordance to the
     * Pythagorean means configuration for the power mean. The following are required by the power
     * mean to produce any of the Pythagorean means: For harmonic mean, p approaches -1.0; for
     * geometric mean, p approaches 0; and for arithmetic mean, p approaches 1.0.
     */
    public void setPower() {
        this.power = ((Math.random() * ((this.maxPower - 1.0) - this.minPower + 1)) + this.minPower) + 0.1;
    }

    /**
     * This prompts the node to produce its hypothesis and thesis upon a vector argument. The result of the
     * node comprehensive function is the node hypothesis, and the node thesis is obtained by subtracting
     * meanError from that hypothesis.
     *
     * @see CFunction
     */
    public void activate(boolean isInputLayer, Double... parameter) {
        if (isInputLayer) {
            this.parameters = parameter;
            this.setParametersBounds(this.parameters, null);
            if (!this.isOutlier(this.parameters)) {
                this.wasActive = true;
                CFunction cFunction = new CFunction(this.functionName, this.parameters);
                this.hypothesis = cFunction.getValue();
                try { this.thesis = this.hypothesis - this.meanError; }
                catch (NullPointerException e) { this.thesis = null; }
            } else { this.thesis = null; }
        } else {
            CFunction cFunction = new CFunction(this.functionName, this.parameters);
            try { this.thesis = this.hypothesis - this.meanError; }
            catch (NullPointerException e) { this.thesis = null; }
        }

     /*   System.out.println("Thesis is " + this.thesis);
        System.out.println();*/
    }

    /**
     * This prompts the node to update its meanError. Given the two arguments: objective and iteration,
     * an intermediate error is calculated, and this error is used to update the node meanError.
     */
    public void optimize (double objective, int iteration, boolean isInputLayer) {
        System.out.println();
        System.out.println("Optimization");
        if (isInputLayer) { this.setParametersBounds(this.parameters, iteration); }
        try { double error = this.thesis - objective;
            this.meanError = this.dynamicPowerMean(this.meanError, error, this.power, iteration);
        } catch (NullPointerException e) { this.meanError = null; }
    }

    /**
     * This prompts the node to update its meanError. The two arguments: iteration and error,
     * are used to update the node meanError.
     */
    public void optimize (int iteration, double error, boolean isInputLayer) {
        if (isInputLayer) { this.setParametersBounds(this.parameters, iteration); }
        try { this.meanError = this.dynamicPowerMean(this.meanError, error, this.power, iteration);
        } catch (NullPointerException e) { this.meanError = null; }
    }

    private boolean isOutlier (Double[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            try { if (this.isBetween(parameters[i], this.parametersLowerBound[i],
                    this.parametersUpperBound[i])) {
                System.out.println(parameters[i] + " is not outlier"); return false; }
            } catch (NullPointerException e) { System.out.println(parameters[i] + " is outlier"); return true; }
        }

        System.out.println(Arrays.toString(parameters) + " is outlier");
        System.out.println("parameters upper bound is " + Arrays.toString(this.parametersUpperBound));
        System.out.println("parameters lower bound is " + Arrays.toString(this.parametersLowerBound));
        System.out.println();
        return true;
    }

    private void setParametersBounds (Double[] parameters, Integer iteration) {
        if (iteration == null) {
            if (!this.wasActive) {
                System.out.println("parameter is " + Arrays.toString(parameters));
                this.parametersUpperBound = parameters;
                this.parametersLowerBound = parameters;
                System.out.println("parameters upper bound is " + Arrays.toString(this.parametersUpperBound));
                System.out.println("parameters lower bound is " + Arrays.toString(this.parametersLowerBound));
                System.out.println();
            }
        } else { try { this.meanParameters = this.dynamicPowerMean(this.meanParameters,
                        parameters, this.power, iteration + 1);
                System.out.println("mean parameter is " + Arrays.toString(meanParameters));
                this.parametersUpperBound = new Double[meanParameters.length];
                this.parametersLowerBound = new Double[meanParameters.length];
                for (int i = 0; i < meanParameters.length; i++) {
                    double parameterStd = this.standardDeviation(parameters, meanParameters[i]);
                    System.out.println("parameter std is " + parameterStd);
                    this.parametersUpperBound[i] = meanParameters[i] + (3 * parameterStd);
                    this.parametersLowerBound[i] = meanParameters[i] - (3 * parameterStd);
                    System.out.println("parameter upper bound is " + this.parametersUpperBound[i]);
                    System.out.println("parameter lower bound is " + this.parametersLowerBound[i]);
                } } catch (NullPointerException e) { this.parametersUpperBound = null;
                this.parametersLowerBound = null;
            }
        }
    }

    private boolean isBetween (Double data, Double minimum, Double maximum) {
        return minimum <= data && data <= maximum;
    }

    private double dynamicPowerMean (double mean, double datum, double power, int time) {
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