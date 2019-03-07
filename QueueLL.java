class QueueLL<A> implements Queue<A>
{
    ListObject<A> head,tail;
    QueueLL()
    {
        head=null;
        tail=null;
    }
    public void enqueue(A x)
    {
        ListObject<A> ob=new ListObject(x);
         if(head==null)
            {
                head=ob;
                head.next=ob;
                tail=ob;
            }
         else
         {
                tail.next=ob;
                tail=ob;
         }
    }
    public A dequeue()
    {
        A temp = (A)(head.val);
        head=head.next;
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
