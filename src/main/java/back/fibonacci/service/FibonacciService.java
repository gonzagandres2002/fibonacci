package back.fibonacci.service;

import back.fibonacci.models.FibonacciSeries;
import back.fibonacci.repository.FibonacciSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonacciService {
    @Autowired
    private FibonacciSeriesRepository repository;

    public List<Integer> generateFibonacciSeries(int seedX, int seedY, int numNumbers) {
        List<Integer> series = new ArrayList<>();
        series.add(seedX);
        series.add(seedY);
        for (int i = 2; i < numNumbers; i++) {
            int nextNumber = series.get(i - 1) + series.get(i - 2);
            series.add(nextNumber);
        }
        return series;
    }

    public void saveFibonacciSeries(int seedX, int seedY, int numNumbers, List<Integer> series) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        fibonacciSeries.setSeedX(seedX);
        fibonacciSeries.setSeedY(seedY);
        fibonacciSeries.setNumNumbers(numNumbers);
        fibonacciSeries.setSeries(series);
        repository.save(fibonacciSeries);
    }
}
