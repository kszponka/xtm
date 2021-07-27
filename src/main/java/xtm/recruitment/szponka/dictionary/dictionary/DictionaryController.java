package xtm.recruitment.szponka.dictionary.dictionary;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xtm.recruitment.szponka.dictionary.translator.Translators;

import java.util.Map;

@RestController
public class DictionaryController {

    DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/result")
    public ResponseEntity<Map<String, Integer>> getResult() {
        return new ResponseEntity<>(dictionaryService.getSortedResult(), HttpStatus.OK);
    }

    @PostMapping("/translate")
    public ResponseEntity<String> translate(@RequestParam String sentenceToTranslate,
                                            @RequestParam(required = false, defaultValue = "REGULAR") Translators.Mode mode) {
        return new ResponseEntity<>(dictionaryService.translateSentence(sentenceToTranslate, mode), HttpStatus.OK);
    }
}
