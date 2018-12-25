import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int[][] wThreading = new int[10][128];

	public static void main(String[] args) throws FileNotFoundException
	{
	    int[] woThreading = new int[128];
	    int[] wCumThreading = new int[128];
	    for (int i=0;i<10;i++)
	    {
	    Arrays.fill(Main.wThreading[0],0);
	    }
	    Arrays.fill(wCumThreading,0);
		File inputfile = new File("C:\\Users\\aliha\\eclipse-workspace\\Assignment 2 Advanced Programming\\src\\big.txt");
		Scanner input = new Scanner(inputfile);
		String data = "";
		while (input.hasNextLine()){
			data += input.nextLine();
		}
		char[] fileInChar = data.toCharArray();
		WithoutThreading W1 = new WithoutThreading();
		long start_time = System.nanoTime();
		woThreading = W1.countCharacters(fileInChar);

		long end_time = System.nanoTime();
		double difference = (end_time - start_time)/1e6;
		System.out.println("The Time in MilliSeconds is Without Threading: " + difference);
		for (int i = 0;i<woThreading.length;i++)
		{
			char ch = (char) i;
			System.out.println("Count of " +ch+" "+woThreading[i]);
		}
		String datasplit[] = new String[10];
		int prev=0,next=0,sizeone=(int) data.length() / 10;
		WithThreading W2[] = new WithThreading[10];
		for (int i=0;i<9;i++) {
			next = next + sizeone;
			//System.out.println(next);
			datasplit[i] = data.substring(prev, next);
			char array[] = datasplit[i].toCharArray();
			W2[i] = new WithThreading(i,array);
			prev = next;
		}

		//System.out.println(data.length());
		W2[9] = new WithThreading(9,data.substring(prev,data.length()-1).toCharArray());
		start_time = System.nanoTime();
		for (int i=0;i<10;i++)
		{
			W2[i].start();
		}
		end_time = System.nanoTime();
		difference = (end_time - start_time)/1e6;
		System.out.println("The Time in MilliSeconds is With Threading:" + difference);
		for (int i=0;i<10;i++)
		{
			for (int j=0;j<wCumThreading.length;j++)
			{
				wCumThreading[j] += Main.wThreading[i][j];
				//System.out.println(wCumThreading[j]);
			}
		}
		for (int i =0;i<wCumThreading.length ;i++)
		{
			char ch = (char) i;
			//System.out.println("Count of " +ch+" "+wCumThreading[i]);
		}
		
	}
}
