class QueueAL<A> implements Queue<A>
{
    Integer buffer;
    Integer size;
    Object arr[];
    Integer j= new Integer(0);
    QueueAL()
        {
            buffer=5;
            size=new Integer(0);
            arr=new Object[buffer];
        }
    public void enqueue(A x)
    {
        if(size>=buffer)
             {
                 buffer*=2;
                 Object arr1[]=new Object[buffer];
                    for(Integer k=0;k<size;k++)
                    {
                        arr1[k]=arr[k];
                    }
                    arr=arr1;
                }
        arr[size]=x;
        size++;
    }
    public A dequeue()
    {
        A temp =(A)(arr[0]);
        int i=0;
        for(i=0;i<size;i++)
            arr[i+1]=arr[i];
        size--;
        return temp;
    }
    public int Getsize()
    {
     return size;
    }
   
}
