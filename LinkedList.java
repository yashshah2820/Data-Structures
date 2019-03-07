public class LinkedList<A> implements List<A>
{
 ListObject<A> head,tail;
 LinkedList(){
    head=null;
    tail=null;
    }
 public boolean IsEmpty()
 {
    return(head==null);
 }
 public void reverse()
  {
    ListObject<A> ob1=null;
    ListObject<A> ob2=head;
    ListObject<A> ob3=null;
    while(ob2!=null)
    {
     ob3=ob2.next;
     ob2.next=ob1;
     ob1=ob2;
     ob2=ob3;
    }
    head=ob1;
    }
 public Integer search(A o){
    ListObject<A> ob;
    ob=head;
    Integer c=1;
    while(ob!=o)
    {
     c++;
     ob=ob.next;
    }
     return c;
    }
 public void add(A obj){
         ListObject<A> ob=new ListObject(obj);
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
 public void add(A o, Integer pos){
    ListObject<A> ob=new ListObject(o);
    ListObject<A> ob1;
    ob1=head;
    Integer c=0;
    Integer d=getsize();
    if(pos<=d)
    {
        while(c!=pos-1)
        {
            ob1=ob1.next;
            c++;
        }
        ob.next=ob1.next;
        ob1.next=ob;
    }
    /*else if(pos==d)
    {
     ob.next=null;
     tail.next=ob;
     tail=ob;
    }*/
    else{
    try { 
            if(pos>d)
            {
            BoundsException ob2 =new BoundsException(); 
            throw ob2;
             }
              }
         catch (BoundsException x)
            {
                x.printError();
                return;
             }
    }
}//not interface. to be defined in class itself.
 public void traverse(){
    ListObject<A> ob;
    ob=head;
    while(ob!=null){
        System.out.println(ob.val);
        ob=ob.next;
    }
    }//from interface
 public Integer getsize(){
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
 public A getElementAt(Integer pos)
    {
        ListObject<A> ob;
        ob=head;
        for(int i=0;i<pos;i++)
        {
            ob=ob.next;
        }
        return (A) (ob.next);
    }//from interface.
 public ListObject remove(Integer pos)
 {
    ListObject<A> ob1;
    ListObject<A> ob2;
    ob1=head;
    ob2=head;
    Integer a=0;
         
         while(a!=pos)
         {
             if(ob1.next==null)
             return null;
             else
             {
                ob2=ob1;
                ob1=ob1.next;
                }
                a++;
        }
        if(ob1==head)
        head=head.next;
        else
        ob2.next=ob1.next;
        return ob1;
    }
}