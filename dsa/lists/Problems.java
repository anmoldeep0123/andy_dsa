package adee.samples.dsa.lists;

public class Problems {

	public static LinkList getListFromArray() {
		int a[] = { 9, 1, 3, 6, 5, 13, 19, 4, 8, 2 };
		LinkList head = new LinkList(a[0]);
		LinkList ptr = head;
		for (int i = 1; i < a.length; i++) {
			LinkList temp = new LinkList(a[i]);
			ptr.setNext(temp);
			ptr = temp;
		}
		return head;
	}

	public static LinkList getDuplicateListFromArray() {
		int a[] = { 1, 3, 4, 2, 5, 6, 8, 9, 0, 2, 3, 5, 6, 7, 8, 5, 4, 3, 2, 1, 7, 6, 4, 5, 6, 9, 8 };
		LinkList head = new LinkList(a[0]);
		LinkList ptr = head;
		for (int i = 1; i < a.length; i++) {
			LinkList temp = new LinkList(a[i]);
			ptr.setNext(temp);
			ptr = temp;
		}
		return head;
	}

	public static void intersectionLists(LinkList list1, LinkList list2) {
		LinkList two = new LinkList(2);
		LinkList three = new LinkList(3);
		LinkList four = new LinkList(4);
		list1.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(null);
		LinkList five = new LinkList(5);
		list2.setNext(five);
		five.setNext(two);
		printAList(list1);
		printAList(list2);
	}

	public static LinkList getSortedLinkedList() {
		int a[] = { 1, 3, 5, 6, 8, 13, 16, 18, 23, 24, 29 };
		LinkList head = new LinkList(a[0]);
		LinkList ptr = head;
		for (int i = 1; i < a.length; i++) {
			LinkList temp = new LinkList(a[i]);
			ptr.setNext(temp);
			ptr = temp;
		}
		return head;
	}

	public static void printAList(LinkList head) {
		while (head != null) {
			System.out.print(head.getData() + " - ");
			head = head.getNext();
		}
		System.out.println();
	}

	public static void checkIfPallindrome(LinkList head) {

	}

