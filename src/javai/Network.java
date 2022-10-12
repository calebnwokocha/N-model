/*------------------------------------------------------------------------------
 Javai is open-source framework for comprehensive learning, produced and
 maintained by Javai Foundation.

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

 Email info@javai.org for technical support and/or special permission
 to use this framework.
---------------------------------------------------------------------------- */

package javai;

import java.util.ArrayList;

public class Network {
    private ArrayList<Layer> layers = new ArrayList<>();
    private int width; private ArrayList<Integer> widthVec;
    private String functionName; private ArrayList<String> functionNameVec;
    private ArrayList<ArrayList<String>> functionNameMat;
    private double power, minPower, maxPower;
    private ArrayList<Double> powerVec, minPowerVec, maxPowerVec;
    private ArrayList<ArrayList<Double>> powerMat, minPowerMat, maxPowerMat;

    // Construct network.
    public Network (int width, int length) {
        this.width = width;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width)); }
    }

    public Network (ArrayList<Integer> widthVec, int length) {
        this.widthVec = widthVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec.get(i))); }
    }

    public Network (int width, int length, String functionName) {
        this.width = width; this.functionName = functionName;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionName));
        }
    }

    public Network (int width, int length, ArrayList<String> functionNameVec) {
        this.width = width; this.functionNameVec = functionNameVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionNameVec));
        }
    }

    public Network (Integer width, Integer length, ArrayList<ArrayList<String>> functionNameMat) {
        this.width = width; this.functionNameMat = functionNameMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionNameMat.get(i)));
        }
    }

    public Network (ArrayList<Integer> widthVec, int length, String functionName) {
        this.widthVec = widthVec; this.functionName = functionName;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec.get(i),
                this.functionName));
        }
    }

    public Network (ArrayList<Integer> widthVec, int length, ArrayList<String> functionNameVec) {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionNameVec));
        }
    }

    public Network (ArrayList<ArrayList<String>> functionNameMat, ArrayList<Integer> widthVec,
                    int length)
    {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionNameMat.get(i)));
        }
    }

    public Network (int width, int length, double power) {
        this.width = width; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.power)); }
    }

    public Network (Integer width, int length, ArrayList<Double> powerVec) {
        this.width = width; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.powerVec)); }
    }

    public Network (int width, Integer length, ArrayList<ArrayList<Double>> powerMat) {
        this.width = width; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.width, this.powerMat.get(i))); }
    }

    public Network (ArrayList<Integer> widthVec, int length, double power) {
        this.widthVec = widthVec; this.power = power;
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(this.widthVec.get(i), this.power)); }
    }

    public Network (ArrayList<Integer> widthVec, Integer length, ArrayList<Double> powerVec) {
        this.widthVec = widthVec; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.powerVec));
        }
    }

    public Network (Integer length, ArrayList<Integer> widthVec, ArrayList<ArrayList<Double>> powerMat) {
        this.widthVec = widthVec; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.powerMat.get(i)));
        }
    }

    public Network (int width, int length, String functionName, double power) {
        this.width = width; this.functionName = functionName; this.power = power;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionName, this.power));
        }
    }

    public Network (int width, int length, ArrayList<String> functionNameVec, double power) {
        this.width = width; this.functionNameVec = functionNameVec; this.power = power;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionNameVec, this.power));
        }
    }

    public Network (int width, int length, String functionName, ArrayList<Double> powerVec) {
        this.width = width; this.functionName = functionName; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionName, this.powerVec));
        }
    }

    public Network (int width, int length, ArrayList<String> functionNameVec, ArrayList<Double> powerVec) {
        this.width = width; this.functionNameVec = functionNameVec; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.powerVec, this.functionNameVec));
        }
    }

    public Network (int width, Integer length, ArrayList<ArrayList<String>> functionNameMat, double power) {
        this.width = width; this.functionNameMat = functionNameMat; this.power = power;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionNameMat.get(i), this.power));
        }
    }

    public Network (int width, int length, ArrayList<ArrayList<Double>> powerMat, String functionName) {
        this.width = width; this.functionName = functionName; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionName, this.powerMat.get(i)));
        }
    }

    public Network (ArrayList<ArrayList<String>> functionNameMat, int width, int length,
                    ArrayList<Double> powerVec)
    {
        this.width = width; this.functionNameMat = functionNameMat; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.powerVec, this.functionNameMat.get(i)));
        }
    }

    public Network (Integer width, int length, ArrayList<String> functionNameVec,
                    ArrayList<ArrayList<Double>> powerMat)
    {
        this.width = width; this.functionNameVec = functionNameVec; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.powerMat.get(i), this.functionNameVec));
        }
    }

    public Network (int width, Integer length, ArrayList<ArrayList<String>> functionNameMat,
                    ArrayList<ArrayList<Double>> powerMat)
    {
        this.width = width; this.functionNameMat = functionNameMat; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.powerMat.get(i), this.functionNameMat.get(i)));
        }
    }

    public Network (ArrayList<Integer> widthVec, int length, String functionName, double power) {
        this.widthVec = widthVec; this.functionName = functionName; this.power = power;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionName, this.power));
        }
    }

    public Network (ArrayList<Integer> widthVec, int length, ArrayList<String> functionNameVec,
                    double power)
    {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec; this.power = power;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionNameVec, this.power));
        }
    }

    public Network (ArrayList<Integer> widthVec, int length, String functionName,
                    ArrayList<Double> powerVec)
    {
        this.widthVec = widthVec; this.functionName = functionName; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionName, this.powerVec));
        }
    }

    public Network (ArrayList<Integer> widthVec, int length, ArrayList<String> functionNameVec,
                    ArrayList<Double> powerVec)
    {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.powerVec, this.functionNameVec));
        }
    }

    public Network (int length, ArrayList<Integer> widthVec, ArrayList<ArrayList<String>>
            functionNameMat, double power)
    {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat; this.power = power;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionNameMat.get(i), this.power));
        }
    }

    public Network (ArrayList<Integer> widthVec, Integer length, String functionName,
                    ArrayList<ArrayList<Double>> powerMat)
    {
        this.widthVec = widthVec; this.functionName = functionName; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionName, this.powerMat.get(i)));
        }
    }

    public Network (int length, ArrayList<Integer> widthVec, ArrayList<ArrayList<String>> functionNameMat,
                    ArrayList<Double> powerVec)
    {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat; this.powerVec = powerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.powerVec, this.functionNameMat.get(i)));
        }
    }

    public Network (ArrayList<Integer> widthVec, Integer length, ArrayList<String> functionNameVec,
                    ArrayList<ArrayList<Double>> powerMat)
    {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.powerMat.get(i), this.functionNameVec));
        }
    }

    public Network (Integer length, ArrayList<Integer> widthVec,
                    ArrayList<ArrayList<String>> functionNameMat, ArrayList<ArrayList<Double>> powerMat)
    {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat; this.powerMat = powerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.powerMat.get(i),
                    this.functionNameMat.get(i)));
        }
    }

    public Network (int width, int length, String functionName, double minPower, double maxPower) {
        this.width = width; this.functionName = functionName; this.minPower = minPower;
        this.maxPower = maxPower;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionName, this.minPower, this.maxPower));
        }
    }

    public Network (int width, int length, ArrayList<String> functionNameVec,
                    double minPower, double maxPower)
    {
        this.width = width; this.functionNameVec = functionNameVec;
        this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionNameVec, this.minPower, this.maxPower));
        }
    }

    public Network (int width, int length, String functionName, ArrayList<Double> minPowerVec,
                    ArrayList<Double> maxPowerVec)
    {
        this.width = width; this.functionName = functionName; this.minPowerVec = minPowerVec;
        this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionName,
                    this.minPowerVec.get(i), this.maxPowerVec.get(i)));
        }
    }

    public Network (int width, int length, ArrayList<String> functionNameVec,
                    ArrayList<Double> minPowerVec, ArrayList<Double> maxPowerVec)
    {
        this.width = width; this.functionNameVec = functionNameVec;
        this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionNameVec,
                    this.minPowerVec.get(i), this.maxPowerVec.get(i)));
        }
    }

    public Network (int width, int length, double minPower, double maxPower,
                    ArrayList<ArrayList<String>> functionNameMat)
    {
        this.width = width; this.functionNameMat = functionNameMat;
        this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionNameMat.get(i),
                    this.minPower, this.maxPower));
        }
    }

    public Network (int width, int length, ArrayList<ArrayList<Double>> minPowerMat,
                    ArrayList<ArrayList<Double>> maxPowerMat, String functionName)
    {
        this.width = width; this.functionName = functionName; this.minPowerMat = minPowerMat;
        this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionName,
                    this.minPowerMat.get(i), this.maxPowerMat.get(i)));
        }
    }

    public Network (Integer width, int length, ArrayList<ArrayList<String>> functionNameMat,
                    ArrayList<Double> minPowerVec, ArrayList<Double> maxPowerVec)
    {
        this.width = width; this.functionNameMat = functionNameMat;this.minPowerVec = minPowerVec;
        this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionNameMat.get(i),
                    this.minPowerVec.get(i), this.maxPowerVec.get(i)));
        }
    }

    public Network (int width, Integer length, ArrayList<String> functionNameVec,
                    ArrayList<ArrayList<Double>> minPowerMat, ArrayList<ArrayList<Double>> maxPowerMat)
    {
        this.width = width; this.functionNameVec = functionNameVec;
        this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionNameVec,
                    this.minPowerMat.get(i), this.maxPowerMat.get(i)));
        }
    }

    public Network (Integer width, Integer length, ArrayList<ArrayList<String>> functionNameMat,
                    ArrayList<ArrayList<Double>> minPowerMat, ArrayList<ArrayList<Double>> maxPowerMat)
    {
        this.width = width; this.functionNameMat = functionNameMat;
        this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.width, this.functionNameMat.get(i),
                    this.minPowerMat.get(i), this.maxPowerMat.get(i)));
        }
    }

    public Network (ArrayList<Integer> widthVec, int length, String functionName,
                    double minPower, double maxPower)
    {
        this.widthVec = widthVec; this.functionName = functionName;
        this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionName,
                    this.minPower, this.maxPower));
        }
    }

    public Network (ArrayList<Integer> widthVec, int length, ArrayList<String> functionNameVec,
                    double minPower, double maxPower)
    {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec;
        this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionNameVec,
                    this.minPower, this.maxPower)); }
    }

    public Network (ArrayList<Integer> widthVec, int length, String functionName,
                    ArrayList<Double> minPowerVec, ArrayList<Double> maxPowerVec)
    {
        this.widthVec = widthVec; this.functionName = functionName;
        this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionName,
                    this.minPowerVec.get(i), this.maxPowerVec.get(i))); }
    }

    public Network (ArrayList<Integer> widthVec, int length, ArrayList<String> functionNameVec,
                    ArrayList<Double> minPowerVec, ArrayList<Double> maxPowerVec)
    {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec;
        this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionNameVec,
                    this.minPowerVec.get(i), this.maxPowerVec.get(i)));
        }
    }

    public Network (int length, ArrayList<Integer> widthVec, ArrayList<ArrayList<String>> functionNameMat,
                    double minPower, double maxPower)
    {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat;
        this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionNameMat.get(i),
                    this.minPower, this.maxPower)); }
    }

    public Network (int length, ArrayList<Integer> widthVec, String functionName,
                    ArrayList<ArrayList<Double>> minPowerMat, ArrayList<ArrayList<Double>> maxPowerMat)
    {
        this.widthVec = widthVec; this.functionName = functionName;
        this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionName,
                    this.minPowerMat.get(i), this.maxPowerMat.get(i)));
        }
    }

    public Network (ArrayList<Integer> widthVec, Integer length, ArrayList<ArrayList<String>> functionNameMat,
                    ArrayList<Double> minPowerVec, ArrayList<Double> maxPowerVec)
    {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat;
        this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionNameMat.get(i),
                    this.minPowerVec.get(i), maxPowerVec.get(i)));
        }
    }

    public Network (Integer length, ArrayList<Integer> widthVec, ArrayList<String> functionNameVec,
                    ArrayList<ArrayList<Double>> minPowerMat, ArrayList<ArrayList<Double>> maxPowerMat)
    {
        this.widthVec = widthVec; this.functionNameVec = functionNameVec;
        this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionNameVec,
                    this.minPowerMat.get(i), this.maxPowerMat.get(i)));
        }
    }

    public Network (int length, ArrayList<Integer> widthVec, ArrayList<ArrayList<String>> functionNameMat,
                    ArrayList<ArrayList<Double>> minPowerMat, ArrayList<ArrayList<Double>> maxPowerMat)
    {
        this.widthVec = widthVec; this.functionNameMat = functionNameMat;
        this.minPowerMat = minPowerMat; this.maxPowerMat = maxPowerMat;
        for (int i = 0; i < length; i++) {
            this.layers.add(new Layer(this.widthVec.get(i), this.functionNameMat.get(i),
                    this.minPowerMat.get(i), this.maxPowerMat.get(i)));
        }
    }

    public ArrayList<Layer> getLayers () { return this.layers; }

    public void setLayers (ArrayList<Layer> layers) { this.layers = layers;
        this.functionNameMat = new ArrayList<>(); this.powerMat = new ArrayList<>();
        this.minPowerMat = new ArrayList<>(); this.maxPowerMat = new ArrayList<>();
        for (Layer layer : this.layers) { this.functionNameMat.add(layer.getFunctionNameVec());
            this.powerMat.add(layer.getPowerVec()); this.minPowerMat.add(layer.getMinPowerVec());
            this.maxPowerMat.add(layer.getMaxPowerVec());
        }
    }

    public void addLayer (Layer layer) { this.layers.add(layer);
        this.functionNameMat.add(layer.getFunctionNameVec()); this.powerMat.add(layer.getPowerVec());
        this.minPowerMat.add(layer.getMinPowerVec()); this.maxPowerMat.add(layer.getMaxPowerVec());
    }
    
    public int getLength () { return this.layers.size(); }
    
    public void setWidth (int width) { this.width = width; }
    
    public int getWidth () { return this.width; }

    public int getWidth (int index) { return this.widthVec.get(index); }

    public void setWidthVec (ArrayList<Integer> widthVec) { this.widthVec = widthVec; }
    
    public ArrayList<Integer> getWidthVec () { return this.widthVec; }

    public void setFunctionName(String functionName) { this.functionName = functionName; }

    public String getFunctionName() { return this.functionName; }

    public String getFunctionName (int index) { return this.functionNameVec.get(index); }

    public String getFunctionName (int indexI, int indexJ) { return this.functionNameMat.get(indexI).get(indexJ); }

    public void setFunctionNameVec(ArrayList<String> functionNameVec) { this.functionNameVec = functionNameVec; }

    public ArrayList<String> getFunctionNameVec() { return this.functionNameVec; }

    public void setFunctionNameMat(ArrayList<ArrayList<String>> functionNameMat) {
        this.functionNameMat = functionNameMat;
    }

    public ArrayList<ArrayList<String>> getFunctionNameMat() { return this.functionNameMat; }

    public void setPower (double power) { this.power = power; }

    public double getPower () { return this.power; }

    public double getPower (int index) { return this.powerVec.get(index); }

    public double getPower (int indexI, int indexJ) { return this.powerMat.get(indexI).get(indexJ); }

    public void setPowerVec (ArrayList<Double> powerVec) { this.powerVec = powerVec; }

    public ArrayList<Double> getPowerVec () { return this.powerVec; }

    public void setPowerMat (ArrayList<ArrayList<Double>> powerMat) { this.powerMat = powerMat; }

    public ArrayList<ArrayList<Double>> getPowerMat () { return this.powerMat; }

    public void setMinPower (double minPower) { this.minPower = minPower; }

    public double getMinPower () { return this.minPower; }

    public void setMaxPower (double maxPower) { this.maxPower = maxPower; }

    public double getMaxPower () { return this.maxPower; }

    public void setMinPowerVec (double[] maxPowerVec) { this.maxPowerVec = minPowerVec; }

    public ArrayList<Double> getMinPowerVec () { return this.minPowerVec; }

    public void setMaxPowerVec (ArrayList<Double> maxPowerVec) { this.maxPowerVec = maxPowerVec; }

    public ArrayList<Double> getMaxPowerVec () { return this.maxPowerVec; }

    public void setMinPowerMat (ArrayList<ArrayList<Double>> minPowerMat) { this.minPowerMat = minPowerMat; }

    public ArrayList<ArrayList<Double>> getMinPowerMat () { return this.minPowerMat; }

    public void setMaxPowerMat (ArrayList<ArrayList<Double>> maxPowerMat) { this.maxPowerMat = maxPowerMat; }

    public ArrayList<ArrayList<Double>> getMaxPowerMat () { return this.maxPowerMat; }

    public double[][] getMeanErrorMat() {
        double[][] meanErrorMat = new double[this.layers.size()][];
        for (int i = 0; i < meanErrorMat.length; i++) { meanErrorMat[i] = layers.get(i).getMeanErrorVec(); }
        return meanErrorMat;
    }

    public Double[][] getHypothesisMat() {
        Double[][] hypothesisMat = new Double[this.layers.size()][];
        for (int i = 0; i < hypothesisMat.length; i++) { hypothesisMat[i] = layers.get(i).getHypothesisVec(); }
        return hypothesisMat;
    }

    public Double[][] getThesisMat() {
        Double[][] thesisMat = new Double[this.layers.size()][];
        for (int i = 0; i < thesisMat.length; i++) { thesisMat[i] = layers.get(i).getThesisVec(); }
        return thesisMat;
    }

    public void coverage (Double area) { for (Layer layer : layers) {layer.coverage(area); } }

    public Double[][] getArea () {
        Double[][] area = new Double[this.layers.size()][];
        for (int i = 0; i < area.length; i++) { area[i] = this.layers.get(i).getArea(); }
        return area;
    }

    public void test (Double... parameters) { // Activate all perceptron layers.
        for (int i = 0; i < this.layers.size(); i++) {
            if (i == 0) { this.layers.get(i).test(parameters); }
            else { this.layers.get(i).test(this.layers.get(i - 1).getThesisVec()); }
        }
    }

    public void test (Double[]... parameters) { // Activate all perceptron layers.
        for (int i = 0; i < this.layers.size(); i++) {
            if (i == 0) {this.layers.get(i).test(parameters); }
            else { this.layers.get(i).test(this.layers.get(i - 1).getThesisVec()); }
        }
    }

    public void train (int iteration, double[] objective, Double... parameters) {
        for (int i = 0; i < this.layers.size(); i++) {
            if (i == 0) { this.layers.get(i).train(iteration, objective, parameters); }
            else { this.layers.get(i).train(iteration, objective, this.layers.get(i - 1).getThesisVec()); }
        }
    }

    public void train (int iteration, double[][] objective, Double... parameters) {
        for (int i = 0; i < this.layers.size(); i++) {
            if (i == 0) { this.layers.get(i).train(iteration, objective[i], parameters); }
            else { this.layers.get(i).train(iteration, objective[i], this.layers.get(i - 1).getThesisVec()); }
        }
    }

    public void train (int iteration, double error) {
        for (Layer layer : this.layers) { layer.train(iteration, error); }
    }
}