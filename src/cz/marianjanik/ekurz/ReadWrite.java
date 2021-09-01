package cz.marianjanik.ekurz;

import java.io.FileNotFoundException;

/**
 * My first interface for printing and writing methods that generate output as specified.
 */
public interface ReadWrite {

    void writeToConsole1(SchoolClass schoolClass); // Marian

    void writeToConsole2(SchoolClass schoolClass); // Marian

    void writeToFile(String fileName,SchoolClass schoolClass) throws FileNotFoundException; // Aleš

}
