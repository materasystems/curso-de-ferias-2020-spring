package com.matera.cursoferias.digitalbank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matera.cursoferias.digitalbank.dto.response.ErroResponseDTO;
import com.matera.cursoferias.digitalbank.dto.response.ResponseDTO;
import com.matera.cursoferias.digitalbank.exception.ServiceException;

public abstract class ControllerBase {

    private final MessageSource messageSource;

    public ControllerBase(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ResponseDTO<Object>> handleException(ServiceException exception) {
        String mensagemErro = messageSource.getMessage(exception.getCodigoErro(), exception.getParametros(), LocaleContextHolder.getLocale());
        ErroResponseDTO erro = new ErroResponseDTO(exception.getCodigoErro() + ": " + mensagemErro);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(ResponseDTO.comErro(erro));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO<Object>> handleException(MethodArgumentNotValidException exception) {
        List<ErroResponseDTO> erros = new ArrayList<>();
        BindingResult bindingResult = exception.getBindingResult();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String campo = fieldError.getField();
            String mensagem = String.format("%s: %s", campo, fieldError.getDefaultMessage());

            erros.add(new ErroResponseDTO(campo, mensagem));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(ResponseDTO.comErros(erros));
    }

}
