package cn.teach.common.util;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * cn.teach.common.util description
 *
 * @author MaZhuli
 * @version 1.0.0
 * @since 2021/2/27
 */
public class IKSUtil {
    public static List<String> getStringList(String text) throws Exception{
        //独立Lucene实现
        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re, false);
        Lexeme lex;
        List<String> s = new ArrayList<>();
        while ((lex = ik.next()) != null) {
            s.add(lex.getLexemeText());
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        List<String> aa = getStringList("阿道夫劳动法乐课力发牢骚道孚龙胆飞");
        System.out.println(aa);

        /*String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        StringReader re = new StringReader(str);
        Result parse = ToAnalysis.parse(str);
        List<Term> terms = parse.getTerms();
        for (Term term : terms) {
            System.out.println(term.getNatureStr());
        }*/
    }
}
