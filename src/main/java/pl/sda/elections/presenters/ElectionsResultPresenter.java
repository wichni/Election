package pl.sda.elections.presenters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.sda.elections.counter.VoteCounter;
import pl.sda.elections.model.ElectionResult;
import pl.sda.elections.model.VotingList;
import pl.sda.elections.repositories.VotingListRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ElectionsResultPresenter {
    private VoteCounter voteCounter;
    private VotingListRepository votingListRepository;
    private MandateDistribution distributionAlgorithm;

    public ElectionsResultPresenter(VoteCounter voteCounter, VotingListRepository votingListRepository) {
        this.voteCounter = voteCounter;
        this.votingListRepository = votingListRepository;
        this.distributionAlgorithm = new DHondtMethodAlgorithm();
    }

    public ElectionResult getResult(Long electionsId, Long mandates) {
        List<VotingList> votingLists = votingListRepository.getVotingListsByElectionsId(electionsId);

        Map<Long, Long> listResult = countVoteForList(electionsId, votingLists);

        Map<Long, Long> comiteeMandates = distributionAlgorithm.getMandates(mandates, listResult);
        return new ElectionResult(0L, electionsId, comiteeMandates);
    }

    private Map<Long, Long> countVoteForList(Long electionsId, List<VotingList> votingLists) {
        Map<Long, Long> listResult = new HashMap<>();
        votingLists.stream()
                .forEach(x -> listResult.put(x.getId(), voteCounter.count(electionsId, x.getId())));
        return listResult;
    }
}
