/*------------------------------------------------------------------------------
 Open-source framework for comprehensive machine learning.

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

 Email calebnwokocha@gmail.com for technical support and/or special
 permission to use this framework.
---------------------------------------------------------------------------- */

package cml.core;

import java.util.ArrayList;

public class Multitask {
    private ArrayList<Network> networks;
    private ArrayList<double[]> objectives;

    public Multitask () {}

    public int getTaskCount() { return networks.size(); }

    public void setNetworks(ArrayList<Network> networks) { this.networks = networks; }

    public ArrayList<Network> getNetworks() { return this.networks; }

    public void addNetwork (Network network) {  this.networks.add(network); }

    public void removeNetwork (int index) { this.networks.remove(index); }

    public void setCoverage (Double coverage) {
        for (Network network : this.networks) { network.setCoverage(coverage); }
    }

    public void setCoverageVec (Double[] coverageVec) {
        for (Network network : this.networks) { network.setCoverageVec(coverageVec); }
    }

    public void setCoverageMat (Double[][] coverageMat) {
        for (Network network : this.networks) { network.setCoverageMat(coverageMat); }
    }

    public void setCoverageTensor (Double[][][] coverageTensor) {
        for (int i = 0; i < this.networks.size(); i++) { networks.get(i).setCoverageMat(coverageTensor[i]); }
    }

    public Double[][][] getCoverageTensor () {
        Double[][][] coverageTensor = new Double[this.networks.size()][][];
        for (int i = 0; i < coverageTensor.length; i++) {
            coverageTensor[i] = networks.get(i).getCoverageMat();
        } return coverageTensor;
    }

    public Double[][] getThesis () {
        Double[][] thesis = new Double[this.networks.size()][];
        for (int i = 0; i < thesis.length; i++) {
            Network currentNetwork = networks.get(i);
            int outputLayerIndex = currentNetwork.getLength() - 1;
            thesis[i] = currentNetwork.getThesisMat()[outputLayerIndex];
        } return thesis;
    }

    public void train (int iteration, double[] objective, Double[]... input) {
        int lastNetworkIndex = this.networks.size() - 1;
        this.networks.get(lastNetworkIndex).train(iteration, objective, input);
    }

    public void test (Double[]... input) { for (Network network : this.networks) { network.test(input); } }
}
