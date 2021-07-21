package nowcoderHW.part1;
import java.util.Scanner;
/**
 * @author sunzhilin
 * @date 2020/9/29  16:53
 */
public class HJ21简单密码破解 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String preWord = sc.nextLine();
            StringBuilder afterWord = new StringBuilder();
            for(char ch :preWord.toCharArray()){
                if(ch>='A'&&ch<='Z'){
                    ch = upper(ch);
                }else if(ch>='a'&&ch<='c'){
                    ch = '2';
                }else if(ch>='d'&&ch<='f'){
                    ch = '3';
                }else if(ch>='g'&&ch<='i'){
                    ch = '4';
                }else if(ch>='j'&&ch<='l'){
                    ch = '5';
                }else if(ch>='m'&&ch<='o'){
                    ch = '6';
                }else if(ch>='p'&&ch<='s'){
                    ch = '7';
                }else if(ch>='t'&&ch<='v'){
                    ch = '8';
                }else if(ch>='w'&&ch<='z'){
                    ch = '9';
                }
                afterWord.append(ch);
            }
            System.out.println(afterWord.toString());
        }
    }
    //大写转换
    public static char upper(char ch){
        char low = (char)(ch-'A'+'a');
        if(low=='z'){
            return 'a';
        }else{
            return (char)(low+1);
        }
    }

}
