/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

import java.util.ArrayList;
import java.util.function.Function;

public class Network {
    private ArrayList<Layer> layers = new ArrayList<>();

    public Network (int length, int width) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width)); }
    }

    public Network (int length, int[] width) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width[i])); }
    }

    public ArrayList<Layer> getLayers () { return this.layers; }

    public void setLayers (ArrayList<Layer> layers) { this.layers = layers; }

    public void addLayer (Layer layer) { this.layers.add(layer); }

    public void removeLayer (int index) { this.layers.remove(index); }

    public int getLength () { return this.layers.size(); }

    public int[] getWidth () { int[] width = new int[this.layers.size()];
        for (int i = 0; i < width.length; i++) { width[i] = this.layers.get(i).getWidth(); }
        return width;
    }

    public void setCFunction (String cFunctionName, Double degree, Function<Double[], Double> cFunction) {
        for (Layer layer : layers) { layer.setCFunction (cFunctionName, degree, cFunction); }
    }

    public void setCFunction(String[] cFunctionName, Double[] degree,
                                    Function<Double[], Double>[] cFunction) {
        for (int i = 0; i < layers.size(); i++) {
            layers.get(i).setCFunction(cFunctionName[i], degree[i], cFunction[i]);
        }
    }

    public void setCFunction(String[][] cFunctionName, Double[][] degree,
                                    Function<Double[], Double>[][] cFunction) {
        for (int i = 0; i < layers.size(); i++) {
            layers.get(i).setCFunction(cFunctionName[i], degree[i], cFunction[i]);
        }
    }

    public String[][] getCFunctionName() { String[][] cFunction = new String[this.layers.size()][];
        for (int i = 0; i < cFunction.length; i++) {
            cFunction[i] = layers.get(i).getCFunctionName();
        } return cFunction;
    }

    public Double[][] getDegree() {
        Double[][] degree = new Double[this.layers.size()][];
        for (int i = 0; i < degree.length; i++) { degree[i] = layers.get(i).getDegree(); }
        return degree;
    }

    public void setPower (Double power) { for (Layer layer : this.layers) { layer.setPower(power); } }

    public void setPower (Double[] power) {
        for (Layer layer : this.layers) { layer.setPower(power); }
    }

    public void setPower (Double[][] power) {
        for (int i = 0; i < layers.size(); i++) { layers.get(i).setPower(power[i]); }
    }

    public Double[][] getPower () {
        Double[][] power = new Double[this.layers.size()][];
        for (int i = 0; i < power.length; i++) { power[i] = layers.get(i).getPower(); }
        return power;
    }

    public void setCoverage (Double coverage) {
        for (Layer layer : this.layers) { layer.setCoverage(coverage); }
    }

    public void setCoverage (Double[] coverage) { for (Layer layer : this.layers) { layer.setCoverage(coverage); } }

    public void setCoverage (Double[][] coverage) {
        for (int i = 0; i < layers.size(); i++) { layers.get(i).setCoverage(coverage[i]); }
    }

    public Double[][] getCoverage () {
        Double[][] coverage = new Double[this.layers.size()][];
        for (int i = 0; i < coverage.length; i++) { coverage[i] = layers.get(i).getCoverage(); }
        return coverage;
    }

    public Double[][] getErrorMean() { Double[][] errorMean = new Double[this.layers.size()][];
        for (int i = 0; i < errorMean.length; i++) {
            errorMean[i] = this.layers.get(i).getErrorMean();
        } return errorMean;
    }

    public void setErrorMean (Double[][] errorMean) {
        for (int i = 0; i < layers.size(); i++) { layers.get(i).setErrorMean(errorMean[i]); }
    }

    public Double[][] getHypothesis() { Double[][] hypothesis = new Double[this.layers.size()][];
        for (int i = 0; i < hypothesis.length; i++) {
            hypothesis[i] = this.layers.get(i).getHypothesis();
        } return hypothesis;
    }

    public Double[][] getThesis() { Double[][] thesis = new Double[this.layers.size()][];
        for (int i = 0; i < thesis.length; i++) { thesis[i] = this.layers.get(i).getThesis(); }
        return thesis;
    }

    public void train (int iteration, Double[] objective, Double[]... input) {
        for (int i = 0; i < this.layers.size(); i++) {
            if (i == 0) { this.layers.get(i).train(iteration, objective, input); }
            else { Double[] previousLayerThesis = this.layers.get(i - 1).getThesis();
                this.layers.get(i).train(iteration, objective, this.vectorToMatrix(previousLayerThesis));
            }
        }
    }

    public void test (Double[]... input) {
        for (int i = 0; i < this.layers.size(); i++) {
            if (i == 0) {this.layers.get(i).test(input);
                if (this.layers.get(i).isNull()) { this.nullifyNetOutput(); }
            } else { Double[] previousLayerThesis = this.layers.get(i - 1).getThesis();
                this.layers.get(i).test(this.vectorToMatrix(previousLayerThesis));
                if (this.layers.get(i).isNull()) { this.nullifyNetOutput(); }
            }
        }
    }

    private Double[][] vectorToMatrix(Double[] vector) {
        Double[][] matrix = new Double[vector.length][1];
        for (int i = 0; i < matrix.length; i++) { matrix[i][0] = vector[i]; }
        return matrix;
    }

    private void nullifyNetOutput () { this.layers.get(this.getLength() - 1).test(null); }
}