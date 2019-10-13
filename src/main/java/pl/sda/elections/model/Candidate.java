package pl.sda.elections.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Candidate {
    private Long id;
    private String name;
    private String lastName;

}

