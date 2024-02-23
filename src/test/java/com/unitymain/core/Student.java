package com.unitymain.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlTransient
    private String name = "妙妙";

    @XmlElement
    public String getName() {
        return "二货";
    }

}
