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

    public String[] getCFunctionNameVec() { String[] cFunctionNameVec = new String[this.nodes.size()];
        for (int i = 0; i < cFunctionNameVec.length; i++) {
            cFunctionNameVec[i] = nodes.get(i).getCFunctionName();
        } return cFunctionNameVec;
    }

    public void setCFunctionVec(String[] cFunctionNameVec, double[] degreeVec,
                                    Function<Double[], Double>[] cFunctionVec) {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).setCFunction(cFunctionNameVec[i], degreeVec[i], cFunctionVec[i]);
        }
    }

    public double[] getDegreeVec() { double[] degreeVec = new double[this.nodes.size()];
        for (int i = 0; i < degreeVec.length; i++) { degreeVec[i] = nodes.get(i).getDegree(); }
        return degreeVec;
    }

    public double[] getPowerVec() { double[] powerVec = new double[this.nodes.size()];
        for (int i = 0; i < powerVec.length; i++) { powerVec[i] = nodes.get(i).getPower(); }
        return powerVec;
    }

    public void setPowerVec(double[] powerVec) {
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setPower(powerVec[i]); }
    }

    public void setCoverage (Double coverage) {
        for (Node node : this.nodes) { node.setCoverage(coverage); }
    }

    public void setCoverageVec (Double[] coverageVec) {
        for (int i = 0; i < nodes.size(); i++) { nodes.get(i).setCoverage(coverageVec[i]); }
    }

    public Double[] getCoverageVec () { Double[] coverageVec = new Double[this.nodes.size()];
        for (int i = 0; i < coverageVec.length; i++) { coverageVec[i] = nodes.get(i).getCoverage(); }
        return coverageVec;
    }

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