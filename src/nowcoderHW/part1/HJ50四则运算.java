package nowcoderHW.part1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 * <p>
 * 输入描述：
 * 输入一个算术表达式
 * <p>
 * 输出描述：
 * 得到计算结果
 * <p>
 * 示例1
 * 输入：
 * 3+2*{1+2*[-4/(8-6)+7]}
 * 复制
 * 输出：
 * 25
 */


/**
 * @author sunzhilin
 * @date 2021/7/19  16:32
 */
public class HJ50四则运算 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(getResult(input));
            //解法二：
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            Object result = engine.eval(input);
            System.out.println(result.toString());
        }
        sc.close();
    }

    private static int getResult(String input) {
        Pattern pattern = Pattern.compile("((?<![\\d)])-?\\d+(\\.\\d+)?|[+\\-*/()])");
        input = input.replaceAll("[{\\[]", "(").replaceAll("[}\\]]", ")");
        Matcher matcher = pattern.matcher(input);
        Stack<String> number = new Stack<>();
        Stack<String> operator = new Stack<>();
        operator.push("null");

        while (matcher.find()) {
            String temp = matcher.group();
            if (temp.matches("[()]")) {
                if ("(".equals(temp)) {
                    operator.push("(");
                } else {
                    String b = null;
                    while (!("(").equals(b = operator.pop())) {
                        number.push(calculate(b, number.pop(), number.pop()));
                    }
                }
            } else if (temp.matches("[+\\-*/]")) {
                if (getPriority(temp) > getPriority(operator.peek())) {
                    operator.push(temp);
                } else {
                    while (getPriority(temp) <= getPriority(operator.peek())) {
                        number.push(calculate(operator.pop(), number.pop(), number.pop()));
                    }
                    operator.push(temp);
                }
            } else {
                number.push(temp);
            }
        }
        while (number.size() > 1) {
            number.push(calculate(operator.pop(), number.pop(), number.pop()));
        }
        return (int) Double.parseDouble(number.pop());
    }


    /**
     * 计算算数表达式的结果
     *
     * @param b  运算符
     * @param a1 操作数1
     * @param a2 操作数2
     * @return
     */
    private static String calculate(String b, String a1, String a2) {
        double result = 0;
        double d1 = Double.parseDouble(a2);
        double d2 = Double.parseDouble(a1);
        switch (b) {
            case "+":
                result = d1 + d2;
                break;
            case "-":
                result = d1 - d2;
                break;
            case "*":
                result = d1 * d2;
                break;
            case "/":
                result = d1 / d2;
                break;
        }
        return result + "";
    }

    /**
     * 获取运算符的优先级
     *
     * @param b
     * @return
     */
    private static int getPriority(String b) {
        switch (b) {
            case "null":
                return 1;
            case "(":
                return 2;
            case "+":
            case "-":
                return 3;
            case "*":
            case "/":
                return 4;
        }
        return 0;
    }
}
