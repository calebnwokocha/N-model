/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Dataset {
    private Double[][] dataset;
    Data data = new Data();

    public Dataset() {}

    public Dataset(Double[]... dataset) { this.dataset = dataset; }

    public Dataset (String... fileNames) throws IOException {
        this.dataset = new Double[fileNames.length][];
        for (int i = 0; i < this.dataset.length; i++) { this.dataset[i] = new Data(fileNames[i]).getData(); }
    }

    public Dataset (String folderName) throws IOException {
        File file = new File(folderName); File[] files = file.listFiles();
        this.dataset = new Double[files.length][];
        for (int i = 0; i < this.dataset.length; i++) { this.dataset[i] = new Data(files[i]).getData(); }
    }

    public Double[][] getDataset() { return this.dataset; }

    public Double[] getData (int index) { return this.dataset[index]; }

    public void setDataset(Double[]... dataset) { this.dataset = dataset; }

    public void shuffle () { Collections.shuffle(Arrays.asList(this.dataset)); }

    public Double[][][] split (int... groupSizes) {
        Double[][][] groups = new Double[groupSizes.length][this.dataset.length][]; int k = 0;
        for (int i = 0; i < groupSizes.length; i++) {
            for (int j = 0; j < groupSizes[i]; j++, k++) {
                groups[i][j] = this.dataset[k];
            }
        } return groups;
    }

    public void transform (Double[]... basis) {
        for (int i = 0; i < dataset.length; i++) { this.data.setData(dataset[i]);
            try { this.data.transform(basis[i]); dataset[i] = this.data.getData(); }
            catch (NullPointerException e) { break; }
        }
    }

    public void stringsToDataset(String... data) {
        System.out.println(Arrays.toString(data));
        System.out.println();
        this.dataset = new Double[data.length][];
        for (int i = 0; i < this.dataset.length; i++) {
            this.dataset[i] = this.data.byteToDouble(data[i].getBytes());
            System.out.println(Arrays.toString(this.dataset[i]));
        }
        System.out.println("................................................................");
    }

    public void saveDataset () {
        for (Double[] data : this.dataset) { this.data.setData(data); this.data.saveData(); }
    }

    public void retrieveDataset () {

    }
}
