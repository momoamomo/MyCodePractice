package nowcoderHW.part1;

import java.util.Scanner;

/**
 * @author sunzhilin
 * @date 2020/8/28  17:46
 */
public class HJ18识别有效IP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString;
        IpAddressAndMask ipAddressAndMask = new IpAddressAndMask();
        while (sc.hasNext()) {
            inputString = sc.next();
            ipAddressAndMask.checkIpAndMask(inputString);
        }
        ipAddressAndMask.printCountResult();
    }
}

class IpAddressAndMask {
    private int countIp[];
    private int countPrivateIp = 0;
    private int countErrorIpOrMask = 0;

    public IpAddressAndMask() {
        //ABCDE五类，countIp[0]-->A类IP地址个数
        countIp = new int[5];
    }

    public void checkIpAndMask(String ipAndMask) {
        int index = ipAndMask.indexOf('~');
        String ip = ipAndMask.substring(0, index);
        String mask = ipAndMask.substring(index + 1);
        int returnIndex = classifyIpAndMask(ip, mask);
        if (returnIndex != -1) {
            countIp[returnIndex]++;
        } else {
            countErrorIpOrMask++;
        }
    }

    /**
     * @param ip
     * @param mask
     * @return 0 represent A IP , 1 represent B Ip ,2 represent C Ip, 3 represent D Ip
     * 4 represent E Ip,   -1 represent errorIp
     */
    public int classifyIpAndMask(String ip, String mask) {
        if (isErrorIp(ip)) {
            return -1;
        }
        if (isErrorMask(mask)) {
            return -1;
        }
        //用 . 做分隔符时  .点是转义字符
        String[] split = ip.split("\\.");
        int[] splitNumber = new int[split.length];
        int i = 0;
        for (String e : split) {
            splitNumber[i] = Integer.parseInt(e);
            i++;
        }
        boolean isPrivateIpAddress =
                splitNumber[2] >= 0 && splitNumber[2] <= 255 && splitNumber[3] >= 0 && splitNumber[3] <= 255
                && ((splitNumber[0] == 10 && splitNumber[1] >= 0 && splitNumber[1] <= 255)
                || (splitNumber[0] == 172 && splitNumber[1] >= 16 && splitNumber[1] <= 31)
                || (splitNumber[0] == 192 && splitNumber[1] == 168)
        );
        if (isPrivateIpAddress) {
            countPrivateIp++;
        }
        if (splitNumber[0] >= 1 && splitNumber[0] <= 126) {
            return 0;
        } else if (splitNumber[0] >= 128 && splitNumber[0] <= 191) {
            return 1;
        } else if (splitNumber[0] >= 192 && splitNumber[0] <= 223) {
            return 2;
        } else if (splitNumber[0] >= 224 && splitNumber[0] <= 239) {
            return 3;
        } else if (splitNumber[0] >= 240 && splitNumber[0] <= 255) {
            return 4;
        }
        return -1;
    }

    /**
     * 判断是否为错误的IP（1:只包含数字和点，2：点的个数为3个,3:点不能连续出现）
     *
     * @param ip
     * @return
     */
    public boolean isErrorIp(String ip) {
        int countDot = 0;
        for (int i = 0; i < ip.length(); i++) {
            boolean isNumbeiOrDot = '0' <= ip.charAt(i) && ip.charAt(i) <= '9' || ip.charAt(i) == '.';
            if (!isNumbeiOrDot) {
                return true;
            }
            if (ip.charAt(i) == '.') {
                countDot++;
                if (countDot > 3) {
                    return true;
                }
                if (i - 1 >= 0 && ip.charAt(i - 1) == '.' || i + 1 < ip.length() && ip.charAt(i + 1) == '.') {
                    return true;
                }
            }

        }
        if (countDot != 3) {
            return true;
        }
        String[] split = ip.split("\\.");
        int[] spiltNumber = new int[split.length];
        int i = 0;
        for (String e : split) {
            spiltNumber[i] = Integer.parseInt(e);
            if (spiltNumber[i] < 0 || spiltNumber[i] > 255) {
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * 是否为错误的掩码
     *
     * @param mask
     * @return
     */
    public boolean isErrorMask(String mask) {
        if (isErrorIp(mask)) {
            return true;
        }
        String[] spilt = mask.split("\\.");
        int[] spiltNumber = new int[spilt.length];
        int i = 0;
        for (String e : spilt) {
            spiltNumber[i] = Integer.parseInt(e);
            i++;
        }
        int continusOne[] = {0b1111_1111, 0b1111_1110, 0b1111_1100, 0b1111_1000,
                0b1111_0000, 0b1110_0000, 0b1100_0000, 0b1000_0000, 0};
        int index = 0;
        //掩码为32位可以分为4个8位    分4段考虑，0段，1段，2段，3段 先从0段index=0开始考虑，
        // 如果0段有出现二进制0则  1段，2段，3段必须全为0 否则不是掩码
        while (index < 4) {
            for (int j = 0; j < continusOne.length; j++) {
                if (spiltNumber[index] == continusOne[j]) {
                    //判断第index 段的8位是不是1111_1111
                    if (j != 0) {
                        int indextemp = index;
                        while (indextemp < 4) {
                            indextemp++;
                            //如果第index 段的8位不是1111_1111 则index以后的每一段都必须为0,为错误掩码
                            if (indextemp < 4 && spiltNumber[indextemp] != 0) {
                                return true;
                            }
                        }
                    }
                    break;
                }
            }
            index++;
        }
        return false;
    }

    public void printCountResult() {
        for (int e : countIp) {
            System.out.println(e + " ");
        }
        System.out.println(countErrorIpOrMask + " " + countPrivateIp);
    }
}
