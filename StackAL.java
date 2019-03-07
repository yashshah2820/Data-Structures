class StackAL<A> implements Stack<A>
{
    Integer buffer;
    Integer size;
    Object arr[];
    Integer j= new Integer(0);
    StackAL(){
        buffer=5;
        size=new Integer(0);
        arr=new Object[buffer];
        }
    public A peek()
    {
      return (A)(arr[size-1]);
    }
    public void push(A x)
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
    public A pop()
    {
                 A temp=(A) (arr[size-1]);
                 arr[size-1]=null;
                 size--;
                 return temp;
    }
    public int Getsize()
    {
    return size;
    }
}