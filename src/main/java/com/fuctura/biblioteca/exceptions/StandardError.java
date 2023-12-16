package com.fuctura.biblioteca.exceptions;

import java.time.LocalDateTime;

public class StandardError {
    private LocalDateTime timeStemp;
    private Integer status;
    private String mensagem;
    private String path;

    public StandardError() {
    }

    public StandardError(LocalDateTime timeStemp, Integer status, String mensagem, String path) {
        this.timeStemp = timeStemp;
        this.status = status;
        this.mensagem = mensagem;
        this.path = path;
    }

    public LocalDateTime getTimeStemp() {
        return timeStemp;
    }

    public void setTimeStemp(LocalDateTime timeStemp) {
        this.timeStemp = timeStemp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
