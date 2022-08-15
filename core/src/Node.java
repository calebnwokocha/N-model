public class Node {
    private String cFunctionName;
    private double value;

    public Node (String cFunctionName) {
        this.cFunctionName = cFunctionName;
    }

    public String getcFunctionName() { return cFunctionName; }

    public void setcFunctionName(String cFunctionName) { this.cFunctionName = cFunctionName; }

    public double getValue() { return value; }

    public void setValue(double value) { this.value = value; }

    public void activate (double[] parameters) { // Activate neuron, use parameters for comprehensive function.
        CFunction cFunction = new CFunction(this.cFunctionName, parameters);
        double cValue = cFunction.getValue(); // Result of comprehensive function.
        switch (this.activationType) { // Find activation function, and initialize neuron value.
            case "identity" -> this.value = this.identity(cValue);
            case "tanh" -> this.value= this.tanh(cValue);
        }
    }
}
