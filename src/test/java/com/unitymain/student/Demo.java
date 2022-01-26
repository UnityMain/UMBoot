package com.unitymain.student;

public final class Demo {
    public static void main(String[] args) {
        String str = "1123";
        // Jdk12之后
        switch (str) {
            case "A", "C" -> System.out.println("A || C");
            case "B" -> System.out.println("B");
            default -> System.out.println("default");
        }

        String sql2 = """
            select
                *
            from
                ord_order_item ooi
            left join ord_order oo on
                ooi.order_id = oo.id
            where
                oo.order_code = 'TEST1001'
            order by
                oo.id desc
        """;
    }
}
