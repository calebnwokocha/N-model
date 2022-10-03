/*=======================================================================
 Caleai is an open-source framework for comprehensive learning.
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

package javis;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Dataset {
    private double[][] dataset;

    public Dataset() {}

    public Dataset (String... fileNames) throws IOException {
        Data[] dataset = new Data[fileNames.length];
        this.dataset = new double[dataset.length][];
        for (int i = 0; i < this.dataset.length; i++) {
            dataset[i] = new Data(fileNames[i]);
            this.dataset[i] = dataset[i].getData();
        }
    }

    public double[][] getDataset() { return this.dataset; }

    public double[] getDataset (int index) { return this.dataset[index]; }

    public void setDataset(double[]... dataset) { this.dataset = dataset; }

    public void shuffle () { Collections.shuffle(Arrays.asList(this.dataset)); }

    public void saveDataset () {
        for (double[] d : this.dataset) {
            Data data = new Data();
            data.setData(d);
            data.saveData();
        }
    }

    public void retrieveDataset () {

    }
}
