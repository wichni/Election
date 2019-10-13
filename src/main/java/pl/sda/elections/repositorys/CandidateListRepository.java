package pl.sda.elections.repositorys;

import pl.sda.elections.model.CandidateList;

import java.util.ArrayList;
import java.util.List;

public class CandidateListRepository {
    private List<CandidateList> candidateLists = new ArrayList<>();

    public CandidateListRepository() {
        candidateLists.add(new CandidateList(0L, 0L, 0L));
        candidateLists.add(new CandidateList(1L, 1L, 1L));
        candidateLists.add(new CandidateList(2L, 2L, 2L));
        candidateLists.add(new CandidateList(3L, 3L, 3L));
        candidateLists.add(new CandidateList(4L, 4L, 4L));
        candidateLists.add(new CandidateList(5L, 5L, 3L));
        candidateLists.add(new CandidateList(6L, 6L, 0L));
        candidateLists.add(new CandidateList(7L, 7L, 1L));
    }
}
