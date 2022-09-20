/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] fileNames = {
                "core/src/test1.txt",
                "core/src/test2.txt",
                "core/src/text3.txt",
                "core/src/text4.txt"
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