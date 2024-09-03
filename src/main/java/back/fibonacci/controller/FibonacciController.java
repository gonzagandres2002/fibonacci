package back.fibonacci.controller;

import back.fibonacci.dto.FibonacciSeriesResponse;
import back.fibonacci.dto.TimeRequest;
import back.fibonacci.models.FibonacciSeries;
import back.fibonacci.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"https://master--curriculum-vitae-udea.netlify.app/", "http://localhost:3000/"})
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

    @GetMapping("/series")
    public List<FibonacciSeriesResponse> getGeneratedSeries() {
        List<FibonacciSeries> seriesList = fibonacciService.getGeneratedSeries();
        List<FibonacciSeriesResponse> responseList = new ArrayList<>();

        for (FibonacciSeries series : seriesList) {
            FibonacciSeriesResponse response = new FibonacciSeriesResponse();
            response.setId(series.getId());
            response.setTime(String.format("%02d:%02d:%02d", series.getSeedX(), series.getSeedY(), series.getNumNumbers()));
            response.setSeries(series.getSeries());
            responseList.add(response);
        }

        return responseList;
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
