/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

public class Function {
    private double value;

    // Construct comprehensive function.
    public Function(String functionName, double parameter) {
        switch (functionName) { // Configure function according to function name.
            case "identity" -> this.identity(parameter);
            case "cubic volume" -> this.cubicVolume(parameter);
        }
    }

    public Function(String functionName, double... parameters) {
        switch (functionName) { // Configure function according to function name.
            case "force" -> this.force(parameters[0], parameters[1]);
            case "sum" -> this.sum(parameters);
        }
    }

    public double getValue() { return this.value; } // Return function value.

    private void cubicVolume (double s) { this.value = Math.pow(s, 3); }

    private void force (double m, double a) { this.value = m * a /*(m + a) - ((m * a) * (1 + m + a - (m * a)))*/; }

    private void identity (double x) { this.value = x; }

    private void sum (double... X) {
        double s = 0;
        for (double x : X) { s += x; }
        this.value =  s;
    }
}
