package classWork.core.service;

import classWork.Book;

import classWork.core.database.Database;
import classWork.core.response.GetAllBookResponce;

import java.util.List;

public class GetAllBookService {

  Database data;


    public GetAllBookService(Database data) {
        this.data = data;
        }
    public GetAllBookResponce execute() {
        List<Book> books = data.getBooks();
        for (Book bookFromList : books)
        {System.out.println(bookFromList.getId() +
                    ". " + bookFromList.getAuthor() +
                    "  " + bookFromList.getTitle());}
        return new GetAllBookResponce(books);
    }


    }
