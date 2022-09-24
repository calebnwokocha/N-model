package caleai;/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

import java.util.ArrayList;

public class Layer {
    private final ArrayList<Node> nodes = new ArrayList<>();

    // Construct layer.
    public Layer (int dimension) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node()); }
    }

    public Layer (int dimension, String function, double power) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(function, power)); }
    }

    public Layer (int dimension, String[] functions, double power) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(functions[i], power)); }
    }

    public Layer (int dimension, String function, double[] powers) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(function, powers[i])); }
    }

    public Layer (int dimension, String[] functions, double[] powers) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(functions[i], powers[i])); }
    }

    public Layer (int dimension, String function) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(function)); }
    }

    public Layer (int dimension, String[] functions) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(functions[i])); }
    }

    public Layer (int dimension, double minimumPower, double maximumPower) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(minimumPower, maximumPower)); }
    }

    public Layer (int dimension, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(minimumPowers[i], maximumPowers[i])); }
    }

    public Layer (int dimension, String function, double minimumPower, double maximumPower) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(function, minimumPower, maximumPower)); }
    }

    public Layer (int dimension, String[] functions, double minimumPower, double maximumPower) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(functions[i], minimumPower, maximumPower)); }
    }

    public Layer (int dimension, String function, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(function, minimumPowers[i], maximumPowers[i])); }
    }

    public Layer (int dimension, String[] functions, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(functions[i], minimumPowers[i], maximumPowers[i])); }
    }

    public ArrayList<Node> getNodes() { return this.nodes; }

    public void addNode(Node node) { this.nodes.add(node); }

    public void activate (byte parameter) { // Activate all layer neurons.
        for (Node node : this.nodes) { node.activate(parameter); }
    }

    public void activate (byte... parameters) { // Activate all layer neurons.
        for (int i = 0; i < this.nodes.size(); i++) { this.nodes.get(i).activate(parameters[i]); }
    }

    public void activate (byte[]... parameters) { // Activate all layer neurons.
        for (int i = 0; i < this.nodes.size(); i++) { this.nodes.get(i).activate(parameters[i]); }
    }

    public void optimize (double[] objectives, int iteration) { // Optimize all layer neurons.
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).optimize(objectives[i], iteration); }
    }

    public void optimize (int iteration, double... error) { // Optimize all layer neurons.
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).optimize(iteration, error[i]); }
    }
}