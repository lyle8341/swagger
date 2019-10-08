package com.example.demo.jline;

import java.io.IOException;
import jline.console.ConsoleReader;

/**
 * 测试jline
 * @author Lyle
 * @date 2019-10-08 上午9:56
 * @version v1.0
 * @since 1.8  
 */
public class Jline {

  public static void main(String[] args) throws IOException {
    ConsoleReader reader = new ConsoleReader();
    reader.readLine("> ");

  }
}