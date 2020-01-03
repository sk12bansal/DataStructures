import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import java.lang.Class;
import java.util.Map;

public class CountWaysMatrix {
    public static void main(String args[]) {
        List<String> list = Arrays.asList("Ram","Shyam","Sohan","Rohan","Mohan");
        String search = findName(list);
        System.out.println(search);

        String string = "Stack Overflow\n" +
                "Products\n" +
                "Customers\n" +
                "Use cases\n" +
                "Search…\n" +
                "Log in Sign up\n" +
                "By using our site, you acknowledge that you have read and understand our Cookie Policy, Privacy Policy, and our Terms of Service.\n" +
                "\n" +
                "How are we doing? Please help us improve Stack Overflow. Take our short survey\n" +
                "Home\n" +
                "PUBLIC\n" +
                "Stack Overflow\n" +
                "Tags\n" +
                "Users\n" +
                "Jobs\n" +
                "TEAMS\n" +
                "What’s this?\n" +
                "First 25 Users Free\n" +
                "\n" +
                "How are we doing?\n" +
                "Take our short survey\n" +
                "Bytes of a string in Java\n" +
                "Ask Question\n" +
                "Asked 9 years ago\n" +
                "Active 10 months ago\n" +
                "Viewed 227k times\n" +
                "\n" +
                "157\n" +
                "\n" +
                "\n" +
                "57\n" +
                "In Java, if I have a String x, how can I calculate the number of bytes in that string?\n" +
                "\n" +
                "java string\n" +
                "shareimprove this question\n" +
                "edited Feb 7 at 17:07\n" +
                "\n" +
                "0xCursor\n" +
                "2,18444 gold badges1111 silver badges2626 bronze badges\n" +
                "asked Dec 8 '10 at 8:49\n" +
                "\n" +
                "Green\n" +
                "1,57922 gold badges1010 silver badges66 bronze badges\n" +
                "13\n" +
                "One might want to use a String to represent the body of an HTTP response and use the size to set the \"Content-Length\" header, which is specified in octets/bytes not characters. w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.13 – iX3 Dec 18 '12 at 20:58\n" +
                "3\n" +
                "A database column may have length restriction in bytes, e.g. VARCHAR2 (4000 BYTE) in Oracle. One might want to know the byte count of a String in desired encoding to know if the String would fit. – Somu Jun 4 '13 at 6:09 \n" +
                "@iX3 Exactly the same as I was trying to do. – MC Emperor Jun 28 '13 at 10:47\n" +
                "1\n" +
                "I believe there are two possible interpretations of this question, depending on the intent: One is \"how much memory does my String use?\". The answer to that is provided by @roozbeh below (maybe modulo VM subtleties like compressed OOPS). The other is, \"if I convert the string to a byte[] how much memory would that byte array use?\". This is the question that is answered by Andrzej Doyle. The difference can be large: \"Hello World\" in UTF8 is 11 bytes, but the String (per @roozbeh) is 50 bytes (if my math is right). – L. Blanc Jun 19 '16 at 13:13\n" +
                "I should have added that the 11 bytes doesn't include the overhead of the byte[] object that holds them, so the comparison is somewhat misleading. – L. Blanc Jun 19 '16 at 13:27\n" +
                "add a comment\n" +
                "7 Answers\n" +
                "activeoldestvotes\n" +
                "\n" +
                "272\n" +
                "\n" +
                "A string is a list of characters (i.e. code points). The number of bytes taken to represent the string depends entirely on which encoding you use to turn it into bytes.\n" +
                "\n" +
                "That said, you can turn the string into a byte array and then look at its size as follows:\n" +
                "\n" +
                "// The input string for this test\n" +
                "final String string = \"Hello World\";\n" +
                "\n" +
                "// Check length, in characters\n" +
                "System.out.println(string.length()); // prints \"11\"\n" +
                "\n" +
                "// Check encoded sizes\n" +
                "final byte[] utf8Bytes = string.getBytes(\"UTF-8\");\n" +
                "System.out.println(utf8Bytes.length); // prints \"11\"\n" +
                "\n" +
                "final byte[] utf16Bytes= string.getBytes(\"UTF-16\");\n" +
                "System.out.println(utf16Bytes.length); // prints \"24\"\n" +
                "\n" +
                "final byte[] utf32Bytes = string.getBytes(\"UTF-32\");\n" +
                "System.out.println(utf32Bytes.length); // prints \"44\"\n" +
                "\n" +
                "final byte[] isoBytes = string.getBytes(\"ISO-8859-1\");\n" +
                "System.out.println(isoBytes.length); // prints \"11\"\n" +
                "\n" +
                "final byte[] winBytes = string.getBytes(\"CP1252\");\n" +
                "System.out.println(winBytes.length); // prints \"11\"\n" +
                "So you see, even a simple \"ASCII\" string can have different number of bytes in its representation, depending which encoding is used. Use whichever character set you're interested in for your case, as the argument to getBytes(). And don't fall into the trap of assuming that UTF-8 represents every character as a single byte, as that's not true either:\n" +
                "\n" +
                "final String interesting = \"\\uF93D\\uF936\\uF949\\uF942\"; // Chinese ideograms\n" +
                "\n" +
                "// Check length, in characters\n" +
                "System.out.println(interesting.length()); // prints \"4\"\n" +
                "\n" +
                "// Check encoded sizes\n" +
                "final byte[] utf8Bytes = interesting.getBytes(\"UTF-8\");\n" +
                "System.out.println(utf8Bytes.length); // prints \"12\"\n" +
                "\n" +
                "final byte[] utf16Bytes= interesting.getBytes(\"UTF-16\");\n" +
                "System.out.println(utf16Bytes.length); // prints \"10\"\n" +
                "\n" +
                "final byte[] utf32Bytes = interesting.getBytes(\"UTF-32\");\n" +
                "System.out.println(utf32Bytes.length); // prints \"16\"\n" +
                "\n" +
                "final byte[] isoBytes = interesting.getBytes(\"ISO-8859-1\");\n" +
                "System.out.println(isoBytes.length); // prints \"4\" (probably encoded \"????\")\n" +
                "\n" +
                "final byte[] winBytes = interesting.getBytes(\"CP1252\");\n" +
                "System.out.println(winBytes.length); // prints \"4\" (probably encoded \"????\")\n" +
                "(Note that if you don't provide a character set argument, the platform's default character set is used. This might be useful in some contexts, but in general you should avoid depending on defaults, and always use an explicit character set when encoding/decoding is required.)\n" +
                "\n" +
                "shareimprove this answer\n" +
                "edited May 22 '14 at 21:15\n" +
                "\n" +
                "worc\n" +
                "2,25533 gold badges2121 silver badges2929 bronze badges\n" +
                "answered Dec 8 '10 at 8:52\n" +
                "\n" +
                "Andrzej Doyle\n" +
                "92.5k2828 gold badges180180 silver badges220220 bronze badges\n" +
                "1\n" +
                "so again if i use getBytes().it will give me the length same as x.length am i wrong because i am not sure – Green Dec 8 '10 at 9:21\n" +
                "4\n" +
                "@Green Ash The length of the byte array -- getBytes() -- and x.length MAY be equal but is not guaranteed to be so. It will be equal if all the characters are represented by a single byte each. This will always hold true for character encodings that use a single byte per character (or less), such as ISO-8859-1. UTF-8 uses either 1 or 2 bytes, so it depends on the exact characters in the string. Then there are character encodings that always use two bytes per character. – Kris Dec 8 '10 at 9:38\n" +
                "i like your answer :) , so they might in somehow be the same but not always am i right? o.k. then is it ok to use the method without the parameter because it causing to me an error!! – Green Dec 8 '10 at 9:44 \n" +
                "@Green the point is that number of bytes is not always the same as the number of characters. The number of bytes depends on the character encoding that's used. You'll have to know which character encoding you're going to use and take that into account. What error are you getting? If you just use getBytes() it will use the default character encoding of your system. – Jesper Dec 8 '10 at 10:51 \n" +
                "@Kris - actually, UTF-8 uses 1, 2 or 3 bytes per code point. – Stephen C Dec 8 '10 at 10:56 \n" +
                "show 6 more comments\n" +
                "\n" +
                "57\n" +
                "\n" +
                "If you're running with 64-bit references:\n" +
                "\n" +
                "sizeof(string) = \n" +
                "8 + // object header used by the VM\n" +
                "8 + // 64-bit reference to char array (value)\n" +
                "8 + string.length() * 2 + // character array itself (object header + 16-bit chars)\n" +
                "4 + // offset integer\n" +
                "4 + // count integer\n" +
                "4 + // cached hash code\n" +
                "In other words:\n" +
                "\n" +
                "sizeof(string) = 36 + string.length() * 2\n" +
                "On a 32-bit VM or a 64-bit VM with compressed OOPs (-XX:+UseCompressedOops), the references are 4 bytes. So the total would be:\n" +
                "\n" +
                "sizeof(string) = 32 + string.length() * 2\n" +
                "This does not take into account the references to the string object.\n" +
                "\n" +
                "shareimprove this answer\n" +
                "answered Aug 3 '13 at 7:49\n" +
                "\n" +
                "roozbeh\n" +
                "65955 silver badges33 bronze badges\n" +
                "4\n" +
                "I was assuming the question was about the number of bytes allocated in memory for a String object. If the question is about the number of bytes required to serialize the String, as others have pointed out, it depends on the encoding used. – roozbeh Aug 13 '13 at 17:02\n" +
                "1\n" +
                "Source for ur answer ? Thanks – mavis Feb 6 '14 at 8:02\n" +
                "Note: sizeof should be multiple of 8. – dieter Sep 30 '16 at 14:09\n" +
                "add a comment\n" +
                "\n" +
                "18\n" +
                "\n" +
                "The pedantic answer (though not necessarily the most useful one, depending on what you want to do with the result) is:\n" +
                "\n" +
                "string.length() * 2\n" +
                "Java strings are physically stored in UTF-16BE encoding, which uses 2 bytes per code unit, and String.length() measures the length in UTF-16 code units, so this is equivalent to:\n" +
                "\n" +
                "final byte[] utf16Bytes= string.getBytes(\"UTF-16BE\");\n" +
                "System.out.println(utf16Bytes.length);\n" +
                "And this will tell you the size of the internal char array, in bytes.\n" +
                "\n" +
                "Note: \"UTF-16\" will give a different result from \"UTF-16BE\" as the former encoding will insert a BOM, adding 2 bytes to the length of the array.\n" +
                "\n" +
                "shareimprove this answer\n" +
                "answered Dec 8 '10 at 12:44\n" +
                "\n" +
                "finnw\n" +
                "42.9k1818 gold badges128128 silver badges206206 bronze badges\n" +
                "Roozbeh's answer is better, because it takes the other bytes into account as well. – Lodewijk Bogaards Mar 30 '18 at 8:46\n" +
                "@finnw Are you sure that the encoding is UTF-16BE and not UTF-16? According to the String class Javadoc (docs.oracle.com/javase/6/docs/api/java/lang/String.html), \"A String represents a string in the UTF-16 format...\". – entpnerd Apr 12 at 19:28\n" +
                "add a comment\n" +
                "\n" +
                "15\n" +
                "\n" +
                "According to How to convert Strings to and from UTF8 byte arrays in Java:\n" +
                "\n" +
                "String s = \"some text here\";\n" +
                "byte[] b = s.getBytes(\"UTF-8\");\n" +
                "System.out.println(b.length);\n" +
                "shareimprove this answer\n" +
                "edited May 23 '17 at 12:03\n" +
                "\n" +
                "Community♦\n" +
                "111 silver badge\n" +
                "answered Dec 8 '10 at 8:51\n" +
                "\n" +
                "Boris Pavlović\n" +
                "53.5k2424 gold badges109109 silver badges138138 bronze badges\n" +
                "but excuse me when i compile your code it gives me an error ; because of the parameter \"UTF-8\".where when i pass an empty parameter it gives me the length same as x.length . i misunderstand the concept. help please – Green Dec 8 '10 at 9:19 \n" +
                "@Green Ash, what version of Java do you have? – Buhake Sindi Dec 8 '10 at 9:26\n" +
                "@Green Ash, what exception are you getting? – Buhake Sindi Dec 8 '10 at 9:48 \n" +
                "1\n" +
                "to be clear this is the output: test.java:11: unreported exception java.io.UnsupportedEncodingException; must be caught or declared to be thrown byte[] b = s.getBytes(\"UTF-8\"); ^ 1 error Process completed. – Green Dec 8 '10 at 9:50\n" +
                "2\n" +
                "@Green, try: s.getBytes(Charset.forName(\"UTF-8\")). – james.garriss Oct 8 '14 at 18:45\n" +
                "add a comment\n" +
                "\n" +
                "9\n" +
                "\n" +
                "A String instance allocates a certain amount of bytes in memory. Maybe you're looking at something like sizeof(\"Hello World\") which would return the number of bytes allocated by the datastructure itself?\n" +
                "\n" +
                "In Java, there's usually no need for a sizeof function, because we never allocate memory to store a data structure. We can have a look at the String.java file for a rough estimation, and we see some 'int', some references and a char[]. The Java language specification defines, that a char ranges from 0 to 65535, so two bytes are sufficient to keep a single char in memory. But a JVM does not have to store one char in 2 bytes, it only has to guarantee, that the implementation of char can hold values of the defines range.\n" +
                "\n" +
                "So sizeof really does not make any sense in Java. But, assuming that we have a large String and one char allocates two bytes, then the memory footprint of a String object is at least 2 * str.length() in bytes.\n" +
                "\n" +
                "shareimprove this answer\n" +
                "answered Dec 8 '10 at 9:26\n" +
                "\n" +
                "Andreas_D\n" +
                "101k1111 gold badges155155 silver badges237237 bronze badges\n" +
                "add a comment\n" +
                "\n" +
                "5\n" +
                "\n" +
                "There's a method called getBytes(). Use it wisely .\n" +
                "\n" +
                "shareimprove this answer\n" +
                "answered Dec 8 '10 at 8:52\n" +
                "\n" +
                "Andrei Ciobanu\n" +
                "10.6k2020 gold badges6666 silver badges111111 bronze badges\n" +
                "16\n" +
                "Wisely = don't use the one without a character set parameter. – Thilo Dec 8 '10 at 8:58\n" +
                "Why? Is this an issue if i configure my environment to run with UTF8 encoding? – ziggy Feb 26 '14 at 18:38\n" +
                "getBytes will also create and copy the array of bytes, so if you're talking long strings, this operation could get pricey. – ticktock Jan 14 '15 at 22:41\n" +
                "add a comment\n" +
                "\n" +
                "4\n" +
                "\n" +
                "Try this :\n" +
                "\n" +
                "Bytes.toBytes(x).length\n" +
                "Assuming you declared and initialized x before\n" +
                "\n" +
                "shareimprove this answer\n" +
                "answered Dec 8 '10 at 9:22\n" +
                "\n" +
                "ant\n" +
                "20.3k3131 gold badges117117 silver badges169169 bronze badges\n" +
                "2\n" +
                "Is this part of the standard Java library? I can't find the Bytes class. – Kröw Jul 4 '18 at 20:33\n" +
                "add a comment\n" +
                "Your Answer\n" +
                "Sign up or log in\n" +
                " Sign up using Google\n" +
                " Sign up using Facebook\n" +
                " Sign up using Email and Password\n" +
                "Post as a guest\n" +
                "Name\n" +
                "Email\n" +
                "Required, but never shown\n" +
                "\n" +
                "Post Your Answer\n" +
                "By clicking “Post Your Answer”, you agree to our terms of service, privacy policy and cookie policy\n" +
                "\n" +
                "Not the answer you're looking for? Browse other questions tagged java string or ask your own question.\n" +
                "Blog\n" +
                "What senior developers can learn from beginners\n" +
                "A holiday carol for coders\n" +
                "Featured on Meta\n" +
                "Update: an agreement with Monica Cellio\n" +
                "Why was I just awarded a bunch of “Announcer” badges?\n" +
                "We’re lowering the close/reopen vote threshold from 5 to 3 for good\n" +
                "Amazon\n" +
                "Amazon\n" +
                "\n" +
                "Bengaluru, India\n" +
                "\n" +
                "E-Commerce, RetailPublic10k+ people\n" +
                "Recommended java jobs\n" +
                "\n" +
                "Software Development Engineer ||\n" +
                "\n" +
                "javac++\n" +
                "Software Development Manager\n" +
                "\n" +
                "javac++\n" +
                "Senior Software Development Engineer\n" +
                "\n" +
                "javac#\n" +
                "View all 7 job openings!\n" +
                "Linked\n" +
                "3\n" +
                "How many Character in 1 MB .txt file?\n" +
                "228\n" +
                "How to convert Strings to and from UTF8 byte arrays in Java\n" +
                "12\n" +
                "Size of notification payload in GCM/FCM\n" +
                "7\n" +
                "Java : Char vs String byte size .\n" +
                "5\n" +
                "How do i know if my GCM Message is small enough (< 4kb) to send? (How to get size of String?)\n" +
                "3\n" +
                "Calculate Json Array Size In Kb or Mb in android?\n" +
                "1\n" +
                "Get bytes from string\n" +
                "1\n" +
                "What is the difference between 65 and the letter A in binary?\n" +
                "2\n" +
                "Java automatic-login to website. Does not work\n" +
                "0\n" +
                "Spark Tuple get details/rdd per key\n" +
                "see more linked questions…\n" +
                "Related\n" +
                "6286\n" +
                "What is the difference between String and string in C#?\n" +
                "3893\n" +
                "How do I read / convert an InputStream into a String in Java?\n" +
                "2137\n" +
                "How do I get a consistent byte representation of strings in C# without manually specifying an encoding?\n" +
                "2021\n" +
                "Convert bytes to a string\n" +
                "3591\n" +
                "How do I make the first letter of a string uppercase in JavaScript?\n" +
                "4121\n" +
                "How to replace all occurrences of a string?\n" +
                "7430\n" +
                "How to check whether a string contains a substring in JavaScript?\n" +
                "2900\n" +
                "How do I convert a String to an int in Java?\n" +
                "6656\n" +
                "Why is subtracting these two times (in 1927) giving a strange result?\n" +
                "23742\n" +
                "Why is processing a sorted array faster than processing an unsorted array?\n" +
                "Hot Network Questions\n" +
                "Why is a leading digit not counted as a significant figure if it is a 1?\n" +
                "Why was there a negative temperature anomaly between 1950 to 1980?\n" +
                "Which non-stop passenger flight connects two cities with the largest temperature difference?\n" +
                "Can I use NULL as substitution for the value of 0?\n" +
                "What are these containers called for waste?\n" +
                "Why do some groups of tourists include someone carrying a banner?\n" +
                "Is the US a welfare state?\n" +
                "How do I write romance if I've never been in love?\n" +
                "Is this homebrew Weaver Wizard subclass balanced?\n" +
                "How are short passwords not safe if you limit the number of attempts?\n" +
                "Should I buy this bike with a dent in the top tube? Is it safe?\n" +
                "Distinguish smooth affine algebraic group by its underlying variety\n" +
                "Can I run CAT6 FTP cables parallel to electrical cable\n" +
                "How do I search specified text in files on my Mac that are less than 20kb?\n" +
                "Adding fruits to a basket, allowing selection from ID and name\n" +
                "Were Mac systems faster than Windows in processing performance?\n" +
                "FIDE rules when opponent accidentally promotes to your Queen\n" +
                "How does increasing the size of a jet engine make it more fuel efficient?\n" +
                "Name a list with Table\n" +
                "What is this plant? Looks like a brassica, if so, what type?\n" +
                "Repair frayed electrical wire with strain-relief stopper\n" +
                "Can The Chief Justice Excuse Senators From The Jury In A Presidential Impeachment?\n" +
                "Losing to low rated players\n" +
                "How fast does an antimatter bullet need to move to pierce rather than explode?\n" +
                " Question feed\n" +
                "\n" +
                "STACK OVERFLOW\n" +
                "Questions\n" +
                "Jobs\n" +
                "Developer Jobs Directory\n" +
                "Salary Calculator\n" +
                "Help\n" +
                "Mobile\n" +
                "Disable Responsiveness\n" +
                "PRODUCTS\n" +
                "Teams\n" +
                "Talent\n" +
                "Advertising\n" +
                "Enterprise\n" +
                "COMPANY\n" +
                "About\n" +
                "Press\n" +
                "Work Here\n" +
                "Legal\n" +
                "Privacy Policy\n" +
                "Contact Us\n" +
                "STACK EXCHANGE\n" +
                "NETWORK\n" +
                "Technology\n" +
                "Life / Arts\n" +
                "Culture / Recreation\n" +
                "Science\n" +
                "Other\n" +
                "Blog\n" +
                "Facebook\n" +
                "Twitter\n" +
                "LinkedIn\n" +
                "site design / logo © 2019 Stack Exchange Inc; user contributions licensed under cc by-sa 4.0 with attribution required. rev 2019.12.20.35703";
        final byte[] utf16Bytes;
        final long  MB = 1024L * 1024L;
        try {
            utf16Bytes = string.getBytes("UTF-16BE");
            System.out.println(utf16Bytes.length/MB);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static String findName(List<String> list) {
        String str1 = "null";
        /*for(String str : list){
            if(str.equals("Shyam")){
                str1= str;
                break;
            }
        }*/
        Map<Integer,Integer> mp = new HashMap<>();
        list.forEach(item-> {
           System.out.println(item + " suraj");
        });
        return str1;
    }
}
