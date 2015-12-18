package kata6.application;

import kata6.application.swing.HistogramPanel;
import kata6.application.swing.Toolbar;
import kata6.control.CalculateCommand;
import kata6.control.Command;
import kata6.view.ui.AttributeDialog;
import kata6.view.ui.HistogramDisplay;
import kata6.view.ui.PopulationDialog;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Application extends JFrame {

    private AttributeDialog attributeDialog;
    private PopulationDialog populationDialog;
    private HistogramDisplay histogramDisplay;
    private Map<String, Command> commands;

    public Application() {
        this.commands = new HashMap<>();
        this.deployUI();
        this.createCommands();
        this.setVisible(true);
    }

    private void deployUI() {
        this.setTitle("Histogram Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(700, 700));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(histogramPanel());
        this.getContentPane().add(toolbar(), BorderLayout.NORTH);
    }

    private JPanel toolbar() {
        Toolbar panel = new Toolbar(commands);
        this.attributeDialog = panel;
        this.populationDialog = panel;
        return panel;
    }

    private JPanel histogramPanel() {
        HistogramPanel panel = new HistogramPanel();
        this.histogramDisplay = panel;
        return panel;
    }

    private void createCommands() {
        commands.put("calculate", new CalculateCommand(attributeDialog, populationDialog, histogramDisplay));
    }

}
