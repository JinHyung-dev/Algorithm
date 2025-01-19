class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1; //1배열의 유효값 마지막 인덱스(최대값)
        int j = n-1; //2배열의 유효값 마지막 인덱스(최대값)
        int k = m + n - 1; //최종 병합된 1배열의 마지막 인덱스

        while(i >= 0 && j >= 0) {
            //1배열의 최대값이 2배열의 최대값보다 클때
            if(nums1[i] > nums2[j]) {
                //1배열 최대값을 빈 공간으로 이동 후 1배열 포인터만 이동
                nums1[k--] = nums1[i--];
            } else {
                // 1배열의 최대값이 2배열 최대값보다 작을때
                nums1[k--] = nums2[j--];
            }
        }

        // 2배열 값이 남아있을 경우 추가 병합
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}