/*=======================================================================
 Javis is an open-source software framework for comprehensive learning.
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

public class Network {
    private ArrayList<Layer> layers = new ArrayList<>();
    private int width; private int[] widthVec; 
    private String functionName; private String[] functionNameVec; private String[][] functionNameMat;
    private double power; private double[] powerVec; private double[][] powerMat;
    private double minPower; private double maxPower;
    private double[] minPowerVec; private double[] maxPowerVec;
    private double[][] minPowerMat; private double[][] maxPowerMat;

    // Construct network.
    public Network (int width, int length) {
        this.width = width;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width)); }
    }

    public Network (int[] widthVec, int length) {
        this.widthVec = widthVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i])); }
    }

    public Network (int width, int length, String functionName) {
        this.width = width; this.functionName = functionName;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionName)); }
    }

    public Network (int width, int length, String[] functionNameVec) {
        this.width = width; this.functionNameVec = functionNameVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameVec)); }
    }

    public Network (int width, int length, String[][] functionNameMat) {
        this.width = width; this.functionNameMat = functionNameMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameMat[i])); }
    }

    public Network (int[] widthVec, int length, String functionName) {
        this.widthVec = widthVec; this.functionName = functionName;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionName)); }
    }

    public Network (int[] widthVec, int length, String[] functionNameVec) {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameVec)); }
    }

    public Network (int[] widthVec, int length, String[][] functionNameMat) {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameMat[i])); }
    }

    public Network (int width, int length, double power) {
        this.width = width; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.power)); }
    }

    public Network (int width, int length, double[] powerVec) {
        this.width = width; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.powerVec)); }
    }

    public Network (int width, int length, double[][] powerMat) {
        this.width = width; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.powerMat[i])); }
    }

    public Network (int[] widthVec, int length, double power) {
        this.widthVec = widthVec; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.power)); }
    }

    public Network (int[] widthVec, int length, double[] powerVec) {
        this.widthVec = widthVec; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.powerVec)); }
    }

    public Network (int[] widthVec, int length, double[][] powerMat) {
        this.widthVec = widthVec; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.powerMat[i])); }
    }

    public Network (int width, int length, String functionName, double power) {
        this.width = width; this.functionName = functionName; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionName, this.power)); }
    }

    public Network (int width, int length, String[] functionNameVec, double power) {
        this.width = width; this.functionNameVec = functionNameVec; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameVec, this.power)); }
    }

    public Network (int width, int length, String functionName, double[] powerVec) {
        this.width = width; this.functionName = functionName; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionName, this.powerVec)); }
    }

    public Network (int width, int length, String[] functionNameVec, double[] powerVec) {
        this.width = width; this.functionNameVec = functionNameVec; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameVec, this.powerVec)); }
    }

    public Network (int width, int length, String[][] functionNameMat, double power) {
        this.width = width; this.functionNameMat = functionNameMat; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameMat[i], this.power)); }
    }

    public Network (int width, int length, String functionName, double[][] powerMat) {
        this.width = width; this.functionName = functionName; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionName, this.powerMat[i])); }
    }

    public Network (int width, int length, String[][] functionNameMat, double[] powerVec) {
        this.width = width; this.functionNameMat = functionNameMat; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameMat[i], this.powerVec)); }
    }

    public Network (int width, int length, String[] functionNameVec, double[][] powerMat) {
        this.width = width; this.functionNameVec = functionNameVec; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameVec, this.powerMat[i])); }
    }

    public Network (int width, int length, String[][] functionNameMat, double[][] powerMat) {
        this.width = width; this.functionNameMat = functionNameMat; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameMat[i], this.powerMat[i])); }
    }

    public Network (int[] widthVec, int length, String functionName, double power) {
        this.widthVec = widthVec; this.functionName = functionName; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionName, this.power)); }
    }

    public Network (int[] widthVec, int length, String[] functionNameVec, double power) {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameVec, this.power)); }
    }

    public Network (int[] widthVec, int length, String functionName, double[] powerVec) {
        this.widthVec = widthVec; this.functionName = functionName; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionName, this.powerVec)); }
    }

    public Network (int[] widthVec, int length, String[] functionNameVec, double[] powerVec) {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameVec, this.powerVec)); }
    }

    public Network (int[] widthVec, int length, String[][] functionNameMat, double power) {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameMat[i], this.power)); }
    }

    public Network (int[] widthVec, int length, String functionName, double[][] powerMat) {
        this.widthVec = widthVec; this.functionName = functionName; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionName, this.powerMat[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionNameMat, double[] powerVec) {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameMat[i], this.powerVec)); }
    }

    public Network (int[] widthVec, int length, String[] functionNameVec, double[][] powerMat) {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameVec, this.powerMat[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionNameMat, double[][] powerMat) {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameMat[i], this.powerMat[i])); }
    }

    public Network (int width, int length, String functionName, double minPower, double maxPower) {
        this.width = width; this.functionName = functionName; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionName, this.minPower, this.maxPower)); }
    }

    public Network (int width, int length, String[] functionNameVec, double minPower, double maxPower) {
        this.width = width; this.functionNameVec = functionNameVec; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameVec, this.minPower, this.maxPower)); }
    }

    public Network (int width, int length, String functionName, double[] minPowerVec, double[] maxPowerVec) {
        this.width = width; this.functionName = functionName; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionName, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int width, int length, String[] functionNameVec, double[] minPowerVec, double[] maxPowerVec) {
        this.width = width; this.functionNameVec = functionNameVec; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameVec, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int width, int length, String[][] functionNameMat, double minPower, double maxPower) {
        this.width = width; this.functionNameMat = functionNameMat; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameMat[i], this.minPower, this.maxPower)); }
    }

    public Network (int width, int length, String functionName, double[][] minPowerMat, double[][] maxPowerMat) {
        this.width = width; this.functionName = functionName; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionName, this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public Network (int width, int length, String[][] functionNameMat, double[] minPowerVec, double[] maxPowerVec) {
        this.width = width; this.functionNameMat = functionNameMat; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameMat[i], this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int width, int length, String[] functionNameVec, double[][] minPowerMat, double[][] maxPowerMat) {
        this.width = width; this.functionNameVec = functionNameVec; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameVec, this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public Network (int width, int length, String[][] functionNameMat, double[][] minPowerMat, double[][] maxPowerMat) {
        this.width = width; this.functionNameMat = functionNameMat; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionNameMat[i], this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public Network (int[] widthVec, int length, String functionName, double minPower, double maxPower) {
        this.widthVec = widthVec; this.functionName = functionName; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionName, this.minPower, this.maxPower)); }
    }

    public Network (int[] widthVec, int length, String[] functionNameVec, double minPower, double maxPower) {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameVec, this.minPower, this.maxPower)); }
    }

    public Network (int[] widthVec, int length, String functionName, double[] minPowerVec, double[] maxPowerVec) {
        this.widthVec = widthVec; this.functionName = functionName; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionName, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String[] functionNameVec, double[] minPowerVec, double[] maxPowerVec) {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameVec, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionNameMat, double minPower, double maxPower) {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameMat[i], this.minPower, this.maxPower)); }
    }

    public Network (int[] widthVec, int length, String functionName, double[][] minPowerMat, double[][] maxPowerMat) {
        this.widthVec = widthVec; this.functionName = functionName; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionName, this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionNameMat, double[] minPowerVec, double[] maxPowerVec) {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameMat[i], this.minPowerVec[i], maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String[] functionNameVec, double[][] minPowerMat, double[][] maxPowerMat) {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameVec, this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionNameMat, double[][] minPowerMat, double[][] maxPowerMat) {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionNameMat[i], this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public ArrayList<Layer> getLayers () { return this.layers; }

    public void setLayers (ArrayList<Layer> layers) { this.layers = layers; }

    public void addLayer (Layer layer) { this.layers.add(layer); }
    
    public int getLength () { return this.layers.size(); }
    
    public void setWidth (int width) { this.width = width; }
    
    public int getWidth () { return this.width; }
    
    public void setWidthVec (int[] widthVec) { this.widthVec = widthVec; }
    
    public int[] getWidthVec () { return this.widthVec; }

    public void setFunctionName(String functionName) { this.functionName = functionName; }

    public String getFunctionName() { return this.functionName; }

    public void setFunctionNameVec(String[] functionNameVec) { this.functionNameVec = functionNameVec; }

    public String[] getFunctionNameVec() { return this.functionNameVec; }

    public void setFunctionNameMat(String[][] functionNameMat) { this.functionNameMat = functionNameMat; }

    public String[][] getFunctionNameMat() { return this.functionNameMat; }

    public void setPower (double power) { this.power = power; }

    public double getPower () { return this.power; }

    public void setPowerVec (double[] powerVec) { this.powerVec = powerVec; }

    public double[] getPowerVec () { return this.powerVec; }

    public void setPowerMat (double[][] powerMat) { this.powerMat = powerMat; }

    public double[][] getPowerMat () { return this.powerMat; }

    public void setMinPower (double minPower) { this.minPower = minPower; }

    public double getMinPower () { return this.minPower; }

    public void setMaxPower (double maxPower) { this.maxPower = maxPower; }

    public double getMaxPower () { return this.maxPower; }

    public void setMinPowerVec (double[] maxPowerVec) { this.maxPowerVec = minPowerVec; }

    public double[] getMinPowerVec () { return this.minPowerVec; }

    public void setMaxPowerVec (double[] maxPowerVec) { this.maxPowerVec = maxPowerVec; }

    public double[] getMaxPowerVec () { return this.maxPowerVec; }

    public void setMinPowerMat (double[][] minPowerMat) { this.minPowerMat = minPowerMat; }

    public double[][] getMinPowerMat () { return this.minPowerMat; }

    public void setMaxPowerMat (double[][] maxPowerMat) { this.maxPowerMat = maxPowerMat; }

    public double[][] getMaxPowerMat () { return this.maxPowerMat; }

    public double[][] getMeanErrorMat() {
        double[][] meanErrorMat = new double[this.layers.size()][];
        for (int i = 0; i < meanErrorMat.length; i++) {
            meanErrorMat[i] = layers.get(i).getMeanErrorVec();
        } return meanErrorMat;
    }

    public double[][] getHypothesisMat() {
        double[][] hypothesisMat = new double[this.layers.size()][];
        for (int i = 0; i < hypothesisMat.length; i++) {
            hypothesisMat[i] = layers.get(i).getHypothesisVec();
        } return hypothesisMat;
    }

    public double[][] getThesisMat() {
        double[][] thesisMat = new double[this.layers.size()][];
        for (int i = 0; i < thesisMat.length; i++) {
            thesisMat[i] = layers.get(i).getThesisVec();
        } return thesisMat;
    }

    public void activate (double parameter) { // Activate all perceptron layers.
        for (Layer layer : this.layers) { layer.activate(parameter); }
    }

    public void activate (double... parameters) { // Activate all perceptron layers.
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).activate(parameters[i]); }
    }

    public void activate (double[]... parameters) { // Activate all perceptron layers.
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).activate(parameters[i]); }
    }

    public void activate (double[][]... parameters) { // Activate all perceptron layers.
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).activate(parameters[i]); }
    }

    public void optimize (double[] objective, int iteration) {
        for (Layer layer : this.layers) { layer.optimize(objective, iteration); }
    }

    public void optimize (double[][] objective, int iteration) {
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).optimize(objective[i], iteration); }
    }

    public void optimize (int iteration, double[]... error) {
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).optimize(iteration, error[i]); }
    }
}