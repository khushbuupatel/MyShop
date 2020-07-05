# MyShop

MyShop is an java CLI utility which allows users to explore and add contents like Books, magazines and applications to the shop. 
It also allows to add different customers as well as admins of the MyShop. It also provides few admin functionalities like the admins 
can change the price of different contents in the shop. Detailed menu can be seen in the MyShopMain class.

The MyShop class have two attributes: a list of Content and a list of User objects. Note that each
content has a unique ID. The interaction with this shop is simulated within the main method (see
the MyShopMain.java class). This program provides following functionalities:  

1.Show content  
2.Add content  
3.Show users  
4.Add users  
5.Change username  
6.Show particular item reviews  
7.Show all reviews  
8.Download content  
9.Show customer downloads  
10.Show item downloads  
11.Show all downloads in shop  
12. Become premium customer  
13.Show admin functionalities  
14.Quit

#### Class Content
Mobile apps and publication items are Content of the MyShop. Each Content (either application
or publication) is associated with the following information: an ID, name, number of downloads,
price. Class Content cannot and should not be instantiated.

#### Class Application
Application objects contain information such as ID, name, number of downloads and price. In
addition, an Application object has an OS (operating system) type that presents the minimum
operating system requirement. An Application object can be initialized as

<pre>
Application game1 = new Application("g1", "Fruit Ninja", 4.7, "androidV4");
</pre>
In the above example the price of the app is $4.7 dollar, “androidV4” is the OS requirement.

Initially the number of downloads is zero.  
If no price is provided, the application is then free.  
<pre>
Application app1 = new Application("app1", "Calendar", "androidV3");
</pre>

#### Class Publication
Another type of Content is Publication. In addition to the data that the Content class has, a Publication object also has: publisher and number of pages.

#### Class Book
Book is one type of Publication. It has additional data: publisher, number of pages and author name. Notes, it is possible that one book have multiple authors.

A Book object can be initialized as
<pre>
String[] authors = {"L. Tolstoy"};
Book b1 = new Book ("b1", "War and Peace", 12.55, "The Russian Messenger", 1225, authors);
</pre>

“War and Peace” is the name of the book; 12.55 is the price; “The Russian Messenger” is the publisher. The book has 1225 pages and is of course authored by “L. Tolstoy”

#### Class Magazine
Another type of Publication is Magazine, which has an additional data: volume. A magazine does
not contain any author’s name. A Magazine object can be initialized as

<pre>
Magazine m1 = new Magazine("m1", "Forbes", 8.99, "Forbes Media", 50, 202004);
</pre>

The name of the magazine here is “Forbes”, selling for $8.99. The publisher is “Forbes Media”.
It has 50 pages, and the current volume is 202004. You can assume the volume is always an
integer showing the year and the month.

New contents can be directly added in MyShopMain.java. It also allows keyboard input to enter new
contents.

#### Class User
The User class has an ID, a username. NOTE, username can be changed by changeName() method.

#### Class Customer
Customer is a type of user. Each customer has a phone number and available fund in the
account. By default, a new user will start with 50 in balance. A Customer can be initialized as:

<pre>
Customer c1 = new Customer("u1", "coolguy", "0412000", 200);
// Mary has a balance of 50
User u2 = new User("u2", "neversaynever", "0433191");
</pre>

#### Class Admin
Admin is a special type of user. Each admin has a password and a level. The level is an integer
indicating the level of his/her admin privilege.

<pre>
Admin a2 = new Admin("a2", "Adele", "kitty123", 3);
</pre>

Each content item, either application or publication, can be reviewed by customers.
Review is a collection of Comment object. One content may have multiple comments as its review.

##### Class Comment
A Comment class keeps the following data: a Customer, which is customer who wrote the comment and a string for the comment.  

A Comment class may be initialised with an integer between 0 to 5, which is the rating from the
customer.  

A mix is also possible, e.g.

<pre>
Comment comment1 = new Comment(c1, "This is a fantastic game!");
Comment comment2 = new Comment(c2, 5);
Comment comment3 = new Comment(c3, 3, "This is an average game!");
Comment comment4 = new Comment(c4, "I quite like this game!", 4);
</pre>

In addition, customers can buy content through method download, where the parameter is a Content
type of object. When a user buys any content, the price of that content needs to be deducted from
the balance of that user. Necessary checks are done before the deduction. The number of downloads of
the content should be updated as well after the purchase. A user may buy multiple content.

The program shows the number of downloads for one content. It can also show the number of
downloads for all contents in the shop as well.

##### Premium customer
A customer can be upgraded to a Premium customer for a
cost of $100. A premium customer gets 20% discount on each purchase of contents after
becoming premium. This upgrade is NOT free.
After this, customers can download in bulk, e.g. download(list), there are multiple items in list.
If the bulk download is not successful, e.g. short of fund, then nothing will be added.

##### Admin functions
An admin can login in and reset the price for and item, e.g.  
If the admin’s level is above 5, then the admin can adjust prices in bulk for all contents in the
shop, e.g. a bulk price reduction of 10% as shown below. This task would not be successful if
the admin’s privilege level is 5 or below.
