package cz.marianjanik.ekurz;

import java.io.FileNotFoundException;

/**
 * My second interface for printing and writing methods that generate output as specified.
 */
public interface ReadWrite {

    void writeToConsole(SchoolClass schoolClass);

    void writeToFile(String fileName,SchoolClass schoolClass) throws FileNotFoundException;

}
