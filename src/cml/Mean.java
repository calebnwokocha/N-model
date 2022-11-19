/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package cml;

public class Mean {
    public Mean() {}

    public Double powerMean (Double mean, Double datum, double power, int iteration) {
        mean = Math.pow((1.0 / iteration) * (Math.pow(datum, power) +
                (Math.pow(mean, power) * (iteration - 1))), 1.0 / power);
        return mean;
    }

    public Double[] powerMean (Double[] mean, Double[] data, double power, int iteration) {
        for (int i = 0; i < data.length; i++) {
            mean[i] = this.powerMean(mean[i], data[i], power, iteration);
        } return mean;
    }

    public Double[][] powerMean (Double[][] mean, Double[][] data, double power, int iteration) {
        for (int i = 0; i < data.length; i++) {
            try{ mean[i] = this.powerMean(mean[i], data[i], power, iteration); }
            catch (ArrayIndexOutOfBoundsException e) { break; }
        } return mean;
    }
}


