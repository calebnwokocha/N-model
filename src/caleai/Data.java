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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;

public class Data {
    private byte[] data;

    public Data (String fileName) throws IOException {
        Path path = Paths.get(fileName);
        this.data = Files.readAllBytes(path);
    }

    public double[] getData() {
        double[] data = new double[this.data.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = this.data[i];
        } return data;
    }

    public void setData(byte[] data) { this.data = data; }

    public double[][] divide (int[] groupSizes) {
        double[][] groups = new double[groupSizes.length][];
        int k = 0;
        for (int i = 0; i < groupSizes.length; i++) {
            for (int j = 0; j < groupSizes[i]; j++, k++) {
                groups[i][j] = this.data[k];
            }
        } return groups;
    }

    public void toText (double... data) {

    }

    public void toSound (double... data) {

    }

    public void toImage (double... data) {

    }

    public void toVideo (double... data) {

    }
}
