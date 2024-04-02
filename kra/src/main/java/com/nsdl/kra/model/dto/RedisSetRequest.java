package com.nsdl.kra.model.dto;


import lombok.Data;

@Data
public class RedisSetRequest {
    private String key;
    private String value;
}
