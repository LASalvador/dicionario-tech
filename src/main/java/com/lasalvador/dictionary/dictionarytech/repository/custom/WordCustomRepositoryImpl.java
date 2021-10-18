package com.lasalvador.dictionary.dictionarytech.repository.custom;

import com.lasalvador.dictionary.dictionarytech.model.Word;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@AllArgsConstructor
public class WordCustomRepositoryImpl implements WordCustomRepository{
    private final MongoTemplate mongoTemplate;
    @Override
    public List<Word> findLatestWords() {
        Aggregation aggregation = Aggregation.newAggregation(
                sort(Sort.by(Sort.Direction.DESC, "createDate")),
                limit(10)
        );
        AggregationResults<Word> output = mongoTemplate.aggregate(aggregation, Word.class, Word.class);
        return output.getMappedResults();
    }
}
