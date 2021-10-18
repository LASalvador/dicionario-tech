package com.lasalvador.dictionary.dictionarytech.vo;

import com.lasalvador.dictionary.dictionarytech.model.Word;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WordVo {
    private String word;
    private String meaning;
    private String example;
    private LocalDate createDate;

    public static WordVo fromWord(Word word) {
        return new WordVo(word.getWord(), word.getMeaning(), word.getExample(), word.getCreateDate());
    }
}
