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
	static void sort() 
	{
		int k;
		String p1;
		p2=Arrays.copyOf(p,p.length);
		for(int j=0;j<n-1;j++)
		{
			if(at[j]==at[j+1]&&bt[j]>=bt[j+1])
			{
				k=at[j];
				at[j]=at[j+1];
				at[j+1]=k;
				k=bt[j];
				bt[j]=bt[j+1];
				bt[j+1]=k;
				p1=p[j];
				p[j]=p[j+1];
				p[j+1]=p1;
			}
			for(int q=j+1;q<n-1;q++)
			{
				if(at[q]<=bt[j]&&at[q+1]<=bt[j]&&bt[q]>bt[q+1])
				{
					k=at[q];
					at[q]=at[q+1];
					at[q+1]=k;
					k=bt[q];
					bt[q]=bt[q+1];
					bt[q+1]=k;
					p1=p[q];
					p[q]=p[q+1];
					p[q+1]=p1;
				}
			}
		}
	}
}