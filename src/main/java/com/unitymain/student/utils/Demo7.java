package com.unitymain.student.utils;

import java.io.*;

public class Demo7 {
    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec("sh");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        bufferedWriter.write("ls");
        bufferedWriter.flush();
        bufferedWriter.close();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
    }
}
