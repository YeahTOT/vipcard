package com.example.vipcard.tool;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCode {

    private static final String QR_CODE_IMAGE_PATH = "C:/Users/dell/Desktop/QRCode/1.png";

    public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        return pngOutputStream.toByteArray();
    }

    public static void main(String[] args) {
        try {
            getQRCodeImage("This is my first QR Code", 350, 350);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

    }



        public String getBinaryStrFromByteArr(byte[] bArr){
            String result ="";
            for(byte b:bArr ){
                result += getBinaryStrFromByte(b);
            }
            return result;
        }
        /**
         * 把byte转化成2进制字符串
         * @param b
         * @return
         */
        public String getBinaryStrFromByte(byte b){
            String result ="";
            byte a = b; ;
            for (int i = 0; i < 8; i++){
                byte c=a;
                a=(byte)(a>>1);//每移一位如同将10进制数除以2并去掉余数。
                a=(byte)(a<<1);
                if(a==c){
                    result="0"+result;
                }else{
                    result="1"+result;
                }
                a=(byte)(a>>1);
            }
            return result;
        }

        /**
         * 把byte转化成2进制字符串
         * @param b
         * @return
         */
        public String getBinaryStrFromByte2(byte b){
            String result ="";
            byte a = b; ;
            for (int i = 0; i < 8; i++){
                result = (a % 2) + result;
                a=(byte)(a>>1);
            }
            return result;
        }

        /**
         * 把byte转化成2进制字符串
         * @param b
         * @return
         */
        public String getBinaryStrFromByte3(byte b){
            String result ="";
            byte a = b; ;
            for (int i = 0; i < 8; i++){
                result = (a % 2) + result;
                a = (byte) (a/2);
            }
            return result;
        }


}