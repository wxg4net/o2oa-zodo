package com.x.zodo.attendance.control.hanvon.v2;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class CommandParam {
    // 动态属性容器
    @JsonAnySetter
    private final Map<String, Object> dynamicFields = new HashMap<>();

    public void set(String key, Object value) {
        dynamicFields.put(key, value);
    }

    public Object get(String key) {
        return dynamicFields.get(key);
    }

    @JsonAnyGetter
    public Map<String, Object> getAll() {
        return dynamicFields;
    }
}
