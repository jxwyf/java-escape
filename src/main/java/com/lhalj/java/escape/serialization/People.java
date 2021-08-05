package com.lhalj.java.escape.serialization;

import lombok.*;

import java.io.Serializable;

/**
 * 描述:
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class People implements Serializable {

    private Long id;
}
