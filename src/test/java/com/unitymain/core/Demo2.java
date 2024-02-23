package com.unitymain.core;

public class Demo2 {
    public static void main(String[] args) {
        厄加特 厄加特 = new 厄加特();
        莎拉 莎拉 = new 莎拉();

        初始化(厄加特,"螃蟹");
        初始化(莎拉,"女枪");

        System.out.println(厄加特.别名);
        System.out.println(莎拉.别名);
    }

    public static void 初始化(英雄 英雄,String 姓名){
        英雄.别名 = 姓名;
    }
}

