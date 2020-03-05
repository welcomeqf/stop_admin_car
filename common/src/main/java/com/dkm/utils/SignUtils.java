package com.dkm.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

/**
 * @Author qf
 * @Date 2019/9/20
 * @Version 1.0
 */
@Slf4j
public class SignUtils {

    /**得到产生的私钥/公钥对
     * @return
     */
    public static KeyPair getKeypair(String AppId){
        //产生RSA密钥对(myKeyPair)
        KeyPairGenerator myKeyGen = null;
        try {
            myKeyGen = KeyPairGenerator.getInstance(AppId);
            myKeyGen.initialize(1024);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        KeyPair myKeyPair = myKeyGen.generateKeyPair();
        return myKeyPair;
    }
    /**根据密钥对对信息进行加密，返回公钥值
     * @param mySig
     * @param myKeyPair
     * @param infomation
     * @return
     */
    public static byte[] getpublicByKeypair(Signature mySig, KeyPair myKeyPair, byte[] infomation){
        byte[] publicInfo=null;
        try {
            //用私钥初始化签名对象
            mySig.initSign(myKeyPair.getPrivate());
            //将待签名的数据传送给签名对象
            mySig.update(infomation);
            //返回签名结果字节数组
            publicInfo = mySig.sign();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publicInfo;
    }

    /**公钥验证签名
     * @param mySig
     * @param myKeyPair
     * @param infomation
     * @param publicInfo
     * @return
     */
    public static boolean decryptBypublic(Signature mySig, KeyPair myKeyPair, String infomation, byte[] publicInfo){
        boolean verify=false;
        try {
            //使用公钥初始化签名对象,用于验证签名
            mySig.initVerify(myKeyPair.getPublic());
            //更新签名内容
            mySig.update(infomation.getBytes());
            //得到验证结果
            verify= mySig.verify(publicInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verify;
    }


}
