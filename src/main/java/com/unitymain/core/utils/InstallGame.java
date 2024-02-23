package com.unitymain.core.utils;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class InstallGame {
    @Option(name = "-a")
    private String address;

    @Option(name = "-n")
    private String name;

    private String path;

    @Argument
    private final List<String> arguments = new ArrayList<String>();

    public static void main(String[] args) {
        new InstallGame().doMain(args);
    }

    private void doMain(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            e.printStackTrace();
        }
        path = System.getProperty("user.dir");
        path += "\\";
        if(StrUtil.isNotEmpty(name)){
            path += name;
        }
        if(StrUtil.isNotEmpty(address)){
            try {
                File file = ZipUtil.unzip(address, path, Charset.forName("GBK"));
            } catch (UtilException e) {
                try {
                    int read = System.in.read();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }
}
