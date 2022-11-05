import cml.Network;

import java.util.Arrays;

public class outlier_detection_experiment {
    public static void main(String[] args) throws Exception {
        double[] trainSet = new double[100];
        for (int i = 0; i < trainSet.length; i++) {
            trainSet[i] = Math.random() + 10;
        }

        double[] outlierTestSet = new double[100];
        for (int i = 0; i < outlierTestSet.length; i++) {
            outlierTestSet[i] = Math.random() + 8;
        }

        Network network = new Network(2, 1);
        network.setFunctionName("sum");
        network.setPower(40);
        network.setCoverage(7.0);

        double[] networkObjective = new double[]{200.0};

        System.out.println("\nNETWORK TRAINING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < trainSet.length; i++) {
            network.train(i + 1, networkObjective, trainSet[i]);
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + Arrays.toString(networkObjective));
            System.out.println();
            System.out.println("Network input is " + trainSet[i]);
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.toString(network.getHypothesisMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.deepToString(network.getThesisMat())/*Arrays.toString(network.getThesisMat()[network.getLength() - 1])*/);
            System.out.println();
            System.out.println("Network error mean is " + Arrays.toString(network.getErrorMeanMat()[network.getLength() - 1]));
            System.out.println();
            System.out.println();
        }

        System.out.println("NETWORK TESTING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < outlierTestSet.length; i++) {
            network.test(outlierTestSet[i]);
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