	public static LinkList reverseLinkedList(LinkList head) {
		LinkList prev = null;
		LinkList current = head;
		LinkList next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	public static LinkList reverseLLRecursion(LinkList head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		LinkList reversedNode = reverseLinkedList(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return reversedNode;
	}

	public static int nThNodeFromEnd(LinkList head, int n) {
		LinkList ptr1 = head;
		while (n > 0) {
			ptr1 = ptr1.getNext();
			n--;
		}
		LinkList ptr2 = head;
		while (ptr1 != null) {
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext();
		}
		return ptr2.getData();
	}

	public static void insertNodeAtSortedPosition(LinkList head, LinkList newNode) {
		if (head == null || head.getData() >= newNode.getData()) {
			newNode.setNext(head);
		} else {
			LinkList current = head;
			LinkList prev = null;
			while (current != null && current.getData() <= newNode.getData()) {
				prev = current;
				current = current.getNext();
			}
			prev.setNext(newNode);
			newNode.setNext(current);
		}
	}

	public static void detectLoop() {
		LinkList head = new LinkList(1);
		LinkList two = new LinkList(2);
		LinkList three = new LinkList(3);
		LinkList four = new LinkList(4);
		LinkList five = new LinkList(5);
		head.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);
		five.setNext(three);
		LinkList loop = detectLoop(head);
		if (loop == null) {
			System.out.println("No Loop found");
		} else {
			System.out.println("Removing Loop");
			removeLoop(loop, head);
			loop = detectLoop(head);
			System.out.println("Loop found = " + loop);
		}
	}

	private static void removeLoop(LinkList loop, LinkList head) {
		LinkList ptr1 = loop;
		int k = 1;
		while (ptr1 != loop) {
			ptr1 = ptr1.getNext();
			k++;
		}
		ptr1 = head;
		LinkList ptr2 = head;
		for (int i = 0; i < k; i++) {
			ptr2 = ptr2.getNext();
		}
		while (ptr2 != ptr1) {
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext();
		}
		while (ptr2.getNext() != ptr1) {
			ptr2 = ptr2.getNext();
		}
		ptr2.setNext(null);
	}

	private static LinkList detectLoop(LinkList head) {
		LinkList fptr = head, sptr = head;
		while (fptr != null && sptr != null && fptr.getNext() != null) {
			fptr = fptr.getNext().getNext();
			sptr = sptr.getNext();
			if (fptr == sptr) {
				System.out.println("Loop found");
				return fptr;
			}
		}
		return null;
	}

	public static int getPointOfIntersection(LinkList list1, LinkList list2) {
		int l1 = 0, l2 = 0;
		int diff = 0;
		LinkList temp = list1;
		while (temp != null) {
			temp = temp.getNext();
			l1++;
		}
		temp = list2;
		while (temp != null) {
			temp = temp.getNext();
			l2++;
		}
		if (l1 > l2) {
			diff = l1 - l2;
			return getIntersectionNode(diff, list1, list2);
		} else {
			diff = l2 - l1;
			return getIntersectionNode(diff, list2, list1);
		}
	}

	private static int getIntersectionNode(int extra, LinkList higher, LinkList lower) {
		while (extra > 0) {
			higher = higher.getNext();
			extra--;
		}
		while (higher != null && lower != null) {
			if (higher.getData() == lower.getData()) {
				return higher.getData();
			}
			higher = higher.getNext();
			lower = lower.getNext();
		}
		return 0;
	}

	public static void deleteNode(LinkList head) {

	}

	public static LinkList mergeAtAlternate(LinkList l1, LinkList l2) {
		printAList(l1);
		printAList(l2);
		LinkList f = l1, s = l2;
		LinkList fNext, sNext = null;
		while (f != null && s != null) {
			fNext = f.getNext();
			sNext = s.getNext();
			f.setNext(s);
			s.setNext(fNext);
			f = fNext;
			s = sNext;
		}
		return l1;
	}

	public static void makeLastNodeFirst(LinkList head) {
		LinkList prev = null;
		LinkList cur = head;
		while (cur.getNext() != null) {
			prev = cur;
			cur = cur.getNext();
		}
		prev.setNext(null);
		cur.setNext(head);
		head = cur;
		printAList(head);
	}

	public static LinkList rotateByKNodes(LinkList head, int k) {
		LinkList cur = head;
		while (k-- > 1) {
			cur = cur.getNext();
		}
		LinkList kth = cur;
		while (cur.getNext() != null) {
			cur = cur.getNext();
		}
		cur.setNext(head);
		head = kth.getNext();
		kth.setNext(null);
		return head;
	}

	public static LinkList swapEvery2Nodes(LinkList head) {
		LinkList temp = head;
		while (temp != null && temp.getNext() != null) {
			int k = temp.getData();
			temp.setData(temp.getNext().getData());
			temp.getNext().setData(k);
			temp = temp.getNext().getNext();
		}
		return head;
	}

	public static LinkList removeDuplicateNodes(LinkList head) {
		LinkList ptr1 = head;
		LinkList ptr2 = null;
		while (ptr1 != null && ptr1.getNext() != null) {
			ptr2 = ptr1;
			while (ptr2.getNext() != null) {
				if (ptr1.getData() == ptr2.getNext().getData()) {
					ptr2.setNext(ptr2.getNext().getNext());
				} else {
					ptr2 = ptr2.getNext();
				}
			}
			ptr1 = ptr1.getNext();
		}
		return head;
	}

	public static LinkList deleteAlternateNodes(LinkList head) {
		LinkList p = head, q = head.getNext();
		while (p != null & q != null) {
			p.setNext(q.getNext());
			p = q.getNext();
			if (p != null) {
				q = p.getNext();
			}
		}
		return head;
	}
}
