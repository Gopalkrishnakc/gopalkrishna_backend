package Day1;

import java.util.Scanner;

public class ArrayOperation {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 System.out.println("enter size");
           int size=sc.nextInt();
          
           int [] array=createArray(size);
           System.out.println("printing array");
           printArray(array) ;
          
           int[] reverse=reversedArray(array);
           System.out.println("printing reversed array");
           printArray(reverse) ;
           
          int[] sort= sortedArray(array);
          System.out.println("printing sorted array");
          printArray(sort) ;
          
          int[]array2= {7,8,9};
        int [] merge=  mergedArray( array, array2);
        System.out.println("printing merged array");
        printArray(merge) ;
        
        int min=minArray(array);
        System.out.println("printing min value of array");
        System.out.println(min);
        
        int max=maxArray( array);
        System.out.println("printing max value of array");
        System.out.println(max);
        
        int [] union=unionArray( array, array2);
        		 System.out.println("printing union array");
        printArray(union) ;
        
      int [] inter=interArray(array,array2);
      System.out.println("printing inter array");
      printArray(inter) ;
	}
	public static int[] createArray(int size) {
		Scanner sc=new Scanner(System.in);
		int[] array1=new int[size];
		for(int i=0;i<size;i++) {
		
			array1[i]=sc.nextInt();
		}
		return  array1;
	}
public static void printArray(int []array) {
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
public static int[] reversedArray(int[] array) {
	
	for(int i=0;i<array.length;i++) {
       array[i]=array[(array.length-1)-i];
	}
	
	return array;
} 

public static int[] sortedArray(int []array) {
	int temp=0;
	for(int i=0;i<array.length;i++) {
		for(int j=i+1;j<array.length;j++) {
			if(array[i]>array[j]) {
				temp=array[i];
				array[i]=array[j];
				array[j]=temp;
			}
		}
		
		
	}
	return array;
	
}
public static int[]  mergedArray(int[] array,int[] array2) {
	int[] array3=new int[array.length+array2.length];
	for(int i=0;i<array.length;i++) {
		array3[i]=array[i];
	}
	for(int i=0;i<array2.length;i++) {
		array3[array.length+i]=array2[i];
	}
	
	return array3;
	
}
public static int[] zigzagArray(int[] array,int[] array2) {
	int[]c=new int[array.length+array2.length];
	int i=0,j=0,k=0;
	while(i<array.length && j<array2.length) {
		
	}
	return c;
}
public static int maxArray(int[] array) {
	int max=array[0];
	for(int i=0;i<array.length;i++) {
		if(max<array[i]) {
			max=array[i];
		}
	}
	return max;
}
public static int minArray(int[] array) {
	int min=array[0];
	for(int i=0;i<array.length;i++) {
		if(min>array[i]) {
			min=array[i];
		}
	}
	return min;
}
public static int[] unionArray(int[] array,int[] array2) {
	int [] newarr=new int[array.length+array2.length];
	int i=0, j=0,k=0;
	while(i<array.length && j<array2.length) {
		if(array[i]==array2[j]) {
			 newarr[k++]=array[i++];
			 j++;
		}else if(array[i]<array2[j]) {
			newarr[k++]=array[j++];
		}else {
			newarr[k++]=array2[j++];
		}
		while(i<array.length) {
			 newarr[k++]=array[i++];
		}
		while(j<array.length) {
			 newarr[k++]=array2[j++];
		}
	}
	return newarr;
}
public static int[] interArray(int[] array,int[] array2) {
	int [] newarr=new int[array.length+array2.length];
	for(int i=0;i<array.length;i++) {
		for(int j=0;j<array.length;j++) {
			if(array[i]==array2[i]) {
				newarr[i]=array[i];
			}
		}
	}
	
	
	return newarr;
}

}

