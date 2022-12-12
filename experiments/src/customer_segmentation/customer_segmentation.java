package customer_segmentation;

import model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class customer_segmentation {
    public static void main(String[] args) throws Exception {
        File customerFile = new File("C:\\Users\\Caleb P. Nwokocha\\Documents\\Automaton\\" +
                "experiments\\src\\customer_segmentation\\customer_data.csv");

        Scanner customerFileScanner = new Scanner(customerFile);
        ArrayList<Double[]> customerDataset = new ArrayList<>();

        while (customerFileScanner.hasNextLine()) {
            customerFileScanner.nextLine();
            String[] lineArray;
            try { lineArray = customerFileScanner.nextLine().split(","); }
            catch (NoSuchElementException e) { break; }
            Dataset dataset = new Dataset();
            dataset.stringsToDataset(lineArray);
            customerDataset.addAll(Arrays.asList(dataset.getDataset()));
        } customerFileScanner.close();

        customerDataset.remove(0); customerDataset.remove(1); customerDataset.remove(2);
        customerDataset.remove(3);

        System.out.println("\nCleaned Customer Data");
        for (Double[] customerData : customerDataset) { System.out.println(Arrays.toString(customerData)); }
    }
}
