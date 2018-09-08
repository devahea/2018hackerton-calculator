package com.ahea.calculator;

import com.ahea.calculator.function.ExampleCalculator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.String.format;
import static java.util.Arrays.asList;

public class CalculatorService {
    public static final String BASE_URL = "http://localhost:8080";
    public static final List<Runnable> ONLY_ONE_FUNCTION = asList(new ExampleCalculator());
    public static final List<Runnable> INFINITE_FUNCTION = asList();

    public static int[][] ongoingSource;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private boolean isFinishCalculation;

    public CalculatorService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public void execute(Integer memberId, Integer puzzleId, Integer size) throws IOException, InterruptedException {
        ongoingSource = getSource(memberId);
        calculate();
        Map<String, Object> response = putSource(memberId, puzzleId, size, this.objectMapper.writeValueAsString(ongoingSource));

        if(response.get("isRight").equals(true))
            System.out.println(format("당신은 %s초만에 푸셨습니다."));
    }

    public int[][] getSource(Integer memberId) throws IOException {
        Map<String, Object> params = new HashMap<>();
        ResponseEntity<Map> response =
                this.restTemplate.getForEntity(BASE_URL + "/puzzle/start/" + memberId, Map.class);
        Map<String, String> body = response.getBody();
        return parse(body.get("source"));
    }

    public Map<String, Object> putSource(Integer memberId, Integer puzzleId, Integer size, String source) throws JsonProcessingException, InterruptedException {
        while(true) {
            Thread.sleep(1000L);
            System.out.println("로직 계산중 ...");
            if(isFinishCalculation)
                break;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("memberId", memberId);
        params.put("puzzleId", puzzleId);
        params.put("size", size);
        params.put("source", source);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(this.objectMapper.writeValueAsString(params), headers);
        ResponseEntity<Map<String, Object>> response =
                this.restTemplate.exchange(BASE_URL + "/mark", HttpMethod.POST, entity, new ParameterizedTypeReference<Map<String, Object>>() {});
        return response.getBody();
    }

    void calculate() {
        for (Runnable function : ONLY_ONE_FUNCTION) {
            function.run();
        }

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; true; i++) {
            Runnable function = INFINITE_FUNCTION.get(i % INFINITE_FUNCTION.size());
            executor.execute(function);

            if(isFinish()) {
                isFinishCalculation = true;
                executor.shutdown();
                return;
            }
        }
    }

    boolean isFinish() {
        for (int i = 0; i < ongoingSource.length; i ++) {
            for (int j = 0; j < ongoingSource[i].length; j++ ) {
                if(ongoingSource[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    int[][] parse(String source) throws IOException {
        return this.objectMapper.readValue(source, int[][].class);
    }
}
