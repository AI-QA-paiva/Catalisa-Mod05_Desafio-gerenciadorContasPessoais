package com.financeiro.desafioPagamentosCorrentes.exception;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerContasAPagar extends ResponseEntityExceptionHandler {
    @Autowired
    MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String mensagemUser = messageSource.getMessage("mensagem.invalida",null,null);
        String mensagemDev =ex.getCause().toString();

        return handleExceptionInternal(ex,new MensagemErro(mensagemUser,mensagemDev),headers,HttpStatus.BAD_REQUEST,request);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MensagemErro{
        private String mensagemDoUsuario;
        private String mensagemDoDesenvolvedor;


    }



    //    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<String> exceptionHandlerCampoInvalido(HttpMessageNotReadableException exception, HttpServletRequest request){
//        return new ResponseEntity<>("O valor inserido no campo, não é válido! Favor verificar o valor se está conforme requisito.", HttpStatus.BAD_REQUEST);
//    }

}
