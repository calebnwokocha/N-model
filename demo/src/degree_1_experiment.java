import nmodel.Network;

import java.util.Arrays;

public class degree_1_experiment {
    public static void main(String[] args) throws Exception {
        double[] x1 = new double[10];
        for (int i = 0; i < 10; i++) {
            x1[i] = Math.random() + 10;
        }

        Network network = new Network(12, 1);
        network.setFunctionName("sum");
        network.setPower(1);
        network.setCoverage(null);

        for (int i = 0; i < x1.length; i++) {
            network.train(i + 1, new double[]{100}, x1[i]);
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + 100);
            System.out.println();
            System.out.println("Network input is " + x1[i]);
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.deepToString(network.getHypothesisMat()));
            System.out.println();
            System.out.println("Network error mean is " + Arrays.deepToString(network.getErrorMeanMat()));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.deepToString(network.getThesisMat()));
            System.out.println();
            System.out.println();
        }
    }
}
