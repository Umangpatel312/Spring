package com.service;

import java.util.HashMap;
import java.util.Map;

public class DigitToWordConvert {
	private static Map<Integer,String> map;
	public DigitToWordConvert() {
		// TODO Auto-generated constructor stub
		map=new HashMap<>();
	}
	public static String digitToWordCount(int n) {
        //int n=sc.nextInt();
        int temp=n;
		String s[]={"one","two","three","four","five","six","seven","eight","nine","ten","eleven",
        "twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String s2[]={"twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
        String s3[]={"hundred","thousand","lac","crore"};
        int cnt=0;
        int digit[]=new int[20];
        while(n!=0){
            digit[cnt++]=n%10;
            n=n/10;
        }
        if(cnt==0){
            //System.out.println("zero");
            if(!map.containsKey(temp)) {
            	map.put(temp, "zero");
            }
        	return "zero";
        }
        else{
            String result[]=new String[cnt];
            String postfix=null;
            //System.out.println(cnt);
            int p=-2,index=0;
            for(int i=0;i<cnt;i++,p++){
                if(digit[i]!=0){
                    //postfix=null;
                    if(p==0){
                        postfix=s3[index++];
                    }
                    else if(p>=0){
                        if(p%2==1){
                            postfix=s3[index];
                            index++;
                        }
                    }
                    //System.out.println("p: "+p+"i:"+index+" posix "+postfix);
                    if(i==0){
                        result[i]=s[digit[i]-1];
                    }
                    else if (i == 1 || i==4 || i==6 || i==8) {
                        if(digit[i]<2) {
                            result[i] = s[10 * digit[i] + digit[i - 1] - 1]+" "+(postfix==null?"":postfix);
                            if(i-2>=0){
                                result[i]+=" "+result[i-2];
                            }
                            result[i - 1] = null;
                        }
                        else {
                            if (i < 4) {
                                result[i] = s2[digit[i] - 2] + " " + (postfix == null ? "" : postfix) + " " + (result[i - 1] == null ? "" : result[i - 1]);
                            }
                            else{
                                result[i] = s2[digit[i] - 2] + " " + (result[i - 1] == null ? "" : result[i - 1]);
                            }
                        }
                    } else {
                        result[i] = s[digit[i] - 1]+" "+(postfix==null?"":postfix+" ")+ (result[i-1]==null?"":result[i-1]);
                    }
                }
            }
            //System.out.println(result[cnt-1]);
            if(!map.containsKey(temp)) {
            	map.put(temp, result[cnt-1]);
            }
            return result[cnt-1];
        }
    }
}
