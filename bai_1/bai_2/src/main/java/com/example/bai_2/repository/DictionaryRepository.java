package com.example.bai_2.repository;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    @Override
    public Map<String, String> dictionary() {
        Map<String, String> dictionaryMap = new LinkedHashMap<>();
        dictionaryMap.put("dog", "chó");
        dictionaryMap.put("cat", "mèo");
        dictionaryMap.put("mouse", "chuột");
        dictionaryMap.put("fish", "cá");
        dictionaryMap.put("duck", "vịt");
        dictionaryMap.put("chicken", "gà");
        return dictionaryMap;
    }
}
