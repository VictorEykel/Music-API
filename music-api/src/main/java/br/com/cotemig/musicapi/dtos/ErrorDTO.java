package br.com.cotemig.musicapi.dtos;

public record ErrorDTO( String message,
                        String[] details) {}
