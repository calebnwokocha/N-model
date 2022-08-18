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
            case "cubic volume" -> this.cubicVolume(parameters[0]);
            case "force" -> this.force(parameters[0], parameters[1]);
        }
    }

    public double getValue() { return this.value; } // Return function value.

    private void cubicVolume (double s) { this.value = Math.pow(s, 3); }

    private void force (double m, double a) { this.value = m * a; }
}
