/*--------------------------------------------------------------------------------------------------
 Javai is open-source framework for comprehensive learning.
 Copyright (C) 2022 Javai Foundation

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

 Email info@javai.org for IT support and/or special permission to use this framework.
----------------------------------------------------------------------------------------------------*/

package javai;

import java.util.ArrayList;

/**
 * Layer class consist of functions and methods for operations on a comprehensive layer.
 */
public class Layer {
    private ArrayList<Node> nodes = new ArrayList<>();
    private String functionName; private ArrayList<String> functionNameVec = new ArrayList<>();
    private double power; private ArrayList<Double> powerVec = new ArrayList<>();
    private double minPower; private double maxPower;
    private ArrayList<Double> minPowerVec = new ArrayList<>();
    private ArrayList<Double> maxPowerVec = new ArrayList<>();

    /**
     * This constructs a comprehensive layer by parametrically setting its dimension. The power
     * and comprehensive function of this layer is automatically configured by the Node object.
     */
    public Layer (int dimension) { for (int i = 0; i < dimension; i++) { this.nodes.add(new Node()); } }

    /**
     * This constructs a comprehensive layer by parametrically setting its dimension and functionName.
     * The functionName is a scalar-string; therefore, every node in the layer is assigned the same
     * functionName. The power of this layer is automatically configured by the Node object.
     */
    public Layer (int dimension, String functionName) { this.functionName = functionName;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionName)); }
    }

    /**
     * This constructs a comprehensive layer by parametrically setting its dimension and functionName.
     * The functionName is a vector-string; therefore, every node in the layer is assigned a specific
     * comprehensive function. The power of this layer is automatically configured by the Node object.
     */
    public Layer (Integer dimension, ArrayList<String> functionNameVec) { this.functionNameVec = functionNameVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionNameVec.get(i))); }
    }

    /**
     * This constructs a comprehensive layer by parametrically setting its dimension and power.
     * The power argument is a scalar; therefore, every node in the layer is assigned the same
     * power. The comprehensive function of this layer is automatically configured by the Node
     * object.
     */
    public Layer (int dimension, double power) { this.power = power;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.power)); }
    }

    /**
     * This constructs a comprehensive layer by parametrically setting its dimension and power.
     * The power argument is a vector; therefore, every node in the layer is assigned a specific
     * power. The comprehensive function of this layer is automatically configured by the Node
     * object.
     */
    public Layer (int dimension, ArrayList<Double> powerVec) { this.powerVec = powerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.powerVec.get(i))); }
    }

    /**
     * This constructs a comprehensive layer by parametrically setting its dimension, functionName,
     * and power. The power and functionName arguments are a scalar and scalar-string, respectively;
     * therefore, every node in the layer is assigned the same power and functionName.
     */
    public Layer (int dimension, String functionName, double power) { this.functionName = functionName; this.power = power;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionName, this.power)); }
    }

    /**
     * This constructs a comprehensive layer by parametrically setting its dimension, functionName,
     * and power. The power and functionName arguments are a scalar and vector-string, respectively;
     * therefore, every node in the layer is assigned the same power, but specific functionName.
     */
    public Layer (int dimension, ArrayList<String> functionNameVec, double power) {
        this.functionNameVec = functionNameVec; this.power = power;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionNameVec.get(i), this.power)); }
    }

    /**
     * This constructs a comprehensive layer by parametrically setting its dimension, functionName,
     * and power.The power and functionName arguments are a vector and scalar-string, respectively;
     * therefore,every node in the layer is assigned the same functionName, but specific power.
     */
    public Layer (int dimension, String functionName, ArrayList<Double> powerVec) {
        this.functionName = functionName; this.powerVec = powerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionName, this.powerVec.get(i))); }
    }

    /**
     * This constructs a comprehensive layer by parametrically setting its dimension, functionName,
     * and power. The power and functionName arguments are a vector and vector-string, respectively;
     * therefore, every node in the layer is assigned a specific power and functionName.
     */
    public Layer (Integer dimension, ArrayList<Double> powerVec, ArrayList<String> functionNameVec) {
        this.functionNameVec = functionNameVec; this.powerVec = powerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionNameVec.get(i), this.powerVec.get(i))); }
    }

    public Layer (int dimension, double minPower, double maxPower) { this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.minPower, this.maxPower)); }
    }

    public Layer (int dimension, ArrayList<Double> minPowerVec, ArrayList<Double> maxPowerVec) {
        this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.minPowerVec.get(i), this.maxPowerVec.get(i))); }
    }

    public Layer (int dimension, String functionName, double minPower, double maxPower) {
        this.functionName = functionName; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionName, this.minPower, this.maxPower)); }
    }

    public Layer (int dimension, ArrayList<String> functionNameVec, double minPower, double maxPower) {
        this.functionNameVec = functionNameVec; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < dimension; i++) {
            this.nodes.add(new Node(this.functionNameVec.get(i), this.minPower, this.maxPower));
        }
    }

    public Layer (int dimension, String functionName, ArrayList<Double> minPowerVec, ArrayList<Double> maxPowerVec) {
        this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < dimension; i++) {
            this.nodes.add(new Node(this.functionName, this.minPowerVec.get(i), this.maxPowerVec.get(i)));
        }
    }

    public Layer (int dimension, ArrayList<String> functionNameVec, ArrayList<Double> minPowerVec, ArrayList<Double> maxPowerVec) {
        this.functionNameVec = functionNameVec; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < dimension; i++) {
            this.nodes.add(new Node(this.functionNameVec.get(i), this.minPowerVec.get(i), this.maxPowerVec.get(i)));
        }
    }

    public ArrayList<Node> getNodes() { return this.nodes; }

    public void setNodes (ArrayList<Node> nodes) { this.nodes = nodes;
        this.functionNameVec = new ArrayList<>(); this.powerVec = new ArrayList<>();
        this.minPowerVec = new ArrayList<>(); this.maxPowerVec = new ArrayList<>();
        for (Node node : this.nodes) { this.functionNameVec.add(node.getFunctionName());
            this.powerVec.add(node.getPower()); this.minPowerVec.add(node.getMinPower());
            this.maxPowerVec.add(node.getMaxPower());
        }
    }

    public void addNode(Node node) { this.nodes.add(node);
        this.functionNameVec.add(node.getFunctionName()); this.powerVec.add(node.getPower());
        this.minPowerVec.add(node.getMinPower()); this.maxPowerVec.add(node.getMaxPower());
    }

    public int getDimension () { return this.nodes.size(); }

    public String getFunctionName() { return this.functionName; }

    public void setFunctionName(String functionName) { this.functionName = functionName;
        for (Node node : nodes) { node.setFunctionName(this.functionName); }
    }

    public double getMinPower() { return this.minPower; }

    public void setMinPower(double minPower) { this.minPower = minPower;
        for (Node node : nodes) { node.setPower(this.minPower); }
    }

    public double getMaxPower() { return this.maxPower; }

    public void setMaxPower(double maxPower) { this.maxPower = maxPower;
        for (Node node : nodes) { node.setPower(this.maxPower); }
    }

    public ArrayList<Double> getMinPowerVec() { return this.minPowerVec; }

    public void setMinPowerVec(ArrayList<Double> minPowerVec) { this.minPowerVec = minPowerVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setPower(this.minPowerVec.get(i)); }
    }

    public ArrayList<Double> getMaxPowerVec() { return this.maxPowerVec; }

    public void setMaxPowerVec(ArrayList<Double> maxPowerVec) { this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setPower(this.maxPowerVec.get(i)); }
    }

    public double getPower() { return this.power; }

    public void setPower(double power) { this.power = power;
        for (Node node : nodes) { node.setPower(this.power); }
    }

    public ArrayList<String> getFunctionNameVec() { return this.functionNameVec; }

    public void setFunctionNameVec(ArrayList<String> functionNameVec) { this.functionNameVec = functionNameVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setFunctionName(this.functionNameVec.get(i)); }
    }

    public ArrayList<Double> getPowerVec() { return this.powerVec; }

    public void setPowerVec(ArrayList<Double> powerVec) { this.powerVec = powerVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setPower(this.powerVec.get(i)); }
    }

    public double[] getMeanErrorVec() {
        double[] meanErrorVec = new double[this.nodes.size()];
        for (int i = 0; i < meanErrorVec.length; i++) { meanErrorVec[i] = nodes.get(i).getMeanError(); }
        return meanErrorVec;
    }

    public double[] getHypothesisVec() {
        double[] hypothesisVec = new double[this.nodes.size()];
        for (int i = 0; i < hypothesisVec.length; i++) { hypothesisVec[i] = nodes.get(i).getHypothesis(); }
        return hypothesisVec;
    }

    public double[] getThesisVec() {
        double[] thesisVec = new double[this.nodes.size()];
        for (int i = 0; i < thesisVec.length; i++) { thesisVec[i] = nodes.get(i).getThesis(); }
        return thesisVec;
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