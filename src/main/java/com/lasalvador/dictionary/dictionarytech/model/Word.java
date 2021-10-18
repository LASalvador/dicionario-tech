package com.lasalvador.dictionary.dictionarytech.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Getter
@Setter
public class Word {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    @Indexed(unique = true)
    private String word;
    private String meaning;
    private String example;
    private Boolean isEnable;
    @CreatedDate
    private LocalDate createDate;

    public Word(String word, String meaning, String example) {
        this.word = word;
        this.meaning = meaning;
        this.example = example;
        this.createDate = LocalDate.now();
        this.isEnable = Boolean.FALSE;
    }
}
