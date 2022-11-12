import cml.Network;

import java.util.Arrays;
import java.util.function.Function;

public class outlier_detection_experiment {
    public static void main(String[] args) throws Exception {
        double[] networkObjective = new double[]{200.0};

        double[] trainSet = new double[100];
        for (int i = 0; i < trainSet.length; i++) {
            trainSet[i] = Math.random() + 10;
        }

        double[] outlierTestSet = new double[100];
        for (int i = 0; i < outlierTestSet.length; i++) {
            outlierTestSet[i] = Math.random() + 8;
        }

        Function<Double[], Double> sum = x -> Math.pow(x[0], 2);

        Network network = new Network(2, 1);
        network.setCFunction("sum", 1, sum);
        network.setPower(40);
        network.setCoverage(5.0);

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
        for (int i = 0; i < outlierTestSet.length; i++) {
            network.test(new Double[]{outlierTestSet[i]});
            System.out.println("Outlier Test " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective));
            System.out.println();
            System.out.println("Network input is " + outlierTestSet[i]);
            System.out.println();
            System.out.println("Network thesis is " + Arrays.toString(network.getThesisMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println();
        }
    }
}
