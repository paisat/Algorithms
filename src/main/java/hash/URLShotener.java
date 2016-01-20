package hash;

/**
 * Created by sarvothampai on 26/12/15.
 */
public class URLShotener {


    public static void main(String[] args) {

        URLShotener obj = new URLShotener();
        String shortenedUrl = obj.getShortenedUrl(12345);
        System.out.println(shortenedUrl);
        System.out.println(obj.getId(shortenedUrl));
    }


    public String getShortenedUrl(Integer id) {


        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        char map[] = s.toCharArray();

        StringBuilder shortUrl = new StringBuilder();

        while (id != 0) {

            shortUrl.insert(0, map[id % 62]);

            id = id / 62;
        }


        return shortUrl.toString();

    }


    public Integer getId(String shortenedUrl) {

        Integer id = 0; // initialize result

        // A simple base conversion logic
        for (int i = 0; i < shortenedUrl.length(); i++) {
            char ch = shortenedUrl.charAt(i);

            if ('a' <= ch && ch <= 'z')
                id = id * 62 + ch - 'a';
            if ('A' <= ch && ch <= 'Z')
                id = id * 62 + ch - 'A' + 26;
            if ('0' <= ch && ch <= '9')
                id = id * 62 + ch - '0' + 52;
        }
        return id;

    }


}
