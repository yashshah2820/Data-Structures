public class StackLL<A> implements Stack<A>
{   
    ListObject<A> head,tail;
    StackLL()
    {
        head=null;
        tail=null;
    }
    public A peek()
    {
        ListObject<A> ob=head;
        Integer x=Getsize();
        for(int i=0;i<x-1;i++)
        {
         ob=ob.next;
        }
        return (ob.val);
    }
    public void push(A x)
    {
     ListObject<A> ob=new ListObject(x);
         if(head==null)
         {
             head=ob;
             head.next=ob;
             tail=ob;
         }
         else{
             tail.next=ob;
             tail=ob;
            }
    }
    public A pop()
    {
        ListObject<A> ob=head;
        ListObject<A> ob2=head;
        Integer x=Getsize();
        for(int i=0;i<x-1;i++)
        {
            ob2=ob;
            ob=ob.next;
        }
        A temp=(A)(ob.val);
        tail=ob2;
        return (A)(temp);
    }
    public int Getsize()
    {
         Integer c=0;
         ListObject<A> ob;
         
         ob=head;
            while(ob!=null)
            {
                c++;
                ob=ob.next;
            }
            
            return c;
    }
}
