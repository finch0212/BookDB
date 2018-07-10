package shell;

import services.BookService;

public class CommandUpdate extends Command {

    @Override
    public void Execute(String[] args) {
        if(args[0].equals("author")) {

            BookService.getInstance().updateAuthor(args);
        }
        else if(args[0].equals("book")) {

            BookService.getInstance().updateBook(args);
        }
    }
}
