/*=======================================================================
 Javis is an open-source software framework for comprehensive learning.
 Copyright (C) 2022 Caleb Princewill Nwokocha

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

 Contact calebnwokocha@gmail.com for special permission to use this software.
=========================================================================*/

package jarvis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Data {
    private double[] data;

    public Data(double[] data) { this.data = data; }

    public Data (String fileName) throws IOException {
        Path path = Paths.get(fileName);
        byte[] data = Files.readAllBytes(path);
        this.data = new double[data.length];
        for (int i = 0; i < this.data.length; i++)
        { this.data[i] = data[i]; }
    }

    public double[] getData() { return this.data; }

    public double getDatum (int index) { return this.data[index]; }

    public void setData(double[] data) { this.data = data; }

    public double[][] divide (int[] groupSizes) {
        double[][] groups = new double[groupSizes.length][];
        int k = 0;
        for (int i = 0; i < groupSizes.length; i++) {
            for (int j = 0; j < groupSizes[i]; j++, k++) {
                groups[i][j] = this.data[k];
            }
        } return groups;
    }

    public void toText () {

    }

    public void toSound () {

    }

    public void toImage () {

    }

    public void toVideo () {

    }

    public void saveData () {

    }

    public void retrieveData () {

    }
}
