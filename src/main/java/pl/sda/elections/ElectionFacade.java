package pl.sda.elections;

import pl.sda.elections.counter.VoteCounter;
import pl.sda.elections.model.ElectionResult;
import pl.sda.elections.model.Vote;
import pl.sda.elections.presenters.ElectionsResultPresenter;
import pl.sda.elections.repositories.CandidateListRepository;
import pl.sda.elections.repositories.CandidateRepository;
import pl.sda.elections.repositories.VoteRepository;
import pl.sda.elections.repositories.VotingListRepository;

public class ElectionFacade {

    private VoteRepository voteRepository = new VoteRepository();

    public boolean vote(Vote vote) {
        Vote savedVote = voteRepository.save(vote);
        return savedVote.getId() != null;
    }

    public ElectionResult getResult(Long electionId) {
        VoteRepository voteRepository = new VoteRepository();
        CandidateRepository candidateRepository = new CandidateRepository();
        CandidateListRepository candidateListRepository = new CandidateListRepository(candidateRepository);
        VotingListRepository votingListRepository = new VotingListRepository(candidateListRepository);
        VoteCounter counter = new VoteCounter(votingListRepository, voteRepository);

        ElectionsResultPresenter presenter = new ElectionsResultPresenter(counter, votingListRepository);
        return presenter.getResult(electionId, 60L);
    }
}
