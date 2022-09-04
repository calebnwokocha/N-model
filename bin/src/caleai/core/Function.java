/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

package caleai.core;

public class Function {
    private double value;

    // Construct comprehensive function.
    public Function(String functionName, double... parameters) {
        switch (functionName) { // Configure function according to function name.
            case "identity" -> this.identity(parameters[0]);
            case "cubic volume" -> this.cubicVolume(parameters[0]);
            case "force" -> this.force(parameters[0], parameters[1]);
            case "tanh" -> this.tanh(parameters[0]);
            case "sum" -> this.sum(parameters);
        }
    }

    public double getValue() { return this.value; } // Return function value.

    private void cubicVolume (double s) { this.value = Math.pow(s, 1); }

    private void force (double m, double a) { this.value = Math.pow(m + a, 2); }

    private void identity (double x) { this.value = x; }

    private void tanh (double x) { this.value = (2 / (1 + Math.pow(Math.E, -(2 * x)))) - 1; }

    private void sum (double... X) {
        double s = 0;
        for (double x : X) { s += x; }
        this.value =  s;
    }
}
