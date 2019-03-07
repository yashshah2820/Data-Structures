class ArrayList <A> implements List<A>
{
    Integer buffer;
    Integer size;
    Object arr[];
    Integer j= new Integer(0);
    ArrayList(){
        buffer=5;
        size=new Integer(0);
        arr=new Object[buffer];
        }
    public void add(A i)
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
         arr[size]=i;
         size++;
        }
    public void add(A obj, Integer pos)
        {
         try { 
            if(pos>size)
            {
            BoundsException ob =new BoundsException(); 
            throw ob;
             }
              }
         catch (BoundsException x)
            {
                x.printError();
                return;
             }
         for(j=size;j>pos;j--)
         {
            arr[j]=arr[j-1];
         }
         arr[pos]=obj;
         size++;
        }
    public void traverse ()
        {
         for(j=0;j<size;j++)
         System.out.println(arr[j]);
        }
    public Integer search(A o)
        {
         Integer i;
         for(i=0;i<size;i++)
         {
          if((Integer) (arr[i])==(Integer) (o))
          return i;
         }
         return -1;
        }
    public A getElementAt(Integer pos)
    {
        return (A)(arr[pos]);
    }
    public void remove(A o)
    {
     Integer i;
     for(i=0;i<size;i++)
     {
             if((Integer) (arr[i])==(Integer) (o))
             {
                 for(Integer k=i;k<size;k++)
                 arr[k]=arr[k+1];
                 size--;
                 i--;
             }
     }
    }
}


