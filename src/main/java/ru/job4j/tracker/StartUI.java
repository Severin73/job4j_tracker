package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();

        List<UserAction> actions = new ArrayList<>() {{
            add(new CreateAction(output));
            add(new ShowAction(output));
            add(new EditAction(output));
            add(new DeleteAction(output));
            add(new FindByIdAction(output));
            add(new FindByNameAction(output));
            add(new ExitAction(output));
        }};

        new StartUI(output).init(input, tracker, actions);
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + "." + actions.get(i).name());
        }
    }
}