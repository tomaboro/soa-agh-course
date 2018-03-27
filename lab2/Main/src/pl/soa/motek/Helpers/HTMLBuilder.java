package pl.soa.motek.Helpers;

import java.io.PrintWriter;

public class HTMLBuilder {
    public static void createBeginning(PrintWriter out, String title){
        out.print("<!doctype html>\n" +
                "<html lang=\"pl\">\n" +
                "\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "\n" +
                "  <title>" + title + "</title>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>");
    }

    public static void createEnding(PrintWriter out){
        out.print("</body>\n" +
                "\n" +
                "</html>");
    }
}
