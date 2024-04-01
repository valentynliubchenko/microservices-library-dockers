package com.valentyn;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookConverter bookConverter;

    public Book saveBook(Book book) {
        BookDTO bookDTO = bookConverter.toDTO(book);
        bookDTO.setId(0L);
        System.out.println("bookDTO: " + bookDTO);
        return bookConverter.fromDTO(bookRepository.save(bookDTO));
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        for (BookDTO bookDTO : bookRepository.findAll()) {
            bookList.add(bookConverter.fromDTO(bookDTO));
        }
        return bookList;
    }

    public Book getBookById(Long id) {
        return bookConverter.fromDTO(bookRepository.findById(id).orElse(null));
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}