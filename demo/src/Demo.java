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
import javai.Network;

import java.util.Arrays;

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

        dataset2 = new Dataset();
        dataset2.setDataset(new Double[][] {
                {1143438888888.0, 234358888888883.0, 2348888888888231.5, 1343.0, 1354153.12}
        });

        Network network = new Network(5, 10);
        network.setFunctionName("sum");
        network.setPower(1.0);
        network.setCoverage(6.0);

        // Train
        for (int i = 0; i < dataset1.getDataset().length; i++) {
            System.out.println("Example " + i);
            network.train(i + 1, new double[]{-100000, 10, 100, 10, 100}, dataset1.getDataset()[i]);
        }

        //network.train(1, new double[]{-100000, 10, 100, 10, 100}, dataset1.getDataset());


        // Test
        dataset1.shuffle();
        for (int i = 0; i < dataset1.getDataset().length; i++) {
            System.out.println("Test " + i);
            network.test(dataset1.getDataset()[i]);
            System.out.println(Arrays.toString(network.getLayers().get(network.getLayers().size() - 1).getThesisVec()));
            System.out.println();
        }

        //network.test(dataset1.getDataset());
        //System.out.println(Arrays.toString(network.getLayers().get(network.getLayers().size() - 1).getThesisVec()));
    }
}