package com.lasalvador.dictionary.dictionarytech.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DictionaryError {
    WORD_ALREADY_EXISTS("Obrigado por nos apoiar, mas este Termo já possui definição!! =)"),
    REQUIRED_FIELDS("Verifique se os campos obrigatórios foram preenchidos! =)"),
    WORD_NOT_FOUND("Termo não encontrado. Gostaria de cadastrá-lo?");
    private String message;
}
