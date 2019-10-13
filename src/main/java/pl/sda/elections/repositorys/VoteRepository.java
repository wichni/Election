package pl.sda.elections.repositorys;

import pl.sda.elections.model.Vote;
import pl.sda.files.csvJsonConverter.FileReaderFactory;
import pl.sda.files.csvJsonConverter.FileWriterFactory;
import pl.sda.files.csvJsonConverter.SDAFileReader;
import pl.sda.files.csvJsonConverter.SDAFileWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VoteRepository {

    private String filePath = "C:\\Users\\jakub\\IdeaProjects\\SDA_J19_Elections\\src\\main\\resources\\votes.csv";
    private Long currentId;
    private List<Vote> votes;

    public VoteRepository() {
        FileReaderFactory fileReaderFactory = new FileReaderFactory();
        SDAFileReader dataBase = fileReaderFactory.produce(filePath);
        try {
            List<Map<String, Object>> votesFromFile = dataBase.read(filePath);
            votes = votesFromFile.stream()
                    .map(x -> new MapToVoteAdapter(x))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            this.votes = new ArrayList<>();
        }
        currentId = findMaxId(votes);
    }

    public Vote save(Vote vote) {
        FileWriterFactory fileWriterFactory = new FileWriterFactory();
        SDAFileWriter writer = fileWriterFactory.produce(filePath);
        currentId = currentId.equals(Long.MIN_VALUE) ? 0 : currentId + 1;
        vote.setId(currentId);
        votes.add(vote);
        List<Map<String, Object>> dataToSave =
                votes.stream()
                        .map(x -> objectToMap(x))
                        .collect(Collectors.toList());
        writer.write(dataToSave, filePath);
        return vote;
    }

    public List<Vote> getVotes() {
        return this.votes;
    }

    private Long findMaxId(List<Vote> votes) {
        Long maxId = Long.MIN_VALUE;
        for (Vote vote : votes) {
            if (vote.getId() > maxId) {
                maxId = vote.getId();
            }
        }
        return maxId;
    }

    private Map<String, Object> objectToMap(Vote vote) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", vote.getId());
        result.put("candidateId", vote.getCandidateId());
        result.put("electionsId", vote.getElectionsId());
        return result;
    }
}
