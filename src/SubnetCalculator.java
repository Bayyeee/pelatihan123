import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SubnetCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan alamat IP (format x.x.x.x): ");
        String ipAddress = scanner.nextLine();

        System.out.print("Masukkan panjang prefix (0-32): ");
        int prefixLength = scanner.nextInt();

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            byte[] ipBytes = inetAddress.getAddress();

            // Menghitung subnet mask
            int subnetMask = (0xFFFFFFFF << (32 - prefixLength)) & 0xFFFFFFFF;

            // Mendapatkan network address
            byte[] networkAddressBytes = new byte[4];
            for (int i = 0; i < 4; i++) {
                networkAddressBytes[i] = (byte) (ipBytes[i] & (subnetMask >> (24 - i * 8)));
            }

            InetAddress networkAddress = InetAddress.getByAddress(networkAddressBytes);

            // Mendapatkan broadcast address
            byte[] broadcastAddressBytes = new byte[4];
            for (int i = 0; i < 4; i++) {
                broadcastAddressBytes[i] = (byte) (networkAddressBytes[i] | (~subnetMask & 0xFF));
            }

            InetAddress broadcastAddress = InetAddress.getByAddress(broadcastAddressBytes);

            // Menghitung jumlah host
            long numHosts = (long) Math.pow(2, (32 - prefixLength)) - 2;

            System.out.println("Network Address: " + networkAddress.getHostAddress());
            System.out.println("Broadcast Address: " + broadcastAddress.getHostAddress());
            System.out.println("Subnet Mask: " + intToIpAddress(subnetMask));
            System.out.println("Jumlah Host: " + numHosts);
        } catch (UnknownHostException e) {
            System.out.println("Alamat IP tidak valid.");
        }
    }

    private static String intToIpAddress(int ip) {
        return ((ip >> 24) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                (ip & 0xFF);
    }
}
