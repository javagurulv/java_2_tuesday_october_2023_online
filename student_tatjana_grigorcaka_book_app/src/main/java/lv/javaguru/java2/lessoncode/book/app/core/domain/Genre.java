package lv.javaguru.java2.lessoncode.book.app.core.domain;

public enum Genre {
    FANTASY(0),
    ADVENTURE(1),
    DETECTIVE(2),
    ROMANCE(3),
    SCIENCE_FICTION(4),
    HORROR(5),
    THRILLER(6),
    HUMOR(7),
    CLASSIC(8),
    FABLE(9);

    int genreId;

    Genre(int genreId) {
        this.genreId = genreId;
    }

    public int getGenreId() {
        return genreId;
    }

    }
