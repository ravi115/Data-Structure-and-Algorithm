# Data-Structure-and-Algorithm
All Data Structure and Algorithm program.


** Binary Search Algorithm

-------------------------------------------------------------------------------------------------------------------------------
** Binary search:
- problem is to find key element by splting into array into two halfs. recursively/iteratively(left array | right array)
- mid = start + (end - start)/2
- arr[mid] == key; return index mid
- arr[mid] > key; BS(left, key)
- arr[mid] < key; BS(right, key)
------------------------------------------------------------------------------------------------------------------------------

** Order not know in binarySearch (means either array is ascending or descending is not known) ||
   example Array: int arr[] = {10, 15, 20, 25, 30} | int descArr[] = {30, 25, 20, 15, 10};
- figure out array is in ascending or descending
- boolean isAscending = arr[start] < arr[descending]
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

** Find fisrt and last element in binary search 
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

** Find Element in rotated sorted array
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

** Nearly sorted array
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

** count of element in sorted array
  - count = last_occurence_pos - first_occurence_pos + 1
  
----------------------------------------------------------------------------------------------------------------------------------------   

** Floor of a number
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
- 
