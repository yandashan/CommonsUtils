package com.mountain.MathUtilsDemo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <p>
 *     常用的浮点数处理工具类
 * </p>
 * @author mountain
 */
public class BigDecimalUtil {

    /**
     * 创建一个参数为整数的一个BigDecimal对象
     */
    public BigDecimal createIntOBJ(int num){
        return new BigDecimal(num);
    }
    /**
     * 创建一个参数为浮点数类型的一个BigDecimal对象【不推荐使用】
     */
    public BigDecimal createDoubleOBJ(double num){
        return new BigDecimal(num);
    }
    /**
     * 创建一个参数为长整型的一个BigDecimal对象
     */
    public BigDecimal createLongOBJ(long num){
        return new BigDecimal(num);
    }
    /**
     * 创建一个参数为字符串表示的数值的一个BigDecimal对象【不推荐使用】
     */
    public BigDecimal createStringOBJ(String num){
        return new BigDecimal(num);
    }

    /**
     * 获得输出的小数位数【包含0】
     */
    public Integer getScaleAllNum(BigDecimal num){
        return num.scale();
    }

    /**
     * 获得输出的小数位数【不包含0】,如果返回值是负数，表示这个数时整数并且某尾有负数绝对值个0
     */
    public Integer getScaleNum(BigDecimal num){
        return num.stripTrailingZeros().scale();
    }

    /**
     * 获取对浮点数进行四舍五入【不推荐】
     * @param num
     * @param keep
     * @return
     */
    public BigDecimal getScaleHalfUp(BigDecimal num,int keep){
        return num.setScale(keep, RoundingMode.HALF_UP);
    }

    /**
     * 获取对浮点数尾数直接截断【当保留位数大于等于存在位数时，会自动降低精度】【不推荐】
     * @param num
     * @param keep
     * @return
     */
    public BigDecimal getScaleDown(BigDecimal num,int keep){
        return num.setScale(keep, RoundingMode.DOWN);
    }

    /**
     * 设置保留为几位小数【默认四舍五入】
     * @param num
     * @param keep
     * @return
     */
    public BigDecimal getScaleRoundHalfUp(BigDecimal num,int keep){
        return num.setScale(keep, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 比较大小【包含精度比较】【>0-大，<0-小，=0-等于】
     * @param num1
     * @param num2
     * @return
     */
    public int compareSize(BigDecimal num1,BigDecimal num2){
        return num1.compareTo(num2);
    }

    public static void main(String[] args) {
        float num1 = 1;
        double num2 = 1.99;
        BigDecimalUtil bigDecimalUtil = new BigDecimalUtil();
        BigDecimal doubleOBJ1 = bigDecimalUtil.createDoubleOBJ(num1);
        BigDecimal doubleOBJ2 = bigDecimalUtil.createDoubleOBJ(num2);

        System.out.print(num1 + "\n");
        System.out.print(num2 + "\n");
        System.out.print(bigDecimalUtil.getScaleAllNum(doubleOBJ2) + "\n");
        System.out.print(bigDecimalUtil.getScaleNum(doubleOBJ2) + "\n");
        System.out.print(bigDecimalUtil.getScaleHalfUp(doubleOBJ2,1) + "\n");
        System.out.print(bigDecimalUtil.getScaleDown(doubleOBJ2,3) + "\n");
        System.out.print(bigDecimalUtil.getScaleRoundHalfUp(doubleOBJ2,1) + "\n");

    }
}
