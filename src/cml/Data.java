/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package cml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {
    private Double[] data;

    public Data(Double[] data) { this.data = data; }

    public Data (String fileName) throws IOException {
        Path path = Paths.get(fileName);
        byte[] data = Files.readAllBytes(path);
        this.data = this.convertByteToDouble(data);
    }

    public Data (File file) throws IOException {
        byte[] data = Files.readAllBytes(file.toPath());
        this.data = this.convertByteToDouble(data);
    }

    public Double[] getData() { return this.data; }

    public double getDatum (int index) { return this.data[index]; }

    public void setData(Double[] data) { this.data = data; }

    public double[][] divide (int[] groupSizes) {
        double[][] groups = new double[groupSizes.length][];
        int k = 0;
        for (int i = 0; i < groupSizes.length; i++) {
            for (int j = 0; j < groupSizes[i]; j++, k++) {
                groups[i][j] = this.data[k];
            }
        } return groups;
    }

    private Double[] convertByteToDouble (byte[] byteData) {
        Double[] doubleData = new Double[byteData.length];
        for (int i = 0; i < doubleData.length; i++) { doubleData[i] = (double) byteData[i]; }
        return doubleData;
    }

    public void toText () {

    }

    public void toSound () {

    }

    public void toImage () {

    }

    public void toVideo () {

    }

    public void saveData () {

    }

    public void retrieveData () {

    }
}
