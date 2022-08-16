/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

public class Network {
    private Layer[] layers;
    private double error;

    public Network (int length, int[] width, String[][] functions, String[][] activators) throws WrongInitialization {
        if (width.length == length && functions.length == length && activators.length == length) {
            this.layers = new Layer[length];
            for (int i = 0; i < layers.length; i++) { layers[i] = new Layer(width[i], functions[i], activators[i]); }
        } else {throw new WrongInitialization("Wrong initialization of network"); }
    }

    public Layer[] getLayers () { return this.layers; }

    public void setLayer (Layer[] layers) { this.layers = layers; }

    public double getError() { return this.error; }

    public void feed (double[][]... input) {
        for (int i = 0; i < this.layers.length; i++) { this.layers[i].activate(input[i]); }
    }

    public void learn (double[] objective, Double error) throws UndefinedTarget {
        this.setError(objective, error); for (Layer layer : layers) { layer.optimize(this.error); }
    }

    private void setError(double[] objective, Double error) throws UndefinedTarget {
        if (objective == null && error != null) { this.error = error;
        } else if (objective != null && error == null) {
            Layer outputLayer = layers[layers.length - 1]; double sum = 0.0;
            for (int i = 0; i < outputLayer.getNeurons().length; i++) {
                sum += Math.abs(outputLayer.getNeurons()[i].getHypothesis() - objective[i]);
            } this.error = sum / outputLayer.getNeurons().length;
        } else { throw new UndefinedTarget("caleai.core.Network target undefined"); }
    }
}
