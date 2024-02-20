package kg.alatoo.libraryapp.services;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import kg.alatoo.libraryapp.mappers.BookMapper;
import kg.alatoo.libraryapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceJPA implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceJPA(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDTO> findBooks() {
        return null;
    }

    @Override
    public Optional<BookDTO> findBookByID(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return Optional.ofNullable(
                bookMapper.bookToBookDto(optionalBook.orElseGet(null))
        );
    }
}
