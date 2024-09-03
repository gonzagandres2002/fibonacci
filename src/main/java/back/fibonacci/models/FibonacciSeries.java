package back.fibonacci.models;

import back.fibonacci.converters.ListToStringConverter;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fibonacci_series")
public class FibonacciSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seed_x")
    private int seedX;

    @Column(name = "seed_y")
    private int seedY;

    @Column(name = "num_numbers")
    private int numNumbers;

    @Column(name = "series")
    @Convert(converter = ListToStringConverter.class)
    private List<Integer> series;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeedX() {
        return seedX;
    }

    public void setSeedX(int seedX) {
        this.seedX = seedX;
    }

    public int getSeedY() {
        return seedY;
    }

    public void setSeedY(int seedY) {
        this.seedY = seedY;
    }

    public int getNumNumbers() {
        return numNumbers;
    }

    public void setNumNumbers(int numNumbers) {
        this.numNumbers = numNumbers;
    }

    public List<Integer> getSeries() {
        return series;
    }

    public void setSeries(List<Integer> series) {
        this.series = series;
    }
}