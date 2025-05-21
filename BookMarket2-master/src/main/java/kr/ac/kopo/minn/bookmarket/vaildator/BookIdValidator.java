package kr.ac.kopo.minn.bookmarket.vaildator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kr.ac.kopo.minn.bookmarket.domain.Book;
import kr.ac.kopo.minn.bookmarket.repository.BookRepository;
import kr.ac.kopo.minn.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookIdValidator implements ConstraintValidator<BookId, String> {
    @Autowired
    private BookService bookService;

    @Override
    public void initialize(BookId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String bookId, ConstraintValidatorContext constraintValidatorContext) { // 도서번호 유효성 검사 메소드
        Book book = null;
        try{
            book = bookService.getBookById(bookId);
        }catch (RuntimeException e){
            return true;
        }

        if(book == null){
            return false;
        }
        return true;
    }
}
