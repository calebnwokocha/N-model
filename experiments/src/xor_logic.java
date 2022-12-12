import model.Multitask;
import model.Network;

import java.util.Arrays;
import java.util.function.Function;

public class xor_logic {
    public static void main(String[] args) throws Exception {
        Double[][] trainSet = new Double[100][2];
        Double[][] testSet = new Double[100][2];
        for (int i = 0; i < trainSet.length; i++) {
            trainSet[i][0] = (double) Math.round(Math.random());
            trainSet[i][1] = (double) Math.round(Math.random());
            testSet[i][0] = (double) Math.round(Math.random());
            testSet[i][1] = (double) Math.round(Math.random());
        }

        Double[] networkObjective = new Double[trainSet.length];
        for (int i = 0; i < trainSet.length; i++) {
            networkObjective[i] = trainSet[i][0] + trainSet[i][1] - (2 * trainSet[i][0] * trainSet[i][1]);
        }

        Function<Double[], Double> sum = x -> {
            Double s = 0.0;
            for (Double d : x) { s += d; }
            return s;
        };

        Network networkA = new Network(5, 1);
        networkA.setCFunction("sum", 1.0, sum);
        networkA.setPower(6.0);
        //networkA.setCoverage(30.0);

        Network networkB = new Network(5, 1);
        networkB.setCFunction("sum", 1.0, sum);
        networkB.setPower(6.0);
        //networkB.setCoverage(30.0);

        Network networkC = new Network(5, 1);
        networkC.setCFunction("sum", 1.0, sum);
        networkC.setPower(6.0);
        //networkC.setCoverage(30.0);

        Network networkD = new Network(5, 1);
        networkD.setCFunction("sum", 1.0, sum);
        networkD.setPower(6.0);
        //networkD.setCoverage(30.0);

        Multitask multitask = new Multitask();

      /*  System.out.println("\nNETWORK TRAINING............................................................................................................................");
        System.out.println();
        System.out.println();*/
        for (int i = 1; i <= 4; i++) {
            switch (i) { case 1 -> multitask.addNetwork(networkA); case 2 -> multitask.addNetwork(networkB);
                case 3 -> multitask.addNetwork(networkC); case 4 -> multitask.addNetwork(networkD);
            }

            //multitask.setCoverage(2000.0);

            for (int j = 0; j < trainSet.length; j++) {
                if (i == 1) {
                    if (trainSet[j][0] == 0.0 && trainSet[j][1] == 0.0) {
                        multitask.train(j + 1, new Double[]{networkObjective[j]}, trainSet[j]);
                        /*System.out.println("Example " + (j + 1) + ":");
                        System.out.println();
                        System.out.println("NetworkA objective is " + networkObjective[j]);
                        System.out.println();
                        System.out.println("NetworkA input is " + Arrays.toString(trainSet[j]));
                        System.out.println();
                        System.out.println("NetworkA hypothesis is " + Arrays.toString(networkA.getHypothesis()[networkA.getLength() - 1]));
                        System.out.println();
                        System.out.println("NetworkA thesis is " + Arrays.toString(networkA.getThesis()[networkA.getLength() - 1]));
                        System.out.println();
                        System.out.println("NetworkA error mean is " + Arrays.toString(networkA.getErrorMean()[networkA.getLength() - 1]));
                        System.out.println();
                        System.out.println();*/
                        //System.out.println(networkA.getErrorMean()[1][0]);
                        System.out.println("Network 1 thesis is " + Arrays.deepToString(multitask.getThesis()));
                    }
                } else if (i == 2) {
                    if (trainSet[j][0] == 1.0 && trainSet[j][1] == 1.0) {
                        multitask.train(j + 1, new Double[]{networkObjective[j]}, trainSet[j]);
                        /*System.out.println("Example " + (i + 1) + ":");
                        System.out.println();
                        System.out.println("NetworkB objective is " + networkObjective[i]);
                        System.out.println();
                        System.out.println("NetworkB input is " + Arrays.toString(trainSet[i]));
                        System.out.println();
                        System.out.println("NetworkB hypothesis is " + Arrays.toString(networkB.getHypothesis()[networkB.getLength() - 1]));
                        System.out.println();
                        System.out.println("NetworkB thesis is " + Arrays.toString(networkB.getThesis()[networkB.getLength() - 1]));
                        System.out.println();
                        System.out.println("NetworkB error mean is " + Arrays.toString(networkB.getErrorMean()[networkB.getLength() - 1]));
                        System.out.println();
                        System.out.println();*/
                        //System.out.println(networkB.getErrorMean()[1][0]);
                        System.out.println("Network 2 thesis is " + Arrays.deepToString(multitask.getThesis()));
                    }
                } else if (i == 3) {
                    if (trainSet[j][0] == 0.0 && trainSet[j][1] == 1.0) {
                        multitask.train(j + 1, new Double[]{networkObjective[j]}, trainSet[j]);
                       /* System.out.println("Example " + (i + 1) + ":");
                        System.out.println();
                        System.out.println("NetworkC objective is " + networkObjective[i]);
                        System.out.println();
                        System.out.println("NetworkC input is " + Arrays.toString(trainSet[i]));
                        System.out.println();
                        System.out.println("NetworkC hypothesis is " + Arrays.toString(networkC.getHypothesis()[networkC.getLength() - 1]));
                        System.out.println();
                        System.out.println("NetworkC thesis is " + Arrays.toString(networkC.getThesis()[networkC.getLength() - 1]));
                        System.out.println();
                        System.out.println("NetworkC error mean is " + Arrays.toString(networkC.getErrorMean()[networkC.getLength() - 1]));
                        System.out.println();
                        System.out.println();*/
                        //System.out.println(networkC.getErrorMean()[1][0]);
                        System.out.println("Network 3 thesis is " + Arrays.deepToString(multitask.getThesis()));
                    }
                } else if (i == 4) {
                    if (trainSet[j][0] == 1.0 && trainSet[j][1] == 0.0) {
                        multitask.train(j + 1, new Double[]{networkObjective[j]}, trainSet[j]);
                        /*System.out.println("Example " + (i + 1) + ":");
                        System.out.println();
                        System.out.println("NetworkD objective is " + networkObjective[i]);
                        System.out.println();
                        System.out.println("NetworkD input is " + Arrays.toString(trainSet[i]));
                        System.out.println();
                        System.out.println("NetworkD hypothesis is " + Arrays.toString(networkD.getHypothesis()[networkD.getLength() - 1]));
                        System.out.println();
                        System.out.println("NetworkD thesis is " + Arrays.toString(networkD.getThesis()[networkD.getLength() - 1]));
                        System.out.println();
                        System.out.println("NetworkD error mean is " + Arrays.toString(networkD.getErrorMean()[networkD.getLength() - 1]));
                        System.out.println();
                        System.out.println();*/
                        //System.out.println(networkD.getErrorMean()[1][0]);
                        System.out.println("Network 4 thesis is " + Arrays.deepToString(multitask.getThesis()));
                    }
                }
            }
        }

/*        System.out.println("NETWORK TESTING............................................................................................................................");
        System.out.println();
        System.out.println();*/
        for (int i = 0; i < testSet.length; i++) {
            multitask.test(testSet[i]);
            System.out.println("Test " + (i + 1) + ":");
            System.out.println();
            Double[] objective = new Double[]{testSet[i][0] + testSet[i][1] - (2 * testSet[i][0] * testSet[i][1])};
            System.out.println("Network objective is " + Arrays.toString(objective));
            System.out.println();
            System.out.println("Network input is " + Arrays.toString(testSet[i]));
            System.out.println();
            //System.out.println("Network thesis is " + Arrays.toString(networkA.getThesis()[networkA.getLength() - 1]));
            System.out.println("Network A thesis is " + Arrays.deepToString(multitask.getNetworks().get(0).getThesis()));
            System.out.println("Network B thesis is " + Arrays.deepToString(multitask.getNetworks().get(1).getThesis()));
            System.out.println("Network C thesis is " + Arrays.deepToString(multitask.getNetworks().get(2).getThesis()));
            System.out.println("Network D thesis is " + Arrays.deepToString(multitask.getNetworks().get(3).getThesis()));
            System.out.println("Network thesis is " + Arrays.deepToString(multitask.getThesis()));
            System.out.println();
            System.out.println();
        }

        System.out.println("Network A coverage is " + Arrays.deepToString(multitask.getNetworks().get(0).getCoverage()));
        System.out.println("Network B coverage is " + Arrays.deepToString(multitask.getNetworks().get(1).getCoverage()));
        System.out.println("Network C coverage is " + Arrays.deepToString(multitask.getNetworks().get(2).getCoverage()));
        System.out.println("Network D coverage is " + Arrays.deepToString(multitask.getNetworks().get(3).getCoverage()));
    }
}
