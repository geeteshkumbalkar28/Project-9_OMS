package com.oms.exceptions;

import com.oms.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidOtpException.class)
    public ResponseEntity<ApiResponse> invalidOtpExceptionHandler(InvalidOtpException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiResponse> invalidCredentialsExceptionHandler(InvalidCredentialsException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserDisabledException.class)
    public ResponseEntity<ApiResponse> userDisabledExceptionHandler(UserDisabledException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailTemplateNotFoundException.class)
    public ResponseEntity<ApiResponse> emailTemplateNotFoundExceptionHandler(EmailTemplateNotFoundException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(OtpExpiredException.class)
    public ResponseEntity<ApiResponse> otpExpiredExceptionHandler(OtpExpiredException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LoadingEmailTemplateException.class)
    public ResponseEntity<ApiResponse> loadingEmailTemplateExceptionHandler(LoadingEmailTemplateException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ApiResponse> userAlreadyExistExceptionHandler(UserAlreadyExistException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValueNotNullException.class)
    public ResponseEntity<ApiResponse> valueNotNullExceptionHandler(ValueNotNullException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse> userNotFoundExceptionHandler(UserNotFoundException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<ApiResponse> pageNotFoundExceptionHandler(PageNotFoundException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<ApiResponse> projectNotFoundExceptionHandler(ProjectNotFoundException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiResponse> taskNotFoundExceptionHandler(TaskNotFoundException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse =new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }

}
