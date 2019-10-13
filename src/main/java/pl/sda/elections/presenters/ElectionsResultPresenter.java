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

    public ElectionResult getResult(Long electionsId, Long mandates) {
        List<VotingList> votingLists = votingListRepository.getVotingListsByElectionsId(electionsId);

        Map<Long, Long> listResult = new HashMap<>();
        votingLists.stream()
                .forEach(x -> listResult.put(x.getId(), voteCounter.count(electionsId, x.getId())));

        List<Quotient> quotients = new ArrayList<>();
        for (Long listId : listResult.keySet()) {
            quotients.addAll(getQuotientsForList(listResult.get(listId), mandates, listId));
        }
        quotients.sort((Quotient x, Quotient y) -> (int) (y.getValue() - x.getValue()));

        Map<Long, Long> comiteeMandates = new HashMap<>();
        quotients.subList(0, Math.toIntExact(mandates)).stream()
                .forEach(x -> {
                    if (comiteeMandates.get(x.getListId()) == null) {
                        comiteeMandates.put(x.getListId(), 0L);
                    }
                    comiteeMandates.put(x.getListId(), comiteeMandates.get(x.getListId()) + 1);
                });
        return new ElectionResult(0L, electionsId, comiteeMandates);
    }

    private List<Quotient> getQuotientsForList(Long voteCount, Long mandates, Long listId) {
        List<Quotient> result = new ArrayList<>();
        for (int i = 1; i <= mandates; i++) {
            result.add(new Quotient(i, voteCount / i, listId));
        }
        return result;
    }

    @AllArgsConstructor
    @Getter
    private class Quotient {
        private int n;
        private Long value;
        private Long listId;
    }
}
