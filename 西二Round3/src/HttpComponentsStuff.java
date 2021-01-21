import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.util.List;

public class HttpComponentsStuff {

    //只寻找国家
    public static Epidemic_Country getResponseOnCountry(String country) {
        //构建对信息来源的链接
        HttpGet get_country = new HttpGet("https://covid-api.mmediagroup.fr/v1/cases?country=" + country);
        //构建Client
        CloseableHttpClient client_country = HttpClientBuilder.create().build();
        //创建Response
        CloseableHttpResponse response_country = null;
        String inf_country = null;
        Epidemic_Country aCountry = null;
        try {
            //response执行链接
            response_country = client_country.execute(get_country);
            //若构建成功则执行
            if (response_country.getCode() == 200) {
                //获取信息串
                inf_country = EntityUtils.toString(response_country.getEntity(), "UTF-8");
                //新建Json用于解析信息串
                FastJsonStuff json = new FastJsonStuff();
                //用对象承接解析后的信息
                aCountry = json.convertTo_Epidemic_Country(inf_country);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭连接
            if (response_country != null) {
                try {
                    response_country.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return aCountry;
    }

    //只寻找省份
    public static Epidemic_Province getResponseOnProvince(String country,String province) {
        //构建对信息来源的链接
        HttpGet get_country = new HttpGet("https://covid-api.mmediagroup.fr/v1/cases?country=" + country);
        //构建Client
        CloseableHttpClient client_country = HttpClientBuilder.create().build();
        //创建Response
        CloseableHttpResponse response_country = null;
        String inf_country = null;
        Epidemic_Province aProvince = null;
        try {
            //response执行链接
            response_country = client_country.execute(get_country);
            //若构建成功则执行
            if (response_country.getCode() == 200) {
                //获取信息串
                inf_country = EntityUtils.toString(response_country.getEntity(), "UTF-8");
                //新建Json用于解析信息串
                FastJsonStuff json = new FastJsonStuff();
                //用对象承接解析后的信息
                aProvince = json.convertToEpidemic_Province(inf_country,province);
                //针对部分省份的国家名字中带有空格所做的调整（在此网站中 空格是非法输入需要用“%20”来替代）
                //为了观看美观 在此将”%20“再替换为空格
                if(country.contains("%20")){
                      country = country.replace("%20"," ");
                }
                //由于省份信息中没有国家名字和省份名字因此单独赋值
                aProvince.setCountry(country);
                aProvince.setProvince(province);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭连接
            if (response_country != null) {
                try {
                    response_country.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return aProvince;
    }
    //只寻找省份
    public static List<Epidemic_Province> getResponseOnProvince(String country) {
        //构建对信息来源的链接
        HttpGet get_country = new HttpGet("https://covid-api.mmediagroup.fr/v1/cases?country=" + country);
        //构建Client
        CloseableHttpClient client_country = HttpClientBuilder.create().build();
        //创建Response
        CloseableHttpResponse response_country = null;
        String inf_country = null;
        List<Epidemic_Province> provinces = null;
        try {
            //response执行链接
            response_country = client_country.execute(get_country);
            //若构建成功则执行
            if (response_country.getCode() == 200) {
                //获取信息串
                inf_country = EntityUtils.toString(response_country.getEntity(), "UTF-8");
                //新建Json用于解析信息串
                FastJsonStuff json = new FastJsonStuff();
                //用对象承接解析后的信息
                provinces = json.convertToEpidemic_Province(inf_country);
                //针对部分省份的国家名字中带有空格所做的调整（在此网站中 空格是非法输入需要用“%20”来替代）
                //为了观看美观 在此将”%20“再替换为空格
                if(country.contains("%20")){
                    country = country.replace("%20"," ");
                }
                //由于省份信息中没有国家名字因此单独赋值
                for (int n=0 ; n<provinces.size() ; n++){
                    provinces.get(n).setCountry(country);
                }

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭连接
            if (response_country != null) {
                try {
                    response_country.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return provinces;
    }






}
