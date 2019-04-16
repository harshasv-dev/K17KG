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
	static void shortest_job_first()
	{
		double sum1=0,sum2=0;
		for(int j=0;j<n;j++)
		{
			if(j==0)
			{
				ct[j]=at[j]+bt[j];
			}
			else 
			{
				if(at[j]>ct[j-1])
				{
					ct[j]=at[j]+bt[j];
				}
				else 
				{
					ct[j]=ct[j-1]+bt[j];
				}
			}
		}
		for(int j=0;j<n;j++)
		{
			tat[j]=ct[j]-at[j];
			if(tat[j]<0)
			{
				tat[j]=0;
			}
			wt[j]=tat[j]-bt[j];
			if(wt[j]<0)
			{
				wt[j]=0;
			}
			sum1=sum1+wt[j];
			sum2=sum2+tat[j];
		}
		avgtat=sum2/n;
		avgwt=sum1/n;
		
	}
	static void resort()
	{
		for(int j=0;j<n;j++)
		{
			for(int k=0;k<n;k++)
			{
				if(p2[j].equals(p[k]))
				{
					at1[j]=at[k];
					bt1[j]=bt[k];
					wt1[j]=wt[k];
					tat1[j]=tat[k];
					ct1[j]=ct[k];
				}
			}
		}
	}
	static void display()
	{
		System.out.println("Processos    AT    BT     CT    TAT   WT");
		for(int j=0;j<n;j++)
		{
			System.out.println(p2[j]+"           "+at1[j]+"      "+bt1[j]+"     "+ct1[j]+"     "+tat1[j]+"    "+wt1[j]);
			
		}
		System.out.print("Order of execution : ");
		for(int j=0;j<n;j++)
		{
			System.out.print(p[j]+" ");
		}
		System.out.println();
		System.out.println("Average turn around time : "+avgtat);
		System.out.println("Average waiting time : "+avgwt);
	}
	public static void main(String...args)
	{
		sjf sj=new sjf();
		sj.getinput();
	    sj.sort();
		sj.shortest_job_first();
		sj.resort();
		sj.display();	
	}
}