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

public class Network {
    private ArrayList<Layer> layers = new ArrayList<>();
    private int width; private ArrayList<Integer> widthVec;
    private String functionName; private ArrayList<String> functionNameVec;
    private ArrayList<ArrayList<String>> functionNameMat;
    private double power; private Double coverage;
    private ArrayList<Double> powerVec, coverageVec;
    private ArrayList<ArrayList<Double>> powerMat, coverageMat;

    public Network (int length, int width) {
        this.width = width;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width)); }
    }

    public Network (int length, ArrayList<Integer> widthVec) {
        this.widthVec = widthVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec.get(i))); }
    }

    public ArrayList<Layer> getLayers () { return this.layers; }

    public void setLayers (ArrayList<Layer> layers) { this.layers = layers;
        this.functionNameMat = new ArrayList<>(); this.powerMat = new ArrayList<>();
        this.widthVec = new ArrayList<>(); this.coverageMat = new ArrayList<>();
        for (Layer layer : this.layers) { this.functionNameMat.add(layer.getFunctionNameVec());
            this.powerMat.add(layer.getPowerVec()); this.widthVec.add(layer.getWidth());
            this.coverageMat.add(layer.getCoverageVec());
        }
    }

    public void addLayer (Layer layer) { this.layers.add(layer);
        this.functionNameMat.add(layer.getFunctionNameVec()); this.powerMat.add(layer.getPowerVec());
        this.widthVec.add(layer.getWidth()); this.coverageMat.add(layer.getCoverageVec());
    }

    public void deleteLayer (int index) { this.layers.remove(index); }

    public int getLength () { return this.layers.size(); }
    
    public void setWidth (int width) { this.width = width; }
    
    public int getWidth () { return this.width; }

    public int getWidth (int index) { return this.widthVec.get(index); }

    public void setWidthVec (ArrayList<Integer> widthVec) { this.widthVec = widthVec; }
    
    public ArrayList<Integer> getWidthVec () { return this.widthVec; }

    public void setFunctionName(String functionName) { this.functionName = functionName;
        for (Layer layer : this.layers) { layer.setFunctionName(this.functionName); }
    }

    public String getFunctionName() { return this.functionName; }

    public String getFunctionName (int index) { return this.functionNameVec.get(index); }

    public String getFunctionName (int indexI, int indexJ) {
        return this.functionNameMat.get(indexI).get(indexJ);
    }

    public void setFunctionNameVec(ArrayList<String> functionNameVec) {
        this.functionNameVec = functionNameVec;
        for (Layer layer : this.layers) { layer.setFunctionNameVec(this.functionNameVec); }
    }

    public ArrayList<String> getFunctionNameVec() { return this.functionNameVec; }

    public void setFunctionNameMat(ArrayList<ArrayList<String>> functionNameMat) {
        this.functionNameMat = functionNameMat;
        for (int i = 0; i < layers.size(); i++) {
            layers.get(i).setFunctionNameVec(this.functionNameMat.get(i));
        }
    }

    public ArrayList<ArrayList<String>> getFunctionNameMat() { return this.functionNameMat; }

    public void setPower (double power) { this.power = power;
        for (Layer layer : this.layers) { layer.setPower(this.power); }
    }

    public double getPower () { return this.power; }

    public double getPower (int index) { return this.powerVec.get(index); }

    public double getPower (int indexI, int indexJ) { return this.powerMat.get(indexI).get(indexJ); }

    public void setPowerVec (ArrayList<Double> powerVec) { this.powerVec = powerVec;
        for (Layer layer : this.layers) { layer.setPowerVec(this.powerVec); }
    }

    public ArrayList<Double> getPowerVec () { return this.powerVec; }

    public void setPowerMat (ArrayList<ArrayList<Double>> powerMat) { this.powerMat = powerMat;
        for (int i = 0; i < layers.size(); i++) { layers.get(i).setPowerVec(this.powerMat.get(i)); }
    }

    public ArrayList<ArrayList<Double>> getPowerMat () { return this.powerMat; }

    public void setCoverage (Double coverage) { this.coverage = coverage;
        for (Layer layer : this.layers) { layer.setCoverage(this.coverage); }
    }

    public Double getCoverage () { return this.coverage; }

    public double getCoverage (int index) { return this.coverageVec.get(index); }

    public double getCoverage (int indexI, int indexJ) { return this.coverageMat.get(indexI).get(indexJ); }

    public void setCoverageVec (ArrayList<Double> coverageVec) { this.coverageVec = coverageVec;
        for (Layer layer : this.layers) { layer.setCoverageVec(this.coverageVec); }
    }

    public ArrayList<Double> getCoverageVec () { return this.coverageVec; }

    public void setCoverageMat (ArrayList<ArrayList<Double>> coverageMat) { this.coverageMat = coverageMat;
        for (int i = 0; i < layers.size(); i++) { layers.get(i).setCoverageVec(this.coverageMat.get(i)); }
    }

    public ArrayList<ArrayList<Double>> getCoverageMat () { return this.coverageMat; }

    public double[][] getErrorMeanMat() { double[][] errorMeanMat = new double[this.layers.size()][];
        for (int i = 0; i < errorMeanMat.length; i++) {
            errorMeanMat[i] = this.layers.get(i).getErrorMeanVec();
        } return errorMeanMat;
    }

    public Double[][] getHypothesisMat() { Double[][] hypothesisMat = new Double[this.layers.size()][];
        for (int i = 0; i < hypothesisMat.length; i++) {
            hypothesisMat[i] = this.layers.get(i).getHypothesisVec();
        } return hypothesisMat;
    }

    public Double[][] getThesisMat() { Double[][] thesisMat = new Double[this.layers.size()][];
        for (int i = 0; i < thesisMat.length; i++) { thesisMat[i] = this.layers.get(i).getThesisVec(); }
        return thesisMat;
    }

    public void test (Double[]... input) {
        for (int i = 0; i < this.layers.size(); i++) {
            if (i == 0) {this.layers.get(i).test(input); }
            else { this.layers.get(i).test(this.layers.get(i - 1).getThesisVec()); }
        }
    }

    public void train (int iteration, double[] objective, Double[]... input) {
        for (int i = 0; i < this.layers.size(); i++) {
            if (i == 0) { this.layers.get(i).train(iteration, objective, input); }
            else { this.layers.get(i).train(iteration, objective, this.layers.get(i - 1).getThesisVec()); }
        }
    }
}