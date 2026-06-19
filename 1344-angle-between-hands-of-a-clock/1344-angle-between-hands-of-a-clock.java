class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = minutes * 6;
        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
        double angle = Math.abs(hourAngle - minuteAngle);
        double min = Math.min(angle, 360 - angle);
        return min;
    }
}