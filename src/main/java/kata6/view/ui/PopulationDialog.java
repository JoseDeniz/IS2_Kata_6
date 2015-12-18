package kata6.view.ui;

import kata6.model.Person;

import java.util.List;

@FunctionalInterface
public interface PopulationDialog {
    List<Person> people();
}
