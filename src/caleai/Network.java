package caleai;/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

import java.util.ArrayList;

public class Network {
    private final ArrayList<Layer> layers = new ArrayList<>();
    private String[][] functions;
    private double[][] powers;
    private double[][] hypotheses;
    private double[][] theses;
    private double[][] errorMeans;

    // Construct network.
    public Network (int width, int length) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width)); }
    }

    public Network (int[] widths, int length) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i])); }
    }

    public Network (int width, int length, String function) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, function)); }
    }

    public Network (int width, int length, String[] functions) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions)); }
    }

    public Network (int width, int length, String[][] functions) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions[i])); }
    }

    public Network (int[] widths, int length, String function) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], function)); }
    }

    public Network (int[] widths, int length, String[] functions) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions)); }
    }

    public Network (int[] widths, int length, String[][] functions) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions[i])); }
    }

    public Network (int width, int length, double power) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, this.power)); }
    }

    public Network (int width, int length, double[] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, this.powers)); }
    }

    public Network (int width, int length, double[][] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, this.powers[i])); }
    }

    public Network (int[] widths, int length, double power) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], this.power)); }
    }

    public Network (int[] widths, int length, double[] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], this.powers)); }
    }

    public Network (int[] widths, int length, double[][] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], this.powers[i])); }
    }

    public Network (int width, int length, String function, double power) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, function, this.power)); }
    }

    public Network (int width, int length, String[] functions, double power) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions, this.power)); }
    }

    public Network (int width, int length, String function, double[] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, function, this.powers)); }
    }

    public Network (int width, int length, String[] functions, double[] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions, this.powers)); }
    }

    public Network (int width, int length, String[][] functions, double power) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions[i], this.power)); }
    }

    public Network (int width, int length, String function, double[][] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, function, this.powers[i])); }
    }

    public Network (int width, int length, String[][] functions, double[] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions[i], this.powers)); }
    }

    public Network (int width, int length, String[] functions, double[][] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions, this.powers[i])); }
    }

    public Network (int width, int length, String[][] functions, double[][] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions[i], this.powers[i])); }
    }

    public Network (int[] widths, int length, String function, double power) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], function, this.power)); }
    }

    public Network (int[] widths, int length, String[] functions, double power) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions, this.power)); }
    }

    public Network (int[] widths, int length, String function, double[] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], function, this.powers)); }
    }

    public Network (int[] widths, int length, String[] functions, double[] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions, this.powers)); }
    }

    public Network (int[] widths, int length, String[][] functions, double power) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions[i], this.power)); }
    }

    public Network (int[] widths, int length, String function, double[][] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], function, this.powers[i])); }
    }

    public Network (int[] widths, int length, String[][] functions, double[] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions[i], this.powers)); }
    }

    public Network (int[] widths, int length, String[] functions, double[][] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions, this.powers[i])); }
    }

    public Network (int[] widths, int length, String[][] functions, double[][] powers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions[i], this.powers[i])); }
    }

    public Network (int width, int length, String function, double minimumPower, double maximumPower) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, function, minimumPower, maximumPower)); }
    }

    public Network (int width, int length, String[] functions, double minimumPower, double maximumPower) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions, minimumPower, maximumPower)); }
    }

    public Network (int width, int length, String function, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, function, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int width, int length, String[] functions, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int width, int length, String[][] functions, double minimumPower, double maximumPower) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions[i], minimumPower, maximumPower)); }
    }

    public Network (int width, int length, String function, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, function, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int width, int length, String[][] functions, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions[i], minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int width, int length, String[] functions, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int width, int length, String[][] functions, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(width, functions[i], minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String function, double minimumPower, double maximumPower) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], function, minimumPower, maximumPower)); }
    }

    public Network (int[] widths, int length, String[] functions, double minimumPower, double maximumPower) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions, minimumPower, maximumPower)); }
    }

    public Network (int[] widths, int length, String function, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], function, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String[] functions, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String[][] functions, double minimumPower, double maximumPower) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions[i], minimumPower, maximumPower)); }
    }

    public Network (int[] widths, int length, String function, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], function, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String[][] functions, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions[i], minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String[] functions, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String[][] functions, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 1; i <= length; i++) { this.layers.add(new Layer(widths[i], functions[i], minimumPowers[i], maximumPowers[i])); }
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