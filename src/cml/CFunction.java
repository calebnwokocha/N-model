/*------------------------------------------------------------------------------
 Open-source framework for comprehensive learning.

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

 Email calebnwokocha@gmail.com for technical support and/or special
 permission to use this framework.
---------------------------------------------------------------------------- */

package cml;

public class CFunction {
    private double value;
    private double degree;

    public CFunction(String functionName, Double... parameters) {
        switch (functionName) {
            case "sum" -> this.sum(parameters);
            case "force" -> this.force(parameters[0], parameters[1]);
            case "square" -> this.square(parameters[0]);
        }
    }

    public double getDegree() { return this.degree; }

    public double getValue() { return this.value; }

    private void cubicVolume (Double s) { this.degree = 3.0; this.value = Math.pow(s, this.degree); }

    private void force (Double m, Double a) { this.degree = 1.0; this.value = m * a; }

    private void sum (Double... X) {
        this.degree = 1.0; double s = 0;
        for (double x : X) { s += x; } this.value =  s;
    }

    private void square (Double x) { this.degree = 2.0; this.value = Math.pow(x, this.degree); }
}
