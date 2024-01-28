package lk.purna.HRnewV1.exception;

import lk.purna.HRnewV1.controller.response.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdviser {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler({EmployeeNotFoundException.class,DependenciesNotFoundException.class,InsuranceNotFoundException.class})
    public CustomErrorResponse handleNotFoundException(Exception exception){


        System.out.println(exception.getMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();

        customErrorResponse.setMessage("Not Found Id");

        return customErrorResponse;
    }
}
