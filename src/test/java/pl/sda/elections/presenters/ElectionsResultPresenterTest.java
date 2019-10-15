package pl.sda.elections.presenters;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import pl.sda.elections.counter.VoteCounter;
import pl.sda.elections.model.VotingList;
import pl.sda.elections.repositories.VotingListRepository;

import java.util.Arrays;

import static org.mockito.Mockito.when;

public class ElectionsResultPresenterTest {

    @Mock
    private VoteCounter voteCounter = Mockito.mock(VoteCounter.class);
    private VotingListRepository votingListRepository = Mockito.mock(VotingListRepository.class);
    private ElectionsResultPresenter presenter = new ElectionsResultPresenter(voteCounter, votingListRepository);

    @Test
    public void getResult() {
        when(votingListRepository.getVotingListsByElectionsId(1L))
                .thenReturn(Arrays.asList(new VotingList(0L, 1L, "Komitet wyborczy Java", 1L)
                        , new VotingList(1L, 1L, "Komitet wyborczy APL", 2L)));

        when(voteCounter.count(1L, 0L)).thenReturn(5000L);
        when(voteCounter.count(1L, 1L)).thenReturn(2000L);

        presenter.getResult(1L, 50L);
    }
}