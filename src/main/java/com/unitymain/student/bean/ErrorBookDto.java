package com.unitymain.student.bean;

import com.unitymain.student.entity.Answer;
import com.unitymain.student.entity.ErrorBook;
import lombok.Data;

import java.util.List;

@Data
public class ErrorBookDto extends ErrorBook {
    /**
     * 答案全集
     */
    private List<Answer> answer;
    private String youAnswer = "";
    private String isTrue ="正确";
    private Boolean isHidden = true;
}
