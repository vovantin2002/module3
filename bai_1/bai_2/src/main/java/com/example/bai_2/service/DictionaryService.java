package com.example.bai_2.service;

import com.example.bai_2.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String findDictionary(String tu) {
        String result = null;
        Map<String, String> dictionaryMap = dictionaryRepository.getDictionaryMap();
        for (String key : dictionaryMap.keySet()) {
            if (tu.equals(key)) {
                result = dictionaryMap.get(key);
            } else {
                result = "không tìm thấy! ";
            }
        }
        return result;
    }
}
