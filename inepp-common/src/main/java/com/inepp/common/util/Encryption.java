package com.inepp.common.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: Encryption
 * @Author
 * @Date 2022/3/26
 */
public class Encryption {

    private static volatile Encryption instance;
    private MessageDigest md;





    private final char[] HEX_CHARS ={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    private Encryption() {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public static Encryption getInstance(){
        if (instance==null){
            synchronized (Encryption.class){
                if (instance==null){
                    instance = new Encryption();
                }
            }
        }

        return instance;

    }

    public  String encrypt(String oldString){
        md.update(oldString.getBytes(StandardCharsets.UTF_8));

        byte[] bytes = md.digest();

        char[] chars = new char[32];



        for (int i = 0 ;i<chars.length;i=i+2){
            byte b = bytes[i/2];


            chars[i] = HEX_CHARS[(b >>> 0x4) & 0xf];

            chars[i+1] = HEX_CHARS[b & 0xf];
        }



        return  new String(chars);
    }

    public static void main(String[] args) {
        String s = Encryption.getInstance().encrypt("123");
        System.out.println(s);
    }





}
