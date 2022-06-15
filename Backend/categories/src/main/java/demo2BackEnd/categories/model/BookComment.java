package demo2BackEnd.categories.model;

import javax.persistence.*;

@Entity
public class BookComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ManyToOne
    @JoinColumn(name = "user")
    User user;

    @ManyToOne
    @JoinColumn(name = "book")
    BookCategory book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookCategory getBook() {
        return book;
    }

    public void setBook(BookCategory book) {
        this.book = book;
    }
}
