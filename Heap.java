import java.util.Scanner;
public class Heap
{
    int size;
    int buffer;
    Integer arr[];
    Heap(int buffer){
        this.buffer=buffer;
        arr=new Integer[buffer];
        size=0;
    }
    void MaxHeapify(int i, int Size)
    {
        Integer lchild=2*i+1;
        Integer rchild=2*i+2;
        Integer largest=i;
        if(lchild<Size && arr[lchild]>arr[i])
        {
            largest=lchild;
        }
        if(rchild<Size && arr[rchild]>arr[largest])
        {
            largest=rchild;
        }
        if (largest!=i)
        {
            Integer temp;
            temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            MaxHeapify(largest,Size);
        }
    }
    void BuildMaxHeap()
    {
        for(Integer i=(size/2)-1;i>=0;i--)
        MaxHeapify(i,size);
    }
    void HeapSort()
    {
        BuildMaxHeap();
        for(Integer i=size-1;i>=0;i--)
        {
            
            Integer temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            MaxHeapify(0,i);
        }
    }
    void insertElement(Integer a)
    {
        if(size<buffer)
        {
            arr[size]=a;
            size++;
            BuildMaxHeap();
        }
        else
        {
         throw new ArrayIndexOutOfBoundsException();
        }
    }
    void deleteElement()
    {
        if(size>0)
        {
            int temp;
            temp=arr[0];
            arr[0]=arr[size-1];
            BuildMaxHeap();
            System.out.println(temp);
            size--;
        }
        else 
        {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    void DisplayHeap()
    {  
        for(int j=0;j<size;j++)
        {
            System.out.println(arr[j]);
        }
    }
}
