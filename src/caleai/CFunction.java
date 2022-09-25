package caleai;/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

public class CFunction {
    private double value;

    // Construct comprehensive function.
    public CFunction(String functionName, double parameter) {
        switch (functionName) { // Configure function according to function name.
            case "sum" -> this.sum(parameter);
            case "cubic volume" -> this.cubicVolume(parameter);
        }
    }

    public CFunction(String functionName, double... parameters) {
        switch (functionName) { // Configure function according to function name.
            case "sum" -> this.sum(parameters);
            case "force" -> this.force(parameters[0], parameters[1]);
        }
    }

    public double getValue() { return this.value; } // Return function value.

    private void cubicVolume (double s) { this.value = Math.pow(s, 3); }

    private void force (double m, double a) { this.value = m * a /*(m + a) - ((m * a) * (1 + m + a - (m * a)))*/; }

    private void sum (double... X) {
        double s = 0;
        for (double x : X) { s += x; }
        this.value =  s;
    }
}
