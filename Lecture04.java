//Sadman Sakib Hassan


class Lecture04 {

    public static void main(String[] args) {
        System.out.println("Hello from lecture 04");

        // SELF-CHECK PROBLEMS:
        // Note: you may need to put some of your answers inside comments

        // 1. When should you use a LinkedList instead of an ArrayList?

        // 2. Would a LinkedList or an ArrayList perform better when run on the
        // following code? Why?
        // public static int min(List<Integer> list) {
        // int min = list.get(0);
        // for (int i = 1; i < list.size(); i++) {
        // if (list.get(i) < min) {
        // min = list.get(i);
        // }
        // }
        // return min;
        // }

        // 3. What is an iterator? Why are iterators often used with linked lists?

        // 4. Write a piece of code that counts the number of duplicate elements in a
        // linked list.
        // That is, the number of elements whose values are repeated at an earlier index
        // in the list. Assume that all duplicates in the list occur consecutively. For
        // example, the list [1, 1, 3, 5, 5, 5, 5, 7, 7, 11] contains five duplicates:
        // one duplicate of element value 1, three duplicates of element value 5, and
        // one duplicate of element value 7.

        // 5. Write a piece of code that inserts a String into an ordered linked list of
        // Strings, maintaining sorted order.
        // For example, for the list ["Alpha", "Baker", "Foxtrot", "Tango", "Whiskey"],
        // inserting "Charlie" in order would produce the list ["Alpha", "Baker",
        // "Charlie", "Foxtrot", "Tango", "Whiskey"].

//Answer:

        #include<iostream>
        using namespace std;
        struct Node
        {
            string data;
            Node* next;
        
        };
        // function to make a new node of linked list
        Node* newNode(string s)
        {
            // allocating memory of type node
            Node* t = new Node();
            
            // initialising data members of structure
            t->data = s;
            t->next=NULL;
            return t;
        }
        
        // function to print the linked list
        void print(Node* head)
        {
            Node* temp = head;
            cout<<"Linked list: "<<endl;
            while(temp!=NULL)
            {
                cout<<temp->data<<"  ";
                temp=temp->next;
            }
        }
        int main()
        {
            Node* head = NULL;
            string a;
            
            // Taking input until 'q' is entered
            cout<<"Enter q to quit"<<endl;
            cin>>a;
            
            while(a!="q")
            {
                // creating a new node for the string entered 
                // by the user
                Node* node = newNode(a);
                
                if(head==NULL)
                {
                    head = node;
                }
                else
                {
                    // using function compare() to compare the two strings
                    // if the function returns a value which is
                    // less than 0 that means string entered
                    // by user is greater than the string of 
                    // the current node
                    if(a.compare(head->data)<0)
                    {
                        node->next=head;
                        head=node;
                    }
                    else
                    {
                        Node* temp = head;
                        
                        // Using pre to store the previous node
                        // after which the current node will be inserted
                        Node* pre=head;
                        while(temp!=NULL && a.compare(temp->data)>0)
                        {
                            pre=temp;
                            temp=temp->next;
                        }
                        node->next = pre->next;
                        pre->next=node;
                    }
                }
                cin>>a;
            }
            print(head);
            return 0;
        }






        // From Section 11.2: Sets
        // 10. A List has every method that a Set has, and more. So why would you use a
        // Set rather than a List?


//Answer: 

If a collection needs to be subjected to set operations like intersection, exclusion, deduplication, etc. but you don't need to maintain more than one unique value for anything. 

Sets are useful for selecting items based on categorical classifications. 

The secret to sets is generating intelligence through the division of a set into subsets according to some standards. 
It happens frequently that you have an array or list of things and wish to create a smaller list where each item has a characteristic in common. 

Sets are collections of Keys of a particular kind that don't duplicate. On the keys, you can do a variety of things.

If you wish to avoid duplicates or quickly search the collection, use a Set rather than a List.

        // 11. When should you use a TreeSet, and when should you use a HashSet?

//Answer:
If you don't wish to keep the order of the elements, use a hash set. If you want to preserve the insertion order of the elements, use LinkedHashSet. If you want to order the components using a Comparator, use TreeSet.
When you want to keep the data sorted, use a TreeSet. For the quickest searching time, use a HashSet with non-comparable types or when order is irrelevant.

        // 12. A Set doesn’t have the get and set methods that an ArrayList has. How do
        // you examine every element of a Set?


//Answer:
There is a There is a method called containsAll declared in the java.util.Collection, using this.


        // 13. What elements are contained in the following set after this code
        // executes?

        // Set<Integer> set = new HashSet<>();
        // set.add(74);
        // set.add(12);
        // set.add(74);
        // set.add(74);
        // set.add(43);
        // set.remove(74);
        // set.remove(999);
        // set.remove(43);
        // set.add(32);
        // set.add(12);
        // set.add(9);
        // set.add(999);


        //Answer: [32, 999, 9, 12] 

        // 14. How do you perform a union operation on two sets? An intersection? Try to
        // give an answer that doesn’t require any loops.

        // 15. Write the output produced when the following method is passed each of the
        // following lists:

        // public static void mystery(List<String> list) {
        // Set<String> result = new TreeSet<>();
        // for (String element : list) {
        // if (element.compareTo(list.get(0)) < 0) {
        // result.add(element);
        // } else {
        // result.clear();
        // }
        // }
        // System.out.println(result);
        // }
        // [marty, stuart, helene, jessica, amanda]
        // [sara, caitlin, janette, zack, riley]
        // [zorah, alex, tyler, roy, roy, charlie, phil, charlie, tyler]


      //Answer:  The output is null or clear if the result compares to the list with input 0. 

//If not, the name will appear in the appropriate list.

        // Exercises:
        // 2. Write a method called alternate that accepts two Lists as its parameters
        // and returns a new List containing alternating elements from the two lists, in
        // the following order:

        // First element from first list
        // First element from second list
        // Second element from first list
        // Second element from second list
        // Third element from first list
        // Third element from second list
        // . . .
        // If the lists do not contain the same number of elements, the remaining
        // elements from the longer list should be placed consecutively at the end. For
        // example, for a first list of [1, 2, 3, 4, 5] and a second list of [6, 7, 8,
        // 9, 10, 11, 12], a call of alternate(list1, list2) should return a list
        // containing [1, 6, 2, 7, 3, 8, 4, 9, 5, 10, 11, 12].

//Answer:
        import java.util.*; 
public class Main
{
    //alternative method returns final list from two list
      List<Integer> alternative( List<Integer> list1,List<Integer>list2)
      {
                   
            Iterator<Integer> i1 = list1.iterator();
            Iterator<Integer> i2 = list2.iterator();
            List<Integer> result = new ArrayList<Integer>();
            
            while(i1.hasNext() || i2.hasNext()) {
                if (i1.hasNext()) {
                    result.add(i1.next());
                }
                if (i2.hasNext()) {
                    result.add(i2.next());
                }
            }
           return result;
     }
	
	public static void main(String[] args) {
	//creating object of class Main
	Main m = new Main();
    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list2 = new ArrayList<Integer>();
    List<Integer> list = new ArrayList<Integer>();
    //adding elements in a list
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(4);
    list1.add(5);
    list2.add(6);
    list2.add(7);
    list2.add(8);
    list2.add(9);
    list2.add(10);
    list2.add(11);
    list2.add(12);
 
    list=m.alternative(list1,list2);
    System.out.println("List 1: "+list1);
    System.out.println("List 2: "+list2);
    System.out.println("Final List :"+list);
}
	
}

        // 9. Write a method hasOdd that accepts a set of integers as a parameter and
        // returns true if the set contains at least one odd integer and false
        // otherwise.
        // If passed the empty set, your method should return false.

//Answer:
public static boolean hasOdd(int[] arr){
    for(int i = 0;i<arr.length;i++){
      if(arr[i]%2 == 1){
        return true;
      }
    }
    return false;
  }

    }
}
