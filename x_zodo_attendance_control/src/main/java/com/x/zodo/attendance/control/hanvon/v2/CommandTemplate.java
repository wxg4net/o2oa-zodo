package com.x.zodo.attendance.control.hanvon.v2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommandTemplate {

    @JsonProperty("RETURN")
    public String RETURN = "GetRequest";

    @JsonProperty("PARAM")
    public CommandParam PARAM = new CommandParam();

    public CommandTemplate() {
    }
    public CommandTemplate(String command) {
        PARAM.set("command", command);
    }

    public String getCommand() {
        return this.PARAM.get("command").toString();
    }

    public CommandParam getCommandParam() {
        return this.PARAM;
    }

    public void setParam(String key, Object value) {
        this.PARAM.set(key, value);
    }
}
