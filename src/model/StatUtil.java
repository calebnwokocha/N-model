/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

class StatUtil {
    StatUtil() {}

    public Double dynamicPowerMean (Double mean, Double datum, double power, int iteration) {
        mean = Math.pow((1.0 / iteration) * (Math.pow(datum, power) +
                (Math.pow(mean, power) * (iteration - 1))), 1.0 / power);
        return mean;
    }

    public Double[] dynamicPowerMean (Double[] mean, Double[] data, double power, int iteration) {
        for (int i = 0; i < data.length; i++) {
            mean[i] = this.dynamicPowerMean(mean[i], data[i], power, iteration);
        } return mean;
    }

    public Double[][] dynamicPowerMean (Double[][] mean, Double[][] data, double power, int iteration) {
        for (int i = 0; i < data.length; i++) {
            try{ mean[i] = this.dynamicPowerMean(mean[i], data[i], power, iteration); }
            catch (ArrayIndexOutOfBoundsException e) { break; }
        } return mean;
    }

    public Double variance (Double[] data, Double expectedValue) {
        double squaredSum = 0.0;
        double variance;
        for (Double datum : data) { squaredSum += Math.pow(datum - expectedValue, 2); }
        if (squaredSum == 0 || (data.length - 1) == 0) { variance = squaredSum; }
        else { variance = squaredSum / (data.length - 1); }
        return variance;
    }

    public Double standardDeviation (Double[] data, Double expectedValue) {
        return Math.sqrt(this.variance(data, expectedValue));
    }

    public boolean isBetween (Double data, Double minimum, Double maximum) {
        return minimum <= data && data <= maximum;
    }

    public boolean isOutlier(Double[] data, Double[] dataLowerBound, Double[] dataUpperBound) {
        try { for (int i = 0; i < data.length; i++) {
            if (this.isBetween(data[i], dataLowerBound[i], dataUpperBound[i])) { return false; }
        } } catch (NullPointerException e) { return true; }
        return true;
    }
}
