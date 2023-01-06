/**
 * @author sichu
 * @date 2023/01/06
 **/
public class Solution {
    public double[] convertTemperature(double celsius) {
        return new double[] {celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
