package riviera.coderz.main;

import riviera.coderz.HashCodeParser;
import riviera.coderz.AlgorithmHashCode2018;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        HashCodeParser.writeFile("data/a_example.out", new AlgorithmHashCode2018().compute(HashCodeParser.readFile("data/a_example.in")));
        HashCodeParser.writeFile("data/b_should_be_easy.out", new AlgorithmHashCode2018().compute(HashCodeParser.readFile("data/b_should_be_easy.in")));
        HashCodeParser.writeFile("data/c_no_hurry.out", new AlgorithmHashCode2018().compute(HashCodeParser.readFile("data/c_no_hurry.in")));
        HashCodeParser.writeFile("data/d_metropolis.out", new AlgorithmHashCode2018().compute(HashCodeParser.readFile("data/d_metropolis.in")));
        HashCodeParser.writeFile("data/e_high_bonus.out", new AlgorithmHashCode2018().compute(HashCodeParser.readFile("data/e_high_bonus.in")));
    }
}
