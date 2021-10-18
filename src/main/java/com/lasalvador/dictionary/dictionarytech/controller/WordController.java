package com.lasalvador.dictionary.dictionarytech.controller;

import com.lasalvador.dictionary.dictionarytech.model.Word;
import com.lasalvador.dictionary.dictionarytech.service.WordService;
import com.lasalvador.dictionary.dictionarytech.vo.WordVo;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WordController {
    private final WordService wordService;

//    @PostMapping("/word")
//    public ResponseEntity createWord(@RequestBody WordVo wordVo) {
//        return ResponseEntity.ok().body(wordService.createWord(wordVo));
//    }
//
//    @GetMapping("/word")
//    public ResponseEntity<WordVo> getWord(@RequestParam String word) {
//        return ResponseEntity.ok().body(wordService.getWord(word));
//    }
//
//    @GetMapping("/word/disable")
//    public ResponseEntity<List<Word>> getDisableWords() {
//        return ResponseEntity.ok().body(wordService.getDisableWords());
//    }
//
//    @PutMapping("/word")
//    public ResponseEntity updateStatus(@RequestParam ObjectId id) {
//        wordService.updateStatus(id);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
