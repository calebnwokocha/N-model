/*------------------------------------------------------------------------------
 Open-source framework for comprehensive learning.

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

 Email calebnwokocha@gmail.com for technical support and/or special
 permission to use this framework.
---------------------------------------------------------------------------- */

package cml.core;

import java.util.Arrays;
import java.util.function.Function;

public class Node {
    private String cFunctionName; private Function<Double[], Double> cFunction;
    private Double hypothesis, thesis, errorMean = 0.0, coverage = null;
    private double power, objective, degree;
    private Double[] inputMean, upperBound, lowerBound;
    private final Mean mean = new Mean();

    public Node () {}

    public void setCFunction (String cFunctionName, double degree, Function<Double[], Double> cFunction) {
        this.cFunctionName = cFunctionName; this.degree = degree; this.cFunction = cFunction;
    }

    public String getCFunctionName () { return this.cFunctionName; }

    public Double getHypothesis() { return this.hypothesis; }

    public Double getThesis() { return this.thesis; }

    public String getRule () {
        double probability = this.thesis / (this.thesis + this.errorMean);
        return this.cFunctionName + " at probability " + probability;
    }

    public double getErrorMean() { return this.squareRoot(this.errorMean); }

    public double getDegree() { return this.degree; }

    public double getPower() { return this.power; }

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

    public void train (double objective, int iteration, Double... input) {
        this.objective = objective; this.activate(input);
        Double error = Math.pow(this.thesis - this.objective, 2);
        if (iteration == 1) { this.inputMean = new Double[input.length];
            Arrays.fill(inputMean, 0.0); this.errorMean = error;}
        if (iteration > 1) { this.errorMean = mean.powerMean(this.errorMean, error, this.power, iteration); }
        if (this.coverage != null) { this.setInputBounds(input, iteration); }
    }

    private void activate (Double[] input) {
        double cValue = this.cFunction.apply(input);
        this.hypothesis = this.degreeRoot(cValue, this.degree) +
                (2 * (this.errorMean - this.degreeRoot(cValue, this.degree))) +
                (2 * this.degreeRoot(cValue, this.degree) * this.objective);
        this.thesis = this.squareRoot(this.hypothesis - this.errorMean);
    }

    private boolean isOutlier (Double[] input) {
        for (int i = 0; i < input.length; i++) {
            try { if (this.isBetween(input[i], this.lowerBound[i],
                    this.upperBound[i])) { return false; }
            } catch (NullPointerException e) { return true; }
        } return true;
    }

    private void setInputBounds (Double[] input, Integer iteration) {
        this.inputMean = mean.powerMean(this.inputMean,
                input, this.power, iteration + 1);
        this.upperBound = new Double[inputMean.length];
        this.lowerBound = new Double[inputMean.length];
        for (int i = 0; i < inputMean.length; i++) {
            double inputDeviation = this.standardDeviation(input, inputMean[i]);
            this.upperBound[i] = inputMean[i] + (this.coverage * inputDeviation);
            this.lowerBound[i] = inputMean[i] - (this.coverage * inputDeviation);
        }
    }

    private double degreeRoot(double cValue, double degree) { return Math.pow(cValue, 1 / degree); }

    private double squareRoot (Double data) { return Math.pow(data, 0.5); }

    private boolean isBetween (Double data, Double minimum, Double maximum) {
        return minimum <= data && data <= maximum;
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