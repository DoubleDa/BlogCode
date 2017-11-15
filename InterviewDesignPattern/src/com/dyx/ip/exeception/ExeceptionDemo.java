package com.dyx.ip.exeception;

public class ExeceptionDemo {
    public static void main(String[] args) {
        printInfo(test5() + "");
//        test2();
    }

    private static void printInfo(String info) {
        System.out.println(info);
    }

    /**
     * 场景一
     */
    public static void test1() {
        try {
            printInfo("test1 try");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printInfo("test1 finally");
        }
    }

    /**
     * 场景二：test2 try
     */
    public static void test2() {
        try {
            printInfo("test2 try");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printInfo("test2 finally");
        }
    }

    /**
     * 场景三：test3 try
     * test3 finally
     * 0
     */
    public static int test3() {
        try {
            printInfo("test3 try");
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printInfo("test3 finally");
        }
        return 0;
    }

    /**
     * 场景四：test4 try
     * test4 finally
     * 6
     */
    public static int test4() {
        int a = 6;
        try {
            printInfo("test4 try");
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a = 10;
            printInfo("test4 finally");
        }
        return a;
    }

    /**
     * 场景五：建议不要再finally代码块中使用return语句
     * test5 try
     * test5 finally
     * 8
     */
    public static int test5() {
        int a = 11;
        try {
            printInfo("test5 try");
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printInfo("test5 finally");
            return 8;
        }
    }
}
