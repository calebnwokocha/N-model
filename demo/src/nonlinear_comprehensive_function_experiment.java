import cml.Network;

import java.util.Arrays;

public class nonlinear_comprehensive_function_experiment {
    public static void main(String[] args) throws Exception {
        double[] trainSet = new double[100];
        for (int i = 0; i < trainSet.length; i++) {
            trainSet[i] = Math.random() + 10;
        }

        double[] testSet = new double[100];
        for (int i = 0; i < testSet.length; i++) {
            testSet[i] = Math.random() + 10;
        }

        Network network = new Network(2, 1);
        network.setFunctionName("square");
        network.setPower(-6);
        network.setCoverage(null);

        double[] networkObjective = new double[]{200.0};

        System.out.println("\nNETWORK TRAINING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < trainSet.length; i++) {
            network.train(i + 1, networkObjective, new Double[]{trainSet[i]});
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective));
            System.out.println();
            System.out.println("Network input is " + trainSet[i]);
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
        for (int i = 0; i < testSet.length; i++) {
            network.test(new Double[]{trainSet[i]});
            System.out.println("Test " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective));
            System.out.println();
            System.out.println("Network input is " + testSet[i]);
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesisMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println();
        }
    }
}
