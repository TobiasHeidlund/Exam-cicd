package org.example.examcicd;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

@Service
public class CryptographyService {
    public String encrypt(String plainText, String seed) {
        byte[] encoded = encode3(plainText,seed);
        String b64 = toBase64(encoded);
        return b64;
    }
    public String decrypt(String cipherText, String seed) {

        byte[] encoded = fromBase64(cipherText);
        String decoded = decode3(encoded,seed);
        return decoded;
    }

    private int generateHash(String seed){
        return seed.hashCode();
    }


    protected String toBase64(byte[] s){
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(s);

    }
    protected byte[] fromBase64(String s){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decoded =  decoder.decode(s);
        return decoded;
    }

    protected byte[] encode3(String text,String seed){
        byte[] hash = getBytes(generateHash(seed));
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        byte[] result = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = (byte) (hash[i%4]^bytes[i]);
        }
        return result;

    }

     protected String decode3 (byte[] text,String seed){
        byte[] hash = getBytes(generateHash(seed));
        byte[] result = new byte[text.length];
        for (int i = 0; i < text.length; i++) {
            result[i] = (byte) (hash[i%4]^text[i]);
        }
        return new String(result,StandardCharsets.UTF_8);
    }

    private byte[] getBytes(int hash){
        byte[] bytes = new byte[4];
        bytes[0] = (byte)(hash>>24);
        bytes[1] = (byte)(hash>>16);
        bytes[2] = (byte)(hash>>8);
        bytes[3] = (byte)hash;
        return bytes;
    }

    @Deprecated
    public ArrayList<Integer> encode2(String text,String seed){
        int hash = generateHash(seed);
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        ArrayList<Integer> result = new ArrayList<>();
        int currentInt = Byte.toUnsignedInt(bytes[0]);
        for (int i = 1; i <= bytes.length; i++) {
            if(i%4==0){
                result.add(currentInt^hash);
                currentInt=Byte.toUnsignedInt(bytes[i]);;
            }else{
                currentInt = currentInt<<8;
                currentInt+=Byte.toUnsignedInt(bytes[i]);
            }
        }
        int byteofset = (bytes.length+1)%4;

        if(byteofset!=0) {
            for (int i = 0; i < byteofset; i++) {
                currentInt = currentInt << 8;
                if ((i + 1) <= byteofset) {
                    result.add(currentInt ^ hash);
                }
            }
        }


        return result;
    }
    @Deprecated
    public String decode2 (ArrayList<Integer> text,String seed){
        int hash = generateHash(seed);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.size(); i++) {
            int withoutHash = text.get(i)^hash;
            byte[] bytes = getBytes(withoutHash);
            result.append(new String(bytes,StandardCharsets.UTF_8));
        }
        return result.toString();
    }




}
