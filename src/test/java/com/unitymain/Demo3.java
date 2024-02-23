package com.unitymain;

public class Demo3 {
    public static void main(String[] args) {
        int h = 14712960;
        byte h16 = (byte) (h>>16);
        byte h8 = (byte) (h >>8);
        byte h0 = (byte) h;
        for(int i=0;i<=15;i++)
        {
            byte k16 = (byte) (h16|i);
            for(int j=0;j<=63;j++){
                byte k8 = (byte) (h8|j);
                for(int k=0;k<=63;k++){
                    byte k0 = (byte) (h0|k);
                    byte[] bytes = new byte[3];
                    bytes[0] = k16;
                    bytes[1] = k8;
                    bytes[2] =  k0;
                    String s = new String(bytes);
                    if(k%40==0){
                        System.out.println();
                    }
                    System.out.print(s+" ");
                }

            }

        }
    }

    public void demo1(){
        int h = 49280;
        byte h8 = (byte) (h >>8);
        byte h0 = (byte) h;
        for(int i=0;i<=31;i++)
        {
            byte k8 = (byte) (h8|i);
            for(int j=0;j<=63;j++){
                byte k0 = (byte) (h0|j);
                byte[] bytes = new byte[2];
                bytes[0] = k8;
                bytes[1] =  k0;
                String s = new String(bytes);
                if(j%40==0){
                    System.out.println();
                }
                System.out.print(s+" ");
            }

        }
    }
}
