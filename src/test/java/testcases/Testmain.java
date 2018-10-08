package testcases;

import java.util.Scanner;

public class Testmain {

	public static int Check (String game)
	{
		int num = game.length();
		int last = game.charAt(num-1);
		int min = 1;
		int count = 1;
		
		for(int i = 0; i<num; i++)
		{
			if(game.charAt(i) == last)
			{
				if (count > min)
				{
				min = count;
				count = 1;
				}
				else
					count = 1;
				
			}
			else
			{
				count++;
			}
		}
		return min;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String game;
		Scanner s = new Scanner(System.in);
		
		game = s.nextLine();
		
		System.out.println(Check(game));
	}
	


}
