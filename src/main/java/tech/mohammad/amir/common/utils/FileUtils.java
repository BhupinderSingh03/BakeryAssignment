package tech.mohammad.amir.common.utils;

import tech.mohammad.amir.common.exceptions.ReaderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import static tech.mohammad.amir.common.Constants.CSV_READING_ERROR;

public class FileUtils {
    public static List<String> readFileText(String fileName) {
        BufferedReader bufferedReader = null;
        try {
            InputStream fileResource = FileUtils.class.getClassLoader().getResourceAsStream(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(fileResource));

            return bufferedReader.lines().skip(1).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ReaderException(CSV_READING_ERROR + fileName);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) { }
        }
    }
}