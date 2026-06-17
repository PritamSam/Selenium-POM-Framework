package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static Object[][] getCsvData(String filePath) {

        List<Object[]> data = new ArrayList<>();

        try (
            InputStream inputStream =
                CSVUtils.class.getClassLoader().getResourceAsStream(filePath);

            BufferedReader br =
                new BufferedReader(new InputStreamReader(inputStream))
        ) {

            String line;

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");

                data.add(new Object[]{
                        values[0].trim(),
                        values[1].trim()
                });
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read CSV file: " + filePath, e);
        }

        return data.toArray(new Object[0][]);
    }
}
