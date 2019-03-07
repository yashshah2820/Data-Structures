public class OrderedList<A> implements List<A>
{
    Integer buffer;
    Integer size;
    Object arr[];
    Integer j= new Integer(0);
    OrderedList(){
        buffer=5;
        size=new Integer(0);
        arr=new Object[buffer];
        }
    public void add(A o)
    {
     Integer pos=0;
     for(Integer i=0;i<=size;i++)
     {
         if(arr[i]==null)
         {
             pos=i;
             break;
            }
         else if((Integer)(arr[i])>=(Integer)(o))
         {
            pos=i;
             break;
            }
     }
      if(arr[pos]!=null)
     for(Integer k=size;k>pos;k--)
     {
        arr[k]=arr[k-1];
        }
        
     arr[pos]=o;
     size++;
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
    }
    public Integer search(A o)
    {
     Integer k=-1, low=0,high=size-1,mid=(low+high)/2;
     while(low<high)
     {
     if((Integer)(arr[mid])==(Integer)(o))
     {
         k=mid;
         return k;
     }
     else if((Integer)(arr[mid])>(Integer)(o))
          high=mid-1;
     else
         low=mid+1;
     }
     return k;
    }
    public A getElementAt(Integer pos)
    {
        return (A)(arr[pos]);
    }
    public void traverse()
    {
         for(j=0;j<size;j++)
         System.out.println(arr[j]);
        }
    public void remove(A o)
    {
     Integer i;
     for(i=0;i<size;i++)
     {
             if(arr[i]==o)
             {
                 for(Integer k=i;k<size;k++)
                 arr[k]=arr[k+1];
                 size--;
                 i--;
             }
     }
    }
}
