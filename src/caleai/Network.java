/*=======================================================================
 <one line to give the program's name and a brief idea of what it does.>
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

package caleai;

import java.util.ArrayList;

public class Network {
    private ArrayList<Layer> layers = new ArrayList<>();
    private int width; private int[] widthVec; 
    private String function; private String[] functionVec; private String[][] functionMat;
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

    public Network (int width, int length, String function) {
        this.width = width; this.function = function;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.function)); }
    }

    public Network (int width, int length, String[] functionVec) {
        this.width = width; this.functionVec = functionVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionVec)); }
    }

    public Network (int width, int length, String[][] functionMat) {
        this.width = width; this.functionMat = functionMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionMat[i])); }
    }

    public Network (int[] widthVec, int length, String function) {
        this.widthVec = widthVec; this.function = function;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.function)); }
    }

    public Network (int[] widthVec, int length, String[] functionVec) {
        this.widthVec = widthVec; this.functionVec = functionVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionVec)); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat) {
        this.widthVec = widthVec; this.functionMat = functionMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionMat[i])); }
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

    public Network (int width, int length, String function, double power) {
        this.width = width; this.function = function; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.function, this.power)); }
    }

    public Network (int width, int length, String[] functionVec, double power) {
        this.width = width; this.functionVec = functionVec; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionVec, this.power)); }
    }

    public Network (int width, int length, String function, double[] powerVec) {
        this.width = width; this.function = function; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.function, this.powerVec)); }
    }

    public Network (int width, int length, String[] functionVec, double[] powerVec) {
        this.width = width; this.functionVec = functionVec; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionVec, this.powerVec)); }
    }

    public Network (int width, int length, String[][] functionMat, double power) {
        this.width = width; this.functionMat = functionMat; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionMat[i], this.power)); }
    }

    public Network (int width, int length, String function, double[][] powerMat) {
        this.width = width; this.function = function; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.function, this.powerMat[i])); }
    }

    public Network (int width, int length, String[][] functionMat, double[] powerVec) {
        this.width = width; this.functionMat = functionMat; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionMat[i], this.powerVec)); }
    }

    public Network (int width, int length, String[] functionVec, double[][] powerMat) {
        this.width = width; this.functionVec = functionVec; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionVec, this.powerMat[i])); }
    }

    public Network (int width, int length, String[][] functionMat, double[][] powerMat) {
        this.width = width; this.functionMat = functionMat; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionMat[i], this.powerMat[i])); }
    }

    public Network (int[] widthVec, int length, String function, double power) {
        this.widthVec = widthVec; this.function = function; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.function, this.power)); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double power) {
        this.widthVec = widthVec; this.functionVec = functionVec; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionVec, this.power)); }
    }

    public Network (int[] widthVec, int length, String function, double[] powerVec) {
        this.widthVec = widthVec; this.function = function; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.function, this.powerVec)); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double[] powerVec) {
        this.widthVec = widthVec; this.functionVec = functionVec; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionVec, this.powerVec)); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double power) {
        this.widthVec = widthVec; this.functionMat = functionMat; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionMat[i], this.power)); }
    }

    public Network (int[] widthVec, int length, String function, double[][] powerMat) {
        this.widthVec = widthVec; this.function = function; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.function, this.powerMat[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double[] powerVec) {
        this.widthVec = widthVec; this.functionMat = functionMat; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionMat[i], this.powerVec)); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double[][] powerMat) {
        this.widthVec = widthVec; this.functionVec = functionVec; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionVec, this.powerMat[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double[][] powerMat) {
        this.widthVec = widthVec; this.functionMat = functionMat; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionMat[i], this.powerMat[i])); }
    }

    public Network (int width, int length, String function, double minPower, double maxPower) {
        this.width = width; this.function = function; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.function, this.minPower, this.maxPower)); }
    }

    public Network (int width, int length, String[] functionVec, double minPower, double maxPower) {
        this.width = width; this.functionVec = functionVec; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionVec, this.minPower, this.maxPower)); }
    }

    public Network (int width, int length, String function, double[] minPowerVec, double[] maxPowerVec) {
        this.width = width; this.function = function; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.function, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int width, int length, String[] functionVec, double[] minPowerVec, double[] maxPowerVec) {
        this.width = width; this.functionVec = functionVec; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionVec, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int width, int length, String[][] functionMat, double minPower, double maxPower) {
        this.width = width; this.functionMat = functionMat; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionMat[i], this.minPower, this.maxPower)); }
    }

    public Network (int width, int length, String function, double[][] minPowerMat, double[][] maxPowerMat) {
        this.width = width; this.function = function; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.function, this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public Network (int width, int length, String[][] functionMat, double[] minPowerVec, double[] maxPowerVec) {
        this.width = width; this.functionMat = functionMat; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionMat[i], this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int width, int length, String[] functionVec, double[][] minPowerMat, double[][] maxPowerMat) {
        this.width = width; this.functionVec = functionVec; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionVec, this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public Network (int width, int length, String[][] functionMat, double[][] minPowerMat, double[][] maxPowerMat) {
        this.width = width; this.functionMat = functionMat; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.functionMat[i], this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public Network (int[] widthVec, int length, String function, double minPower, double maxPower) {
        this.widthVec = widthVec; this.function = function; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.function, this.minPower, this.maxPower)); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double minPower, double maxPower) {
        this.widthVec = widthVec; this.functionVec = functionVec; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionVec, this.minPower, this.maxPower)); }
    }

    public Network (int[] widthVec, int length, String function, double[] minPowerVec, double[] maxPowerVec) {
        this.widthVec = widthVec; this.function = function; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.function, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double[] minPowerVec, double[] maxPowerVec) {
        this.widthVec = widthVec; this.functionVec = functionVec; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionVec, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double minPower, double maxPower) {
        this.widthVec = widthVec; this.functionMat = functionMat; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionMat[i], this.minPower, this.maxPower)); }
    }

    public Network (int[] widthVec, int length, String function, double[][] minPowerMat, double[][] maxPowerMat) {
        this.widthVec = widthVec; this.function = function; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.function, this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double[] minPowerVec, double[] maxPowerVec) {
        this.widthVec = widthVec; this.functionMat = functionMat; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionMat[i], this.minPowerVec[i], maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double[][] minPowerMat, double[][] maxPowerMat) {
        this.widthVec = widthVec; this.functionVec = functionVec; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionVec, this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double[][] minPowerMat, double[][] maxPowerMat) {
        this.widthVec = widthVec; this.functionMat = functionMat; this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionMat[i], this.minPowerMat[i], this.maxPowerMat[i])); }
    }

    public ArrayList<Layer> getLayers () { return this.layers; }

    public void setLayers (ArrayList<Layer> layers) { this.layers = layers; }

    public void addLayer (Layer layer) { this.layers.add(layer); }
    
    public int getLength () { return this.layers.size(); }
    
    public void setWidth (int width) { this.width = width; }
    
    public int getWidth () { return this.width; }
    
    public void setWidthVec (int[] widthVec) { this.widthVec = widthVec; }
    
    public int[] getWidthVec () { return this.widthVec; }

    public void setFunction (String function) { this.function = function; }

    public String getFunction () { return this.function; }

    public void setFunctionVec (String[] functionVec) { this.functionVec = functionVec; }

    public String[] getFunctionVec () { return this.functionVec; }

    public void setFunctionMat (String[][] functionMat) { this.functionMat = functionMat; }

    public String[][] getFunctionMat () { return this.functionMat; }

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