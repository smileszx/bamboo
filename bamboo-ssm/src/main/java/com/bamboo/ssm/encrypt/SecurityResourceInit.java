package com.bamboo.ssm.encrypt;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/30 10:42
 **/
public class SecurityResourceInit implements SecurityResource {

    public String encrypt(String securityResource) {
        char[] s = securityResource.toCharArray();
        int i = 0;
        int j =s.length -1;
        while(i<j){
            char t = s[i];
            s[i++] = s[j];
            s[j--] = t;
        }
        return String.valueOf(s);
    }
}
