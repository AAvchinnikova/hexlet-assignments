package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<BookDTO> getAll() {
        var books = bookRepository.findAll();
        return books.stream().map(bookMapper::map).toList();
    }

    public BookDTO findById(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        return bookMapper.map(book);
    }

    public BookDTO create(BookCreateDTO data) {
        try {
            var author = authorRepository.findById(data.getAuthorId()).get();
            var book = bookMapper.map(data);
            book.setAuthor(author);
            bookRepository.save(book);
            return bookMapper.map(book);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    public BookDTO update(Long id, BookUpdateDTO data) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        bookMapper.update(data, book);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public void delete(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        bookRepository.deleteById(id);
    }
    // END
}
