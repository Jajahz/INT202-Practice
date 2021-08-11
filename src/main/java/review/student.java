package review;

import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = "gpax")
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class student implements Comparable<student>{
    private Integer id;
    private String name;
    private Double gpax;

    @Override
    public int compareTo(student s1) {
        if(this.getGpax().equals(s1.getGpax())){
            return this.getName().compareTo(s1.getName());
        }
        if (s1.getGpax() > this.getGpax()) {
            return -1;
        }
        return 1;
    }


}

