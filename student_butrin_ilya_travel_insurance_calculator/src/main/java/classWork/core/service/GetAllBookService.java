package classWork.core.service;

import classWork.domen.Book;

import classWork.core.database.BookRepository;
import classWork.core.response.GetAllBookResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GetAllBookService {

    @Autowired
    BookRepository data;

    public GetAllBookResponce execute() {
        List<Book> books = data.getBooks();
        for (Book bookFromList : books)
        {System.out.println(bookFromList.getId() +
                    ". " + bookFromList.getAuthor() +
                    "  " + bookFromList.getTitle());}
        return new GetAllBookResponce(books);
    }


    }
