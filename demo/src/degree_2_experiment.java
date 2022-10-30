import nmodel.Network;

public class degree_2_experiment {
    public static void main(String[] args) throws Exception {
        double[] x1 = new double[100];
        for (int i = 0; i < x1.length; i++) {
            x1[i] = Math.random() + 10;
        }

        Network network = new Network(6, 1);
        network.setFunctionName("exponent");
        network.setPower(1);
        network.setCoverage(null);
        //network.getLayers().get(4).getNodes().get(0).setFunctionName("exponent");
        //network.getLayers().get(5).getNodes().get(0).setPower(2);

        for (int i = 0; i < x1.length; i++) {
   /*         network.train(i + 1, new double[]{200}, x1[i]);
            System.out.println("Example " + (i + 1) + ":");
            System.out.println();
            System.out.println("Network objective is " + 200);
            System.out.println();
            System.out.println("Network input is " + x1[i]);
            System.out.println();
            System.out.println("Network hypothesis is " + Arrays.deepToString(network.getHypothesisMat()));
            System.out.println();
            System.out.println("Network error mean is " + Arrays.deepToString(network.getErrorMeanMat()));
            System.out.println();
            System.out.println("Network thesis is " + Arrays.deepToString(network.getThesisMat()));
            System.out.println();
            System.out.println();*/
            //System.out.println(network.getLayers().get(5).getNodes().get(0).getThesis());
            System.out.println("result is " + Math.pow(-2, -0.6));
        }
    }
}
