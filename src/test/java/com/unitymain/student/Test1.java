package com.unitymain.student;

import com.unitymain.StudentApplication;
import com.unitymain.student.entity.Answer;
import com.unitymain.student.service.AnswerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = StudentApplication.class)
public class Test1 {
    @Autowired
    private AnswerService answerService;

    @Test
    public void sqlTest(){
        Answer answer = answerService.queryById(1);
        System.out.println(answer);
    }
}
