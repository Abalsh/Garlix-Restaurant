package com.restaurant.garlix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException{
    private String itemName;
    private String fieldName;
    private Object fieldValue;

    public ItemNotFoundException(String itemName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", itemName, fieldName, fieldValue));
        this.itemName = itemName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getItemName() {
        return itemName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
