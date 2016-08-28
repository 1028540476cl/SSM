package com.util;
import java.util.UUID;
public class VertifyUtil {
    public static String genarateEmailCode(){
    	UUID uuid=UUID.randomUUID();
    	return uuid.toString();
    }
}
