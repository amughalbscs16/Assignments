import java.util.Arrays;

public class WithoutThreading implements CountingCharacters {
	int countcharacters[] = new int[128];
	int[] countCharacters(char[] inputchar) {
		Arrays.fill(this.countcharacters, 0);
		for (int i=0;i<inputchar.length;i++)
		{
			this.countcharacters[inputchar[i]]++;
		}
		return this.countcharacters;
		
	} 
}
