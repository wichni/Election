package pl.sda;

import pl.sda.elections.ElectionFacade;
import pl.sda.elections.counter.VoteCounter;
import pl.sda.elections.model.ElectionResult;
import pl.sda.elections.model.Vote;
import pl.sda.elections.presenters.ElectionsResultPresenter;
import pl.sda.elections.repositorys.CandidateListRepository;
import pl.sda.elections.repositorys.CandidateRepository;
import pl.sda.elections.repositorys.VoteRepository;
import pl.sda.elections.repositorys.VotingListRepository;

public class App {
    public static void main(String[] args) {
        ElectionFacade facade = new ElectionFacade();
        facade.vote(new Vote(1L, 1L));
        facade.vote(new Vote(2L, 1L));
        facade.vote(new Vote(1L, 1L));
        facade.vote(new Vote(1L, 1L));
        facade.vote(new Vote(4L, 1L));

        VoteRepository voteRepository = new VoteRepository();
        CandidateRepository candidateRepository = new CandidateRepository();
        CandidateListRepository candidateListRepository = new CandidateListRepository(candidateRepository);
        VotingListRepository votingListRepository = new VotingListRepository(candidateListRepository);
        VoteCounter counter = new VoteCounter(votingListRepository, voteRepository);

//        System.out.println(counter.count(1L, 0L));
//        System.out.println(counter.count(1L, 1L));
//        System.out.println(counter.count(1L, 2L));
//        System.out.println(counter.count(1L, 3L));
//        System.out.println(counter.count(1L, 4L));

        ElectionsResultPresenter presenter = new ElectionsResultPresenter(counter, votingListRepository);
        ElectionResult result = presenter.getResult(1L, 3L);
        System.out.println(result);
    }
}
