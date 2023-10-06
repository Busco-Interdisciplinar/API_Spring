package com.example.api_busco.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private boolean responseSucessfull;
    private String description;
    private List<Usuarios> object;

    public boolean isResponseSucessfull() {
        return responseSucessfull;
    }

    public void setResponseSucessfull(boolean responseSucessfull) {
        this.responseSucessfull = responseSucessfull;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(List<Usuarios> object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "responseSucessfull=" + responseSucessfull +
                ", description='" + description + '\'' +
                ", object=" + object +
                '}';
    }
}
