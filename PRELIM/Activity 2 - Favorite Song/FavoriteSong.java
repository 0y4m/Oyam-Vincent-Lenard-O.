public class FavoriteSong {
    public static void main(String[] args) {
        String[] lyrics = {
            "",
            "Cause all of the small things that you do",
            "Are what remind me why I fell for you",
            "And when we're apart, and I'm missing you",
            "I close my eyes and all I see is you",         
        };
        
        int delay = 140;
        System.out.println("My favorite part of the song is now playing...........");
        System.out.println("TITLE:THOSE EYES");
        System.out.println("Song by New West");
        System.out.print("Wait for a few second");
        Lyrics(lyrics, delay);
        System.out.print("<3");
        System.out.print("<3");
        System.out.print("<3");

    }
    private static void Lyrics(String[] lyrics, int delay) {
        try {
            for (String line:lyrics){
                System.out.print("\r");
                for(char c : line.toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(delay);
                }
                Thread.sleep(delay*10);
            }
        }
        catch
          (InterruptedException e) {
             e.printStackTrace();
        }
    }
    
}
      