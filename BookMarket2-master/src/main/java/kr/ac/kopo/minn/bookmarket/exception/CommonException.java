package kr.ac.kopo.minn.bookmarket.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException {
    @ExceptionHandler(value = RuntimeException.class)
    private ModelAndView handleCommonException(HttpServletRequest request,CategoryException e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e.toString());
        mav.addObject("category", e.getCategory());
        mav.addObject("url", request.getRequestURL());
        mav.addObject("errorMessage", e.getErrormessage());
        mav.setViewName("errorCommon");
        return mav;
    }
}
