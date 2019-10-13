package pl.sda.elections.repositorys;

import pl.sda.elections.model.VotingList;

import java.util.ArrayList;
import java.util.List;

public class VotingListRepository {
    private List<VotingList> votingLists = new ArrayList<>();
    private Long currentId = 0L;

    public VotingListRepository() {
        votingLists.add(new VotingList(0L, 1L, "Komitet wyborczy Java", 1L));
        votingLists.add(new VotingList(1L, 1L, "Komitet wyborczy APL", 2L));
        votingLists.add(new VotingList(2L, 1L, "Komitet wyborczy Python", 3L));
        votingLists.add(new VotingList(3L, 1L, "Komitet wyborczy PHP", 4L));
        votingLists.add(new VotingList(4L, 1L, "Komitet wyborczy C++", 5L));
    }
}
