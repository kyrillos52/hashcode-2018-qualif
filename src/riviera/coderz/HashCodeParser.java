package riviera.coderz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The parser will convert the input file into an input data object
 * and convert an output data object into an output file
 */
public class HashCodeParser {

    /**
     * Convert an input file into an input data object
     * @param path File path
     * @return Input data object
     * @throws IOException Impossible to read the file
     */
    public static InputData readFile(String path) throws IOException {
        FileReader fileReader =
                new FileReader(path);

        BufferedReader bufferedReader =
                new BufferedReader(fileReader);

        String line = null;
        int counterLine = 0;
        InputData input = new InputData();
        List<Ride> rides = new ArrayList<>();
        while((line = bufferedReader.readLine()) != null) {
            String[] firstLine = line.split(" ");
            if(counterLine == 0) {
                input.r = Integer.parseInt(firstLine[0]);
                input.c = Integer.parseInt(firstLine[1]);
                input.f = Integer.parseInt(firstLine[2]);
                input.n = Integer.parseInt(firstLine[3]);
                input.b = Integer.parseInt(firstLine[4]);
                input.t = Integer.parseInt(firstLine[5]);
            } else {
                Ride ride = new Ride();
                ride.a = Integer.parseInt(firstLine[0]);
                ride.b = Integer.parseInt(firstLine[1]);
                ride.x = Integer.parseInt(firstLine[2]);
                ride.y = Integer.parseInt(firstLine[3]);
                ride.s = Integer.parseInt(firstLine[4]);
                ride.f = Integer.parseInt(firstLine[5]);
                ride.nbRide = counterLine-1;
                rides.add(ride);
            }
            counterLine++;
        }
        input.rides = rides;
        return input;
    }

    /**
     * Write the output file from the output data object
     * @param path Path to the output file
     * @param outputData Output data object
     * @throws IOException Impossible to create the file
     */
    public static void writeFile(String path, OutputData outputData) throws IOException {

        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for(Roadbook roadbook : outputData.roadbooks) {
            bw.write(""+roadbook.rides.size());
            for(Integer ride : roadbook.rides) {
                bw.write(" "+ride);
            }
            bw.newLine();
        }
        bw.close();
    }
}
