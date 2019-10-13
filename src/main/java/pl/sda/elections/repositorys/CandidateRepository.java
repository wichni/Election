package pl.sda.elections.repositorys;

import pl.sda.elections.model.Candidate;

import java.util.ArrayList;
import java.util.List;

public class CandidateRepository {
    private List<Candidate> candidateList = new ArrayList<>();

    public CandidateRepository() {
        candidateList.add(new Candidate(0L, "Primus", "Javowy"));
        candidateList.add(new Candidate(1L, "Secundus", "Aplowy"));
        candidateList.add(new Candidate(2L, "Tercjusz", "Pythonowy"));
        candidateList.add(new Candidate(3L, "Fordus", "Pehapowy"));
        candidateList.add(new Candidate(4L, "Tercjusz", "Ceplusowy"));
        candidateList.add(new Candidate(5L, "Primus", "Pehapowy"));
        candidateList.add(new Candidate(6L, "Secundus", "Javowy"));
        candidateList.add(new Candidate(7L, "Fordus", "Aplowy"));
    }
}
