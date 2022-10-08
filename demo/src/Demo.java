/*--------------------------------------------------------------------------------------------------
 Javai is open-source framework for comprehensive learning.
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

 Email info@javai.org for IT support and/or special permission to use this framework.
----------------------------------------------------------------------------------------------------*/

import javai.Dataset;
import javai.Layer;
import javai.Network;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        String[] fileNames1 = {
                "demo/dataset1/test1.txt",
                "demo/dataset1/test2.txt",
                "demo/dataset1/text3.txt",
                "demo/dataset1/text4.txt",
                "demo/dataset1/test1.txt",
                "demo/dataset1/test2.txt",
                "demo/dataset1/text3.txt",
                "demo/dataset1/text4.txt",
                "demo/dataset1/test1.txt",
                "demo/dataset1/test2.txt",
                "demo/dataset1/text3.txt",
                "demo/dataset1/text4.txt",
                "demo/dataset1/test1.txt",
                "demo/dataset1/test2.txt",
                "demo/dataset1/text3.txt",
                "demo/dataset1/text4.txt",
                "demo/dataset1/test1.txt",
                "demo/dataset1/test2.txt",
                "demo/dataset1/text3.txt",
                "demo/dataset1/text4.txt",
                "demo/dataset1/test1.txt",
                "demo/dataset1/test2.txt",
                "demo/dataset1/text3.txt",
                "demo/dataset1/text4.txt"
        };

        String[] fileNames2 = {
                "demo/dataset2/test1.txt",
                "demo/dataset2/test2.txt",
                "demo/dataset2/text3.txt",
                "demo/dataset2/text4.txt",
                "demo/dataset2/test1.txt",
                "demo/dataset2/test2.txt",
                "demo/dataset2/text3.txt",
                "demo/dataset2/text4.txt",
                "demo/dataset2/test1.txt",
                "demo/dataset2/test2.txt",
                "demo/dataset2/text3.txt",
                "demo/dataset2/text4.txt",
                "demo/dataset2/test1.txt",
                "demo/dataset2/test2.txt",
                "demo/dataset2/text3.txt",
                "demo/dataset2/text4.txt",
                "demo/dataset2/test1.txt",
                "demo/dataset2/test2.txt",
                "demo/dataset2/text3.txt",
                "demo/dataset2/text4.txt",
                "demo/dataset2/test1.txt",
                "demo/dataset2/test2.txt",
                "demo/dataset2/text3.txt",
                "demo/dataset2/text4.txt"
        };

        Dataset dataset1 = new Dataset(fileNames1);
        Dataset dataset2 = new Dataset(fileNames2);

        Network network = new Network(5, 10, 1);

        // Train
        for (int i = 0; i < dataset1.getDataset().length; i++) {
            //System.out.println("Example " + i);
            for (int j = 0; j < network.getLayers().size(); j++) {
                if (j == 0) {
                    network.getLayers().get(j).activate(dataset1.getDataset()[i]);
                }
                else {
                    network.getLayers().get(j).activate(network.getLayers().get(j - 1).getThesisVec());
                }
                Layer layer = new Layer(7);

                //System.out.println("Layer " + j);
                //System.out.println(Arrays.toString(network.getLayers().get(j).getThesisVec()));
                //System.out.println();
            }

            network.optimize(new double[]{-100000, 10, 100, 10, 100}, i + 1);
        }

        // Test
        dataset1.shuffle();
        for (int i = 0; i < dataset1.getDataset().length; i++) {
            System.out.println("Test " + i);
            for (int j = 0; j < network.getLayers().size(); j++) {
                if (j == 0) {
                    network.getLayers().get(j).activate(dataset1.getDataset()[i]);
                }
                else {
                    network.getLayers().get(j).activate(network.getLayers().get(j - 1).getThesisVec());
                }
                Layer layer = new Layer(7);

                //System.out.println("Layer " + j);
                //System.out.println(Arrays.toString(network.getLayers().get(j).getThesisVec()));
                //System.out.println();
            }

            System.out.println(Arrays.toString(network.getLayers().get(network.getLayers().size() - 1).getThesisVec()));
            System.out.println();
        }
    }
}