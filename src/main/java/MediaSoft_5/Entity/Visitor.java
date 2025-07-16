package MediaSoft_5.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {
    private Long id;
    private String name;
    private int age;
    private String gender;
}
