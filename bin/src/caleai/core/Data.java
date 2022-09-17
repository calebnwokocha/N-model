/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {
    private final byte[] bytes;

    public Data (String fileName) throws Exception {
        Path path = Paths.get(fileName);
        this.bytes = Files.readAllBytes(path);
    }

    public double[] getData() {
        double[] data = new double[this.bytes.length];
        for (int i = 0; i < data.length; i++ ) { data[i] = this.bytes[i];}
        return data;
    }
}
