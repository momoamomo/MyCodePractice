package odpart;

/*
    有一个特殊的五键键盘
    上面有A、Ctrl-C、Ctrl-X、Ctrl-V、Ctrl-A
    A键在屏幕上输出一个字母A
    Ctrl-C将当前所选的字母复制到剪贴板
    Ctrl-X将当前选择的字母复制到剪贴板并清空所选择的字母
    Ctrl-V将当前剪贴板的字母输出到屏幕
    Ctrl-A选择当前屏幕中所有字母
    注意：
      1. 剪贴板初始为空
      2. 新的内容复制到剪贴板会覆盖原有内容
      3. 当屏幕中没有字母时,Ctrl-A无效
      4. 当没有选择字母时Ctrl-C、Ctrl-X无效
      5. 当有字母被选择时A和Ctrl-V这两个输出功能的键,
         会先清空所选的字母再进行输出

    给定一系列键盘输入,
    输出最终屏幕上字母的数量

    输入描述:
       输入为一行
       为简化解析用数字12345分别代替A、Ctrl-C、Ctrl-X、Ctrl-V、Ctrl-A的输入
       数字用空格分割

    输出描述:
        输出一个数字为屏幕上字母的总数量

    示例一:
        输入:
          1 1 1
        输出:
          3

   示例二:
        输入:
          1 1 5 1 5 2 4 4
        输出:
          2

   */

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author szl
 * @date 2022/1/27  9:36
 */
public class Main五键键盘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ops = sc.nextLine();
        sc.close();
        List<String> opsList = Stream.of(ops.split(" ")).collect(Collectors.toList());
        StringBuilder show = new StringBuilder();

        String choose = "";
        String clipboard = "";

        //数字12345分别代替A、Ctrl-C、Ctrl-X、Ctrl-V、Ctrl-A的输入
        //当有字母被选择时A和Ctrl-V这两个输出功能的键,会先清空所选的字母再进行输出
        for (String op :opsList){
            switch (op){
                case "1":
                    choose = resetChoose(show,choose);
                    show.append("A");
                    break;
                case "2":
                    if (!choose.isEmpty()){
                        clipboard = choose;
                    }
                    break;
                case "3":
                    if(!choose.isEmpty()){
                        clipboard = choose;
                        choose = "";
                        show = new StringBuilder();
                    }
                    break;
                case "4":
                    choose = resetChoose(show,choose);
                    show.append(clipboard);
                    break;
                case "5":
                    if(show.length()!=0){
                        choose = show.toString();
                    }
                    break;
                default:
                    break;
            }
//            System.out.println("输出："+show + ","+"选择："+choose + "," +"剪切板："+clipboard );
//            System.out.println(show.length());
        }
        System.out.println(show.length());

    }

    private static String resetChoose(StringBuilder builder, String choose){
        if(!choose.isEmpty()){
            //todo:当前所选内容只可能为Ctrl+A全部
            builder.replace(0,choose.length(),"");
            choose="";

        }
        return choose;
    }
}
