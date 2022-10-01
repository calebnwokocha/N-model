package caleai;

/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * SCHOOL: THE UNIVERSITY OF MANITOBA
 * DEPARTMENT: COMPUTER SCIENCE
 * WARNING: THIS SOURCE CODE IS AVAILABLE UNDER GNU AFFERO GENERAL PUBLIC LICENSE.
 *          CONTACT CALEBNWOKOCHA@GMAIL.COM FOR SPECIAL PERMISSION OR LICENSE
 *          TO USE THIS SOURCE CODE.
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Dataset {
    private Data[] dataset;

    public Dataset (String... fileNames) throws IOException {
        this.dataset = new Data[fileNames.length];
        for (int i = 0; i < this.dataset.length; i++) {
            this.dataset[i] = new Data(fileNames[i]); }
    }

    public double[][] getDataset() {
        double[][] dataset = new double[this.dataset.length][];
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = this.dataset[i].getData();
        } return dataset;
    }

    public void setDataset(Data... dataset) { this.dataset = dataset; }

    public void shuffle () { Collections.shuffle(Arrays.asList(this.dataset)); }
}
