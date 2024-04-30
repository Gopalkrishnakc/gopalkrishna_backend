package Day1;

public class ArrayPart2 {
int[] br=removeDuplicate(arr);
		for(int i=0;i<br.length;i++)
		{
			System.out.println(br[i]+" ");
		}
	
		int rs=frequencyOfSpecifiedArrEle(arr,45);
		System.out.println(rs);
		
		
		int pc=countPrimeNumber(arr);
		System.out.println("Number of Prime numbers:"+pc);
		
		int[] rem=duplicateElements(arr);
		for(int i=0;i<rem.length;i++)
		{
			System.out.println(rem[i]+" ");
		}
	}

	private static int[] duplicateElements(int[] arr) {
		int[] c=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==arr[i+1]) {
				c[i]=arr[i];
			}
		}
		return c;
	}

	private static int countPrimeNumber(int[] x) {
		int count=0;
		for(int i=0;i<x.length;i++) {
			boolean rs=isPrime(x[i]);
			if(rs)
				count++;
		}
		return count;
	}

	static boolean isPrime(int n) {
		for(int i=2;i<=n/2;i++) {
			if(n%2==0)
				return false;
		}
		return true;

	}

	private static int frequencyOfSpecifiedArrEle(int[] x, int ele) {
		int count=0;
		for(int i=0;i<x.length;i++) {

			if(x[i]==ele)
			{
				count++;

			}
		}
		return count;	
		
	}

	private static int[] removeDuplicate(int[] arr) {
		int [] br=new int[arr.length];
		int k=0;
		for(int i=0;i<arr.length;i++) {
			boolean rs=true;
			for(int j=0;j<k;j++)
			{
				if(arr[i]==br[j]) {
					rs=false;
					break;
				}
			}
			if(rs)
				br[k++]=arr[i];
		}
		int[] rs=new int[k];
		for(int i=0;i<rs.length;i++) {
			rs[i]=br[i];
		}
		return rs;
		
	}
}
