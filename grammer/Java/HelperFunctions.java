import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class HelperFunctions {
    public static void main(String[] args) throws Exception {
        //sort Array
        int[] a = new int[] { 4, 6, 2, 1 };
        Arrays.sort(a);
        System.out.println(Arrays.toString(a)); // 1 2 4 6


        //sort Collections
        Integer[] aI = new Integer[] { 4, 6, 2, 1 }; // Arrays.asList(int[]) 是不支持的！！！！！
        List<Integer> l = Arrays.asList(aI); // List<int>
        Collections.sort(l, (x,y) -> y - x );
        System.out.println(Arrays.toString(l.toArray())); //6 4 2 1


        //foreach
        int sum = 0;
        for (int i : a) {  //both
            sum += i;
        }
        for (Integer I : aI) {
            sum -= I;
        }
        if (sum != 0)
            throw new Exception("foreach error"); //remember to use new 

        // BigInteger, from math.*
        BigInteger bi = new BigInteger("778899");
        bi = bi.multiply(BigInteger.valueOf(10));  //it's like a string, does not support inplace updating
        System.out.println(bi);  //7788990

        // Max, Min
        System.out.printf("max: %s min %d:\n", Math.max(0, 10) ,  Integer.min(0, 10));  //10, 0
        // String does not support min and max!!!!!

        // MAX ,MIN value
        //  two values
        System.out.printf("INT_MAX_VALUE:%d, INT_MIN_VALUE:%d\n", Integer.MAX_VALUE, Integer.MIN_VALUE);
        //  values
        System.out.printf("collections max: %d\n", Collections.max(l)); // no array supported

        // numeral system
        System.out.println(Integer.toBinaryString(11)); //decimal to binary, 1011
        System.out.println(Integer.parseInt("ff", 16)); //hex to decimal, 255 

        // String, 
        // 长度是length方法！
        String baseStr = " 12345678abc ";
        baseStr = baseStr.strip();
        System.out.printf("base:%s, pos of abc: %d, pos of abd: %d, pos of 123 from pos 1: %d \n", baseStr,
                baseStr.indexOf("abc"), baseStr.indexOf("abd"), baseStr.indexOf("123", 1));
        
        String rstr = baseStr.replace("123", "abc"); //abc45678abc
        //  startsWith Split
        if (rstr.startsWith("abc")) {
            System.out.println(Arrays.toString(rstr.split("c")));  //ab 45678ab
        } 
        
        // toLowerCase, toUpperCase, subString(start_index, end_index), will throw exception if end_index > length()!!!
        System.out.println("Abc".toUpperCase().substring(1,3));
        

        // Stringbuilder ，  StringBuffer(thread-safe)
        
    }
}
