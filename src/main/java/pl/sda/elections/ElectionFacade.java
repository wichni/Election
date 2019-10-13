package pl.sda.elections;

import pl.sda.elections.model.ElectionResult;
import pl.sda.elections.model.Vote;
import pl.sda.elections.repositories.VoteRepository;

public class ElectionFacade {

    private VoteRepository voteRepository = new VoteRepository();
    public boolean vote(Vote vote) {
        Vote savedVote = voteRepository.save(vote);
        return savedVote.getId() != null;
    }

    public ElectionResult getResult(Long electionId) {
        return null;
    }
}
