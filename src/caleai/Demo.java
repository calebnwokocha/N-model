package caleai;/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        String[] fileNames = {
                "src/caleai/test1.txt",
                "src/caleai/test2.txt",
                "src/caleai/text3.txt",
                "src/caleai/text4.txt",
                "src/caleai/test1.txt",
                "src/caleai/test2.txt",
                "src/caleai/text3.txt",
                "src/caleai/text4.txt",
                "src/caleai/test1.txt",
                "src/caleai/test2.txt",
                "src/caleai/text3.txt",
                "src/caleai/text4.txt",
                "src/caleai/test1.txt",
                "src/caleai/test2.txt",
                "src/caleai/text3.txt",
                "src/caleai/text4.txt",
                "src/caleai/test1.txt",
                "src/caleai/test2.txt",
                "src/caleai/text3.txt",
                "src/caleai/text4.txt",
                "src/caleai/test1.txt",
                "src/caleai/test2.txt",
                "src/caleai/text3.txt",
                "src/caleai/text4.txt"
        };

        Dataset dataset = new Dataset(fileNames);

        Network network = new Network(5, 11, 1);

        for (int i = 0; i < dataset.getDataset().length; i++) {
            for (int j = 0; j < network.getLayers().size(); j++) {
                if (j == 0) {
                    network.getLayers().get(j).activate(dataset.getDataset()[i]);
                    network.getLayers().get(j).optimize(new double[]{1000, 2000, -3000, 4000, 5000}, i + 1);
                }
                else {
                    network.getLayers().get(j - 1).setTheses();
                    network.getLayers().get(j).activate(network.getLayers().get(j - 1).getTheses());
                    network.getLayers().get(j).optimize(new double[]{1000, 2000, -3000, 4000, 5000}, i + 1);
                }
            }
        }

        for (int j = 0; j < network.getLayers().size(); j++) {
            if (j == network.getLayers().size() - 1) {
                network.getLayers().get(j).setTheses();
            } System.out.println(Arrays.toString(network.getLayers().get(j).getTheses()));
        }
    }
}