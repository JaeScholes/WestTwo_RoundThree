import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Epidemic_CountryDao {

        //建表语句
        protected void buildEpidemic_Country(){
            //语句
            String sql = "Create table Epidemic_Country ( id INT PRIMARY KEY AUTO_INCREMENT  ," +
                    "country VARCHAR(50) NOT NULL ,  confirmed INT NOT NULL," +
                    "recovered INT NOT NULL, deaths INT NOT NULL," +
                    "population INT, sq_km_area INT, life_expectancy INT," +
                    "elevation_in_meters DOUBLE, continent VARCHAR(40)," +
                    "abbreviation VARCHAR(50), location VARCHAR(50)," +
                    "iso INT,capital_city VARCHAR(50), lat DOUBLE," +
                    "longitude DOUBLE, updated DATE )";
            Connection conn = null;
            PreparedStatement ptmt = null;
            try {
                //开启链接
                conn = DbUtil.getConnection();
                ptmt = conn.prepareStatement(sql);
                //执行
                ptmt.execute();
                System.out.println("------------------\nConstruction is finished.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                //关闭连接
                DbUtil.close(conn);
                DbUtil.close(ptmt);
            }
        }

        //添加记录-->完整的添加-->其他更细节的添加只需要改变values语句即可
        protected void addEpidemic_Country(Epidemic_Country inf) {
            //语句
            String sql = "INSERT INTO Epidemic_Country(country, confirmed, recovered, deaths, population, sq_km_area, life_expectancy," +
                         " elevation_in_meters, continent, abbreviation, location, iso, capital_city, longitude, lat, updated)" +
                         "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection conn = null;
            PreparedStatement ptmt = null;
            try {
                //开启链接
                conn = DbUtil.getConnection();
                //利用对象给语句赋值
                ptmt = conn.prepareStatement(sql);
                ptmt.setString(1, inf.getCountry());
                ptmt.setInt(2, inf.getConfirmed());
                ptmt.setInt(3, inf.getRecovered());
                ptmt.setInt(4, inf.getDeaths());
                ptmt.setInt(5, inf.getPopulation());
                ptmt.setInt(6, inf.getSq_km_area());
                ptmt.setDouble(7, inf.getLife_expectancy());
                ptmt.setInt(8, inf.getElevation_in_meters());
                ptmt.setString(9, inf.getContinent());
                ptmt.setString(10, inf.getAbbreviation());
                ptmt.setString(11, inf.getLocation());
                ptmt.setInt(12, inf.getIso());
                ptmt.setString(13, inf.getCapital_city());
                ptmt.setDouble(14, inf.getLongitude());
                ptmt.setDouble(15, inf.getLat());
                if(inf.getUpdated()!=null) {
                    ptmt.setDate(16, new Date(inf.getUpdated().getTime()));
                }
                else {
                    ptmt.setDate(16, null);
                }
                //执行
                ptmt.execute();
                System.out.println("-------"+inf.getCountry()+"-------\nAddition is finished.");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                //关闭连接
                DbUtil.close(ptmt);
                DbUtil.close(conn);
            }
        }


        //更新语句信息-->整条更新（时间推移、信息完全更新）-->其他更细节的更新只需要改变set和where语句即可
    protected void updateEpidemic_Country(Epidemic_Country inf){
        //语句
        String sql = "UPDATE Epidemic_Country SET confirmed=?, recovered=?, deaths=?, population=?, sq_km_area=?, life_expectancy=?," +
                     "elevation_in_meters=?, continent=?, abbreviation=?, location=?, iso=?, capital_city=?,  longitude=?, lat=?, updated=? " +
                     "WHERE country=?";

        Connection conn = null;
        PreparedStatement ptmt = null;

        try {
            //开启链接
            conn = DbUtil.getConnection();
            ptmt = conn.prepareStatement(sql);
            //利用对象给语句赋值
            ptmt.setInt(1,inf.getConfirmed());
            ptmt.setInt(2,inf.getRecovered());
            ptmt.setInt(3,inf.getDeaths());
            ptmt.setInt(4,inf.getPopulation());
            ptmt.setInt(5,inf.getSq_km_area());
            ptmt.setDouble(6,inf.getLife_expectancy());
            ptmt.setInt(7,inf.getElevation_in_meters());
            ptmt.setString(8,inf.getContinent());
            ptmt.setString(9,inf.getAbbreviation());
            ptmt.setString(10,inf.getLocation());
            ptmt.setInt(11,inf.getIso());
            ptmt.setString(12,inf.getCapital_city());
            ptmt.setDouble(13,inf.getLongitude());
            ptmt.setDouble(14,inf.getLat());
            if(inf.getUpdated()!=null) {
                ptmt.setDate(15, new Date(inf.getUpdated().getTime()));
            }
            else {
                ptmt.setDate(15, null);
            }
            ptmt.setString(16,inf.getCountry());
            //执行语句
            ptmt.execute();
            System.out.println("-------"+inf.getCountry()+"-------\nUpdate is finished.");
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            DbUtil.close(ptmt);
            DbUtil.close(conn);
        }
    }

    //删除语句--整条删除 -->其他更细节的删除只需要改变delete内容和where语句即可
    protected void delEpidemic_Country(Epidemic_Country inf)throws SQLException{
            //语句
        String sql = "delete from Epidemic_Country where country=?";
        Connection conn = null;
        PreparedStatement ptmt = null;
        try {
            //开启链接
            conn = DbUtil.getConnection();
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, inf.getCountry());
            //执行
            ptmt.execute();
            System.out.println("-------"+inf.getCountry()+"-------\nDeletion is finished.");
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            DbUtil.close(ptmt);
            DbUtil.close(conn);
        }
    }

    //查询语句-->整条查询 -->其他更细节的查询只需要改变*和where语句即可
    protected List<Epidemic_Country> findEpidemic_CountryList(String country) {
            //语句
        String sql = "select * from Epidemic_Country where country=?";
        Connection conn = null;
        PreparedStatement ptmt =null;
        //用结果集来存储信息
        ResultSet rs = null;
        //创建一个集合对象用来存放查询到的数据
        List<Epidemic_Country> courseList = new ArrayList<>();
        try {
            //开启链接
            conn = DbUtil.getConnection();
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, country);
            rs = (ResultSet) ptmt.executeQuery();
            Epidemic_Country mid = new Epidemic_Country();
            while (rs.next()) {
                //给要放入结果集的对象赋值
                mid.setCountry(rs.getString("country"));
                mid.setId(rs.getInt("id"));
                mid.setConfirmed(rs.getInt("confirmed"));
                mid.setRecovered(rs.getInt("recovered"));
                mid.setDeaths(rs.getInt("deaths"));
                mid.setPopulation(rs.getInt("population"));
                mid.setSq_km_area(rs.getInt("sq_km_area"));
                mid.setLife_expectancy(rs.getDouble("life_expectancy"));
                mid.setElevation_in_meters(rs.getInt("elevation_in_meters"));
                mid.setContinent(rs.getString("continent"));
                mid.setAbbreviation(rs.getString("abbreviation"));
                mid.setLocation(rs.getString("location"));
                mid.setIso(rs.getInt("iso"));
                mid.setCapital_city(rs.getString("capital_city"));
                mid.setLongitude(rs.getDouble("longitude"));
                mid.setLat(rs.getDouble("lat"));
                mid.setUpdated(rs.getDate("updated"));
            }
            //将对象放到集合中
            courseList.add(mid);
            //打印结果
            mid.printInformation();
            System.out.println("-------"+country+"-------\nSelection is finished");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            DbUtil.close(ptmt);
            DbUtil.close(conn);
        }
        return courseList;

    }
    
}
