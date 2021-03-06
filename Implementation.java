class Node 
{
    int data;
    Node next;
    Node prev;
};
class LinkedList
{
  Node head;
  LinkedList()
  {
    head = null;
  }
void push_back(int newElement) 
{
    Node newNode = new Node();
    newNode.data = newElement;
    newNode.next = null;
    newNode.prev = null; 
    if(head == null)
    {
      head = newNode;
    }
    else 
    {
      Node temp = new Node();
      temp = head;
      while(temp.next != null)
        temp = temp.next;
      temp.next = newNode;
      newNode.prev = temp;
    }    
}
void pop_at(int position)
{     
    if(position < 1)
    {
      System.out.print("\nposition should be >= 1.");
    }
    else if (position == 1 && head != null)
    {
      Node nodeToDelete = head;
      head = head.next;
      nodeToDelete = null;
      if (head != null)
        head.prev = null;
    } else {
      Node temp = new Node();
      temp = head;
      for(int i = 1; i < position-1; i++) 
      {
        if(temp != null)
        {
          temp = temp.next;
        }
      }
      if(temp != null && temp.next != null) 
      {
        Node nodeToDelete = temp.next;
        temp.next = temp.next.next; 
        if(temp.next.next != null)
          temp.next.next.prev = temp.next;  
        nodeToDelete = null; 
      }
      else
      {
        System.out.print("\nThe node is already null.");
      }       
    }
} 
void pop_back()
{
    if(this.head != null)
    {
      if(this.head.next == null)
      {
        this.head = null;
      }
      else
      {
        Node temp = new Node();
        temp = this.head;
        while(temp.next.next != null)
          temp = temp.next;
        Node lastNode = temp.next;
        temp.next = null; 
        lastNode = null;
      }
    }
}
void SearchElement(int searchValue)
{
    Node temp = new Node();
    temp = this.head;

    int found = 0;
    int i = 0;

    if(temp != null) 
    {
      while(temp != null)
      {
        i++;
        if(temp.data == searchValue)
        {
          found++;
          break;
        }
        temp = temp.next;
      }
      if (found == 1) {
        System.out.println(searchValue + " is found at index = " + i +".");
      }
      else
      {
        System.out.println(searchValue + " is not found in the list.");
      }
    }
    else 
    {
      System.out.println("The list is empty.");
    }
  }   
void PrintList()
{
    Node temp = new Node();
    temp = this.head;
    if(temp != null) 
    {
      System.out.print("The list contains: ");
      while(temp != null)
      {
        System.out.print(temp.data + " ");
        temp = temp.next;
      }
      System.out.println();
    }
    else 
    {
      System.out.println("The list is empty.");
    }
  }    
};
public class Implementation
{
  public static void main(String[] args)
  {
    LinkedList MyList = new LinkedList();
    MyList.push_back(1);
    MyList.push_back(2);
    MyList.push_back(3);
    MyList.PrintList(); 
    MyList.SearchElement(1);
    MyList.SearchElement(5);
    MyList.SearchElement(3);
    MyList.pop_at(2);
    MyList.PrintList();
    MyList.pop_at(1);
    MyList.PrintList();
    MyList.pop_back();
    MyList.PrintList();  
  }
}