/*
LeetCode 2161 - Partition Array According to Given Pivot

Approach 1: Three Lists
TC: O(n)
SC: O(n)
--------------------------------------------------

Approach 2: Count + Direct Placement
TC: O(n)
SC: O(n)


*/


/*
Appproach 1:3 lists

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lesser = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        for(int n : nums){
            if(n == pivot){
                equal.add(n);
            }else if(n < pivot){
                lesser.add(n);
            }else{
                greater.add(n);
            }
        }
        int[] res = new int[nums.length];
        int index=0;
        int i=0;
        while(i<lesser.size()){
            res[index]=lesser.get(i);
            //lesser.remove(0);
            i++;
            index++;
        }
        int j=0;
        while(j<equal.size()){
            res[index]= equal.get(j);
            j++;
            index++;
        }
        int k=0;
        while(k<greater.size()){
            res[index] = greater.get(k);
            k++;
            index++;
        }
        return res;
    }
}

*/
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int lessCount =0;
        int equalCount =0;
        int greatCount =0;
        int[] res = new int[nums.length];
        for(int n :nums){
            if(n<pivot)lessCount++;
            else if(n> pivot)greatCount++;
            else equalCount++;
        }
        int lessIndex =0;
        int equalIndex = lessCount;
        int greatIndex =lessCount+equalCount;
        for(int n : nums){
            if(n<pivot){
                res[lessIndex]=n;
                lessIndex++;
            }else if(n>pivot){
                res[greatIndex]=n;
                greatIndex++;
            }else{
                res[equalIndex]=n;
                equalIndex++;
            }
        }
        return res;
    }
}

