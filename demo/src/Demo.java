/*------------------------------------------------------------------------------
 Javai is open-source framework for comprehensive learning, produced and
 maintained by the Javai Foundation.

 Copyright (C) 2022 Javai Foundation

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published
 by the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with this program. If not, see <https://www.gnu.org/licenses/>.

 Email info@javai.org for technical support and/or special permission
 to use this framework.
---------------------------------------------------------------------------- */

import javai.Dataset;
import javai.Layer;

public class Demo {
    public static void main(String[] args) throws Exception {
        String[] fileNames1 = {
                "demo/dataset1/data1.txt",
                "demo/dataset1/data2.txt",
                "demo/dataset1/data3.txt",
                "demo/dataset1/data4.txt",
                "demo/dataset1/data1.txt",
                "demo/dataset1/data2.txt",
                "demo/dataset1/data3.txt",
                "demo/dataset1/data4.txt",
                "demo/dataset1/data1.txt",
                "demo/dataset1/data2.txt",
                "demo/dataset1/data3.txt",
                "demo/dataset1/data4.txt",
                "demo/dataset1/data1.txt",
                "demo/dataset1/data2.txt",
                "demo/dataset1/data3.txt",
                "demo/dataset1/data4.txt",
                "demo/dataset1/data1.txt",
                "demo/dataset1/data2.txt",
                "demo/dataset1/data3.txt",
                "demo/dataset1/data4.txt",
                "demo/dataset1/data1.txt",
                "demo/dataset1/data2.txt",
                "demo/dataset1/data3.txt",
                "demo/dataset1/data4.txt"
        };

        String[] fileNames2 = {
                "demo/dataset2/data1.txt",
                "demo/dataset2/data2.txt",
                "demo/dataset2/data3.txt",
                "demo/dataset2/data4.txt",
                "demo/dataset2/data1.txt",
                "demo/dataset2/data2.txt",
                "demo/dataset2/data3.txt",
                "demo/dataset2/data4.txt",
                "demo/dataset2/data1.txt",
                "demo/dataset2/data2.txt",
                "demo/dataset2/data3.txt",
                "demo/dataset2/data4.txt",
                "demo/dataset2/data1.txt",
                "demo/dataset2/data2.txt",
                "demo/dataset2/data3.txt",
                "demo/dataset2/data4.txt",
                "demo/dataset2/data1.txt",
                "demo/dataset2/data2.txt",
                "demo/dataset2/data3.txt",
                "demo/dataset2/data4.txt",
                "demo/dataset2/data1.txt",
                "demo/dataset2/data2.txt",
                "demo/dataset2/data3.txt",
                "demo/dataset2/data4.txt"
        };

        Dataset dataset1 = new Dataset(fileNames1);
        Dataset dataset2 = new Dataset(fileNames2);
        Dataset dataset3 = new Dataset();


        double[] x1 = new double[100];
        double[] x2 = new double[100];
        int[] y = new int[100];
        Double[][] dset = new Double[100][2];
        for (int i = 0; i < 100; i++) {
            x1[i] = Math.random();
            x2[i] = Math.random();
            y[i] = (int) Math.round((x1[i] + x2[i]) - (2 * x1[i] + x2[i]));
        }

        for (int i = 0; i < 100; i++) {
            dset[i][0] = x1[i];
            dset[i][1] = x2[i];
        }

        dataset3.setDataset(dset);


        Layer[] layer = new Layer[10];
        for (int i = 0; i < layer.length; i++) {
            if (i == layer.length - 1) {
                layer[i] = new Layer(1);
            } else { layer[i] = new Layer(1); }
            layer[i].setFunctionName("sum");
            layer[i].setPower(1.0);
            layer[i].setCoverage(7.0);
        }

        // Train
        for (int i = 0; i < dataset3.getDataset().length; i++) {
            for (int j = 0; j < layer.length; j++) {
                if (j == 0) {
                    layer[j].train(i + 1, new double[]{y[i]}, dataset3.getDataset()[i]);
                } else {
                    layer[j].train(i + 1, new double[]{y[i]}, layer[j - 1].getThesisVec());
                }
            }

            /*System.out.println("Example " + i);
            System.out.println("Input is " + Arrays.toString(dataset3.getDataset()[i]));
            System.out.println("Objective is " + y[i]);
            System.out.println("Network prediction is " + Arrays.toString(layer[layer.length - 1].getThesisVec()));
            System.out.println("Network error is " + Arrays.toString(layer[layer.length - 1].getErrorMeanVec()));
            System.out.println();*/

            System.out.println(layer[layer.length - 1].getErrorMeanVec()[0]);
        }

/*        dataset2 = new Dataset();
        dataset2.setDataset(new Double[][] {
                {1143438888888.0, 234358888888883.0, 2348888888888231.5, 1343.0, 1354153.12}
        });*/

/*        Network network1 = new Network(5, 10);
        network1.setFunctionName("sum");
        network1.setPower(1.0);
        network1.setCoverage(7.0);

        // Train
        for (int i = 0; i < dataset1.getDataset().length; i++) {
            System.out.println("Example " + i);
            network1.train(i + 1, new double[]{100000, 10, 100, 10, 100}, dataset1.getDataset()[i]);
            for (Layer layer : network1.getLayers()) {
                System.out.println(Arrays.toString(layer.getThesisVec()));
                System.out.println();
            }
        }*/

        //network1.train(1, new double[]{-100000, 10, 100, 10, 100}, dataset1.getDataset());


        // Test
/*
        dataset1.shuffle();
        for (int i = 0; i < dataset2.getDataset().length; i++) {
            System.out.println("Test " + i);
            network1.test(dataset2.getDataset()[i]);
            System.out.println(Arrays.toString(network1.getLayers().get(network1.getLayers().size() - 1).getThesisVec()));
            System.out.println();
        }
*/

        //network1.test(dataset1.getDataset());
        //System.out.println(Arrays.toString(network1.getLayers().get(network1.getLayers().size() - 1).getThesisVec()));
    }
}