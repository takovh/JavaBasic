package cn.zhang.sort.bubbleSort;

public class BS2 {
	public static void main(String[] args) {
		int[] arr={6,3,8,2,9,1};
		System.out.println("����ǰ����Ϊ��");
		for(int num:arr){
			System.out.print(num+" ");
		}
		boolean sorted = true;
		for(int i=0;i<arr.length-1;i++){//���ѭ��������������
			sorted = true;
			for(int j=0;j<arr.length-1-i;j++){//�ڲ�ѭ������ÿһ��������ٴ�
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			if(sorted) break;
		} 
		System.out.println();
		System.out.println("����������Ϊ��");
		for(int num:arr){
			System.out.print(num+" ");
		} 
	}
}
