package nmodel;

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


