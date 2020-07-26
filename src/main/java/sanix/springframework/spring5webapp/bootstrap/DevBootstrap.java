package sanix.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sanix.springframework.spring5webapp.model.Author;
import sanix.springframework.spring5webapp.model.Book;
import sanix.springframework.spring5webapp.model.Publisher;
import sanix.springframework.spring5webapp.repositories.AuthorRepository;
import sanix.springframework.spring5webapp.repositories.BookRepository;
import sanix.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository ){
        this.authorRepository =authorRepository;
        this.bookRepository=bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        initData();
    }

    private void initData(){

        Publisher publisher=new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);

        Author eric=new Author("Eric", "Evans");
        Book ddd=new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod=new Author("Rod", "Johnson");
        Book noEJB=new Book("J2EE Development without EJB", "23444", publisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
