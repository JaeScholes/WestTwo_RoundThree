import java.sql.*;
import java.util.List;

public class DbUtil {
    //设置连接
    public static final String URL = "jdbc:mysql://localhost:3306/west2?allowPublicKeyRetrieval=true&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    static Connection conn = null;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //构建链接
        Connection conn = null;
            try {
                conn = getConnection();
                System.out.println(conn);
                System.out.println("连接成功");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        //创建httpComponent -- 建立与网站信息的链接并获取疫情信息 用对象保存
        HttpComponentsStuff component = new HttpComponentsStuff();
            //ps 获取时 不允许空格等原网站不合法字符 检测不合法则抛出(比如说 空格)
            //ps 拥有下属省份的国家如英国 中国 日本 美国 国家整体信息里不存在updated更新时间 long lat经纬度
            //   这些信息会在省份中体现
            //ps 而类似于阿尔巴尼亚这类没有下属（在网站中）省份的国家中 updated long 和 lat 则均可以在整体信息中体现

        //创建对应对象
        Epidemic_Country unitedkingdom = component.getResponseOnCountry("United%20Kingdom") ;
        Epidemic_Country china = component.getResponseOnCountry("china")   ;
        Epidemic_Country us = component.getResponseOnCountry("us")   ;
        Epidemic_Country japan = component.getResponseOnCountry("japan")   ;
        Epidemic_Country albania = component.getResponseOnCountry("albania");
        List<Epidemic_Province> proUK = component.getResponseOnProvince("United%20Kingdom");
        Epidemic_Province anguilla = component.getResponseOnProvince("United%20Kingdom","anguilla");

        //创建Dao类来代理操作
        Epidemic_CountryDao countryDao  = new Epidemic_CountryDao();
        Epidemic_ProvinceDao provinceDao = new Epidemic_ProvinceDao();

        //各种操作
        //判断 是否存在表 若不存在则进行创建 否则跳过
        if(!validateTableExist("Epidemic_Country")){
            countryDao.buildEpidemic_Country();
        }
        if(!validateTableExist("Epidemic_Province")){
            provinceDao.buildEpidemic_Province();
        }

        countryDao.addEpidemic_Country(unitedkingdom);
        countryDao.addEpidemic_Country(china);
        countryDao.addEpidemic_Country(us);
        countryDao.addEpidemic_Country(japan);
        countryDao.addEpidemic_Country(albania);
        provinceDao.addEpidemic_Province(anguilla);
        for(int n=0 ; n<proUK.size() ; n++){
            provinceDao.addEpidemic_Province(proUK.get(n));
            provinceDao.findEpidemic_ProvinceList(proUK.get(n).getProvince());
        }
        countryDao.findEpidemic_CountryList("china");
        countryDao.findEpidemic_CountryList("us");
        countryDao.findEpidemic_CountryList("United Kingdom");
        countryDao.findEpidemic_CountryList("japan");
        countryDao.findEpidemic_CountryList("albania");
        provinceDao.findEpidemic_ProvinceList("anguilla");

        //进行一次删除
        countryDao.delEpidemic_Country(albania);
        //进行一次更新 -- 更新时 根据时间更新
        countryDao.updateEpidemic_Country(us);

    }

    //获取链接
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }
    //关闭连接
    public static void close(PreparedStatement pstmt){
        if(pstmt != null){						//避免出现空指针异常
            try{
                pstmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public static boolean validateTableExist(String tableName) throws SQLException {
        //定义一个变量标示
        DatabaseMetaData dmd = conn.getMetaData();
        boolean flag = true ;
        ResultSet rs = dmd.getTables(null, null, "TEST", null);
        try {
            if (rs.next()) flag=true;
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();
        }
        return flag;
    }


}