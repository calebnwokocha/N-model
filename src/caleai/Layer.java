package caleai;

/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * SCHOOL: THE UNIVERSITY OF MANITOBA
 * DEPARTMENT: COMPUTER SCIENCE
 * WARNING: THIS SOURCE CODE IS AVAILABLE UNDER GNU AFFERO GENERAL PUBLIC LICENSE.
 *          CONTACT CALEBNWOKOCHA@GMAIL.COM FOR SPECIAL PERMISSION OR LICENSE
 *          TO USE THIS SOURCE CODE.
 */

import java.util.ArrayList;

public class Layer {
    private ArrayList<Node> nodes = new ArrayList<>();
    private String function; private String[] functionVec;
    private double power; private double[] powerVec;
    private double minPower; private double maxPower;
    private double[] minPowerVec; private double[] maxPowerVec;

    // Construct layer.
    public Layer (int dimension) { for (int i = 0; i < dimension; i++) { this.nodes.add(new Node()); } }

    public Layer (int dimension, String function) { this.function = function;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.function)); }
    }

    public Layer (int dimension, String[] functionVec) { this.functionVec = functionVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionVec[i])); }
    }

    public Layer (int dimension, double power) { this.power = power;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.power)); }
    }

    public Layer (int dimension, double[] powerVec) { this.powerVec = powerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.powerVec[i])); }
    }

    public Layer (int dimension, String function, double power) { this.function = function; this.power = power;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.function, this.power)); }
    }

    public Layer (int dimension, String[] functionVec, double power) { this.functionVec = functionVec; this.power = power;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionVec[i], this.power)); }
    }

    public Layer (int dimension, String function, double[] powerVec) { this.function = function; this.powerVec = powerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.function, this.powerVec[i])); }
    }

    public Layer (int dimension, String[] functionVec, double[] powerVec) { this.functionVec = functionVec; this.powerVec = powerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionVec[i], this.powerVec[i])); }
    }

    public Layer (int dimension, double minPower, double maxPower) { this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.minPower, this.maxPower)); }
    }

    public Layer (int dimension, double[] minPowerVec, double[] maxPowerVec) {
        this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Layer (int dimension, String function, double minPower, double maxPower) {
        this.function = function; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.function, this.minPower, this.maxPower)); }
    }

    public Layer (int dimension, String[] functionVec, double minPower, double maxPower) {
        this.functionVec = functionVec; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionVec[i], this.minPower, this.maxPower)); }
    }

    public Layer (int dimension, String function, double[] minPowerVec, double[] maxPowerVec) {
        this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.function, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Layer (int dimension, String[] functionVec, double[] minPowerVec, double[] maxPowerVec) {
        this.functionVec = functionVec; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionVec[i], this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public ArrayList<Node> getNodes() { return this.nodes; }

    public void setNodes (ArrayList<Node> nodes) { this.nodes = nodes; }

    public void addNode(Node node) { this.nodes.add(node); }

    public int getDimension () { return this.nodes.size(); }

    public String getFunction() { return this.function; }

    public void setFunction(String function) { this.function = function;
        for (Node node : nodes) { node.setFunction(this.function); }
    }

    public double getMinPower() { return this.minPower; }

    public void setMinPower(double minPower) { this.minPower = minPower;
        for (Node node : nodes) { node.setPower(this.minPower); }
    }

    public double getMaxPower() { return this.maxPower; }

    public void setMaxPower(double maxPower) { this.maxPower = maxPower;
        for (Node node : nodes) { node.setPower(this.maxPower); }
    }

    public double[] getMinPowerVec() { return this.minPowerVec; }

    public void setMinPowerVec(double[] minPowerVec) { this.minPowerVec = minPowerVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setPower(this.minPowerVec[i]); }
    }

    public double[] getMaxPowerVec() { return this.maxPowerVec; }

    public void setMaxPowerVec(double[] maxPowerVec) { this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setPower(this.maxPowerVec[i]); }
    }

    public double getPower() { return this.power; }

    public void setPower(double power) { this.power = power;
        for (Node node : nodes) { node.setPower(this.power); }
    }

    public String[] getFunctionVec() { return this.functionVec; }

    public void setFunctionVec(String[] functionVec) { this.functionVec = functionVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setFunction(this.functionVec[i]); }
    }

    public double[] getPowerVec() { return this.powerVec; }

    public void setPowerVec(double[] powerVec) { this.powerVec = powerVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setPower(this.powerVec[i]); }
    }

    public double[] getMeanErrorVec() {
        double[] meanErrorVec = new double[this.nodes.size()];
        for (int i = 0; i < meanErrorVec.length; i++) {
            meanErrorVec[i] = nodes.get(i).getMeanError();
        } return meanErrorVec;
    }

    public double[] getHypothesisVec() {
        double[] hypothesisVec = new double[this.nodes.size()];
        for (int i = 0; i < hypothesisVec.length; i++) {
            hypothesisVec[i] = nodes.get(i).getHypothesis();
        } return hypothesisVec;
    }

    public double[] getThesisVec() {
        double[] thesisVec = new double[this.nodes.size()];
        for (int i = 0; i < thesisVec.length; i++) {
            thesisVec[i] = nodes.get(i).getThesis();
        } return thesisVec;
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