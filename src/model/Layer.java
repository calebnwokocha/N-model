/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * The Layer class represents a collection of Node objects and provides methods for manipulating
 * and interacting with those nodes. It contains an ArrayList of Node objects, as well as methods
 * to add, remove, and get the Nodes in the list. It also has methods to set and get the
 * cFunction, cFunctionName, and degree variables of all the nodes in the layer, as well as
 * the power variable. It also has methods to get the width of the layer and an array of
 * cFunctionName of all the nodes in the layer. Additionally, it has a method to train and
 * test all the nodes in the layer and a method to check if the layer is null.
 */
public class Layer {
    private boolean isNull;
    private ArrayList<Node> nodes = new ArrayList<>();

    /**
     * Constructor for the Layer class.
     * @param width The number of nodes to be created in the layer.
     */
    public Layer (int width) {
        for (int i = 0; i < width; i++) {
            this.nodes.add(new Node());
        }
    }

    /**
     * Getter method for the nodes variable.
     * @return The value of the nodes variable.
     */
    public ArrayList<Node> getNodes() { return this.nodes; }

    /**
     * Setter method for the nodes variable.
     * @param nodes The new value of the nodes variable.
     */
    public void setNodes (ArrayList<Node> nodes) { this.nodes = nodes; }

    /**
     * This method adds a node to the nodes variable.
     * @param node The node to be added to the nodes variable.
     */
    public void addNode(Node node) { this.nodes.add(node); }

    /**
     * This method removes a node from the nodes variable.
     * @param index The index of the node to be removed.
     */
    public void removeNode (int index) { this.nodes.remove(index); }

    /**
     * Getter method for the width of the layer.
     * @return The width of the layer.
     */
    public int getWidth () { return this.nodes.size(); }

    /**
     * This method sets the cFunction, cFunctionName and degree variables of all the nodes in the layer.
     * @param cFunctionName The new value of the cFunctionName variable.
     * @param degree The new value of the degree variable.
     * @param cFunction The new value of the cFunction variable.
     */
    public void setCFunction (String cFunctionName, Double degree, Function<Double[], Double> cFunction) {
        for (Node node : nodes) {
            node.setCFunction (cFunctionName, degree, cFunction);
        }
    }

    /**
     * This method sets the power variable of all the nodes in the layer.
     * @param power The new value of the power variable.
     */
    public void setPower(Double power) {
        for (Node node : nodes) {
            node.setPower(power);
        }
    }

    /**
     * This method returns an array of cFunctionName of all the nodes in the layer.
     * @return An array of cFunctionName of all the nodes in the layer.
     */
    public String[] getCFunctionName() { String[] cFunctionName = new String[this.nodes.size()];
        for (int i = 0; i < cFunctionName.length; i++) {
            cFunctionName[i] = nodes.get(i).getCFunctionName();
        } return cFunctionName;
    }

