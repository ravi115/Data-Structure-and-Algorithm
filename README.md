# Data-Structure-and-Algorithm
All Data Structure and Algorithm program.


1. **Binary Search Algorithms**
-------------------------------------------------------------------------------------------------------------------------------
**Binary search**:

*Desc. problem is to find key element by splting into array into two halfs. recursively/iteratively(left array | right array)*
- mid = start + (end - start)/2
- arr[mid] == key; return index mid
- arr[mid] > key; BS(left, key)
- arr[mid] < key; BS(right, key)
------------------------------------------------------------------------------------------------------------------------------

*Desc. Order not know in binarySearch (means either array is ascending or descending is not known) ||
   example Array: int arr[] = {10, 15, 20, 25, 30} | int descArr[] = {30, 25, 20, 15, 10};*
- figure out array is in ascending or descending
- boolean isAscending = arr[start] < arr[end]
- arr[mid] == key; return mid index
- arr[mid] > key
	if (isAscending)
		means search in left
		BS(left, key)
	else
		means descending so search in right
		BS(right, key)
- arr[mid] < key
	if (isAscending)
		means search in right
		BS(right, key)
	else
		BS(left, key)
      
---------------------------------------------------------------------------------------------------------------------------------

*Desc. Find fisrt and last element in binary search* 
int arr[] = {10, 15, 15, 15, 15, 15, 20, 25, 25, 25, 25, 30, 30};
FirstOccurence()
  - apply BS
  - arr[mid] == key; 
      int firstIndex = mid note: if the mid is key then first index will be towards left only
      end = mid -1;
  - arr[mid] > key
  -   BS(left, key)
  - arr[mid] < key
  -   BS( right, key)

LastOccurecne()
apply BS
 - arr[mid] == key
 -  int lastOccurence = mid; if this mid is key then last element will be towards right only
 -  start = mid + 1
 - arr[mid] > key
 -  BS(left, key)
 - arr[mid] < key
 -  BS(right, key) 
----------------------------------------------------------------------------------------------------------------------------------------

*Desc. Find Element in rotated sorted array*
int[] arr2 = {15, 18, 2, 5, 6, 8, 11, 12}; || Key = 5; so index is at 3

findPivot()
  - find the index of min element by which array is rotated.
  - to find the index of min element
  - mid = start + (end - start)/2
  - arr[mid] < arr[mid+1] && arr[mid] < arr[mid -1] return mid;
  - arr[start] < arr[mid]
  -   start = mid + 1
  - arr[mid] < arr[end]
  -   end = mid - 1
 
 
 now apply binary search
 
 - int pivot = findPivot()
 - if (pivot == -1) return -1
 - else if (arr[pivot] == key) return pivot
 - else if (arr[pivot] < key)
    // search in right BS(right, pivot+1)
 - else if (arr[pivot] > key)
    // search in left BS(left, pivot -1)
    
------------------------------------------------------------------------------------------------------------------------------------------------

*Desc. Nearly sorted array*
  neary sorted array is the array whose element original position is shifted by 1 either towards left or right.
  example: sorted array {23, 25, 26, 30}  => nearly sorted array could be {23, 26, 25, 30} || {23, 25, 30, 26}
  
  Note: since array is shifted by index 1, we need to check the element at i-1, i, i+1
  - mid = start + (end - start)/2
  - arr[mid] == key return mid
  - mid > start && arr[mid-1] == key return mid -1
  - mid < end && arr[mid+1] == key return mid + 1 
  - arr[mid] > key end = mid -2
  - arr[mid] < key start = mid + 2

----------------------------------------------------------------------------------------------------------------------------------------------------

*Desc. count of element in sorted array*
  - count = last_occurence_pos - first_occurence_pos + 1
  
----------------------------------------------------------------------------------------------------------------------------------------   

*Desc. Floor of a number*
- floor of a number is the largest number in the array which are smaller than or equal or key
- example: {1,2,3,4,6,7,8} 
- floor of 5 in this array is 4
- floor of 3 in this array is 3
- int index = 0;
- mid = start + (end - start)/2
- arr[mid] == key; index = mid; break;
- arr[mid] > key; end = mid - 1
- arr[mid] < key; start = mid + 1; index = mid
- return arr[index]


*****************************************************************************************************************************


2. **Sorting Algorithm**

a. *Bubble Sort (Sinking Sort)*
- In place and comparison based sorting technique.
- Compare two consecutive elementes and correct their position by swaping them. repeat until last element.
- In first iteration the 0th position element will become sorted. 
- Repeat this comparision for each index of the array.
- *Optimization: use some boolean flag and set to true if no single elements are sorted and break the outer loop based on boolean flag being true*.
- Best & Worst time complexity (n^2).  

b. *Selection Sort*
- In place and comparison based sorting technique.
- Logically devides array into two halves one sorted (left most) and unsorted (right most). but still no extra memory used here to allocate new array as it logically devides the array.
- Example, if an array of size 4 is given then intially sorted will be of 0 element where as unsorted will be the whole array element which is of size 4.
- We start from i = 0 to i < len(arr) and find the minimum one among them and put it in left most which at i = 0; and then increment i++.
- Bascially swap the minimum element with i=0 element in first iteration and then with i=1 in second iteration and so on... 
- Best and Worst time complexity is (n^2).

c. *Insertion Sort (Bin Sort)*
- In place and comparison based sorting technique.
- We compare an element in array to all its left element and correct the position by swapping them based on min/max element depending on its sorting type (asc/desc).
- repeat this steps for all the element in the array.
- For example, we take first element and we leave it at 0th index as there are no other element in left of this element to be compared. then take second element and compare with 0th element as this is the only element towards left and comapre and swap their position. for third element start comparing with element from second towards 0th element and when we found min(in case of desc)/max(in case of asc) then stop there after swaping their position.
- Worst and Average time complexity will be (n^2) but best case will be 0(n) if the element is already sorted. 

c. *Count Sort*
- Note: This is not an inplace and comparision based sorting algorithm.
- This works well with small rage of number given.
- Step 1. find the range from given array.
	- range = (min-elem of array - max-elem of array)
- Step 2. Create an frequncy array of size range.
	- int freq = new int[range + 1]
- Step 3. Iterate through the entire elem of array and update the frequency of each element in the frequency array.
	``` i in arr:
		int index = arr[i] - min;
		freq[index]++;
- Step 4. Now update the ending index position of element in freq array which will be used to prepare final sorted array.
	``` i=1 in freq:
		freq[i] = freq[i-1] + freq[i];
- Step 5. Create an answer array of original size array.
	``` int ans = new int[arr.length]
- Step 6. from end of ariginal array toward start, iterate throough each element in arr and find the index of the element from freq array and put the element into ans at that index and then update the freq array by decrementing the count.
	``` i = arr.length; i >0; i--:
		int index = arr[i] - min;
		int idx = freq[index];
		ans[idx] = arr[i];
		freq[index]--;
- Step 7. copy the ans array into original arr.
	``` for i in ans:
		arr[i] = ans[i]

			
