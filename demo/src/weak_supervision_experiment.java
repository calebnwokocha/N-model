import cml.Network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class weak_supervision_experiment {
    public static void main(String[] args) throws Exception {
        double[] trainSet = new double[10];
        for (int i = 0; i < trainSet.length; i++) {
            trainSet[i] = Math.random() + 10;
        }

        double[] testSet = new double[10];
        for (int i = 0; i < testSet.length; i++) {
            testSet[i] = Math.random() + 10;
        }

        ArrayList<Integer> width = new ArrayList<>();
        width.add(1);
        width.add(2);
        width.add(1);

        Network network = new Network(3, width);
        network.setFunctionName("sum");
        network.setPower(40);
        network.setCoverage(null);

        double[] networkObjective = new double[]{200.0};
        double networkError = 0.0;

        System.out.println("\nNETWORK TRAINING............................................................................................................................");
        System.out.println();
        System.out.println();
        for (int i = 0; i < trainSet.length; i++) {
            network.train(i + 1, networkError, new Double[]{trainSet[i]});
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
            System.out.println("Network error mean is " + Arrays.deepToString(network.getErrorMeanMat())/*Arrays.toString(network.getErrorMeanMat()[network.getLength() - 1])*/);
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter network error:");
            networkError = Double.parseDouble(scanner.nextLine());
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
