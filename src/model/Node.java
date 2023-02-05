/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

import java.util.Arrays;
import java.util.function.Function;

/**
 * The Node class is a representation of a node in a comprehensive layer model.
 * It has several fields such as cFunctionName, hypothesis, thesis, errorMean,
 * coverage, power, degree, inputMean, inputUpperBound, inputLowerBound, and an
 * instance of the StatUtil class. The class contains several getter and
 * setter methods for the fields, a method to set the comprehensive function,
 * a method to train the node, a method to test the node, a method to get the rule of the
 * node and a method to get the coverage of the node. The train method sets the
 * value of the objective, inputMean and errorMean variable, while the test
 * method sets the value of the thesis variable. The class also contains a
 * method to check if the node is null.
 */
public class Node {

    private String cFunctionName;
    private Function<Double[], Double> cFunction;
    private Double hypothesis, thesis, currentErrorMean = 0.0,
            previousErrorMean = 0.0, coverage = null;
    private Double power, objective, degree;
    private Double[] inputMean, inputUpperBound, inputLowerBound;
    private final StatUtil stat = new StatUtil();

    /**
     * Constructor for the Node class.
     */
    public Node () {}

    /**
     * Getter method for the hypothesis variable.
     * @return The value of the hypothesis variable.
     */
    public Double getHypothesis() { return this.hypothesis; }

    /**
     * Getter method for the thesis variable.
     * @return The value of the thesis variable.
     */
    public Double getThesis() { return this.thesis; }

    /**
     * This method returns a string representation of the rule of the current node.
     * @return A string representation of the rule of the current node.
     */
    public Double getWeight () { return this.thesis / this.hypothesis; }

    /**
     * Getter method for the errorMean variable.
     * @return The value of the errorMean variable.
     */
    public Double getCurrentErrorMean() { return Math.sqrt(this.currentErrorMean); }

    /**
     * Setter method for the errorMean variable.
     * @param currentErrorMean The new value of the errorMean variable.
     */
    public void setCurrentErrorMean(Double currentErrorMean) { this.currentErrorMean = currentErrorMean; }

    /**
     * Getter method for the degree variable.
     * @return The value of the degree variable.
     */
    public Double getDegree() { return this.degree; }

    /**
     * Getter method for the power variable.
     * @return The value of the power variable.
     */
    public Double getPower() { return this.power; }

    /**
     * Setter method for the power variable.
     * @param power The new value of the power variable.
     */
    public void setPower(Double power) { this.power = power; }

    /**
     * Setter method for the coverage variable.
     * @param coverage The new value of the coverage variable.
     */
    public void setCoverage (Double coverage) { this.coverage = coverage; }

    /**
     * Getter method for the coverage variable.
     * @return The value of the coverage variable.
     */
    public Double getCoverage() { return this.coverage; }

    /**
     * Getter method for the cFunctionName variable.
     * @return The value of the cFunctionName variable.
     */
    public String getCFunctionName () { return this.cFunctionName; }

    /**
     * This method sets the value of the cFunctionName, degree, and cFunction variables.
     * @param cFunctionName The new value of the cFunctionName variable.
     * @param degree The new value of the degree variable.
     * @param cFunction The new value of the cFunction variable.
     */
    public void setCFunction (String cFunctionName, Double degree, Function<Double[], Double> cFunction) {
        this.cFunctionName = cFunctionName; this.degree = degree; this.cFunction = cFunction;
    }

    /**
     * This method trains the node with a given objective, iteration and input data.
     * It sets the values of the objective, inputMean and errorMean variables.
     * @param objective The objective value for the training.
     * @param iteration The iteration number for the training.
     * @param input The input data for the training.
     */
    public void train (Double objective, int iteration, Double... input) {
        this.objective = objective; this.activate(input);
        try { Double error = Math.pow(this.hypothesis - this.objective, 2);
            //System.out.println("Node error is " + error);
            if (iteration == 1) { this.inputMean = new Double[input.length];
                Arrays.fill(inputMean, 0.0); this.currentErrorMean = error;
            } if (iteration > 1) {
                this.previousErrorMean = this.currentErrorMean;
                this.currentErrorMean = stat.dynamicPowerMean(this.currentErrorMean, error, this.power, iteration);
            }
        } catch (NullPointerException ignored) {}
        if (this.coverage != null) { this.setInputBounds(input, iteration); }
    }

    /**
     * This method tests the input by activating the function
     * and determining if it is an outlier.
     * @param input The input to be tested.
     */
    public void test (Double... input) {
        if (coverage == null) { this.activate(input); }
        else { if (stat.isOutlier(input, this.inputLowerBound, this.inputUpperBound)) { this.thesis = null; }
        else { this.activate(input); }
        }
    }

    public Double getGradient (int iteration) {
        return Math.pow(this.currentErrorMean, this.power) - Math.pow(this.previousErrorMean, this.power);
    }

    /**
     * This method activates the cFunction with the input,
     * sets the hypothesis and thesis variables.
     * @param input The input to be used in activating the function.
     */
    private void activate (Double... input) {
        try { this.hypothesis = this.degreeRoot(Math.abs(this.cFunction.apply(input)), this.degree) + 1;
            this.thesis = ((Math.pow(this.hypothesis, 2) +
                    Math.pow(this.objective, 2)) - this.currentErrorMean) / (2 * this.hypothesis);
        } catch (NullPointerException ignored) {}
    }

    /**
     * This method sets the input bounds based on the input and iteration number.
     * It sets the inputMean, inputUpperBound and inputLowerBound variables.
     * @param input The input data to be used in setting the bounds.
     * @param iteration The iteration number for the input data.
     */
    private void setInputBounds (Double[] input, Integer iteration) {
        if (iteration == 1) { this.inputMean = input; }
        else { this.inputMean = stat.dynamicPowerMean(this.inputMean, input,
                this.power, iteration + 1); }
        this.inputUpperBound = new Double[input.length];
        this.inputLowerBound = new Double[input.length];
        for (int i = 0; i < input.length; i++) {
            try { Double inputDeviation = stat.standardDeviation(input, this.inputMean[i]);
                this.inputUpperBound[i] = this.inputMean[i] + (this.coverage * inputDeviation);
                this.inputLowerBound[i] = this.inputMean[i] - (this.coverage * inputDeviation);
            } catch (NullPointerException e) { break; }
        }
    }

    /**
     * This method calculates the degree root of a given value.
     * @param cValue The value for which the degree root is to be calculated.
     * @param degree The degree of the root to be calculated.
     * @return The degree root of the given value.
     */
    private Double degreeRoot(Double cValue, Double degree) { return Math.pow(cValue, 1 / degree); }
}