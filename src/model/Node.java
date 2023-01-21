/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

import java.util.Arrays;
import java.util.function.Function;

public class Node {
    private String cFunctionName; private Function<Double[], Double> cFunction;
    private final Complex hypothesis = new Complex(0.0, 0.0);
    private Complex thesis = new Complex(0.0, 0.0);
    private Double power, objective, degree, errorMean = 0.0, coverage = null;
    private Double[] inputMean, inputUpperBound, inputLowerBound;
    private final StatUtil stat = new StatUtil();

    public Node () {}

    public Complex getHypothesis() { return this.hypothesis; }

    public Complex getThesis() { return this.thesis; }

/*    public String getRule () {
        double probability = this.thesis / (this.thesis + this.errorMean);
        return this.cFunctionName + " at probability " + probability;
    }*/

    public Double getErrorMean() { return Math.sqrt(this.errorMean); }

    public void setErrorMean(Double errorMean) { this.errorMean = errorMean; }

    public Double getDegree() { return this.degree; }

    public Double getPower() { return this.power; }

    public void setPower(Double power) { this.power = power; }

    public void setCoverage (Double coverage) { this.coverage = coverage; }

    public Double getCoverage() { return this.coverage; }

    public String getCFunctionName () { return this.cFunctionName; }

    public void setCFunction (String cFunctionName, Double degree, Function<Double[], Double> cFunction) {
        this.cFunctionName = cFunctionName; this.degree = degree; this.cFunction = cFunction;
    }

    public void train (Double objective, int iteration, Double... input) {
        this.objective = objective; this.activate(input);
        try { Double error = Math.pow(this.hypothesis.getReal() - this.objective, 2);
            if (iteration == 1) { this.inputMean = new Double[input.length];
                Arrays.fill(inputMean, 0.0); this.errorMean = error;
            } if (iteration > 1) {
                this.errorMean = stat.dynamicPowerMean(this.errorMean, error, this.power, iteration);
            }
        } catch (NullPointerException ignored) {}
        if (this.coverage != null) { this.setInputBounds(input, iteration); }
    }

    public void test (Double... input) {
        if (coverage == null) { this.activate(input); }
        else { if (stat.isOutlier(input, this.inputLowerBound, this.inputUpperBound)) { this.thesis = null; }
            else { this.activate(input); }
        }
    }

    private void activate (Double... input) {
        try { if (this.cFunction.apply(input) < 0.0) {
            this.hypothesis.setImaginary(this.degreeRoot(Math.abs(this.cFunction.apply(input)), this.degree) + 1);
        } else { this.hypothesis.setReal(this.degreeRoot(this.cFunction.apply(input), this.degree) + 1);
        } Complex numerator = new Complex(0.0, 0.0), denominatior  = new Complex(0.0, 0.0);
            numerator.add(this.hypothesis);
            numerator.multiply(numerator);
            numerator.setReal((numerator.getReal() + Math.pow(this.objective, 2)) - this.errorMean);
            denominatior.add(this.hypothesis);
            denominatior.setReal(denominatior.getReal() * 2);
            this.thesis.add(numerator);
            this.thesis.divide(denominatior);
        } catch (NullPointerException ignored) {}
    }

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

    private Double degreeRoot(Double cValue, Double degree) { return Math.pow(cValue, 1 / degree); }
}