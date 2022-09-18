/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

import java.util.ArrayList;

public class Network {
    private final ArrayList<Layer> layers = new ArrayList<>();

    // Construct network.
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

    public void optimize (int iteration, double[][] error) {
        for (int i = 0; i < this.layers.size(); i++) { this.layers.get(i).optimize(iteration, error[i]); }
    }
}