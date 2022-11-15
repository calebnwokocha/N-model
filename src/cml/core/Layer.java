/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package cml.core;

import java.util.ArrayList;
import java.util.function.Function;

public class Layer {
    private ArrayList<Node> nodes = new ArrayList<>();

    public Layer (int width) { for (int i = 0; i < width; i++) { this.nodes.add(new Node()); } }

    public ArrayList<Node> getNodes() { return this.nodes; }

    public void setNodes (ArrayList<Node> nodes) { this.nodes = nodes; }

    public void addNode(Node node) { this.nodes.add(node); }

    public void removeNode (int index) { this.nodes.remove(index); }

    public int getWidth () { return this.nodes.size(); }

    public void setCFunction (String cFunctionName, double degree, Function<Double[], Double> cFunction) {
        for (Node node : nodes) { node.setCFunction (cFunctionName, degree, cFunction); }
    }

    public void setPower(double power) { for (Node node : nodes) { node.setPower(power); } }

    public String[] getCFunctionName() { String[] cFunctionName = new String[this.nodes.size()];
        for (int i = 0; i < cFunctionName.length; i++) {
            cFunctionName[i] = nodes.get(i).getCFunctionName();
        } return cFunctionName;
    }

    public void setCFunction(String[] cFunctionName, double[] degree,
                             Function<Double[], Double>[] cFunction) {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).setCFunction(cFunctionName[i], degree[i], cFunction[i]);
        }
    }

    public double[] getDegree() { double[] degree = new double[this.nodes.size()];
        for (int i = 0; i < degree.length; i++) { degree[i] = nodes.get(i).getDegree(); }
        return degree;
    }

    public double[] getPower() { double[] power = new double[this.nodes.size()];
        for (int i = 0; i < power.length; i++) { power[i] = nodes.get(i).getPower(); }
        return power;
    }

    public void setPower(double[] power) {
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setPower(power[i]); }
    }

    public void setCoverage (Double coverage) {
        for (Node node : this.nodes) { node.setCoverage(coverage); }
    }

    public void setCoverage (Double[] coverage) {
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setCoverage(coverage[i]); }
    }

    public Double[] getCoverage () { Double[] coverage = new Double[this.nodes.size()];
        for (int i = 0; i < coverage.length; i++) { coverage[i] = nodes.get(i).getCoverage(); }
        return coverage;
    }

    public Double[] getErrorMean() { Double[] errorMean = new Double[this.nodes.size()];
        for (int i = 0; i < errorMean.length; i++) { errorMean[i] = this.nodes.get(i).getErrorMean(); }
        return errorMean;
    }

    public void setErrorMean (Double[] errorMean) { 
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setErrorMean(errorMean[i]); } 
    }

    public Double[] getHypothesis() { Double[] hypothesis = new Double[this.nodes.size()];
        for (int i = 0; i < hypothesis.length; i++) { hypothesis[i] = this.nodes.get(i).getHypothesis(); }
        return hypothesis;
    }

    public Double[] getThesis() { Double[] thesis = new Double[this.nodes.size()];
        for (int i = 0; i < thesis.length; i++) { thesis[i] = this.nodes.get(i).getThesis(); }
        return thesis;
    }

    public void train (int iteration, double[] objectives, Double[]... input) {
        for (int i = 0; i < this.nodes.size(); i++) {
            if (input.length > 1) {
                try { this.nodes.get(i).train(objectives[i], iteration, input[i]); }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Make sure layer width is equal to layer input length.");
                }
            } else { this.nodes.get(i).train(objectives[i], iteration, input[0]); }
        }
    }

    public void test (Double[]... input) {
        for (int i = 0; i < this.nodes.size(); i++) {
            if (input.length > 1) {
                try { this.nodes.get(i).test(input[i]); }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Make sure layer width is equal to layer input length.");
                }
            } else { this.nodes.get(i).test(input[0]); }
        }
    }
}