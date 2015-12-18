package kata6.view.process;

import kata6.model.Attribute;
import kata6.model.Histogram;

import java.util.List;

public class HistogramBuilder<T> {

    private final List<T> items;

    public HistogramBuilder(List<T> items) {
        this.items = items;
    }

    public <A> Histogram<A> build(Attribute<T, A> attribute) {
        Histogram<A> histogram = new Histogram<>();
        items.forEach(item -> histogram.increment(attribute.get(item)));
        return histogram;
    }

}
