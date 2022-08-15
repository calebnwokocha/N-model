/*
 * AUTHOR: CALEB PRINCEWILL NWOKOCHA
 * SCHOOL: THE UNIVERSITY OF MANITOBA
 * DEPARTMENT: COMPUTER SCIENCE
 */

package caleai.core;

public class CFunction {
    private double value;

    public CFunction(String cFunctionName, double... parameters) {
        switch (cFunctionName) {
            case "cubic volume" -> this.cubicVolume(parameters[0]);
            case "force" -> this.force(parameters[0], parameters[2]);
        }
    }

    public double getValue() { return this.value; }

    private void cubicVolume (double s) { this.value = Math.pow(s, 3); }

    private void force (double m, double a) { this.value = m * a; }
}
