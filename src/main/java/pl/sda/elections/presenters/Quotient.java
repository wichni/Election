package pl.sda.elections.presenters;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Quotient {
    private int n;
    private Long value;
    private Long listId;
}
