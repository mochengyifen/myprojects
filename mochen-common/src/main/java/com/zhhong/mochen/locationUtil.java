package com.zhhong.mochen;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 董仁亮
 * @date 2020-01-14 14:15
 * @Description:经纬度工具类
 */
public class locationUtil {
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }


    /**
     * @date:2019-08-28 18:33
     *@description:通过经纬度获取距离(单位：千米)
     *
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(
                Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        return s;

    }

    /**
     * @Description:判断一个点是否在圆形区域内
     *
     * e:lng经度，lat纬度，radius距离
     * @return:
     */
    public static boolean isInCircle(double lng1, double lat1, double lng2, double lat2, double radius) {
        double distance = getDistance(lat1, lng1, lat2, lng2);
        if (distance > radius/1000) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断是否在多边形区域内
     *
     *  pointLon 要判断的点的纵坐标
     *  pointLat 要判断的点的横坐标
     *  lon 区域各顶点的纵坐标数组
     *  lat 区域各顶点的横坐标数组
     * @return
     */
    public static boolean isInPolygon(double pointLon, double pointLat, double[] lon, double[] lat) {
        // 将要判断的横纵坐标组成一个点
        Point2D.Double point = new Point2D.Double(pointLon, pointLat);
        // 将区域各顶点的横纵坐标放到一个点集合里面
        List<Point2D.Double> pointList = new ArrayList<Point2D.Double>();
        double polygonPoint_x = 0.0, polygonPoint_y = 0.0;
        for (int i = 0; i < lon.length; i++) {
            polygonPoint_x = lon[i];
            polygonPoint_y = lat[i];
            Point2D.Double polygonPoint = new Point2D.Double(polygonPoint_x, polygonPoint_y);
            pointList.add(polygonPoint);
        }
        return check(point, pointList);
    }

    /**
     * 一个点是否在多边形内
     *
     *  point  要判断的点的横纵坐标
     *  polygon 组成的顶点坐标集合
     * @return
     */
    private static boolean check(Point2D.Double point, List<Point2D.Double> polygon) {
        java.awt.geom.GeneralPath peneralPath = new java.awt.geom.GeneralPath();

        Point2D.Double first = polygon.get(0);
        // 通过移动到指定坐标（以双精度指定），将一个点添加到路径中
        peneralPath.moveTo(first.x, first.y);
        polygon.remove(0);
        for (Point2D.Double d : polygon) {
            // 通过绘制一条从当前坐标到新指定坐标（以双精度指定）的直线，将一个点添加到路径中。
            peneralPath.lineTo(d.x, d.y);
        }
        // 将几何多边形封闭
        peneralPath.lineTo(first.x, first.y);
        peneralPath.closePath();
        // 测试指定的 Point2D 是否在 Shape 的边界内。
        return peneralPath.contains(point);
    }

    // lngStr经度 latStr纬度/单位米/range搜索的范围
    public static List<Double> getLngLats(double lngStr, double latStr, double range) {
        // TODO Auto-generated method stub
        // 先计算查询点的经纬度范围
        double r = 6371;// 地球半径千米
        double dis = range / 1000;// 0.5千米距离
        double dlng = 2 * Math.asin(Math.sin(dis / (2 * r)) / Math.cos(latStr * Math.PI / 180));
        dlng = dlng * 180 / Math.PI;// 角度转为弧度
        double dlat = dis / r;
        dlat = dlat * 180 / Math.PI;
        double minlat = latStr - dlat;
        double maxlat = latStr + dlat;
        double minlng = lngStr - dlng;
        double maxlng = lngStr + dlng;
        List<Double> lngLats = new ArrayList<Double>();
        lngLats.add(minlng);
        lngLats.add(maxlng);
        lngLats.add(minlat);
        lngLats.add(maxlat);
        return lngLats;
    }


    /** 长半径a=6378137 */
    private static double a = 6378137;
    /** 短半径b=6356752.3142 */
    private static double b = 6356752.3142;
    /** 扁率f=1/298.2572236 */
    private static double f = 1 / 298.2572236;

    /**
     * 弧度换成度
     *  x 弧度
     * @return 度
     */
    private static double deg(double x) {
        return x * 180 / Math.PI;
    }


    /**
     * 计算另一点经纬度
     *
     *  lon 经度
     *  lat 维度
     *  brng 方位角
     *  dist 距离（米）
     */
    public static List<Double> computerThatLonLat( double lat, double lon, double brng, double dist) {

        double alpha1 = rad(brng);
        double sinAlpha1 = Math.sin(alpha1);
        double cosAlpha1 = Math.cos(alpha1);

        double tanU1 = (1 - f) * Math.tan(rad(lat));
        double cosU1 = 1 / Math.sqrt((1 + tanU1 * tanU1));
        double sinU1 = tanU1 * cosU1;
        double sigma1 = Math.atan2(tanU1, cosAlpha1);
        double sinAlpha = cosU1 * sinAlpha1;
        double cosSqAlpha = 1 - sinAlpha * sinAlpha;
        double uSq = cosSqAlpha * (a * a - b * b) / (b * b);
        double A = 1 + uSq / 16384 * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));

        double cos2SigmaM=0;
        double sinSigma=0;
        double cosSigma=0;
        double sigma = dist / (b * A), sigmaP = 2 * Math.PI;
        while (Math.abs(sigma - sigmaP) > 1e-12) {
            cos2SigmaM = Math.cos(2 * sigma1 + sigma);
            sinSigma = Math.sin(sigma);
            cosSigma = Math.cos(sigma);
            double deltaSigma = B * sinSigma * (cos2SigmaM + B / 4 * (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM)
                    - B / 6 * cos2SigmaM * (-3 + 4 * sinSigma * sinSigma) * (-3 + 4 * cos2SigmaM * cos2SigmaM)));
            sigmaP = sigma;
            sigma = dist / (b * A) + deltaSigma;
        }

        double tmp = sinU1 * sinSigma - cosU1 * cosSigma * cosAlpha1;
        double lat2 = Math.atan2(sinU1 * cosSigma + cosU1 * sinSigma * cosAlpha1,
                (1 - f) * Math.sqrt(sinAlpha * sinAlpha + tmp * tmp));
        double lambda = Math.atan2(sinSigma * sinAlpha1, cosU1 * cosSigma - sinU1 * sinSigma * cosAlpha1);
        double C = f / 16 * cosSqAlpha * (4 + f * (4 - 3 * cosSqAlpha));
        double L = lambda - (1 - C) * f * sinAlpha
                * (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM)));

        double revAz = Math.atan2(sinAlpha, -tmp); // final bearing

        System.out.println(revAz);
        System.out.println(lon+deg(L)+","+deg(lat2));

        List<Double> ltReturn = new ArrayList<Double>();
        ltReturn.add(deg(lat2));
        ltReturn.add(lon+deg(L));
        return ltReturn;
    }


    //计算方位角
    /**
     * 计算方位角
     *  lat_a
     *  lng_a
     *  lat_b
     *  lng_b
     * @return
     */
    public static double azimuthAngle(double lat_a, double lng_a, double lat_b, double lng_b) {
        double d = 0;
        lat_a=lat_a*Math.PI/180;
        lng_a=lng_a*Math.PI/180;
        lat_b=lat_b*Math.PI/180;
        lng_b=lng_b*Math.PI/180;
        d=Math.sin(lat_a)*Math.sin(lat_b)+Math.cos(lat_a)*Math.cos(lat_b)*Math.cos(lng_b-lng_a);
        d=Math.sqrt(1-d*d);
        d=Math.cos(lat_b)*Math.sin(lng_b-lng_a)/d;
        d=Math.asin(d)*180/Math.PI;
        return d;
    }
}
