package caleai;/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

import java.util.ArrayList;

public class Network {
    private final ArrayList<Layer> layers = new ArrayList<>();
    private int width; private int[] widthVec; private int length;
    private String function; private String[] functionVec; private String[][] functionMat;
    private double power; private double[] powerVec; private double[][] powerMat;
    private double minPower; private double maxPower;
    private double[] minPowerVec; private double[] maxPowerVec;
    private double[][] minPowerMat; private double[][] maxPowerMat;

    // Construct network.
    public Network (int width, int length) {
        this.width = width; this.length = length;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width)); }
    }

    public Network (int[] widthVec, int length) {
        this.widthVec = widthVec; this.length = length;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i])); }
    }

    public Network (int width, int length, String function) {
        this.width = width; this.length = length; this.function = function;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.function)); }
    }

    public Network (int width, int length, String[] functionVec) {
        this.width = width; this.length = length; this.functionVec = functionVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.functionVec)); }
    }

    public Network (int width, int length, String[][] functionMat) {
        this.width = width; this.length = length; this.functionMat = functionMat;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.functionMat[i])); }
    }

    public Network (int[] widthVec, int length, String function) {
        this.widthVec = widthVec; this.length = length; this.function = function;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.function)); }
    }

    public Network (int[] widthVec, int length, String[] functionVec) {
        this.widthVec = widthVec; this.length = length; this.functionVec = functionVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionVec)); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat) {
        this.widthVec = widthVec; this.length = length; this.functionMat = functionMat;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionMat[i])); }
    }

    public Network (int width, int length, double power) {
        this.width = width; this.length = length; this.power = power;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.power)); }
    }

    public Network (int width, int length, double[] powerVec) {
        this.width = width; this.length = length; this.powerVec = powerVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.powerVec)); }
    }

    public Network (int width, int length, double[][] powerMat) {
        this.width = width; this.length = length; this.powerMat = powerMat;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.powerMat[i])); }
    }

    public Network (int[] widthVec, int length, double power) {
        this.widthVec = widthVec; this.length = length; this.power = power;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.power)); }
    }

    public Network (int[] widthVec, int length, double[] powerVec) {
        this.widthVec = widthVec; this.length = length; this.powerVec = powerVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.powerVec)); }
    }

    public Network (int[] widthVec, int length, double[][] powerMat) {
        this.widthVec = widthVec; this.length = length; this.powerMat = powerMat;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.powerMat[i])); }
    }

    public Network (int width, int length, String function, double power) {
        this.width = width; this.length = length; this.function = function; this.power = power;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.function, this.power)); }
    }

    public Network (int width, int length, String[] functionVec, double power) {
        this.width = width; this.length = length; this.functionVec = functionVec; this.power = power;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.functionVec, this.power)); }
    }

    public Network (int width, int length, String function, double[] powerVec) {
        this.width = width; this.length = length; this.function = function; this.powerVec = powerVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.function, this.powerVec)); }
    }

    public Network (int width, int length, String[] functionVec, double[] powerVec) {
        this.width = width; this.length = length; this.functionVec = functionVec; this.powerVec = powerVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.functionVec, this.powerVec)); }
    }

    public Network (int width, int length, String[][] functionMat, double power) {
        this.width = width; this.length = length; this.functionMat = functionMat; this.power = power;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.functionMat[i], this.power)); }
    }

    public Network (int width, int length, String function, double[][] powerMat) {
        this.width = width; this.length = length; this.function = function; this.powerMat = powerMat;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.function, this.powerMat[i])); }
    }

    public Network (int width, int length, String[][] functionMat, double[] powerVec) {
        this.width = width; this.length = length; this.functionMat = functionMat; this.powerVec = powerVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.functionMat[i], this.powerVec)); }
    }

    public Network (int width, int length, String[] functionVec, double[][] powerMat) {
        this.width = width; this.length = length; this.functionVec = functionVec; this.powerMat = powerMat;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.functionVec, this.powerMat[i])); }
    }

    public Network (int width, int length, String[][] functionMat, double[][] powerMat) {
        this.width = width; this.length = length; this.functionMat = functionMat; this.powerMat = powerMat;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.functionMat[i], this.powerMat[i])); }
    }

    public Network (int[] widthVec, int length, String function, double power) {
        this.widthVec = widthVec; this.length = length; this.function = function; this.power = power;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.function, this.power)); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double power) {
        this.widthVec = widthVec; this.length = length; this.functionVec = functionVec; this.power = power;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionVec, this.power)); }
    }

    public Network (int[] widthVec, int length, String function, double[] powerVec) {
        this.widthVec = widthVec; this.length = length; this.function = function; this.powerVec = powerVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.function, this.powerVec)); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double[] powerVec) {
        this.widthVec = widthVec; this.length = length; this.functionVec = functionVec; this.powerVec = powerVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionVec, this.powerVec)); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double power) {
        this.widthVec = widthVec; this.length = length; this.functionMat = functionMat; this.power = power;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionMat[i], this.power)); }
    }

    public Network (int[] widthVec, int length, String function, double[][] powerMat) {
        this.widthVec = widthVec; this.length = length; this.function = function; this.powerMat = powerMat;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.function, this.powerMat[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double[] powerVec) {
        this.widthVec = widthVec; this.length = length; this.functionMat = functionMat; this.powerVec = powerVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionMat[i], this.powerVec)); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double[][] powerMat) {
        this.widthVec = widthVec; this.length = length; this.functionVec = functionVec; this.powerMat = powerMat;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionVec, this.powerMat[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double[][] powerMat) {
        this.widthVec = widthVec; this.length = length; this.functionMat = functionMat; this.powerMat = powerMat;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.widthVec[i], this.functionMat[i], this.powerMat[i])); }
    }

    public Network (int width, int length, String function, double minPower, double maxPower) {
        this.width = width; this.length = length; this.function = function; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.function, this.minPower, this.maxPower)); }
    }

    public Network (int width, int length, String[] functionVec, double minPower, double maxPower) {
        this.width = width; this.length = length; this.functionVec = functionVec; this.minPower = minPower; this.maxPower = maxPower;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.functionVec, this.minPower, this.maxPower)); }
    }

    public Network (int width, int length, String function, double[] minPowerVec, double[] maxPowerVec) {
        this.width = width; this.length = length; this.function = function; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.function, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int width, int length, String[] functionVec, double[] minPowerVec, double[] maxPowerVec) {
        this.width = width; this.length = length; this.functionVec = functionVec; this.minPowerVec = minPowerVec; this.maxPowerVec = maxPowerVec;
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(this.width, this.functionVec, this.minPowerVec[i], this.maxPowerVec[i])); }
    }

    public Network (int width, int length, String[][] functionMat, double minPower, double maxPower) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(width, functionMat[i], minPower, maxPower)); }
    }

    public Network (int width, int length, String function, double[][] minPowerVec, double[][] maxPowerVec) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(width, function, minPowerVec[i], maxPowerVec[i])); }
    }

    public Network (int width, int length, String[][] functionMat, double[] minPowerVec, double[] maxPowerVec) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(width, functionMat[i], minPowerVec[i], maxPowerVec[i])); }
    }

    public Network (int width, int length, String[] functionVec, double[][] minPowerVec, double[][] maxPowerVec) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(width, functionVec, minPowerVec[i], maxPowerVec[i])); }
    }

    public Network (int width, int length, String[][] functionMat, double[][] minPowerVec, double[][] maxPowerVec) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(width, functionMat[i], minPowerVec[i], maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String function, double minPower, double maxPower) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(widthVec[i], function, minPower, maxPower)); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double minPower, double maxPower) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(widthVec[i], functionVec, minPower, maxPower)); }
    }

    public Network (int[] widthVec, int length, String function, double[] minPowerVec, double[] maxPowerVec) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(widthVec[i], function, minPowerVec[i], maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double[] minPowerVec, double[] maxPowerVec) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(widthVec[i], functionVec, minPowerVec[i], maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double minPower, double maxPower) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(widthVec[i], functionMat[i], minPower, maxPower)); }
    }

    public Network (int[] widthVec, int length, String function, double[][] minPowerVec, double[][] maxPowerVec) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(widthVec[i], function, minPowerVec[i], maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double[] minPowerVec, double[] maxPowerVec) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(widthVec[i], functionMat[i], minPowerVec[i], maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String[] functionVec, double[][] minPowerVec, double[][] maxPowerVec) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(widthVec[i], functionVec, minPowerVec[i], maxPowerVec[i])); }
    }

    public Network (int[] widthVec, int length, String[][] functionMat, double[][] minPowerVec, double[][] maxPowerVec) {
        for (int i = 1; i <= this.length; i++) { this.layers.add(new Layer(widthVec[i], functionMat[i], minPowerVec[i], maxPowerVec[i])); }
    }

    public ArrayList<Layer> getLayers () { return this.layers; }

    public void addLayer (Layer layer) { this.layers.add(layer); }

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

    public void optimize (double[][] objective, int iteration) {
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).optimize(objective[i], iteration); }
    }

    public void optimize (int iteration, double[]... error) {
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).optimize(iteration, error[i]); }
    }
}