package com.lasalvador.dictionary.dictionarytech.controller;

import com.lasalvador.dictionary.dictionarytech.exception.DictionaryError;
import com.lasalvador.dictionary.dictionarytech.exception.DictionaryException;
import com.lasalvador.dictionary.dictionarytech.model.Word;
import com.lasalvador.dictionary.dictionarytech.service.WordService;
import com.lasalvador.dictionary.dictionarytech.vo.WordVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DictionaryController {
    private final WordService wordService;

    @GetMapping("/find")
    public ModelAndView getWord(@RequestParam String word) {
        ModelAndView mv = new ModelAndView("find");
        try {
            WordVo wordVo = wordService.getWord(word);
            mv.addObject("word", wordVo);
        } catch (DictionaryException dictionaryException) {
            mv.addObject("messageAlert", dictionaryException.getMessage());
        }
        return mv;
    }

    @GetMapping("latest")
    public ModelAndView getLatest() {
        List<Word> latestWords = wordService.getLatestWords();
        ModelAndView mv = new ModelAndView("latest");
        mv.addObject("words", latestWords);
        return mv;
    }
    
    @GetMapping("/create")
    public String getCreate() {
        return "create";
    }

    @PostMapping("/create")
    public String createWord(WordVo wordVo, RedirectAttributes attributes) {
        if (wordVo.getWord().isEmpty() || wordVo.getMeaning().isEmpty()) {
            attributes.addFlashAttribute("message", DictionaryError.REQUIRED_FIELDS.getMessage());
            return "redirect:/create";
        }

        try {
            wordService.createWord(wordVo);
        } catch (DictionaryException dictionaryException) {
            attributes.addFlashAttribute("messageAlert", dictionaryException.getMessage());
            return "redirect:/create";
        }
        return "index";
    }

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}
