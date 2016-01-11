package kata6.application.swing;

import kata6.application.MailReader;
import kata6.control.Command;
import kata6.model.Attribute;
import kata6.model.Person;
import kata6.view.ui.AttributeDialog;
import kata6.view.ui.PopulationDialog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Toolbar extends JPanel implements PopulationDialog, AttributeDialog {

    private final Map<String, Command> commands;
    private final List<Attribute> attributes;
    private JComboBox<String> comboBox;

    public Toolbar(Map<String, Command> commands) {
        super(new FlowLayout());
        this.commands = commands;
        this.attributes = new ArrayList<>();
        this.addAttribute(mailDomainAttribute());
        this.addAttribute(firstLetterOfMailAttribute());
        this.add(comboBox());
        this.add(calculateButton());
    }

    private void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    private Attribute<Person, String> mailDomainAttribute() {
        return person -> person.getMail().getDomain();
    }

    private Attribute<Person, Character> firstLetterOfMailAttribute() {
        return person -> person.getMail().address().charAt(0);
    }
    private JComboBox comboBox() {
        comboBox = new JComboBox<>(new String[]{"Mail Domains", "First letter of email"});
        return comboBox;
    }

    private JButton calculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(e -> commands.get("calculate").execute());
        return button;
    }

    @Override
    public Attribute attribute() {
        return attributes.get(comboBox.getSelectedIndex());
    }

    @Override
    public List people() {
        return MailReader.read("src/main/resources/mails.txt");
    }
}
