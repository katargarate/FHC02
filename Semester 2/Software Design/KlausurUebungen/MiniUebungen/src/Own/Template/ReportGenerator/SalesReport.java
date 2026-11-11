package Own.Template.ReportGenerator;

public class SalesReport extends Report {

    @Override
    protected String format(String data) {
        String[] strNums = data.split(";");
        int[] nums = new int[strNums.length];

        for (int i = 0; i < strNums.length; i++) {
            nums[i] = Integer.parseInt(strNums[i]);
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return String.format("Umsatzbericht: %d", sum);
    }

    @Override
    protected String gatherData() {
        return "100;250;50";
    }
}
