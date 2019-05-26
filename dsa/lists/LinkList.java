package adee.samples.dsa.lists;

public class LinkList {

	private LinkList next;
	private int data;

	public LinkList(int data) {
		this.data = data;
		this.next = null;
	}

	public LinkList getNext() {
		return next;
	}

	public void setNext(LinkList next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public static void main(String[] args) {
		LinkList list = Problems.getListFromArray();
		LinkList list2 = Problems.getListFromArray();
		Problems.printAList(list);
		Problems.printAList(Problems.reverseLinkedList(list));
		list2 = Problems.reverseLLRecursion(list2);
		System.out.println("reverse-recursion");
		Problems.printAList(list2);
		list = Problems.getListFromArray();
		System.out.println(Problems.nThNodeFromEnd(list, 3));
		list = Problems.getSortedLinkedList();
		Problems.insertNodeAtSortedPosition(list, new LinkList(10));
		Problems.printAList(list);
		// Problems.detectLoop();
		LinkList _list1 = new LinkList(1);
		LinkList _list2 = new LinkList(7);
		Problems.intersectionLists(_list1, _list2);
		System.out.println(Problems.getPointOfIntersection(_list1, _list2));
		System.out.println("MERGE");
		list = Problems.getListFromArray();
		list2 = Problems.getSortedLinkedList();
		LinkList list3 = Problems.mergeAtAlternate(list, list2);
		Problems.printAList(list3);
		Problems.makeLastNodeFirst(list3);
		list = Problems.getListFromArray();
		System.out.println("rotate");
		Problems.printAList(list);
		list = Problems.rotateByKNodes(list, 3);
		Problems.printAList(list);
		System.out.println("swap every - 2");
		list = Problems.swapEvery2Nodes(list);
		Problems.printAList(list);
		System.out.println("delete alternate");
		list = Problems.deleteAlternateNodes(list);
		Problems.printAList(list);
		System.out.println("dupes");
		LinkList dupes = Problems.getDuplicateListFromArray();
		dupes = Problems.removeDuplicateNodes(dupes);
		Problems.printAList(dupes);
	}
}