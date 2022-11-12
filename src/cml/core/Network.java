/*------------------------------------------------------------------------------
 Open-source framework for comprehensive machine learning.

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

package cml.core;

import java.util.ArrayList;
import java.util.function.Function;

public class Network {
    private ArrayList<Layer> layers = new ArrayList<>();

    public Network (int length, int width) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width)); }
    }

    public Network (int length, int[] widthVec) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widthVec[i])); }
    }

    public ArrayList<Layer> getLayers () { return this.layers; }

    public void setLayers (ArrayList<Layer> layers) { this.layers = layers; }

    public void addLayer (Layer layer) { this.layers.add(layer); }

    public void deleteLayer (int index) { this.layers.remove(index); }

    public int getLength () { return this.layers.size(); }

    public int getWidth (int index) { return this.getWidthVec()[index]; }

    public int[] getWidthVec () { int[] widthVec = new int[this.layers.size()];
        for (int i = 0; i < widthVec.length; i++) { widthVec[i] = this.layers.get(i).getWidth(); }
        return widthVec;
    }

    public void setCFunction (String cFunctionName, double degree, Function<Double[], Double> cFunction) {
        for (Layer layer : layers) { layer.setCFunction (cFunctionName, degree, cFunction); }
    }

    public void setCFunctionVec(String[] cFunctionNameVec, double[] degreeVec,
                                    Function<Double[], Double>[] cFunctionVec) {
        for (int i = 0; i < layers.size(); i++) {
            layers.get(i).setCFunction(cFunctionNameVec[i], degreeVec[i], cFunctionVec[i]);
        }
    }

    public void setCFunctionMat(String[][] cFunctionNameMat, double[][] degreeMat,
                                    Function<Double[], Double>[][] cFunction) {
        for (int i = 0; i < layers.size(); i++) {
            layers.get(i).setCFunctionVec(cFunctionNameMat[i], degreeMat[i], cFunction[i]);
        }
    }

    public String[][] getCFunctionNameMat() { String[][] cFunctionMat = new String[this.layers.size()][];
        for (int i = 0; i < cFunctionMat.length; i++) {
            cFunctionMat[i] = layers.get(i).getCFunctionNameVec();
        } return cFunctionMat;
    }

    public double[][] getDegreeMat() {
        double[][] degreeMat = new double[this.layers.size()][];
        for (int i = 0; i < degreeMat.length; i++) { degreeMat[i] = layers.get(i).getDegreeVec(); }
        return degreeMat;
    }

    public void setPower (double power) { for (Layer layer : this.layers) { layer.setPower(power); } }

    public void setPowerVec (double[] powerVec) {
        for (Layer layer : this.layers) { layer.setPowerVec(powerVec); }
    }

    public void setPowerMat (double[][] powerMat) {
        for (int i = 0; i < layers.size(); i++) { layers.get(i).setPowerVec(powerMat[i]); }
    }

    public double[][] getPowerMat () {
        double[][] powerMat = new double[this.layers.size()][];
        for (int i = 0; i < powerMat.length; i++) { powerMat[i] = layers.get(i).getPowerVec(); }
        return powerMat;
    }

    public void setCoverage (Double coverage) {
        for (Layer layer : this.layers) { layer.setCoverage(coverage); }
    }

    public void setCoverageVec (Double[] coverageVec) {
        for (Layer layer : this.layers) { layer.setCoverageVec(coverageVec); }
    }

    public void setCoverageMat (Double[][] coverageMat) {
        for (int i = 0; i < layers.size(); i++) { layers.get(i).setCoverageVec(coverageMat[i]); }
    }

    public Double[][] getCoverageMat () {
        Double[][] coverageMat = new Double[this.layers.size()][];
        for (int i = 0; i < coverageMat.length; i++) { coverageMat[i] = layers.get(i).getCoverageVec(); }
        return coverageMat;
    }

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
            if (this.isNull(this.layers.get(i))) { this.nullifyNetOutput(); break; }
        }
    }

    public void train (int iteration, double[] objective, Double[]... input) {
        for (int i = 0; i < this.layers.size(); i++) {
            if (i == 0) { this.layers.get(i).train(iteration, objective, input); }
            else { this.layers.get(i).train(iteration, objective, this.layers.get(i - 1).getThesisVec()); }
        }
    }

    private boolean isNull (Layer layer) {
        for (Node node : layer.getNodes()) { if (node.getThesis() == null) { return true; } }
        return false;
    }

    private void nullifyNetOutput () { this.layers.get(this.getLength() - 1).test(new Double[][]{{null}}); }
}