/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * ORGANIZATION: CALE TECHNOLOGY ENTERPRISE
 * DEPARTMENT: MAS-R&D
 */

public class CFunction {
    private double value;

    // Construct comprehensive function.
    public CFunction(String functionName, byte parameter) {
        switch (functionName) { // Configure function according to function name.
            case "identity" -> this.identity(parameter);
            case "cubic volume" -> this.cubicVolume(parameter);
        }
    }

    public CFunction(String functionName, byte... parameters) {
        switch (functionName) { // Configure function according to function name.
            case "force" -> this.force(parameters[0], parameters[1]);
            case "sum" -> this.sum(parameters);
        }
    }

    public double getValue() { return this.value; } // Return function value.

    private void cubicVolume (byte s) { this.value = Math.pow(s, 3); }

    private void force (byte m, byte a) { this.value = m * a /*(m + a) - ((m * a) * (1 + m + a - (m * a)))*/; }

    private void identity (byte x) { this.value = x; }

    private void sum (byte... X) {
        double s = 0;
        for (double x : X) { s += x; }
        this.value =  s;
    }
}
