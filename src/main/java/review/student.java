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
        // create int to return all arg
        int hash = this.name.compareTo(s1.getName());
        return hash;
    }


}

