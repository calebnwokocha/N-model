package caleai;

/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * SCHOOL: THE UNIVERSITY OF MANITOBA
 * DEPARTMENT: COMPUTER SCIENCE
 */

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        String[] fileNames = {
                "src/caleai/dataset/test1.txt",
                "src/caleai/dataset/test2.txt",
                "src/caleai/dataset/text3.txt",
                "src/caleai/dataset/text4.txt",
                "src/caleai/dataset/test1.txt",
                "src/caleai/dataset/test2.txt",
                "src/caleai/dataset/text3.txt",
                "src/caleai/dataset/text4.txt",
                "src/caleai/dataset/test1.txt",
                "src/caleai/dataset/test2.txt",
                "src/caleai/dataset/text3.txt",
                "src/caleai/dataset/text4.txt",
                "src/caleai/dataset/test1.txt",
                "src/caleai/dataset/test2.txt",
                "src/caleai/dataset/text3.txt",
                "src/caleai/dataset/text4.txt",
                "src/caleai/dataset/test1.txt",
                "src/caleai/dataset/test2.txt",
                "src/caleai/dataset/text3.txt",
                "src/caleai/dataset/text4.txt",
                "src/caleai/dataset/test1.txt",
                "src/caleai/dataset/test2.txt",
                "src/caleai/dataset/text3.txt",
                "src/caleai/dataset/text4.txt"
        };

        Dataset dataset = new Dataset(fileNames);

        Network network = new Network(5, 10, 1);

        for (int i = 0; i < dataset.getDataset().length; i++) {
            System.out.println("Example " + i);
            for (int j = 0; j < network.getLayers().size(); j++) {
                if (j == 0) {
                    network.getLayers().get(j).activate(dataset.getDataset()[i]);
                    network.getLayers().get(j).optimize(new double[]{-10, 10, -10, 10, -10}, i + 1);
                }
                else {
                    network.getLayers().get(j).activate(network.getLayers().get(j - 1).getThesisVec());
                    network.getLayers().get(j).optimize(new double[]{-10, 10, -10, 10, -10}, i + 1);
                }

                System.out.println("Layer " + j);
                System.out.println(Arrays.toString(network.getLayers().get(j).getThesisVec()));
                System.out.println();
            }
        }
    }
}