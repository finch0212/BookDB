package shell;

public class CommandExit extends Command
{
    @Override
    void Execute() {

        System.exit(0);
    }
}