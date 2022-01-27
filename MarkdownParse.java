// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);

            //find all matching parans and skip them
            int closeParen = openParen;
            int newBracket = markdown.indexOf("(", closeParen+1);
            int nextNewline = markdown.indexOf("\n", openParen);
            while(newBracket != -1 && newBracket<nextNewline && closeParen<nextNewline){
                //find matching bracket
                closeParen = markdown.indexOf(")", newBracket);
                newBracket = markdown.indexOf("(", closeParen);
                nextNewline = markdown.indexOf("\n", closeParen);
            }

            int lastBracket = markdown.indexOf(")", closeParen+1);
            nextNewline = markdown.indexOf("\n", lastBracket); // -1
            if(lastBracket != -1 && lastBracket<nextNewline || nextNewline == -1){
                closeParen = lastBracket;
            }
            if(closeParen>nextNewline && nextNewline != -1){
                closeParen = -1;
            }

            //if brackets aren't complete
            currentIndex++;
            if(nextOpenBracket == -1 || openParen == -1) break;
            if(nextCloseBracket == -1 || closeParen == -1) continue;
            if(openParen != nextCloseBracket + 1) continue;

            if(openParen + 1 < markdown.length() && closeParen <= markdown.length() && closeParen >= openParen + 1){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            currentIndex = closeParen + 1;
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
        if(args.length < 1) {
            System.out.println("this program needs at least one argument to run");
            return;
        }

		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}