package com.unitymain.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author UnityMain
 */
@Data
public class Student implements Serializable {
    private String name;
    private String sex;
}

