package back.fibonacci.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FibonacciSeriesResponse {
    private Long id;
    private String time;
    private List<Integer> series;

}
