package kr.ac.kopo.minn.bookmarket.config;

import kr.ac.kopo.minn.bookmarket.vaildator.BookValidator;
import kr.ac.kopo.minn.bookmarket.vaildator.UnitsInStockValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Validation {
    @Autowired
    UnitsInStockValidator unitsInStockValidator;

    @Bean
    public BookValidator bookValidator() {
        BookValidator bookValidator = new BookValidator();
        bookValidator.springValidators.add(unitsInStockValidator);
        return bookValidator;
    }
}
