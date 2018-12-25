import java.util.Arrays;

public class WithThreading extends Thread{
	char charStrings[];
	int id;
		// run() method contains the code that is executed by the thread.
	    WithThreading(int id, char[] charStrings) {
	    	this.charStrings = charStrings;
	    	this.id = id;
	    }
	    @Override
	    public void run() {
	    	this.countCharacters(this.charStrings,this.id);
	    }
	    
	    static void countCharacters(char[] inputchar,int id) {
			for (int i=0;i<inputchar.length;i++)
			{
				Main.wThreading[id][inputchar[i]]++;
			}
			System.out.print(id);
		}
}
