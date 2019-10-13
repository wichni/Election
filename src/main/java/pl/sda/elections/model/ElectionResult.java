package pl.sda.elections.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@NoArgsConstructor
public class ElectionResult {
    private Long id;
    private Long electionsId;
    Map<Long, Long> committeeMandates;

    public ElectionResult(Long id, Long electionsId, Map<Long, Long> committeeMandates) {
        this.id = id;
        this.electionsId = electionsId;
        this.committeeMandates = committeeMandates;
    }

}
