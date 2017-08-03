package com.google.codejame;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rigel on 3/14/17.
 * <p>
 * <p>
 * https://code.google.com/codejam/contest/7234486/dashboard
 */
public class IntegeregexTest {


    @Test
    public void testSimple() throws Exception {


//        this.rootLocation = Paths.get(this.getClass().ge);


        List<String> lines = getFile("codejam/A-large-practice.in");

        // show data
//        lines.stream().forEach(System.err::println);




//        Float.MAX_VALUE
        long cntTest = 0;
        String ex = "";
        Long min = 0l;
        Long max = 0l;
        for (int i = 0; i < lines.size(); i++) {
            String s = lines.get(i);



           // print log
            boolean isDebug = false;
            if(isDebug){

                System.err.println(s);
            }

            if ((i == 0)) {
                cntTest = Integer.valueOf(s);
                continue;
            }

            if ((i % 2 == 0)) {

                ex = s;
                System.out.printf("expression  : %s \n", ex);

                int matchCnt = 0;
                Pattern compile = Pattern.compile(ex);
                for (long j = min; j < max; j++) {

                    long intVal = j;
                    Matcher matcher = compile.matcher(String.valueOf(intVal));

                    int flag = 0;
                    while (matcher.find()) {


//                        System.out.println(matcher.groupCount());
//                        System.out.println(matcher.group(0));
//                    System.out.println(matcher.group(1));
//                    System.out.println(matcher.group(2));
                        flag = flag + 1;
                    }
                    matchCnt =  flag;

                }
                System.out.println("match cnt  : " + matchCnt );


            } else {
                String[] minMax = s.split("\\s");
                min = Long.valueOf(minMax[0]);
                max = Long.valueOf(minMax[1]);
                System.out.printf(" min : %s , minx : %s \n", min, max);


                //
            }


        }


    }


    private List<String> getFile(String file) {

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(file);
        List<String> lines = null;
        try {
            lines = IOUtils.readLines(resourceAsStream);
//            fieString = IOUtils.toString(resourceAsStream, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Gson gson = new Gson();
//        return gson.fromJson(theString2, Map.class);
        return lines;
    }
}
