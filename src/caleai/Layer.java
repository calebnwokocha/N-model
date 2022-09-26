package caleai;/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

import java.util.ArrayList;

public class Layer {
    private ArrayList<Node> nodes = new ArrayList<>();
    private String function;
    private double power;
    private double minimumPower;
    private double maximumPower;
    private String[] functions;
    private double[] powers;
    private double[] minimumPowers;
    private double[] maximumPowers;

    // Construct layer.
    public Layer (int dimension) {
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node()); }
    }

    public Layer (int dimension, String function) {
        this.function = function;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.function)); }
    }

    public Layer (int dimension, String[] functions) {
        this.functions = functions;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.functions[i])); }
    }

    public Layer (int dimension, double power) {
        this.power = power;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.power)); }
    }

    public Layer (int dimension, double[] powers) {
        this.powers = powers;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.powers[i])); }
    }

    public Layer (int dimension, String function, double power) {
        this.function = function; this.power = power;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.function, this.power)); }
    }

    public Layer (int dimension, String[] functions, double power) {
        this.functions = functions; this.power = power;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.functions[i], this.power)); }
    }

    public Layer (int dimension, String function, double[] powers) {
        this.function = function; this.powers = powers;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.function, this.powers[i])); }
    }

    public Layer (int dimension, String[] functions, double[] powers) {
        this.functions = functions; this.powers = powers;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.functions[i], this.powers[i])); }
    }

    public Layer (int dimension, double minimumPower, double maximumPower) {
        this.minimumPower = minimumPower; this.maximumPower = maximumPower;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.minimumPower, this.maximumPower)); }
    }

    public Layer (int dimension, double[] minimumPowers, double[] maximumPowers) {
        this.minimumPowers = minimumPowers; this.maximumPowers = maximumPowers;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.minimumPowers[i], this.maximumPowers[i])); }
    }

    public Layer (int dimension, String function, double minimumPower, double maximumPower) {
        this.function = function; this.minimumPower = minimumPower; this.maximumPower = maximumPower;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.function, this.minimumPower, this.maximumPower)); }
    }

    public Layer (int dimension, String[] functions, double minimumPower, double maximumPower) {
        this.functions = functions; this.minimumPower = minimumPower; this.maximumPower = maximumPower;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.functions[i], this.minimumPower, this.maximumPower)); }
    }

    public Layer (int dimension, String function, double[] minimumPowers, double[] maximumPowers) {
        this.minimumPowers = minimumPowers; this.maximumPowers = maximumPowers;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.function, this.minimumPowers[i], this.maximumPowers[i])); }
    }

    public Layer (int dimension, String[] functions, double[] minimumPowers, double[] maximumPowers) {
        this.functions = functions; this.minimumPowers = minimumPowers; this.maximumPowers = maximumPowers;
        for (int i = 1; i <= dimension; i++) { this.nodes.add(new Node(this.functions[i], this.minimumPowers[i], this.maximumPowers[i])); }
    }

    public ArrayList<Node> getNodes() { return this.nodes; }

    public void setNodes (ArrayList<Node> nodes) { this.nodes = nodes; }

    public void addNode(Node node) { this.nodes.add(node); }

    public String getFunction() { return this.function; }

    public void setFunction(String function) {
        this.function = function;
        for (Node node : nodes) { node.setFunction(this.function); }
    }

    public double getMinimumPower() { return this.minimumPower; }

    public void setMinimumPower(double minimumPower) {
        this.minimumPower = minimumPower;
        for (Node node : nodes) { node.setMinimumPower(this.minimumPower); }
    }

    public double getMaximumPower() { return this.maximumPower; }

    public void setMaximumPower(double maximumPower) {
        this.maximumPower = maximumPower;
        for (Node node : nodes) { node.setMaximumPower(this.maximumPower); }
    }

    public double[] getMinimumPowers() { return this.minimumPowers; }

    public void setMinimumPowers(double[] minimumPowers) {
        this.minimumPowers = minimumPowers;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setMinimumPower(this.minimumPowers[i]); }
    }

    public double[] getMaximumPowers() { return this.maximumPowers; }

    public void setMaximumPowers(double[] maximumPowers) {
        this.maximumPowers = maximumPowers;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setMaximumPower(this.maximumPowers[i]); }
    }

    public double getPower() { return this.power; }

    public void setPower(double power) {
        this.power = power;
        for (Node node : nodes) { node.setPower(this.power); }
    }

    public String[] getFunctions() { return this.functions; }

    public void setFunctions(String[] functions) {
        this.functions = functions;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setFunction(this.functions[i]); }
    }

    public double[] getPowers() { return this.powers; }

    public void setPowers(double[] powers) {
        this.powers = powers;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setPower(this.powers[i]); }
    }

    public double[] getErrorMeans() {
        double[] errorMeans = new double[this.nodes.size()];
        for (int i = 0; i < this.nodes.size(); i++) {
            errorMeans[i] = nodes.get(i).getErrorMean();
        } return errorMeans;
    }

    public double[] getHypotheses() {
        double[] hypotheses = new double[this.nodes.size()];
        for (int i = 0; i < this.nodes.size(); i++) {
            hypotheses[i] = nodes.get(i).getHypothesis();
        } return hypotheses;
    }

    public double[] getTheses() {
        double[] theses = new double[this.nodes.size()];
        for (int i = 0; i < this.nodes.size(); i++) {
            theses[i] = nodes.get(i).getThesis();
        } return theses; 
    }

    public void activate (double parameter) { // Activate all layer neurons.
        for (Node node : this.nodes) { node.activate(parameter); }
    }

    public void activate (double... parameters) { // Activate all layer neurons.
        for (int i = 0; i < this.nodes.size(); i++) { this.nodes.get(i).activate(parameters[i]); }
    }

    public void activate (double[]... parameters) { // Activate all layer neurons.
        for (int i = 0; i < this.nodes.size(); i++) { this.nodes.get(i).activate(parameters[i]); }
    }

    public void optimize (double[] objectives, int iteration) { // Optimize all layer neurons.
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).optimize(objectives[i], iteration); }
    }

    public void optimize (int iteration, double... errors) { // Optimize all layer neurons.
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).optimize(iteration, errors[i]); }
    }
}