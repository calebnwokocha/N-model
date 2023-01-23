/*------------------------------------------------------------------------------
 Author: Caleb Princewill Nwokocha
 Emails: calebnwokocha@gmail.com, nwokochc@myumanitoba.ca
---------------------------------------------------------------------------- */

package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The Data class is a model class that provides functionality for reading, writing
 * and manipulating data. The class has several constructors, one of which allows
 * the user to create an instance of the class with data that is read from a specified
 * file. The class also has methods for getting and setting the data, splitting
 * the data into groups of specified sizes, transforming the data by adding a
 * specified basis to it, and converting an array of bytes to an array of Doubles.
 */
public class Data {
    private Double[] data;

    /**
     * Creates an empty instance of the data class
     */
    public Data() {}

    /**
     * Creates an instance of the data class with the specified data
     * @param data the data to be included in the data object
     */
    public Data(Double... data) { this.data = data; }

    /**
     * Creates an instance of the data class with data read from the specified file
     * @param fileName the name of the file to read data from
     * @throws IOException if an error occurs while reading the file
     */
    public Data (String fileName) throws IOException {
        Path path = Paths.get(fileName);
        byte[] data = Files.readAllBytes(path);
        this.data = this.byteToDouble(data);
    }

    /**
     * Creates an instance of the data class with data read from the specified file
     * @param file the file to read data from
     * @throws IOException if an error occurs while reading the file
     */
    public Data (File file) throws IOException {
        byte[] data = Files.readAllBytes(file.toPath());
        this.data = this.byteToDouble(data);
    }

    /**
     * Returns the data in the data object
     * @return the data in the data object
     */
    public Double[] getData() { return this.data; }

    /**
     * Returns the datum at the specified index in the data object
     * @param index the index of the datum to be returned
     * @return the datum at the specified index in the data object
     */
    public Double getDatum (int index) { return this.data[index]; }

    /**
     * Sets the data in the data object
     * @param data the data to be set in the data object
     */
    public void setData(Double[] data) { this.data = data; }

    /**
     * Splits the data in the data object into multiple groups of specified sizes
     * @param groupSizes the sizes of the groups to split the data into
     * @return a 2D array of the split data
     */
    public Double[][] split (int... groupSizes) {
        Double[][] groups = new Double[groupSizes.length][]; int k = 0;
        for (int i = 0; i < groupSizes.length; i++) {
            for (int j = 0; j < groupSizes[i]; j++, k++) {
                groups[i][j] = this.data[k];
            }
        } return groups;
    }

    /**
     * Transforms the data by adding the specified basis to it.
     * If the basis array is smaller than the data array, the transformation will only be done till
     * the last element of the basis array. If the basis array is larger than the data array, the
     * extra elements of the basis array will be ignored.
     * @param basis the basis to be added to the data
     */
    public void transform (Double... basis) {
        for (int i = 0; i < data.length; i++) {
            try { data[i] += basis[i]; }
            catch (NullPointerException | ArrayIndexOutOfBoundsException e) { break; }
        }
    }

    /**
     * Converts an array of bytes to an array of Doubles
     * @param byteData the byte array to be converted
     * @return the converted Double array
     */
    public Double[] byteToDouble(byte... byteData) {
        Double[] doubleData = new Double[byteData.length];
        for (int i = 0; i < doubleData.length; i++) { doubleData[i] = (double) byteData[i]; }
        return doubleData;
    }

    public void saveData () {

    }

    public void retrieveData () {

    }
}
