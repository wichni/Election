package pl.sda.elections.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CandidateList {
    private Long id;
    private Long candidateId;
    private Long listId;
}
