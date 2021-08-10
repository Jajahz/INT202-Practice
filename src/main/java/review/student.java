package review;

import lombok.*;

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
        return ((Double)gpax).compareTo(s1.getGpax());
    }


}

