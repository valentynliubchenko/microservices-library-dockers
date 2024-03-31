package com.valentyn;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public BookDTO saveBook(BookDTO book) {
        return bookRepository.save(book);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}