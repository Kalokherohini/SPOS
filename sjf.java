import java.util.*;
class sjf
{
	public static void main(String[] args)
	{
		int id[]=new int[20];
		int etime[]=new int[20];
		int stime[]=new int[20];
		int wtime[]=new int[20];
		int btime[]=new int[20];
		int ctime[]=new int[20];
		int flag[]=new int[20];
		//check process is completed or not.
		int ta[]=new int[20];
		int total=0;
		int st=0;
		int temp,i;
		float avgwt=0,avgta=0;
		Scanner sn = new Scanner(System.in);
	     System.out.print("\nEnter the number of processes : ");
		int n = sn.nextInt();
		for (i=0;i<n;i++)
		{
			System.out.println();
			System.out.print("Enter the process ID of process "+(i+1)+" : ");
			id[i]=sn.nextInt();
			System.out.print("Enter the execution time of process "+(i+1)+" : ");
			etime[i]=sn.nextInt();
			btime[i]=etime[i];
			flag[i]=0;
		}
		while(true)
		{
			int min=9999,c=n;
			if(total==n)
			break;
			for(i=0;i<n;i++)
			{
			   if((id[i]<=st) && (flag[i]==0) && (etime[i]<min))
				{
					min=etime[i];
					c=i;
				}
			}
			if(c==n)
				st++;
			else
			{
				etime[c]--;
				st++;
				if(etime[c]==0)
				{
					ctime[c]=st;
					flag[c]=1;
					total++;	
				}
			}
		}
		for(i=0;i<n;i++)
		{
			ta[i]=ctime[i]-id[i];
			wtime[i]=ta[i]-btime[i];
			avgwt+=wtime[i];
			avgta+=ta[i];
		}
	System.out.println("\nArrival_time\tExecution_time\tcompletion_time\t  Wait_time\tturn around time");
		for(i=0;i<n;i++)
		{
			System.out.println(id[i]+"\t\t"+btime[i]+"\t\t"+ctime[i]+"\t\t"+wtime[i]+"\t\t"+ta[i]);
		}
		System.out.println("\nAverage wait time: "+(float)(avgwt/n));
		System.out.println("\nAverage turn around time: "+(float)(avgta/n));
	}

}
