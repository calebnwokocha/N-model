/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 * The Dataset class is used for reading, writing and manipulating a set of data objects.
 * The class has several methods like creating an empty or initialized instance of the class,
 * reading data from files or a folder, getting and setting the dataset, shuffling the
 * dataset, splitting the dataset into multiple groups of specified sizes, transforming
 * the dataset by adding the specified basis to it, converting strings to dataset, etc.
 * The class also throws IOException if an error occurs while reading the files.
 */
public class Dataset {
    private Double[][] dataset;
    Data data = new Data();

    /**
     * Creates an empty instance of the dataset class
     */
    public Dataset() {}

    /**
     * Creates an instance of the dataset class with the specified data
     * @param dataset the data to be included in the dataset object
     */
    public Dataset(Double[]... dataset) { this.dataset = dataset; }

    /**
     * Creates an instance of the dataset class with data read from the specified files
     * @param fileNames the names of the files to read data from
     * @throws IOException if an error occurs while reading the files
     */
    public Dataset (String... fileNames) throws IOException {
        this.dataset = new Double[fileNames.length][];
        for (int i = 0; i < this.dataset.length; i++) { this.dataset[i] = new Data(fileNames[i]).getData(); }
    }

    /**
     * Creates an instance of the dataset class with data read from the files in the specified folder
     * @param folderName the name of the folder to read data from
     * @throws IOException if an error occurs while reading the files
     */
    public Dataset (String folderName) throws IOException {
        File file = new File(folderName); File[] files = file.listFiles();
        this.dataset = new Double[files.length][];
        for (int i = 0; i < this.dataset.length; i++) { this.dataset[i] = new Data(files[i]).getData(); }
    }

    /**
     * Returns the data in the dataset object
     * @return the data in the dataset object
     */
    public Double[][] getDataset() { return this.dataset; }

    /**
     * Returns the data at the specified index in the dataset object
     * @param index the index of the data to be returned
     * @return the data at the specified index in the dataset object
     */
    public Double[] getData (int index) { return this.dataset[index]; }

    /**
     * Sets the data in the dataset object
     * @param dataset the data to be set in the dataset object
     */
    public void setDataset(Double[]... dataset) { this.dataset = dataset; }

    /**
     * Shuffles the data in the dataset object
     */
    public void shuffle () { Collections.shuffle(Arrays.asList(this.dataset)); }

    /**
     * Splits the dataset into multiple groups of specified sizes
     * @param groupSizes the sizes of the groups to split the dataset into
     * @return a 3D array of the split dataset
     */
    public Double[][][] split (int... groupSizes) {
        Double[][][] groups = new Double[groupSizes.length][this.dataset.length][]; int k = 0;
        for (int i = 0; i < groupSizes.length; i++) {
            for (int j = 0; j < groupSizes[i]; j++, k++) {
                groups[i][j] = this.dataset[k];
            }
        } return groups;
    }

    /**
     * Transforms the dataset by adding the specified basis to it.
     * If the basis array is smaller than the dataset array, the transformation will only be done till
     * the last element of the basis array. If the basis array is larger than the dataset array, the
     * extra elements of the basis array will be ignored.
     * @param basis the basis to be added to the dataset
     */
    public void transform (Double[]... basis) {
        for (int i = 0; i < dataset.length; i++) { this.data.setData(dataset[i]);
            try { this.data.transform(basis[i]); dataset[i] = this.data.getData(); }
            catch (NullPointerException e) { break; }
        }
    }

    /**
     * Converts an array of strings to an array of Doubles
     * @param data the string array to be converted
     */
    public void stringsToDataset(String... data) {
        System.out.println(Arrays.toString(data));
        System.out.println();
        this.dataset = new Double[data.length][];
        for (int i = 0; i < this.dataset.length; i++) {
            this.dataset[i] = this.data.byteToDouble(data[i].getBytes());
            System.out.println(Arrays.toString(this.dataset[i]));
        }
        System.out.println("................................................................");
    }

    public void saveDataset () {
        for (Double[] data : this.dataset) { this.data.setData(data); this.data.saveData(); }
    }

    public void retrieveDataset () {

    }
}
