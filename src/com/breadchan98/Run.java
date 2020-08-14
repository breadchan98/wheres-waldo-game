/*

Brent Buenarte
Where's Waldo Game
Just placing it here, just in case I delete my file on my local computer or something.
*/

package FinalGame;

public class Run {
    public static void main(String[] args)
    {

        String songFile = 
        "FinalGame/30 Second Timer With Jeopardy Thinking Music.wav";
        Cursor x = new Cursor();
        x.windowBorder();
        x.theTimer();
        x.titleGame();
        x.requirements();
        x.theCharacter();
        x.playMusic(songFile);
    }
}
