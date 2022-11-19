/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package cml;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Dataset {
    private Double[][] dataset;

    public Dataset(Double[][] dataset) { this.dataset = dataset; }

    public Dataset (String... fileNames) throws IOException {
        Data[] dataset = new Data[fileNames.length];
        this.dataset = new Double[dataset.length][];
        for (int i = 0; i < this.dataset.length; i++) {
            dataset[i] = new Data(fileNames[i]);
            this.dataset[i] = dataset[i].getData();
        }
    }

    public Dataset (String folderName) throws IOException {
        File file = new File(folderName);
        File[] files = file.listFiles();
        Data[] dataset = new Data[files.length];
        this.dataset = new Double[dataset.length][];
        for (int i = 0; i < this.dataset.length; i++) {
            dataset[i] = new Data(files[i]);
            this.dataset[i] = dataset[i].getData();
        }
    }

    public Double[][] getDataset() { return this.dataset; }

    public Double[] getDataset (int index) { return this.dataset[index]; }

    public void setDataset(Double[]... dataset) { this.dataset = dataset; }

    public void shuffle () { Collections.shuffle(Arrays.asList(this.dataset)); }

    public void saveDataset () {
        for (Double[] d : this.dataset) {
            Data data = new Data(d);
            data.saveData();
        }
    }

    public void retrieveDataset () {

    }
}
