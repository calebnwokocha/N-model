/*------------------------------------------------------------------------------
 Javai is open-source framework for comprehensive learning, produced and
 maintained by the Javai Foundation.

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

 Email info@nmodel.org for technical support and/or special permission
 to use this framework.
---------------------------------------------------------------------------- */

package nmodel;

import java.util.ArrayList;

/**
 * Layer class consist of functions and methods for operations on a comprehensive layer.
 */
public class Layer {
    private ArrayList<Node> nodes = new ArrayList<>();
    private String functionName; private ArrayList<String> functionNameVec;
    private double minPower, maxPower, power; private Double coverage;
    private ArrayList<Double> minPowerVec, maxPowerVec, powerVec, coverageVec;

    /**
     * This constructs a comprehensive layer by parametrically setting its width. The powers
     * and comprehensive functions of the layer is automatically configured by the Node object.
     *
     * @see Node
     */
    public Layer (int width) { for (int i = 0; i < width; i++) { this.nodes.add(new Node()); } }

    public ArrayList<Node> getNodes() { return this.nodes; }

    public void setNodes (ArrayList<Node> nodes) { this.nodes = nodes;
        this.functionNameVec = new ArrayList<>(); this.powerVec = new ArrayList<>();
        this.minPowerVec = new ArrayList<>(); this.maxPowerVec = new ArrayList<>();
        this.coverageVec = new ArrayList<>();
        for (Node node : this.nodes) { this.functionNameVec.add(node.getFunctionName());
            this.powerVec.add(node.getPower()); this.minPowerVec.add(node.getMinPower());
            this.maxPowerVec.add(node.getMaxPower()); this.coverageVec.add(node.getCoverage());
        }
    }

    public void addNode(Node node) { this.nodes.add(node);
        this.functionNameVec.add(node.getFunctionName()); this.powerVec.add(node.getPower());
        this.minPowerVec.add(node.getMinPower()); this.maxPowerVec.add(node.getMaxPower());
        this.coverageVec.add(node.getCoverage());
    }

    public int getWidth () { return this.nodes.size(); }

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

    public void setFunctionNameVec(ArrayList<String> functionNameVec) {
        this.functionNameVec = functionNameVec;
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).setFunctionName(this.functionNameVec.get(i));
        }
    }

    public ArrayList<Double> getPowerVec() { return this.powerVec; }

    public void setPowerVec(ArrayList<Double> powerVec) { this.powerVec = powerVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setPower(this.powerVec.get(i)); }
    }

    public void setCoverage (Double coverage) { this.coverage = coverage;
        for (Node node : this.nodes) { node.setCoverage(this.coverage); }
    }

    public Double getCoverage () { return this.coverage; }

    public void setCoverageVec (ArrayList<Double> coverageVec) { this.coverageVec = coverageVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setCoverage(this.coverageVec.get(i)); }
    }

    public ArrayList<Double> getCoverageVec () { return this.coverageVec; }

    public double[] getErrorMeanVec() { double[] errorMeanVec = new double[this.nodes.size()];
        for (int i = 0; i < errorMeanVec.length; i++) { errorMeanVec[i] = nodes.get(i).getErrorMean(); }
        return errorMeanVec;
    }

    public Double[] getHypothesisVec() { Double[] hypothesisVec = new Double[this.nodes.size()];
        for (int i = 0; i < hypothesisVec.length; i++) { hypothesisVec[i] = nodes.get(i).getHypothesis(); }
        return hypothesisVec;
    }

    public Double[] getThesisVec() { Double[] thesisVec = new Double[this.nodes.size()];
        for (int i = 0; i < thesisVec.length; i++) { thesisVec[i] = nodes.get(i).getThesis(); }
        return thesisVec;
    }

    public void test (Double... input) { // Activate all layer neurons.
        for (int i = 0; i < this.nodes.size(); i++) { this.nodes.get(i).test(input[i]); }
    }

    public void test (Double[]... input) { // Activate all layer neurons.
        for (int i = 0; i < this.nodes.size(); i++) { this.nodes.get(i).test(input[i]); }
    }

    public void train (int iteration, double[] objectives, Double... input) { // Optimize all layer neurons.
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).train(objectives[i], iteration, input[i]); }
    }

    public void train (int iteration, double[] objectives, Double[]... input) { // Optimize all layer neurons.
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).train(objectives[i], iteration, input[i]); }
    }

    public void train (int iteration, double error, Double[]... input) { // Optimize all layer neurons.
        for (int i = 0; i < nodes.size(); i++) { double nodeError = nodes.get(i).getThesis() / error;
            nodes.get(i).train(nodeError, iteration, input[i]);
        }
    }
}