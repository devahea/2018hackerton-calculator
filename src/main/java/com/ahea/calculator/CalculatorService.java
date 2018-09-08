package com.ahea.calculator;

import com.ahea.calculator.function.ExampleCalculator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.Arrays.asList;

public class CalculatorService {
    public static final String BASE_URL = "www.localhost:8080";
    public static final List<Runnable> ONLY_ONE_FUNCTION = asList(new ExampleCalculator());
    public static final List<Runnable> INFINITE_FUNCTION = asList();

    public static int[][] ongoingSource;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public CalculatorService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public String execute(Integer memberId) {
        ongoingSource = getSource();
        calculate();
        putSource();

        return null;
    }

    public int[][] getSource() {
        Map<String, Object> params = new HashMap<>();
        params.put("memberId", 1);
        params.put("puzzleId", 1);
        params.put("size", 1);
        params.put("source", 1);
//        this.restTemplate.postForEntity(BASE_URL + "/mark", );
        return parse();
    }

    public String putSource() {
        return null;
    }

    void calculate() {
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

    private int[][] parse() {
        return null;
    }
}
