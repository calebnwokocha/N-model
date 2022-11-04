import cml.Network;

import java.util.Arrays;

public class nonlinear_comprehensive_function_experiment {
    public static void main(String[] args) throws Exception {
        double[] x1 = new double[100];
        for (int i = 0; i < x1.length; i++) {
            x1[i] = Math.random() + 10;
        }

        Network network = new Network(2, 1);
        network.setFunctionName("square");
        network.getLayers().get(0).setPower(0.6);
        network.getLayers().get(1).setPower(6.5);
        network.setCoverage(null);

        double[] networkObjective = new double[]{200.0};

        System.out.println("\nNETWORK TRAINING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < x1.length; i++) {
            network.train(i + 1, networkObjective, x1[i]);
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective));
            System.out.println();
            System.out.println("Network input is " + x1[i]);
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.toString(network.getHypothesisMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesisMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println("Network error mean is " + Arrays.toString(network.getErrorMeanMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println();
        }

        System.out.println("NETWORK TESTING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < x1.length; i++) {
            network.test(x1[i]);
            System.out.println("Test " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective));
            System.out.println();
            System.out.println("Network input is " + x1[i]);
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesisMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println();
        }
    }
}
