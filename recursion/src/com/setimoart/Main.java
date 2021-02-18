package com.setimoart;

public class Main {

    // bug in nestParen

    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(bunnyEars2(1));
        System.out.println(bunnyEars(3));
        System.out.println(fibonacci(6));
        System.out.println(triangle(4));
        System.out.println(sumDigits(2341));
        System.out.println(count7(879077271));
        System.out.println(count8(8818789));
        System.out.println(powerN(3,3));
        System.out.println(countX("xxhxxixxXTxxcx"));
        System.out.println(countHi("xhixhixhiuhihihihihuhi"));
        System.out.println(changeXY("xhixhixxxyujxghxfxfxhxxkxjxhgxgxhxX"));
        System.out.println(changePi("pip"));
        System.out.println(noX("xfx"));
        System.out.println(array6(new int[]{1, 6, 7, 9, 4}, 2));
        System.out.println(array11(new int[]{11,11, 6, 7, 9, 4}, 0));
        System.out.println(array220(new int[]{11,110, 6, 60, 9, 4}, 0));
        System.out.println(allStar("hello"));
        System.out.println(pairStar("xxyyaascfss"));
        System.out.println(endX("xhixhixwwxxlsixjshyxhgxx") );
        System.out.println(countPairs("axbxbxsx"));
        System.out.println(countAbc("abaxxabaabaabbabc") );
        System.out.println(count11("abc11x111x1111") );
        System.out.println(stringClean("abbaabcddeeeeeeeffghttyssslll"));
        System.out.println(countHi2("ahixhihixhihi"));
        System.out.println(parenBit("xyz(abc)"));
        System.out.println(nestParen("((((xx))))"));
        System.out.println(strCount("catcowcatcatocat", "cat") );
        System.out.println(strDist("catcowcat", "cat"));
        System.out.println(groupSum(0, new int[]{8}, 8));
    }

    public static boolean groupSum(int start, int[] nums, int target) {


        if (start >= nums.length) return (target == 0);
        if (groupSum(start + 1, nums, target - nums[start])) return true;
        if (groupSum(start + 1, nums, target)) return true;


        return false;

    }

    public static int strDist(String str, String sub) {
        if(str.length() < sub.length()) return 0;
        if(str.startsWith(sub) && str.substring((str.length()-sub.length())).equals(sub)) return str.length();
        if(str.startsWith(sub)) return strDist(str.substring(0,str.length()-1), sub);

        return strDist(str.substring(1), sub);
    }

    private static int strCount(String str, String sub) {

        if(str.length() < sub.length()) return 0;
        if(str.substring(0,sub.length()).equals(sub)) return 1 + strCount(str.substring(sub.length()), sub);

        return strCount(str.substring(1), sub);
    }

    private static boolean nestParen(String str) {

        if(str.isEmpty()) return true;
        if(str.charAt(0) != '(' && str.charAt(str.length()-1) != ')') return nestParen(str.substring(1));
        if(str.charAt(0) == '(') return str.charAt(str.length()-1) == ')' && nestParen(str.substring(1,str.length()-1));
        return false;
    }

    private static String parenBit(String str) {

        if(str.charAt(0) == '(' && str.charAt(str.length()-1) == ')') return str;

        if(str.charAt(0) == '(') return parenBit(str.substring(0,str.length()-1));

        return parenBit(str.substring(1));

    }

    private static int countHi2(String str) {

        if(str.length() < 3) return 0;
        if(!str.substring(0,3).equals("xhi") && str.substring(1,3).equals("hi")) return 1 + countHi2(str.substring(3));

        return countHi2(str.substring(1));
    }

    private static String stringClean(String str) {

        if(str.length() < 2) return str;
        if(str.charAt(0) == str.charAt(1)) return stringClean(str.substring(1));

        return str.charAt(0) + stringClean(str.substring(1));
    }

    private static int count11(String str) {

        if(str.length() <= 1) return 0;
        if(str.startsWith("11")) return 1 + count11(str.substring(2));

        return count11(str.substring(1));
    }

    private static int countAbc(String str) {

        if(str.length() <= 2) return 0;
        if(str.startsWith("abc") || str.substring(0,3).equals("aba")) return 1 + countAbc(str.substring(3));

        return countAbc(str.substring(1));
    }

    private static int countPairs(String str) {

        if(str.length() <= 2) return 0;
        if(str.charAt(0) == str.charAt(2)) return 1 + countPairs(str.substring(1));

        return countPairs(str.substring(1));
    }

    private static String endX(String str) {

        if(str.isEmpty()) return "";
        if(str.charAt(0) == 'x') return endX(str.substring(1)) + "x";

        return str.charAt(0) + endX(str.substring(1));
    }

    private static String pairStar(String str) {

        if(str.length() <= 1) return str;
        if(str.charAt(0) == str.charAt(1)) return str.charAt(0) + "*" + pairStar(str.substring(1));
        return str.charAt(0) + pairStar(str.substring(1));
    }

    private static String allStar(String str) {

        if(str.length() <= 1 ) return str;

        return str.charAt(0) + "*" + allStar(str.substring(1));
    }

    private static boolean array220(int[] arr, int i) {

        if(arr.length == 0 || arr.length <= i + 1) return false;
        if(arr[i]*10 == (arr[i+1])) return true;

        return array220(arr, i+1);
    }

    private static int array11(int[] arr, int i) {
        if(arr.length == 0 || arr.length < i + 1) return 0;
        if(arr[i] == 11) return 1 + array11(arr, i+1);
        return array11(arr, i+1);
    }

    private static boolean array6(int[] arr, int i) {

        if(arr.length == 0 || arr.length < i + 1) return false;
        if(arr[i] == 6) return true;

        return array6(arr, i+1);
    }

    private static String noX(String str) {

        if(str.length() == 0) return "";
        if(str.charAt(0) == 'x') return noX(str.substring(1));

        return str.charAt(0) + noX(str.substring(1));
    }

    private static String changePi(String str) {

        if(str.length() <= 1) return str;
        if(str.substring(0,2).equals("pi")) return "3.14" + changePi(str.substring(2));
        return str.charAt(0) + changePi(str.substring(1));
    }

    private static String changeXY(String str) {

        if(str.length() == 0) return "";
        if(str.charAt(0) == 'x') return  "y" + changeXY(str.substring(1));

        return str.charAt(0) + changeXY(str.substring(1));


    }

    private static int countHi(String str) {

        if(str.length() < 2) return 0;
        if(str.charAt(0) == 'h' && str.charAt(1) == 'i') return 1 + countHi(str.substring(2));


        return  countHi(str.substring(1));

    }

    private static int countX(String str) {

        if(str.equals("x")) return 1;
        if(str.length() == 1 && str != "x") return 0;

        return countX(str.substring(0,1)) + countX(str.substring(1));
    }

    private static int powerN(int i, int j) {

        if(i == 1 || j == 0) return 1;
        if(j == 1) return i;

        return i * powerN(i, j-1);

    }

    private static int count8(int i) {
        if(i == 8) return 1;
        if(i / 10 == 0 && i != 8) return 0;
        return count8(i%10) + count8(i/10);
    }

    private static int count7(int i) {
        if(i == 7) return 1;
        if(i / 10 == 0 && i != 7) return 0;
        return count7(i%10) + count7(i/10);
    }

    private static int sumDigits(int i) {

        if(i / 10 == 0) return i;

        return (i%10) + sumDigits(i/10);
    }

    private static int triangle(int i) {
        if(i <= 0) return 0;
        if(i == 1) return 1;

        return i + triangle(i - 1);
    }


    private static int fibonacci(int i) {
        if(i <= 0) return 0;
        if(i == 1 ) return 1;
        if(i == 2 ) return 1;

        return fibonacci(i-1) + fibonacci(i-2);
    }

    private static int bunnyEars(int i) {
        if(i < 1) return 0;
        if(i == 1) return 2;
        return 2 + bunnyEars(i-1);
    }

    private static int bunnyEars2(int i) {
        if(i < 1) return 0;

        if(i%2 == 0) return 3 + bunnyEars2(i-1);

        return 2 + bunnyEars2(i-1);
    }

    public static int factorial(int n) {

        if(n < 1) return 0;
        if(n == 1) return 2;
        if(n == 2) return 3;

        return n * factorial(n -1);
    }
}
