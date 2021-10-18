package com.lasalvador.dictionary.dictionarytech.service;

import com.lasalvador.dictionary.dictionarytech.exception.DictionaryError;
import com.lasalvador.dictionary.dictionarytech.exception.DictionaryException;
import com.lasalvador.dictionary.dictionarytech.model.Word;
import com.lasalvador.dictionary.dictionarytech.repository.WordRepository;
import com.lasalvador.dictionary.dictionarytech.vo.WordVo;
import com.mongodb.DuplicateKeyException;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository wordRepository;

    public WordVo createWord(WordVo wordVo) {
        try {
            Word word = new Word(wordVo.getWord(), wordVo.getMeaning(), wordVo.getExample());
            wordRepository.save(word);
            wordVo.setCreateDate(word.getCreateDate());
            return wordVo;
        } catch (Exception error) {
            throw new DictionaryException(DictionaryError.WORD_ALREADY_EXISTS.getMessage());
        }
    }

    public WordVo getWord(String word) {
        Optional<Word> wordOptional = wordRepository.findByWord(word);
        if (!wordOptional.isPresent()) {
            throw new DictionaryException(DictionaryError.WORD_NOT_FOUND.getMessage());
        }

        return WordVo.fromWord(wordOptional.get());
    }

    public List<Word> getLatestWords() {
        return wordRepository.findLatestWords();
    }

    public List<Word> getDisableWords() {
        return wordRepository.findByIsEnable(false);
    }

    public void updateStatus(ObjectId id) {
        Optional<Word> wordOptional = wordRepository.findById(id);
        if (!wordOptional.isPresent()) {
            throw new RuntimeException("Not Found");
        }
        Word word = wordOptional.get();
        word.setIsEnable(true);
        wordRepository.save(word);
    }
}
