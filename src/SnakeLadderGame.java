import java.util.Random;
public class SnakeLadderGame 
{
	//uc1
	private static int CHOICE= 1;
    private static int POSITION=0;
    private static int END_POINT=100;
    private static int FINAL_POSITION;
    private static int COUNT1=0,COUNT2=0;
    private static boolean PLAYER=true;
	public static void main(String[] args)
	{
		System.out.println("Starting position="+POSITION);
		rollingDie();
	}
       //uc2
	static void rollingDie()
	{
		System.out.println("Generating random number");
		Random random=new Random();
		int dieNumber = random.nextInt(6)+1;
		System.out.println(" Number is : " + dieNumber);
		movePosition(dieNumber);
	 }
	//uc3 and uc4 and uc5 and uc6
	 static void movePosition(int dieNumber)
	 {
		while(END_POINT>=0)
		{
			twoPlayers(CHOICE);
			Random randomDie=new Random();
			int dieChoice = randomDie.nextInt(2)+1;
			if(dieChoice==1)//1 for Ladder
			{
				POSITION=POSITION+dieNumber;
				System.out.println("Ladder Position="+POSITION);
				if(POSITION>=100)
				{
					if(PLAYER==true)
					{
						CHOICE=2;
					}
					else
					{
						CHOICE=1;
					}
					FINAL_POSITION=POSITION-(POSITION%100);
					System.out.println("Player " + CHOICE + " Won the Game and Updated Ladder Position="+FINAL_POSITION);
					break;
					
				}
				COUNT1=COUNT1+1;
			}
			if(dieChoice==2)// 2 for snake
			{
				POSITION=POSITION-dieNumber;
				if(POSITION<=0)// position=0
				{
					POSITION=0;
					System.out.println("Back to Position=0");
					//continue;
				}
				System.out.println("Snake Position="+POSITION);
				if(POSITION>=100)
				{
					FINAL_POSITION=POSITION-(POSITION%100);
					System.out.println("Updated Snake Position="+FINAL_POSITION);
					break;
				}
				
			}
			COUNT2=COUNT2+1;
		}
		
		END_POINT--;
		
		System.out.println("Snake Came these "+ COUNT2+" times");
	  }
		
 
		static void twoPlayers(int CHOICE) 
		{
			if(PLAYER==true) 
			{
				System.out.println("Player 1" );
				PLAYER=false;
			}
			else
			{
				System.out.println("Player 2 ");
				PLAYER=true;
			}
		}
		
		
}

