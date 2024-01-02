package lv.javaguru.java2.lessoncode.book.app.matchers;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import org.mockito.ArgumentMatcher;

public class ReaderMatcher implements ArgumentMatcher<Reader> {

    private String firstName;
    private String lastName;
    private String personalCode;


    public ReaderMatcher(String firstName, String lastName, String personalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
    }


    @Override
    public boolean matches(Reader reader) {
        return reader.getFirstName().equals(firstName)
                && reader.getLastName().equals(lastName)
                && reader.getPersonalCode().equals(personalCode);
    }


}
