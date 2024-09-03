package back.fibonacci.controller;

import back.fibonacci.dto.TimeRequest;
import back.fibonacci.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @GetMapping
    public List<Integer> getFibonacciSeries() {
        LocalTime currentTime = LocalTime.now();
        int seedX = currentTime.getMinute();
        int seedY = currentTime.getSecond();
        int numNumbers = currentTime.getSecond();
        List<Integer> series = fibonacciService.generateFibonacciSeries(seedX, seedY, numNumbers);
        fibonacciService.saveFibonacciSeries(seedX, seedY, numNumbers, series);
        return series.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
    }

    @PostMapping
    public List<Integer> getFibonacciSeries(@RequestBody TimeRequest timeRequest) {
        LocalTime time = LocalTime.parse(timeRequest.getTime(), DateTimeFormatter.ofPattern("HH:mm:ss"));
        int seedX = time.getMinute();
        int seedY = time.getSecond();
        int numNumbers = time.getSecond();
        List<Integer> series = fibonacciService.generateFibonacciSeries(seedX, seedY, numNumbers);
        fibonacciService.saveFibonacciSeries(seedX, seedY, numNumbers, series);
        return series.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
    }
}
