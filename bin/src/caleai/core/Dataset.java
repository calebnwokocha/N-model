package caleai.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dataset {
    private Data[] dataset;

    public Dataset (String[] fileNames) throws IOException {
        this.dataset = new Data[fileNames.length];
        for (int i = 0; i < this.dataset.length; i++) {
            this.dataset[i] = new Data(fileNames[i]);
        }
    }

    public Data[] getDataset() { return this.dataset; }

    public void setDataset(Data[] dataset) { this.dataset = dataset; }

    public void shuffle () { Collections.shuffle(Arrays.asList(this.dataset)); }
}
