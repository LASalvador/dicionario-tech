package com.lasalvador.dictionary.dictionarytech.repository.custom;

import com.lasalvador.dictionary.dictionarytech.model.Word;

import java.util.List;

public interface WordCustomRepository {
    List<Word> findLatestWords();
}
