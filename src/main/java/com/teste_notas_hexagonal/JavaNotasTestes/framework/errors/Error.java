package com.teste_notas_hexagonal.JavaNotasTestes.framework.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {
    private static final long serialVersionUID = -3098212556060809862L;

    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty(value = "reason", required = true)
    private String reason;

    @JsonProperty(value = "message", required = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonProperty(value = "status", required = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer status;

    @JsonProperty(value = "referenceError", required = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String referenceError;

    @JsonProperty(value = "@baseType", required = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String baseType;

    @JsonProperty(value = "@schemaLocation", required = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String schemaLocation;

    @JsonProperty(value = "@type", required = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;

    public Error() {
        super();
    }

    public Error(String code, String reason, Integer status) {
        this.code = code;
        this.reason = reason;
        this.status = status;
    }

    public Error(String code, String reason, String message, Integer status) {
        this.code = code;
        this.reason = reason;
        this.message = message;
        this.status = status;
    }
}

