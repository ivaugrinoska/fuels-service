package mk.ukim.finki.fuelsservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Street {
    private Long id;

    private String name;

    private Float latitude;

    private Float longitude;
}
