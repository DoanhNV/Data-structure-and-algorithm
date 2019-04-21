package datastructure.singlelinkedlist;
/**
 * 
 * @author DoanhNV Apr 14, 2019 - 7:42:58 PM
 *
 */
public class Main {
	
	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<>();
		names.add("Doanh");
		names.add("Long");
		names.add("Quan");
		names.add("Truong");
		names.add("Minh");
		
		names.remove("Long");
		names.update("Quan", "Quang - updated");
		names.addFirst("Doanh first");
		names.displayList();

		Link<String> minhLink = names.find("Minh");
		minhLink.setValue("Minh finded");
		names.displayList();
		
		List<String> list = names;
		System.out.println("=====================================");
		list.foreach(name -> {
			System.out.println(name);
		});
	}
}
