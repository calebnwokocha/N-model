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

package javis;

/**
 * CFunction class consist of comprehensive functions used by the Node class.
 */
public class CFunction {
    private double value;

    /**
     * This constructs a comprehensive function with only one parameter.
     * It requires the function name.
     */
    public CFunction(String functionName, double parameter) {
        switch (functionName) { // Configure function according to function name.
            case "sum" -> this.sum(parameter);
            case "cubic volume" -> this.cubicVolume(parameter);
        }
    }

    /**
     * This constructs a comprehensive function with multiple parameters.
     * It requires the function name.
     */
    public CFunction(String functionName, double... parameters) {
        switch (functionName) { // Configure function according to function name.
            case "sum" -> this.sum(parameters);
            case "force" -> this.force(parameters[0], parameters[1]);
        }
    }

    /**
     * This returns the result of a comprehensive function operation.
     */
    public double getValue() { return this.value; }

    // Below are methods for comprehensive functions.

    private void cubicVolume (double s) { this.value = Math.pow(s, 3); }

    private void force (double m, double a) { this.value = m * a /*(m + a) - ((m * a) * (1 + m + a - (m * a)))*/; }

    private void sum (double... X) {
        double s = 0;
        for (double x : X) { s += x; }
        this.value =  s;
    }
}
