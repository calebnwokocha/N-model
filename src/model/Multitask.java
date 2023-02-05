/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Multitask class is used to hold multiple instances of the Network class,
 * allowing for training and testing of multiple networks at once. It also allows
 * for knowledge transfer between networks and keeps track of the non-null thesis frequency
 * of each network. The class has various methods such as adding and removing networks,
 * getting the coverage and thesis of all networks, and training and testing all the
 * networks in the multitask network. It also has a variable to keep track of the index
 * of the last network added to the multitask network.
 */
public class Multitask {
    private ArrayList<Network> networks = new ArrayList<>();
    private Double[][] errorMeanMean;
    private int lastNetworkIndex;
    private final ArrayList<Integer> nullFrequencyPerNetwork = new ArrayList<>();

    /**
     * Creates an empty instance of the multitask class
     */
    public Multitask () {}

    /**
     * Creates an instance of the multitask class with the specified networks
     * @param networks the networks to be included in the multitask object
     */
    public Multitask (ArrayList<Network> networks) { this.networks = networks; }

    /**
     * Returns the number of networks in the multitask object
     * @return the number of networks
     */
    public int getTaskCount() { return networks.size(); }

    /**
     * Sets the networks in the multitask object
     * @param networks the networks to be set in the multitask object
     */
    public void setNetworks(ArrayList<Network> networks) { this.networks = networks; }

    /**
     * Returns the networks in the multitask object
     * @return the networks in the multitask object
     */
    public ArrayList<Network> getNetworks() { return this.networks; }

    /**
     * Adds a new network to the multitask object and transfers knowledge from the previous network
     * @param network the new network to be added
     */
    public void addNetwork (Network network) {
        if (networks.size() >= 1) { this.transferKnowledgeTo(network); }
        this.networks.add(network);
    }

    /**
     * Removes a network at the specified index from the multitask object
     * @param index the index of the network to be removed
     */
    public void removeNetwork (int index) { this.networks.remove(index); }

    /**
     * Returns the coverage of all networks in the multitask object as a 3D array
     * @return the coverage of all networks
     */
    public Double[][][] getCoverage () {
        Double[][][] coverage = new Double[this.networks.size()][][];
        for (int i = 0; i < coverage.length; i++) {
            coverage[i] = networks.get(i).getCoverage();
        } return coverage;
    }

    /**
     * Returns the thesis of all networks in the multitask object as a 2D array
     * @return the thesis of all networks
     */
    public Double[][] getThesis () {
        Double[][] thesis = new Double[this.networks.size()][];
        for (int i = 0; i < thesis.length; i++) {
            Network currentNetwork = this.networks.get(i);
            int outputLayerIndex = currentNetwork.getLength() - 1;
            thesis[i] = currentNetwork.getThesis()[outputLayerIndex];
        } return thesis;
    }

    /**
     * The train method is used to train the last network added to the multitask network.
     *
     * @param iteration The number of iterations the network should be trained for.
     * @param objective The expected output for the given input.
     * @param input The input to be trained on.
     */
    public void train (int iteration, Double[] objective, Double[]... input) {
        this.lastNetworkIndex = this.networks.size() - 1;
        this.networks.get(this.lastNetworkIndex).train(iteration, objective, input);
    }

    /**
     * The test method is used to test all the networks in the multitask network.
     * It also prints the null frequency per network of the multitask network.
     *
     * @param iteration The number of iterations the network should be tested for.
     * @param input The input to be tested on.
     */
    public void test (int iteration, Double[]... input) { for (Network network : this.networks) { network.test(input); }
        Double[][] thesis = this.getThesis();
        int[][] nullNonNullAs10 = this.convertNullTo1AndNonNullTo0(thesis);
        int[] nullCountPerNetwork = this.countNullsPerNetwork(nullNonNullAs10);
        if (iteration == 0) {
            for (int count : nullCountPerNetwork) { this.nullFrequencyPerNetwork.add(count); }
        } else { for (int i = 0; i < nullCountPerNetwork.length; i++) {
            this.nullFrequencyPerNetwork.set(i, this.nullFrequencyPerNetwork.get(i) + nullCountPerNetwork[i]);
        }
        }/* System.out.println("Non-null thesis frequence per network of multitask: "
                + Arrays.toString(new ArrayList[]{this.nullFrequencyPerNetwork}));*/
        System.out.println();
        System.out.println();
    }

    /**
     * The transferKnowledgeTo method is used to transfer knowledge from the last network to the current network.
     *
     * @param network The current network that knowledge is being transferred to.
     */
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

    /**
     * The hasOnlyOneNetwork method checks if the multitask network has only one network.
     *
     * @return A boolean indicating if the multitask network has only one network.
     */
    private boolean hasOnlyOneNetwork () { return this.networks.size() == 1; }

    /**
     * convertNullTo1AndNonNullTo0 is a helper function that converts all the null values in a 2D Double array to 0
     * and all non-null values to 1.
     *
     * @param thesis a 2D Double array containing the thesis of the network
     * @return an int[][] where all the null values in the input thesis are converted to 0 and all non-null values to 1.
     */
    private int[][] convertNullTo1AndNonNullTo0 (Double[][] thesis) {
        int[][] nullNonNullAs01 = new int[thesis.length][];
        for (int i = 0; i < thesis.length; i++) {
            nullNonNullAs01[i] = new int[thesis[i].length];
            for (int j = 0; j < thesis[i].length; j++) {
                if (thesis[i][j] == null) { nullNonNullAs01[i][j] = 0; }
                else { nullNonNullAs01[i][j] = 1; }
            }
        } return nullNonNullAs01;
    }

    /**
     * countNullsPerNetwork is a helper function that counts the number of non-null values in each network
     *
     * @param nullNonNullAs01 a 2D int array where all the null values are converted to 0 and all non-null values to 1
     * @return an int[] where the i-th element represents the number of non-null values in the i-th network
     */
    private int[] countNullsPerNetwork (int[][] nullNonNullAs01) {
        int[] nonnullCountPerNetwork = new int[nullNonNullAs01.length];
        Arrays.fill(nonnullCountPerNetwork, 0);
        for (int i = 0; i < nonnullCountPerNetwork.length; i++) {
            for (int j = 0; j < nullNonNullAs01[i].length; j++) {
                nonnullCountPerNetwork[i] += nullNonNullAs01[i][j];
            }
        } return nonnullCountPerNetwork;
    }

    private void forgetNetwork () {

    }
}