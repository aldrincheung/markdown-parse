import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test1(){
        Path filename = Path.of("./test-file.md");
        String contents = "";
        try {
            contents = Files.readString(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void test2(){
        Path filename = Path.of("./test-file2.md");
        String contents = "";
        try {
            contents = Files.readString(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void test3(){
        Path filename = Path.of("./test-file3.md");
        String contents = "";
        try {
            contents = Files.readString(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void test4(){
        Path filename = Path.of("./test-file4.md");
        String contents = "";
        try {
            contents = Files.readString(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void test5(){
        Path filename = Path.of("./test-file5.md");
        String contents = "";
        try {
            contents = Files.readString(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void test6(){
        Path filename = Path.of("./test-file6.md");
        String contents = "";
        try {
            contents = Files.readString(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(List.of("page.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void test7(){
        Path filename = Path.of("./test-file7.md");
        String contents = "";
        try {
            contents = Files.readString(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void test8(){
        Path filename = Path.of("./test-file8.md");
        String contents = "";
        try {
            contents = Files.readString(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(List.of("a link on the first line"), MarkdownParse.getLinks(contents));
    }

    // @Test
    // public void test9(){
    //     Path filename = Path.of("./error-inducing.md");
    //     String contents = "";
    //     try {
    //         contents = Files.readString(filename);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     assertEquals(List.of("asdf", "https://www.google.com/search?q=what+is+(sdf)+asdf"), MarkdownParse.getLinks(contents));
    // }
    
}