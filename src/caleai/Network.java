package caleai;/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

import java.util.ArrayList;

public class Network {
    private final ArrayList<Layer> layers = new ArrayList<>();

    // Construct network.
    public Network (int width, int length, String function, double power) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, function, power)); }
    }

    public Network (int width, int length, String[] functions, double power) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions, power)); }
    }

    public Network (int width, int length, String function, double[] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, function, powers)); }
    }

    public Network (int width, int length, String[] functions, double[] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions, powers)); }
    }

    public Network (int width, int length, String[][] functions, double power) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions[i], power)); }
    }

    public Network (int width, int length, String function, double[][] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, function, powers[i])); }
    }

    public Network (int width, int length, String[][] functions, double[] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions[i], powers)); }
    }

    public Network (int width, int length, String[] functions, double[][] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions, powers[i])); }
    }

    public Network (int width, int length, String[][] functions, double[][] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions[i], powers[i])); }
    }

    public Network (int[] widths, int length, String function, double power) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], function, power)); }
    }

    public Network (int[] widths, int length, String[] functions, double power) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions, power)); }
    }

    public Network (int[] widths, int length, String function, double[] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], function, powers)); }
    }

    public Network (int[] widths, int length, String[] functions, double[] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions, powers)); }
    }

    public Network (int[] widths, int length, String[][] functions, double power) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions[i], power)); }
    }

    public Network (int[] widths, int length, String function, double[][] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], function, powers[i])); }
    }

    public Network (int[] widths, int length, String[][] functions, double[] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions[i], powers)); }
    }

    public Network (int[] widths, int length, String[] functions, double[][] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions, powers[i])); }
    }

    public Network (int[] widths, int length, String[][] functions, double[][] powers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions[i], powers[i])); }
    }

    public Network (int width, int length, String function, double minimumPower, double maximumPower) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, function, minimumPower, maximumPower)); }
    }

    public Network (int width, int length, String[] functions, double minimumPower, double maximumPower) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions, minimumPower, maximumPower)); }
    }

    public Network (int width, int length, String function, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, function, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int width, int length, String[] functions, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int width, int length, String[][] functions, double minimumPower, double maximumPower) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions[i], minimumPower, maximumPower)); }
    }

    public Network (int width, int length, String function, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, function, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int width, int length, String[][] functions, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions[i], minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int width, int length, String[] functions, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int width, int length, String[][] functions, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(width, functions[i], minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String function, double minimumPower, double maximumPower) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], function, minimumPower, maximumPower)); }
    }

    public Network (int[] widths, int length, String[] functions, double minimumPower, double maximumPower) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions, minimumPower, maximumPower)); }
    }

    public Network (int[] widths, int length, String function, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], function, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String[] functions, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String[][] functions, double minimumPower, double maximumPower) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions[i], minimumPower, maximumPower)); }
    }

    public Network (int[] widths, int length, String function, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], function, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String[][] functions, double[] minimumPowers, double[] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions[i], minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String[] functions, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions, minimumPowers[i], maximumPowers[i])); }
    }

    public Network (int[] widths, int length, String[][] functions, double[][] minimumPowers, double[][] maximumPowers) {
        for (int i = 0; i < length; i++) { this.layers.add(new Layer(widths[i], functions[i], minimumPowers[i], maximumPowers[i])); }
    }

    public ArrayList<Layer> getLayers () { return this.layers; }

    public void addLayer (Layer layer) { this.layers.add(layer); }

    public void activate (byte parameter) { // Activate all perceptron layers.
        for (Layer layer : this.layers) { layer.activate(parameter); }
    }

    public void activate (byte... parameters) { // Activate all perceptron layers.
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).activate(parameters[i]); }
    }

    public void activate (byte[]... parameters) { // Activate all perceptron layers.
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).activate(parameters[i]); }
    }

    public void activate (byte[][]... parameters) { // Activate all perceptron layers.
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).activate(parameters[i]); }
    }

    public void optimize (double[][] objective, int iteration) {
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).optimize(objective[i], iteration); }
    }

    public void optimize (int iteration, double[]... error) {
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).optimize(iteration, error[i]); }
    }
}