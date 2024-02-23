package com.unitymain.core.utils;

import cn.hutool.core.util.HexUtil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class AwakeComputer {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getByName("255.255.255.255");
        int port = 9;
        String magicPackage = "ffffffffffff";
        for (int i = 0; i < 16; i++) {
            magicPackage += "50ebf6823db6";
        }
        byte[] bytes = HexUtil.decodeHex(magicPackage);

        MulticastSocket multicastSocket = new MulticastSocket(port);
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, port);
        multicastSocket.send(datagramPacket);
        multicastSocket.close();
        System.out.println("发送成功");
    }
}
