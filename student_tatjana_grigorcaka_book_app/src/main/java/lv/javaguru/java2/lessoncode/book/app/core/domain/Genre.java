package lv.javaguru.java2.lessoncode.book.app.core.domain;

public enum Genre {
    FANTASY,
    ADVENTURE,
    DETECTIVE,
    ROMANCE,
    SCIENCE_FICTION,
    HORROR,
    THRILLER,
    HUMOR,
    CLASSIC,
    FABLE,
    PERSONAL_FINANCE;

    public String enumToString() {
        return this.name();
    }

    }
