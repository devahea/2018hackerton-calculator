package com.ahea.calculator;

import com.ahea.calculator.function.ExampleCalculator;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.Arrays.asList;

public class CalculatorService {
    public static List<Runnable> ONLY_ONE_FUNCTION = asList(new ExampleCalculator());
    public static List<Runnable> INFINITE_FUNCTION;

    public static String ongoingSource;
    private final RestTemplate restTemplate;

    public CalculatorService() {
        this.restTemplate = new RestTemplate();
    }

    public String execute() {
        ongoingSource = getSource();
        calculate();
        putSource();

        return null;
    }

    public String getSource() {
        return null;
    }

    public void calculate() {
        for (Runnable function : ONLY_ONE_FUNCTION) {
            function.run();
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; true; i++) {
            Runnable function = INFINITE_FUNCTION.get(i % INFINITE_FUNCTION.size());
            executor.execute(function);
            if (1 == 1)
                break;
        }
    }

    public String putSource() {
        return null;
    }
}
