package pl.sda.elections.repositorys;

import pl.sda.elections.model.Elections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ElectionsRepository {
    private List<Elections> elections = new ArrayList<>();

    public ElectionsRepository() {
        elections.add(new Elections(0L, LocalDate.of(2019, 10, 13)));
    }
}