    /**
     * setCFunction sets the comprehensive function for each node in the layer.
     * @param cFunctionName - an array of strings representing the names of the comprehensive functions
     * @param degree - an array of doubles representing the degrees of the comprehensive functions
     * @param cFunction - an array of functions representing the comprehensive functions
     */
    public void setCFunction(String[] cFunctionName, Double[] degree, Function<Double[], Double>[] cFunction) {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).setCFunction(cFunctionName[i], degree[i], cFunction[i]);
        }
    }

    /**
     * getDegree returns an array of the degree of each node in the layer.
     * @return - an array of doubles representing the degrees of the nodes
     */
    public Double[] getDegree() {
        Double[] degree = new Double[this.nodes.size()];
        for (int i = 0; i < degree.length; i++) { degree[i] = nodes.get(i).getDegree(); }
        return degree;
    }

    /**
     * getPower returns an array of the power of each node in the layer.
     * @return - an array of doubles representing the power of the nodes
     */
    public Double[] getPower() {
        Double[] power = new Double[this.nodes.size()];
        for (int i = 0; i < power.length; i++) { power[i] = nodes.get(i).getPower(); }
        return power;
    }

    /**
     * setPower sets the power of each node in the layer.
     * @param power - an array of doubles representing the desired power of the nodes
     */
    public void setPower(Double[] power) {
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setPower(power[i]); }
    }

    /**
     * setCoverage sets the coverage of each node in the layer.
     * @param coverage - the coverage to be set for each node
     */
    public void setCoverage (Double coverage) {
        for (Node node : this.nodes) { node.setCoverage(coverage); }
    }

    /**
     * setCoverage sets the coverage of each node in the layer.
     * @param coverage - an array of doubles representing the desired coverage of the nodes
     */
    public void setCoverage (Double[] coverage) {
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setCoverage(coverage[i]); }
    }

    /**
     * getCoverage returns an array of the coverage of each node in the layer.
     * @return - an array of doubles representing the coverage of the nodes
     */
    public Double[] getCoverage () {
        Double[] coverage = new Double[this.nodes.size()];
        for (int i = 0; i < coverage.length; i++) { coverage[i] = nodes.get(i).getCoverage(); }
        return coverage;
    }

    /**
     * This method returns an array of the error mean of each node in the list of nodes.
     * @return an array of the error mean of each node in the list of nodes.
     */
    public Double[] getErrorMean() {
        Double[] errorMean = new Double[this.nodes.size()];
        for (int i = 0; i < errorMean.length; i++) { errorMean[i] = this.nodes.get(i).getCurrentErrorMean(); }
        return errorMean;
    }

    /**
     * This method sets the error mean of each node in the list of nodes.
     * @param errorMean an array of error means that will be set to each node in the list of nodes.
     */
    public void setErrorMean (Double[] errorMean) {
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setCurrentErrorMean(errorMean[i]); }
    }

    /**
     * This method returns an array of the hypothesis of each node in the list of nodes.
     * @return an array of the hypothesis of each node in the list of nodes.
     */
    public Double[] getHypothesis() {
        Double[] hypothesis = new Double[this.nodes.size()];
        for (int i = 0; i < hypothesis.length; i++) { hypothesis[i] = this.nodes.get(i).getHypothesis(); }
        return hypothesis;
    }

    /**
     * This method returns an array of the thesis of each node in the list of nodes.
     * @return an array of the thesis of each node in the list of nodes.
     */
    public Double[] getThesis() { Double[] thesis = new Double[this.nodes.size()];
        for (int i = 0; i < thesis.length; i++) { thesis[i] = this.nodes.get(i).getThesis(); }
        return thesis;
    }

    /**
     * Method to train the nodes in the layer.
     * @param iteration Number of iterations to train the layer.
     * @param objectives Array of objectives for each node.
     * @param input Array of input data for each node.
     */
    public void train (int iteration, Double[] objectives, Double[]... input) {
        for (int i = 0; i < this.nodes.size(); i++) {
            try { this.nodes.get(i).train(objectives[i], iteration, input[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                //if there are more nodes than objectives or input data, break the loop.
                break;
            }
        }
    }

    /**
     * Method to test the nodes in the layer.
     * @param input Array of input data for each node.
     */
    public void test (Double[]... input) {
        int nullCount = 0;
        for (int i = 0; i < this.nodes.size(); i++) {
            try { this.nodes.get(i).test(input[i]); }
            catch (ArrayIndexOutOfBoundsException e) {
                //if there are more nodes than input data, break the loop.
                break;
            } catch (NullPointerException e) {
                //if the input data is null, pass null to the node.
                nodes.get(i).test(null);
            } Node currentNode = this.nodes.get(i);
            if (currentNode.getThesis() == null && currentNode.getCoverage() != null) {
                //counts the number of nodes with null thesis and non-null coverage
                nullCount += 1;
            }
        } this.isNull = nullCount > this.nodes.size() / 3;
    }

    public Double[] getGradient () {
        Double[] gradient = new Double[this.getWidth()];
        for (int i = 0; i < gradient.length; i++) { gradient[i] = this.nodes.get(i).getGradient(); }
        return gradient;
    }

    /**
     * Method to check if the layer is null
     * @return boolean value indicating if the layer is null
     */
    public boolean isNull () { return this.isNull; }
}