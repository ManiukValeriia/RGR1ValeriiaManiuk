package consoleTasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class FileManager {

    public static void readFromFile(String fileName, Interpolator listInt) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        listInt.clear();
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(";");
            double x = Double.parseDouble(values[0]);
            double y = Double.parseDouble(values[1]);
            listInt.addPoint(new PointData(x, y));
        }
        reader.close();
    }

    public static void writeToFile(String fileName, Interpolator listInt) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write("x,y\n");
        for (int i = 0; i < listInt.numPoints(); i++) {
            PointData point = listInt.getPoint(i);
            writer.write(point.getX() + ";" + point.getY() + "\n");
        }
        writer.close();
    }
}