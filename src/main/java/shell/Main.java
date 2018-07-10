package shell;


import dataAccess.H2DBController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map map = new HashMap<String, Command>();

    public static void main(String[] args)
    {
        H2DBController.Connect();
        Scanner in = new Scanner(System.in);
        MyParser pars = new MyParser();

        map.put("add",new CommandAdd());
        map.put("show",new CommandShow());
        map.put("exit",new CommandExit());
        map.put("update",new CommandUpdate());
        map.put("remove",new CommandRemove());
        while(true) {
            String command = in.nextLine();
            List<String> commands = pars.Parse(command, ' ');
            if (map.containsKey(commands.get(0))) {
                Command c = (Command) map.get(commands.get(0));
                if (commands.size() == 1)
                    c.Execute();
                else {
                    commands.remove(0);
                    String[] commArgs = new String[commands.size()];
                    for (int i = 0; i < commands.size(); i++) {
                        commArgs[i] = commands.get(i);
                    }
                    c.Execute(commArgs);
                }
            } else {
                System.out.println("Wrong command.");
            }
        }
    }
}