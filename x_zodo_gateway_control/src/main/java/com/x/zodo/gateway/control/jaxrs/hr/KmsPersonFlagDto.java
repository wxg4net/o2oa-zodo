package com.x.zodo.gateway.control.jaxrs.hr;

import java.util.List;

public class KmsPersonFlagDto {

    private List<String> personList;

    public KmsPersonFlagDto(List<String> personList) {
        this.personList = personList;
    }
    public List<String> getPersonList() {
        return personList;
    }

    public void setPersonList(List<String> personList) {
        this.personList = personList;
    }
}

