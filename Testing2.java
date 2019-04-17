import java.util.*;
class sjf 
{
	static String p[]=new String[100];
	static String p2[]=new String[100];
	static int at1[]=new int[100];
	static int bt1[]=new int[100];
	static int ct1[]=new int[100];
	static int tat1[]=new int[100];
	static int wt1[]=new int[100];
	static int at[]=new int[100];
	static int bt[]=new int[100];
	static int wt[]=new int[100];
	static int tat[]=new int[100];
	static int ct[]=new int[100];
	static double avgtat,avgwt;
	static int n,i,l;
	static Scanner s1=new Scanner(System.in);
	static boolean getinput()
	{
		System.out.println("enter number of processors");
		n=s1.nextInt();
		for(i=0;i<n;i++)
		{
			System.out.println("Enter processor name : ");
			p[i]=s1.next();
			System.out.println("Enter arrival time of processor "+p[i]+" : ");
			at[i]=s1.nextInt();
			System.out.println("Enter burst time of processor "+p[i]+" : ");
			bt[i]=s1.nextInt();
			if(bt[i]>10)
			{
				System.out.println("Burst time cant be more than 10 Enter again the burst time");
				bt[i]=s1.nextInt();
			}
			
		}
		return true;
		
	}
	
}