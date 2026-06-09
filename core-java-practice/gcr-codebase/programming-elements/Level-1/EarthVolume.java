public class EarthVolume {
    public static void main(String[] args) {
        double radius = 6378;
        double volumeKm = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        double volumeMiles = volumeKm * 0.239913;

        System.out.println("The volume of earth in cubic kilometers is " +
                volumeKm + " and cubic miles is " + volumeMiles);
    }
}
