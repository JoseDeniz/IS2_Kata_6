package kata6.view.ui;

import kata6.model.Histogram;

@FunctionalInterface
public interface HistogramDisplay {
    void display(Histogram histogram);
}