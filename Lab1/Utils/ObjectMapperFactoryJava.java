package com.example.lab1.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ObjectMapperFactory {

    /**
     * Возвращает настроенный ObjectMapper для работы с JSON.
     *
     * @return ObjectMapper с включенным форматированием вывода
     */
    public static ObjectMapper json() {
        // Создаем новый ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Включаем опцию для "красивого" форматирования JSON (с отступами)
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return objectMapper;
    }
}
