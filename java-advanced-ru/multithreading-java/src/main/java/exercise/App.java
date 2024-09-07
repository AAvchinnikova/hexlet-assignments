package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {

        Map<String, Integer> result = new HashMap<>();

        MinThread minThread = new MinThread(numbers);
        MaxThread maxThread = new MaxThread(numbers);

        minThread.start();
        maxThread.start();

        try {
            minThread.join();
            maxThread.join();
        }catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Прерывание по время выполнения потока", e);
        }

        result.put("min", minThread.getMinNumber());
        result.put("max", maxThread.getMaxNumber());
        return result;
    }
    // END
}
