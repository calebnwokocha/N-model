/*------------------------------------------------------------------------------
 Open-source framework for comprehensive machine learning.

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

package cml.core;

public class Mean {
    public Mean() {}

    public Double powerMean (Double mean, Double datum, double power, int time) {
        mean = Math.pow((1.0 / time) * (Math.pow(datum, power) +
                (Math.pow(mean, power) * (time - 1))), 1.0 / power);
        return mean;
    }

    public Double[] powerMean (Double[] mean, Double[] data, double power, int time) {
        for (int i = 0; i < data.length; i++) {
            mean[i] = this.powerMean(mean[i], data[i], power, time);
        } return mean;
    }
}


