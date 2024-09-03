package back.fibonacci.repository;

import back.fibonacci.models.FibonacciSeries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FibonacciSeriesRepository extends JpaRepository<FibonacciSeries, Long> {
}
