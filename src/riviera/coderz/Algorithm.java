package riviera.coderz;

import riviera.coderz.InputData;
import riviera.coderz.OutputData;

/**
 * Algorithm test interface
 */
public interface Algorithm {

    /**
     * Compute an algorithm
     * @param inputData Input parameter
     * @return Output parameter
     */
    OutputData compute(InputData inputData);
}
