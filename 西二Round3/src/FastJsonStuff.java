import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FastJsonStuff {
    //根据所要查找的目标（国家|省份）来进行解析

    //当目的是解析国家时
    public static Epidemic_Country convertTo_Epidemic_Country(String inf_country) {
         //转化为JSON对象
         JSONObject totalInf = JSON.parseObject(inf_country);
         //在整条数据中抽出 包含国家整体信息的部分
         String country = totalInf.getString("All");
        //为了获取long字段--long由于命名原因用longitude来代替 但是longitude无法获取原网站long信息 因此需要再次转回来获取
        JSONObject countryJson = JSON.parseObject(country);
         Double longitude = countryJson.getDouble("long");
         //利用对象进行储存
         Epidemic_Country aCountry = JSON.parseObject(country,Epidemic_Country.class);
        if(longitude!=null) {
            //进行赋值
            aCountry.setLongitude(longitude);
        }
         return aCountry;
    }

    //当目的是解析省份时
    public static Epidemic_Province convertToEpidemic_Province(String inf_country, String inf_province) {
        //转化为JSON对象
        JSONObject totalInf = JSON.parseObject(inf_country);
        //在整条数据中抽出 包含对应省份信息的部分
        String province = totalInf.getString(inf_province);
        //为了获取long字段--long由于命名原因用longitude来代替 但是longitude无法获取原网站long信息 因此需要再次转回来获取
        JSONObject provinceJson = JSON.parseObject(province);
        Double longitude = provinceJson.getDouble("long");
        //将这部分信息利用对象储存
        Epidemic_Province aProvince = JSON.parseObject(province,Epidemic_Province.class);
        if(longitude!=null) {
            //进行赋值
            aProvince.setLongitude(longitude);
        }
        return aProvince;
    }


    //当需要去获取一个国家里的所有省份
    public static List<Epidemic_Province> convertToEpidemic_Province(String inf_country){
        //转化为JSON对象
        JSONObject totalInf = JSON.parseObject(inf_country);
        //用集合来收集所有符合要求的省份
        List<Epidemic_Province> provinces = new ArrayList<>();
        //遍历所有的key来寻找每个省份的单独信息
        for (Map.Entry<String, Object> entry : totalInf.entrySet()) {
            //抛掉国家信息
            if(entry.getKey()!="All"){
                //获取只含省份的信息
                String inf_only_province = totalInf.getString(entry.getKey());
                //用省份对象来储存省份信息
                Epidemic_Province aProvince = JSON.parseObject(inf_only_province,Epidemic_Province.class);
                //为了获取long字段--long由于命名原因用longitude来代替 但是longitude无法获取原网站long信息 因此需要再次转回来获取
                JSONObject provinceJson = JSON.parseObject(inf_only_province);
                Double longitude = provinceJson.getDouble("long");
                //注意应对空指针问题
                if(longitude!=null) {
                    //进行赋值
                    aProvince.setLongitude(longitude);
                }
                //获取省份名字
                aProvince.setProvince(entry.getKey());
                provinces.add(aProvince);
            }
        }
        return provinces;
    }

}



