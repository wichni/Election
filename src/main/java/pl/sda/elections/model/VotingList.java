package pl.sda.elections.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VotingList {
    private Long id;
    private Long electionId;
    private String name;
    private Long number;

}
