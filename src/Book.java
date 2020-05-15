
public class Book extends Publication{

	// It has additional data: publisher, number of pages and author
	// name. Notes, it is possible that one book have multiple authors.
	
	private String[] authors;
	
	Book(String ID, String name, double price, String publisher, int noOfPages, String[] authors) {
		super(ID, name, price, publisher, noOfPages);
		this.authors = authors;
	}
	
	public void showItemDetails() {
		System.out.println("****** Book ID: " + this.getID() + " ******");
		super.showItemDetails();
		System.out.print("Author(s): ");
		
		for(String author : this.authors)
			System.out.print(author + "  ");
		
		System.out.println("\n-----------------------------------\n");
	}
}
