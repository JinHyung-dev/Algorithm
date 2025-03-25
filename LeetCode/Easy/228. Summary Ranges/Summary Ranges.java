class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int start = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] + 1 != nums[i]) { // 이전값과 현재값이 같지 않으면(연속x면 저장)
                if(start == i - 1) { // 시작인덱스밖에 없을 때 저장
                    result.add(String.valueOf(nums[start]));
                } else { // 연속 범위 저장
                    result.add(nums[start] + "->" + nums[i-1]);
                }
                // 저장 후 시작값 초기화
                start = i;
            }
        }
        // 마지막 시작값 추가 계산
        if(start == nums.length - 1) { // 남은 시작값이 마지막 인덱스일 때
            result.add(String.valueOf(nums[start]));
        } else {
            result.add(nums[start] + "->" + nums[nums.length-1]);
        }
        return result;
    }
}