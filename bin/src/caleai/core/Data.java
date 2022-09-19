/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {
    private byte[] data;

    public Data (String fileName) throws IOException {
       this.setData(fileName);
    }

    public byte[] getData() { return this.data; }

    public int getLength() { return this.data.length; }

    public void setData(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        this.data = Files.readAllBytes(path);
    }

    public double[][] divide (int[] groups) {
        double[][] groupedData = new double[groups.length][];
        int k = 0;
        for (int i = 0; i < groups.length; i++) {
            for (int j = 0; j < groups[i]; j++, k++) {
                groupedData[i][j] = this.data[k];
            }
        } return groupedData;
    }
}
