package br.eti.gadelha.exception.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EnumTypeComission {
    A("A"),
    B("B");

    private final String name;
}
