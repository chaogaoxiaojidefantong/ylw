	package com.canteen.common.util;

import java.util.Random;
import java.util.UUID;

    public class RandomUtil {

            /**
             * 返回随机数,一般用来保证文件不会重名
             * @return
             */
            public static String UUIDrandom() {
                return UUID.randomUUID().toString()
                .replace("-", "");
            }

            /**
             * 返回随机验证码
             * @param number 随机验证码的个数
             */
            public static String randomVerifyCode(int number) {

                String codeNum = "";
                int [] code = new int[3];
                Random random = new Random();
                for (int i = 0; i < number; i++) {
                    int num = random.nextInt(10) + 48;
                    int uppercase = random.nextInt(26) + 65;
                    int lowercase = random.nextInt(26) + 97;
                    code[0] = num;
                    code[1] = uppercase;
                    code[2] = lowercase;
                    codeNum+=(char)code[random.nextInt(3)];
                }
                System.out.println(codeNum);
                return codeNum;
            }
        }
