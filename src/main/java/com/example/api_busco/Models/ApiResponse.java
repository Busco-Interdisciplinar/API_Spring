package com.example.api_busco.Models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private boolean responseSucessfull;
    private String description;
    private List<Object> object;
    private Object aditionalInformation;
}
