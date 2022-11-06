/*------------------------------------------------------------------------------
 Open-source framework for comprehensive learning.

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

 Email calebnwokocha@gmail.com for technical support and/or special
 permission to use this framework.
---------------------------------------------------------------------------- */

package cml;

import java.util.ArrayList;

public class Layer {
    private ArrayList<Node> nodes = new ArrayList<>();
    private String functionName; private ArrayList<String> functionNameVec;
    private double power; private Double coverage;
    private ArrayList<Double> powerVec, coverageVec;

    public Layer (int width) { for (int i = 0; i < width; i++) { this.nodes.add(new Node()); } }

    public ArrayList<Node> getNodes() { return this.nodes; }

    public void setNodes (ArrayList<Node> nodes) { this.nodes = nodes;
        this.functionNameVec = new ArrayList<>(); this.powerVec = new ArrayList<>();
        this.coverageVec = new ArrayList<>();
        for (Node node : this.nodes) { this.functionNameVec.add(node.getFunctionName());
            this.powerVec.add(node.getPower()); this.coverageVec.add(node.getCoverage());
        }
    }

    public void addNode(Node node) { this.nodes.add(node);
        this.functionNameVec.add(node.getFunctionName()); this.powerVec.add(node.getPower());
        this.coverageVec.add(node.getCoverage());
    }

    public void deleteNode (int index) { this.nodes.remove(index); }

    public int getWidth () { return this.nodes.size(); }

    public String getFunctionName() { return this.functionName; }

    public String getFunctionName (int index) { return this.functionNameVec.get(index); }

    public void setFunctionName(String functionName) { this.functionName = functionName;
        for (Node node : nodes) { node.setFunctionName(this.functionName); }
    }

    public double getPower() { return this.power; }

    public double getPower (int index) { return this.powerVec.get(index); }

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

    public double getCoverage (int index) { return this.coverageVec.get(index); }

    public void setCoverageVec (ArrayList<Double> coverageVec) { this.coverageVec = coverageVec;
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setCoverage(this.coverageVec.get(i)); }
    }

    public ArrayList<Double> getCoverageVec () { return this.coverageVec; }

    public double[] getErrorMeanVec() { double[] errorMeanVec = new double[this.nodes.size()];
        for (int i = 0; i < errorMeanVec.length; i++) { errorMeanVec[i] = this.nodes.get(i).getErrorMean(); }
        return errorMeanVec;
    }

    public Double[] getHypothesisVec() { Double[] hypothesisVec = new Double[this.nodes.size()];
        for (int i = 0; i < hypothesisVec.length; i++) { hypothesisVec[i] = this.nodes.get(i).getHypothesis(); }
        return hypothesisVec;
    }

    public Double[] getThesisVec() { Double[] thesisVec = new Double[this.nodes.size()];
        for (int i = 0; i < thesisVec.length; i++) { thesisVec[i] = this.nodes.get(i).getThesis(); }
        return thesisVec;
    }

    public void test (Double[]... input) {
        for (int i = 0; i < this.nodes.size(); i++) {
            if (input.length > 1) { this.nodes.get(i).test(input[i]); }
            else { this.nodes.get(i).test(input[0]); }
        }
    }

    public void train (int iteration, double[] objectives, Double[]... input) {
        for (int i = 0; i < this.nodes.size(); i++) {
            if (input.length > 1) { this.nodes.get(i).train(objectives[i], iteration, input[i]); }
            else { this.nodes.get(i).train(objectives[i], iteration, input[0]); }
        }
    }

    public void train (int iteration, double error, Double[]... input) {
        for (int i = 0; i < this.nodes.size(); i++) {
            if (input.length > 1) { nodes.get(i).train(error, iteration, input[i]); }
            else { nodes.get(i).train(error, iteration, input[0]); }
        }
    }
}