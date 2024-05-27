package com.minitest_12.formatter;

import com.minitest_12.model.TypeComputer;
import com.minitest_12.service.type_computer.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class TypeFormatter implements Formatter<TypeComputer> {

    private final ITypeService typeService;

    @Autowired
    public TypeFormatter(ITypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public TypeComputer parse(String text, Locale locale) throws ParseException {
        Optional<TypeComputer> typeComputer = typeService.getById(Long.parseLong(text));
        return typeComputer.orElse(null);
    }

    @Override
    public String print(TypeComputer object, Locale locale) {
        return "[" + object.getId() + "," + object.getName() + "]";
    }
}
