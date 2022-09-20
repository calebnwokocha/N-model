/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai;

import caleai.core.Data;
import caleai.core.Dataset;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] fileNames = {
                "bin/src/caleai/core/test1.txt",
                "bin/src/caleai/core/test2.txt",
                "bin/src/caleai/core/text3.txt",
                "bin/src/caleai/core/text4.txt"
        };

        Dataset dataset = new Dataset(fileNames);

        System.out.println("Unshuffle dataset");
        for (Data data : dataset.getDataset()) {
            System.out.println(Arrays.toString(data.getData()));
        }

        dataset.shuffle();

        System.out.println("\nShuffle dataset");
        for (Data data : dataset.getDataset()) {
            System.out.println(Arrays.toString(data.getData()));
        }

        dataset.shuffle();

        System.out.println("\nShuffle dataset");
        for (Data data : dataset.getDataset()) {
            System.out.println(Arrays.toString(data.getData()));
        }
    }
}