package com.inepp.common.startup;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName: BrowserStarup
 * @Author
 * @Date 2022/3/19
 */

public class BrowserStartup implements CommandLineRunner {



    @Override
    public  void run(String...args)  {
        try {
            String cmd = "cmd /c start \"\" ";
            String chromePath = "\"C:/Users/strve/AppData/Local/Google/Chrome/Application/chrome.exe\"";
            Runtime.getRuntime().exec(cmd+chromePath+" http://localhost:"+args[0]+"/doc.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
