package com.lasalvador.dictionary.dictionarytech.repository;

import com.lasalvador.dictionary.dictionarytech.model.Word;
import com.lasalvador.dictionary.dictionarytech.repository.custom.WordCustomRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface WordRepository extends MongoRepository<Word, ObjectId>, WordCustomRepository {
    Optional<Word> findByWord(String word);
    List<Word> findByIsEnable(Boolean isEnable);
}
