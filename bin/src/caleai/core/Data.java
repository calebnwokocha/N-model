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

    public byte[][] divide (int[] groupSizes) {
        byte[][] groupedData = new byte[groupSizes.length][];
        int k = 0;
        for (int i = 0; i < groupSizes.length; i++) {
            for (int j = 0; j < groupSizes[i]; j++, k++) {
                groupedData[i][j] = this.data[k];
            }
        } return groupedData;
    }

    public byte[] transform () {
        // TODO: This function should return a transformation of data.
        return null;
    }
}
