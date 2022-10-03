/*=======================================================================
 Caleai is an open-source framework for comprehensive learning.
 Copyright (C) 2022 Caleb Princewill Nwokocha

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

 Contact calebnwokocha@gmail.com for special permission to use this software.
=========================================================================*/

package javis;

import java.util.ArrayList;

public class Layer {
    private ArrayList<Node> nodes = new ArrayList<>();
    private String functionName; private String[] functionNameVec;
    private double power; private double[] powerVec;
    private double minPower; private double maxPower;
    private double[] minPowerVec; private double[] maxPowerVec;

    // Construct layer.
    public Layer (int dimension) { for (int i = 0; i < dimension; i++) { this.nodes.add(new Node()); } }

    public Layer (int dimension, String functionName) { this.functionName = functionName;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionName)); }
    }

    public Layer (int dimension, String[] functionNameVec) { this.functionNameVec = functionNameVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionNameVec[i])); }
    }

    public Layer (int dimension, double power) { this.power = power;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.power)); }
    }

    public Layer (int dimension, double[] powerVec) { this.powerVec = powerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.powerVec[i])); }
    }

    public Layer (int dimension, String functionName, double power) { this.functionName = functionName; this.power = power;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionName, this.power)); }
    }

    public Layer (int dimension, String[] functionNameVec, double power) { this.functionNameVec = functionNameVec; this.power = power;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionNameVec[i], this.power)); }
    }

    public Layer (int dimension, String functionName, double[] powerVec) { this.functionName = functionName; this.powerVec = powerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionName, this.powerVec[i])); }
    }

    public Layer (int dimension, String[] functionNameVec, double[] powerVec) { this.functionNameVec = functionNameVec; this.powerVec = powerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionNameVec[i], this.powerVec[i])); }
    }

    public Layer (int dimension, double minPower, double maxPower) { this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.minPower, this.maxPower)); }
    }

    public Layer (int dimension, double[] minPowerVec, double[] maxPowerVec) {
        this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Layer (int dimension, String functionName, double minPower, double maxPower) {
        this.functionName = functionName; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionName, this.minPower, this.maxPower)); }
    }

    public Layer (int dimension, String[] functionNameVec, double minPower, double maxPower) {
        this.functionNameVec = functionNameVec; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionNameVec[i], this.minPower, this.maxPower)); }
    }

    public Layer (int dimension, String functionName, double[] minPowerVec, double[] maxPowerVec) {
        this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionName, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Layer (int dimension, String[] functionNameVec, double[] minPowerVec, double[] maxPowerVec) {
        this.functionNameVec = functionNameVec; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < dimension; i++) { this.nodes.add(new Node(this.functionNameVec[i], this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public ArrayList<Node> getNodes() { return this.nodes; }

    public void setNodes (ArrayList<Node> nodes) { this.nodes = nodes; }

    public void addNode(Node node) { this.nodes.add(node); }

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

    public String[] getFunctionNameVec() { return this.functionNameVec; }

    public void setFunctionNameVec(String[] functionNameVec) { this.functionNameVec = functionNameVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setFunctionName(this.functionNameVec[i]); }
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