/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

import java.util.ArrayList;

public class Layer {
    private final ArrayList<Node> nodes = new ArrayList<>();

    // Construct layer.
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

    public void optimize (int iteration, double[] error) { // Optimize all layer neurons.
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).optimize(iteration, error[i]); }
    }
}