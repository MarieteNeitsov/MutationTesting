package ee.ut.cs.swt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumBinaryHeapTest {
	
	private MinimumBinaryHeap heap;
	private List<Integer> result;
	
	@BeforeEach
	public void setUp() {
		heap = new MinimumBinaryHeap();
		result = new ArrayList<>();
		result.add(10);
		result.add(5);
		result.add(4);
		result.add(8);
		result.add(12);
	}
	
	@Test
	public void minHeapifyTest() {
		heap.minHeapify(result);
		assertEquals(4, heap.getArray().get(0), 0);
		assertEquals(8, heap.getArray().get(1), 0);
		assertEquals(5, heap.getArray().get(2), 0);

	}
	
	@Test
	public void extractMinTest() {
		heap.add(7);
		heap.add(1);
		heap.add(6);
		int min = heap.exractMin();
		assertEquals(1, min);
	}
	
	@Test
	public void swapTest() {
		heap.add(5);
		heap.add(8);
		heap.add(13);
		heap.swap(1, 2);
		assertEquals(5, heap.getArray().get(0), 0);
		assertEquals(13, heap.getArray().get(1), 0);
		assertEquals(8, heap.getArray().get(2), 0);
	}
	
	@Test
	public void addTest() {
		heap.add(10);
		heap.add(5);
		heap.add(4);
		heap.add(8);
		heap.add(12);
		assertEquals(4, heap.getArray().get(0), 0);
		assertEquals(8, heap.getArray().get(1), 0);
		assertEquals(5, heap.getArray().get(2), 0);
	}
	
	@Test
	public void removeTest() {
		heap.add(5);
		heap.add(3);
		heap.add(2);
		boolean b1 = heap.remove(3);

		assertEquals(true, b1);
	}

	@Test
	public void isEmptyTest() {
		heap = new MinimumBinaryHeap();
		assertEquals(true, heap.isEmpty());
	}
	@Test
	public void isNotEmptyTest() {
		heap = new MinimumBinaryHeap();
		heap.add(1);
		assertEquals(false, heap.isEmpty());
	}

	@Test
	public void extractMinOnEmptyHeap() {
		heap = new MinimumBinaryHeap();
		assertThrows(IllegalArgumentException.class, () -> heap.exractMin());
	}
	@Test
	public void removeTestWithOneElement() {
		heap.add(2);
		boolean b1 = heap.remove(2);

		assertEquals(true, b1);
	}
	@Test
	public void extractMinOneElement() {
		heap = new MinimumBinaryHeap();
		heap.add(2);
		int min = heap.exractMin();
		assertEquals(2, min);
	}

	@Test
	public void minHeapifySortedTest() {
		List<Integer> sortedList = new ArrayList<>();
		sortedList.add(1);
		sortedList.add(2);
		sortedList.add(3);
		sortedList.add(4);
		sortedList.add(5);
		heap.minHeapify(sortedList);
		assertEquals(sortedList, heap.getArray());
	}

	@Test
	public void addTestValidateAllPositions() {
		heap.add(10);
		heap.add(5);
		heap.add(4);
		heap.add(8);
		heap.add(12);
		assertEquals(4, heap.getArray().get(0), 0);
		assertEquals(8, heap.getArray().get(1), 0);
		assertEquals(5, heap.getArray().get(2), 0);
		assertEquals(10, heap.getArray().get(3), 0);
		assertEquals(12, heap.getArray().get(4), 0);
	}

	@Test
	public void bubbleUpTest() {
		heap.add(1);
		heap.add(2);
		heap.add(3);
		heap.add(4);
		heap.add(5);

		heap.bubbleUp(heap.getArray().size() - 1);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5), heap.getArray());
	}

	@Test
	public void bubbleDownTest() {
		heap.add(1);
		heap.add(2);
		heap.add(3);
		heap.add(4);
		heap.add(5);

		heap.bubbleDown(0);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5), heap.getArray());
	}

	@Test
	public void removeNonExistentElementTest() {
		heap.add(1);
		heap.add(2);
		heap.add(3);
		heap.add(4);
		heap.add(5);

		assertFalse(heap.remove(6));
	}

	@Test
	public void removeLastTest() {
		heap.add(5);
		heap.add(3);
		heap.add(2);
		boolean b1 = heap.remove(2);

		assertEquals(true, b1);
	}








}

