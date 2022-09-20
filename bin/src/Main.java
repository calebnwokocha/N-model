/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] fileNames = {
                "bin/src/test1.txt",
                "bin/src/test2.txt",
                "bin/src/text3.txt",
                "bin/src/text4.txt"
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