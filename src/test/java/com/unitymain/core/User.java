package com.unitymain.core;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -6613255266088238653L;

    private int id;
    private List<String> prims;
}
