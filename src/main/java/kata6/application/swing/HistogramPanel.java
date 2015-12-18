package kata6.application.swing;

import kata6.model.Histogram;
import kata6.view.ui.HistogramDisplay;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

import static org.jfree.chart.ChartFactory.createBarChart;

public class HistogramPanel extends JPanel implements HistogramDisplay {

    private Histogram histogram;

    public HistogramPanel(){
        super(new BorderLayout());
    }

    @Override
    public void display(Histogram histogram) {
        this.histogram = histogram;
        this.reload();
    }

    private void reload() {
        this.removeAll();
        this.add(new ChartPanel(createChart(createDataset())));
        this.revalidate();
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        return createBarChart("Histogram", "", "Nº mails", dataSet);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
        histogram.keySet().forEach(key -> categoryDataset.addValue(histogram.get(key), "", (Comparable) key));
        return categoryDataset;
    }
}

