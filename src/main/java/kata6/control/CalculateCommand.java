package kata6.control;

import kata6.model.Histogram;
import kata6.view.process.HistogramBuilder;
import kata6.view.ui.AttributeDialog;
import kata6.view.ui.HistogramDisplay;
import kata6.view.ui.PopulationDialog;

public class CalculateCommand implements Command {

    private final AttributeDialog attributeDialog;
    private final PopulationDialog populationDialog;
    private final HistogramDisplay display;

    public CalculateCommand(AttributeDialog attributeDialog, PopulationDialog populationDialog, HistogramDisplay display) {
        this.attributeDialog = attributeDialog;
        this.populationDialog = populationDialog;
        this.display = display;
    }

    @Override
    public void execute() {
        Histogram histogram = new HistogramBuilder<>(populationDialog.people()).build(attributeDialog.attribute());
        display.display(histogram);
    }

}
