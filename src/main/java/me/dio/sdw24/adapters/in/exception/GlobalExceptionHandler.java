package me.dio.sdw24.adapters.in.exception;

import me.dio.sdw24.domain.exception.ChampionNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ChampionNotFoundException.class)
    public ResponseEntity<ApiError> handlerDomainException(ChampionNotFoundException domainError){
        return ResponseEntity.unprocessableEntity().body(new ApiError(domainError.getMessage()));
    }

    public record ApiError(String message){}

}

