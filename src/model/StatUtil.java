/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

/**
 The StatUtil class is a collection of methods for manipulating and interacting with data.
 It includes methods for calculating the dynamic power mean, variance, and standard deviation
 of a given array of data. It also includes methods for calculating the dynamic power mean of
 a given mean and datum, and a given array of means and data, and a given 2D array of means
 and data, all using the specified power and iteration. Additionally, it includes a constructor
 for the StatUtil class.
 */
class StatUtil {

    /**
     * Constructor for the StatUtil class.
     */
    StatUtil() {}

    /**
     * This method calculates the dynamic power mean of a given mean and datum using the specified power and iteration.
     * @param mean The current mean of the data.
     * @param datum The new data point to be added to the mean.
     * @param power The power to be used in the calculation of the dynamic power mean.
     * @param iteration The number of iterations for which the mean has been calculated.
     * @return The dynamic power mean of the data.
     */
    public Double dynamicPowerMean (Double mean, Double datum, Double power, int iteration) {
        mean = Math.pow((1.0 / iteration) * (Math.pow(datum, power) +
                (Math.pow(mean, power) * (iteration - 1))), 1.0 / power);
        return mean;
    }

    /**
     * This method calculates the dynamic power mean of a given array of means and data using the specified power and iteration.
     * @param mean The current mean of the data in the form of an array.
     * @param data The new data points to be added to the mean in the form of an array.
     * @param power The power to be used in the calculation of the dynamic power mean.
     * @param iteration The number of iterations for which the mean has been calculated.
     * @return The dynamic power mean of the data in the form of an array.
     */
    public Double[] dynamicPowerMean (Double[] mean, Double[] data, double power, int iteration) {
        for (int i = 0; i < data.length; i++) {
            try { mean[i] = this.dynamicPowerMean(mean[i], data[i], power, iteration); }
            catch (NullPointerException ignored) {}
        } return mean;
    }

    /**
     * This method calculates the dynamic power mean of a given 2D array of means and data using the specified power and iteration.
     * @param mean The current mean of the data in the form of a 2D array.
     * @param data The new data points to be added to the mean in the form of a 2D array.
     * @param power The power to be used in the calculation of the dynamic power mean.
     * @param iteration The number of iterations for which the mean has been calculated.
     * @return The dynamic power mean of the data in the form of a 2D array.
     */
    public Double[][] dynamicPowerMean (Double[][] mean, Double[][] data, double power, int iteration) {
        for (int i = 0; i < data.length; i++) {
            try{ mean[i] = this.dynamicPowerMean(mean[i], data[i], power, iteration); }
            catch (ArrayIndexOutOfBoundsException e) { break; }
        } return mean;
    }

    /**
     * This method calculates the variance of a given array of data using the specified expected value.
     * @param data The array of data for which the variance is to be calculated.
     * @param expectedValue The expected value of the data.
     * @return The variance of the data.
     */
    public Double variance (Double[] data, Double expectedValue) {
        double squaredSum = 0.0;
        double variance;
        try { for (Double datum : data) { squaredSum += Math.pow(datum - expectedValue, 2); } }
        catch (NullPointerException ignored) {}
        if (squaredSum == 0 || (data.length - 1) == 0) { variance = squaredSum; }
        else { variance = squaredSum / (data.length - 1); }
        return variance;
    }

    /**
     * This method calculates the standard deviation of a given array of data using the specified expected value.
     * @param data The array of data for which the standard deviation is to be calculated.
     * @param expectedValue The expected value of the data.
     * @return The standard deviation of the data.
     */
    public Double standardDeviation (Double[] data, Double expectedValue) {
        return Math.sqrt(this.variance(data, expectedValue));
    }

    /**
     * This method checks if a given data point is between a specified minimum and maximum value.
     * @param data The data point to be checked.
     * @param minimum The lower bound of the range.
     * @param maximum The upper bound of the range.
     * @return true if data is between minimum and maximum, false otherwise.
     */
    public boolean isBetween (Double data, Double minimum, Double maximum) {
        return minimum <= data && data <= maximum;
    }

    /**
     * This method checks if a given array of data points is an outlier based on the specified lower and upper bounds of the data.
     * @param data The array of data points to be checked for outliers.
     * @param dataLowerBound The lower bounds of the data.
     * @param dataUpperBound The upper bounds of the data.
     * @return true if data is an outlier, false otherwise.
     */
    public boolean isOutlier(Double[] data, Double[] dataLowerBound, Double[] dataUpperBound) {
        try { for (int i = 0; i < data.length; i++) {
            if (this.isBetween(data[i], dataLowerBound[i], dataUpperBound[i])) { return false; }
        } } catch (NullPointerException e) { return true; }
        return true;
    }

}
