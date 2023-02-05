/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

import java.util.ArrayList;
import java.util.function.Function;

/**
 The Network class represents a comprehensive network and provides methods for creating and
 manipulating the network. The class has a private field called 'layers' which is an
 ArrayList of Layer objects. Users can create a new network by specifying the number
 of layers and the width of each layer. The class also provides methods for getting
 and setting the layers in the network, adding and removing layers, getting the number
 of layers, getting the width of each layer, and setting the comprehensive function for all
 layers in the network. The class also provides methods for setting the
 degree for each layer in the layers list.
 */
public class Network {
    private ArrayList<Layer> layers = new ArrayList<>();

    /**
     * Creates a new network with the specified number of layers and a width of each layer.
     * @param length The number of layers in the network
     * @param width The width of each layer in the network
     */
    public Network (int length, int width) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width)); }
    }

    /**
     * Creates a new network with the specified number of layers and a width of each layer.
     * @param length The number of layers in the network
     * @param width The width of each layer in the network as an array
     */
    public Network (int length, int[] width) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width[i])); }
    }

    /**
     * Returns the layers in the network.
     * @return An ArrayList of the layers in the network
     */
    public ArrayList<Layer> getLayers () { return this.layers; }

    /**
     * Sets the layers in the network.
     * @param layers An ArrayList of layers to be set in the network
     */
    public void setLayers (ArrayList<Layer> layers) { this.layers = layers; }

    /**
     * Adds a new layer to the network.
     * @param layer The new layer to be added to the network
     */
    public void addLayer (Layer layer) { this.layers.add(layer); }

    /**
     * Removes a layer at the specified index from the network.
     * @param index The index of the layer to be removed
     */
    public void removeLayer (int index) { this.layers.remove(index); }

    /**
     * Returns the number of layers in the network.
     * @return The number of layers in the network
     */
    public int getLength () { return this.layers.size(); }

    /**
     * Returns the width of each layer in the network as an array.
     * @return An array of the width of each layer in the network
     */
    public int[] getWidth () { int[] width = new int[this.layers.size()];
        for (int i = 0; i < width.length; i++) { width[i] = this.layers.get(i).getWidth(); }
        return width;
    }

    /**
     * Sets the comprehensive function for all layers in the network.
     * @param cFunctionName The name of the comprehensive function
     * @param degree The degree of the comprehensive function
     * @param cFunction The comprehensive function to be set
     */
    public void setCFunction (String cFunctionName, Double degree, Function<Double[], Double> cFunction) {
        for (Layer layer : layers) { layer.setCFunction (cFunctionName, degree, cFunction); }
    }

    /**
     * This method sets the cFunction, degree, and cFunctionName for each layer in the layers list.
     * @param cFunctionName an array of strings representing the names of the cFunctions for each layer
     * @param degree an array of doubles representing the degrees of the cFunctions for each layer
     * @param cFunction an array of functions that take in an array of doubles and return a double
     */
    public void setCFunction(String[] cFunctionName, Double[] degree,
                             Function<Double[], Double>[] cFunction) {
        for (int i = 0; i < layers.size(); i++) {
            layers.get(i).setCFunction(cFunctionName[i], degree[i], cFunction[i]);
        }
    }

    /**
     * This method sets the cFunction, degree, and cFunctionName for each layer in the layers list.
     * @param cFunctionName a 2D array of strings representing the names of the cFunctions for each layer
     * @param degree a 2D array of doubles representing the degrees of the cFunctions for each layer
     * @param cFunction a 2D array of functions that take in an array of doubles and return a double
     */
    public void setCFunction(String[][] cFunctionName, Double[][] degree,
                             Function<Double[], Double>[][] cFunction) {
        for (int i = 0; i < layers.size(); i++) {
            layers.get(i).setCFunction(cFunctionName[i], degree[i], cFunction[i]);
        }
    }

    /**
     * This method returns a 2D array of strings representing the names of the cFunctions for each layer
     * @return a 2D array of strings representing the names of the cFunctions for each layer
     */
    public String[][] getCFunctionName() { String[][] cFunction = new String[this.layers.size()][];
        for (int i = 0; i < cFunction.length; i++) { cFunction[i] = layers.get(i).getCFunctionName(); }
        return cFunction;
    }

    /**
     * This method returns a 2D array of doubles representing the degrees of the cFunctions for each layer
     * @return a 2D array of doubles representing the degrees of the cFunctions for each layer
     */
    public Double[][] getDegree() {
        Double[][] degree = new Double[this.layers.size()][];
        for (int i = 0; i < degree.length; i++) { degree[i] = layers.get(i).getDegree(); }
        return degree;
    }

    /**
     * This method sets the power for each layer in the layers list.
     * @param power a double representing the power for each layer
     */
    public void setPower (Double power) { for (Layer layer : this.layers) { layer.setPower(power); } }

    /**
     * This method sets the power for each layer in the layers list.
     * @param power an array of doubles representing the power for each layer
     */
    public void setPower (Double[] power) {
        for (Layer layer : this.layers) { layer.setPower(power); }
    }

    /**
     * Set the power of each layer
     *
     * @param power a 2D array of Double representing the power for each layer and each node
     */
    public void setPower(Double[][] power) {
        for (int i = 0; i < layers.size(); i++) { layers.get(i).setPower(power[i]); }
    }

    /**
     * Get the power of each layer
     *
     * @return a 2D array of Double representing the power for each layer and each node
     */
    public Double[][] getPower() {
        Double[][] power = new Double[this.layers.size()][];
        for (int i = 0; i < power.length; i++) { power[i] = layers.get(i).getPower(); }
        return power;
    }

    /**
     * Set the coverage of each layer
     *
     * @param coverage a double value representing the coverage for all layers
     */
    public void setCoverage(Double coverage) {
        for (Layer layer : this.layers) { layer.setCoverage(coverage); }
    }

    /**
     * Set the coverage of each layer
     *
     * @param coverage an array of double value representing the coverage for each layer
     */
    public void setCoverage(Double[] coverage) { for (Layer layer : this.layers) { layer.setCoverage(coverage); } }

    /**
     * Set the coverage of each layer
     *
     * @param coverage a 2D array of double value representing the coverage for each layer and each node
     */
    public void setCoverage(Double[][] coverage) {
        for (int i = 0; i < layers.size(); i++) { layers.get(i).setCoverage(coverage[i]); }
    }

    /**
     * Get the coverage of each layer
     *
     * @return a 2D array of Double representing the coverage for each layer and each node
     */
    public Double[][] getCoverage() {
        Double[][] coverage = new Double[this.layers.size()][];
        for (int i = 0; i < coverage.length; i++) { coverage[i] = layers.get(i).getCoverage(); }
        return coverage;
    }

    public Double[][] getWeight () { Double[][] weight = new Double[this.getLength()][];
        for (int i = 0; i < weight.length; i++) { weight[i] = this.layers.get(i).getWeight(); }
        return weight;
    }

    /**
     * Get the mean error of each layer
     *
     * @return a 2D array of Double representing the error mean for each layer and each node
     */
    public Double[][] getErrorMean() {
        Double[][] errorMean = new Double[this.layers.size()][];
        for (int i = 0; i < errorMean.length; i++) { errorMean[i] = this.layers.get(i).getErrorMean(); }
        return errorMean;
    }

    /**
     * Set the mean error of each layer
     *
     * @param errorMean a 2D array of Double representing the error mean for each layer and each node
     */
    public void setErrorMean(Double[][] errorMean) {
        for (int i = 0; i < layers.size(); i++) { layers.get(i).setErrorMean(errorMean[i]); }
    }

    /**
     * Returns the hypothesis of all the layers in the network
     * @return Double[][] hypothesis
     */
    public Double[][] getHypothesis() {
        Double[][] hypothesis = new Double[this.layers.size()][];
        for (int i = 0; i < hypothesis.length; i++) { hypothesis[i] = this.layers.get(i).getHypothesis(); }
        return hypothesis;
    }

    /**
     * Returns the thesis of all the layers in the network
     * @return Double[][] thesis
     */
    public Double[][] getThesis() {
        Double[][] thesis = new Double[this.layers.size()][];
        for (int i = 0; i < thesis.length; i++) { thesis[i] = this.layers.get(i).getThesis(); }
        return thesis;
    }

    /**
     * Trains the network using the input and objective provided
     * @param iteration the number of iterations to train the network
     * @param objective the objective/expected output of the network
     * @param input the input to the network
     */
    public void train (int iteration, Double[] objective, Double[]... input) {
        for (int i = 0; i < this.layers.size(); i++) {
            if (i == 0) { this.layers.get(i).train(iteration, objective, input); }
            else { Double[] previousLayerThesis = this.layers.get(i - 1).getThesis();
                this.layers.get(i).train(iteration, objective, this.vectorToMatrix(previousLayerThesis));
            }
        }
    }

    /**
     * Test the network using the given input.
     * @param input The input values to test the network with.
     */
    public void test (Double[]... input) {
        for (int i = 0; i < this.layers.size(); i++) {
            if (i == 0) {
                // If this is the first layer, pass the input directly to the test method
                this.layers.get(i).test(input);
                if (this.layers.get(i).isNull()) {
                    // If the output is null, nullify the entire network's output
                    this.nullifyNetOutput();
                }
            } else {
                // If this is not the first layer, pass the previous layer's thesis as input
                Double[] previousLayerThesis = this.layers.get(i - 1).getThesis();
                this.layers.get(i).test(this.vectorToMatrix(previousLayerThesis));
                if (this.layers.get(i).isNull()) {
                    // If the output is null, nullify the entire network's output
                    this.nullifyNetOutput();
                }
            }
        }
    }

    public Double[][] getGradient (int iteration) {
        Double[][] gradient = new Double[this.getLength()][];
        for (int i = 0; i < gradient.length; i++) { gradient[i] = this.layers.get(i).getGradient(iteration); }
        return gradient;
    }

    /**
     * Utility function to convert a vector to a matrix
     * @param vector The vector to convert
     * @return matrix The converted matrix
     */
    private Double[][] vectorToMatrix(Double[] vector) {
        Double[][] matrix = new Double[vector.length][1];
        for (int i = 0; i < matrix.length; i++) { matrix[i][0] = vector[i]; }
        return matrix;
    }

    /**
     * Set the output of the last layer to null
     */
    private void nullifyNetOutput () { this.layers.get(this.getLength() - 1).test(null); }
}