package shell;

import services.BookService;

public class CommandAdd extends Command {

    @Override
    public void Execute(String[] args) {

        if(args[0].equals("author")) {

            BookService.getInstance().addAuthor(args);
        }
        else if(args[0].equals("book")) {

            BookService.getInstance().addBook(args);
        }
    }
}
