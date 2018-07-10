package shell;

import services.BookService;

public class CommandRemove extends Command {

    @Override
    public void Execute(String[] args) {
        if(args[0].equals("author")) {

            BookService.getInstance().removeAuthor(args);
        }
        else if(args[0].equals("book")) {

            BookService.getInstance().removeBook(args);
        }
    }
}
