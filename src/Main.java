/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] fileNames = {
                "src/test1.txt",
                "src/test2.txt",
                "src/text3.txt",
                "src/text4.txt"
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