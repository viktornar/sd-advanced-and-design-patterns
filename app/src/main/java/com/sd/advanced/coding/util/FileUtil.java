package com.sd.advanced.coding.util;

import java.io.*;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.sd.advanced.coding.Constants.*;

public class FileUtil {
    public static List<String> readData(String filePath) {
        return readData(new File(filePath));
    }

    public static List<String> readData(File input) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    private static void writeData(String output, String dataToWrite) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
            bw.write(dataToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeData(File output, String dataToWrite) {
        try {
            if (!Files.isDirectory(output.toPath())) {
                writeData(output.getAbsolutePath(), dataToWrite);
            } else {
                throw new AccessDeniedException(ACCESS_DENIED_EXCEPTION);
            }
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }
    }

    public static void copy(InputStream inputStream, File input, File output) {
        try {
            if (!Files.isDirectory(input.toPath())) {
                String absolutePath = input.getAbsolutePath();
                OutputStream outputStream = new FileOutputStream(output);
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = inputStream.read(buffer);
                while (bytesRead != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                    bytesRead = inputStream.read(buffer);
                }
                outputStream.close();
                inputStream.close();
            } else {
                throw new AccessDeniedException(ACCESS_DENIED_EXCEPTION);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


