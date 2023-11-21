package classWork.core.service;

import classWork.Book;

import classWork.core.database.Database;
import classWork.core.response.GetAllBookResponce;
import classWork.dependency_injection.DIComponent;
import classWork.dependency_injection.DIDependency;

import java.util.List;
@DIComponent
public class GetAllBookService {

  @DIDependency
  Database data;

    public GetAllBookResponce execute() {
        List<Book> books = data.getBooks();
        for (Book bookFromList : books)
        {System.out.println(bookFromList.getId() +
                    ". " + bookFromList.getAuthor() +
                    "  " + bookFromList.getTitle());}
        return new GetAllBookResponce(books);
    }


    }
