/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Multitask {
    private ArrayList<Network> networks = new ArrayList<>();
    private Double[][] errorMeanMean;
    private int lastNetworkIndex;
    private final ArrayList<Integer> nullFrequencyPerNetwork = new ArrayList<>();

    public Multitask () {}

    public Multitask (ArrayList<Network> networks) { this.networks = networks; }

    public int getTaskCount() { return networks.size(); }

    public void setNetworks(ArrayList<Network> networks) { this.networks = networks; }

    public ArrayList<Network> getNetworks() { return this.networks; }

    public void addNetwork (Network network) {
        if (networks.size() >= 1) { this.transferKnowledgeTo(network); }
        this.networks.add(network);
    }

    public void removeNetwork (int index) { this.networks.remove(index); }

    public Double[][][] getCoverage () {
        Double[][][] coverage = new Double[this.networks.size()][][];
        for (int i = 0; i < coverage.length; i++) {
            coverage[i] = networks.get(i).getCoverage();
        } return coverage;
    }

    public Double[][] getThesis () {
        Double[][] thesis = new Double[this.networks.size()][];
        for (int i = 0; i < thesis.length; i++) {
            Network currentNetwork = this.networks.get(i);
            int outputLayerIndex = currentNetwork.getLength() - 1;
            thesis[i] = currentNetwork.getThesis()[outputLayerIndex];
        } return thesis;
    }

    public void train (int iteration, Double[] objective, Double[]... input) {
        this.lastNetworkIndex = this.networks.size() - 1;
        this.networks.get(this.lastNetworkIndex).train(iteration, objective, input);
    }

    public void test (int iteration, Double[]... input) { for (Network network : this.networks) { network.test(input); }
        Double[][] thesis = this.getThesis();
        int[][] nullNonNullAs10 = this.convertNullTo1AndNonNullTo0(thesis);
        int[] nullCountPerNetwork = this.countNullsPerNetwork(nullNonNullAs10);
        if (iteration == 0) {
            for (int count : nullCountPerNetwork) { this.nullFrequencyPerNetwork.add(count); }
        } else { for (int i = 0; i < nullCountPerNetwork.length; i++) {
            this.nullFrequencyPerNetwork.set(i, this.nullFrequencyPerNetwork.get(i) + nullCountPerNetwork[i]);
            }
        } System.out.println("Null frequence per network of multitask: "
                + Arrays.toString(new ArrayList[]{this.nullFrequencyPerNetwork}));
        System.out.println();
        System.out.println();
    }

    private void transferKnowledgeTo(Network network) {
        if (networks.size() > 0) {
            this.lastNetworkIndex = this.networks.size() - 1;
            Double[][] lastNetworkErrorMean = networks.get(this.lastNetworkIndex).getErrorMean();
            StatUtil stat = new StatUtil();
            if (hasOnlyOneNetwork()) {
                this.errorMeanMean = this.networks.get(this.lastNetworkIndex).getErrorMean();
            } else { this.errorMeanMean = stat.dynamicPowerMean(this.errorMeanMean, lastNetworkErrorMean,
                    1.0, this.networks.size());
            } network.setErrorMean(this.errorMeanMean);
        }
    }

    private boolean hasOnlyOneNetwork () { return this.networks.size() == 1; }

    private int[][] convertNullTo1AndNonNullTo0 (Double[][] thesis) {
        int[][] nullNonNullAs10 = new int[thesis.length][];
        for (int i = 0; i < thesis.length; i++) {
            nullNonNullAs10[i] = new int[thesis[i].length];
            for (int j = 0; j < thesis[i].length; j++) {
                if (thesis[i][j] == null) { nullNonNullAs10[i][j] = 1; }
                else { nullNonNullAs10[i][j] = 0; }
            }
        } return nullNonNullAs10;
    }

    private int[] countNullsPerNetwork (int[][] nullNonNullAs10) {
        int[] nullCountPerNetwork = new int[nullNonNullAs10.length];
        Arrays.fill(nullCountPerNetwork, 0);
        for (int i = 0; i < nullCountPerNetwork.length; i++) {
            for (int j = 0; j < nullNonNullAs10[i].length; j++) {
                nullCountPerNetwork[i] += nullNonNullAs10[i][j];
            }
        } return nullCountPerNetwork;
    }

    private void forgetNetwork () {

    }
}
