import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Epidemic_ProvinceDao {

    //建表
    protected void buildEpidemic_Province(){
        //语句
        String sql = "Create table Epidemic_Province ( id INT PRIMARY KEY AUTO_INCREMENT  ," +
                     "province VARCHAR(50) NOT NULL, country VARCHAR(50) NOT NULL,  " +
                     "confirmed INT NOT NULL,recovered INT NOT NULL, deaths INT NOT NULL," +
                     "lat DOUBLE,longitude DOUBLE, updated DATE)";
        Connection conn = null;
        PreparedStatement ptmt = null;
        try {
            //启动链接
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
    protected void addEpidemic_Province(Epidemic_Province inf){
        //语句
        String sql = "INSERT INTO Epidemic_Province(province, country, confirmed, recovered," +
                     " deaths,  longitude, lat, updated)" +
                     "values(?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement ptmt = null;

        try {
            //开启语句
            conn = DbUtil.getConnection();
            ptmt = conn.prepareStatement(sql);
            //利用对象给语句赋值
            ptmt.setString(1,inf.getProvince());
            ptmt.setString(2, inf.getCountry());
            ptmt.setInt(3, inf.getConfirmed());
            ptmt.setInt(4, inf.getRecovered());
            ptmt.setInt(5, inf.getDeaths());
            ptmt.setDouble(6, inf.getLongitude());
            ptmt.setDouble(7, inf.getLat());
            ptmt.setDate(8, new Date(inf.getUpdated().getTime()));
            //执行
            ptmt.execute();
            System.out.println("-------"+inf.getProvince()+"-------\nAddition is finished");
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

    //更新语句信息-->整条更新（时间推移、信息完全更新）-->其他更细节的更新只需要改变set和where语句即可
    protected void updateEpidemic_Province(Epidemic_Province inf){
        //语句
        String sql = "UPDATE Epidemic_Province SET country=?, confirmed=?, recovered=?,"
                     + "deaths=?, longitude=?, lat=?, updated=? WHERE province=?";

        Connection conn = null;
        PreparedStatement ptmt = null;

        try {
            //开启链接
            conn = DbUtil.getConnection();
            ptmt = conn.prepareStatement(sql);
            //利用对象给语句赋值
            ptmt.setString(1,inf.getCountry());
            ptmt.setInt(2,inf.getConfirmed());
            ptmt.setInt(3,inf.getRecovered());
            ptmt.setInt(4,inf.getDeaths());
            ptmt.setDouble(5,inf.getLongitude());
            ptmt.setDouble(6,inf.getLat());
            ptmt.setDate(7,new Date(inf.getUpdated().getTime()));
            ptmt.setString(8,inf.getProvince());
            //执行语句
            ptmt.execute();
            System.out.println("-------"+inf.getProvince()+"-------\nUpdate is finished.");
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
    protected void delEpidemic_Province(Epidemic_Province inf)throws SQLException{
        //语句
        String sql = "delete from Epidemic_Province where province=?";
        Connection conn = null;
        PreparedStatement ptmt = null;
        try {
            //开启链接
            conn = DbUtil.getConnection();
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, inf.getProvince());
            //执行
            ptmt.execute();
            System.out.println("-------"+inf.getProvince()+"-------\nDeletion is finished.");
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
    public List<Epidemic_Province> findEpidemic_ProvinceList(String province) {
        //语句
        String sql = "select * from Epidemic_Province where province=?";
        Connection conn = null;
        PreparedStatement ptmt =null;
        //用结果集来存储信息
        ResultSet rs = null;
        //创建一个集合对象用来存放查询到的数据
        List<Epidemic_Province> courseList = new ArrayList<>();
        try {
            //开启链接
            conn = DbUtil.getConnection();
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1,province);
            rs = (ResultSet) ptmt.executeQuery();
            Epidemic_Province mid = new Epidemic_Province();
            while (rs.next()) {
                //给要放入结果集的对象赋值
                mid = new Epidemic_Province();
                mid.setId(rs.getInt("id"));
                mid.setProvince(rs.getString("province"));
                mid.setCountry(rs.getString("country"));
                mid.setConfirmed(rs.getInt("confirmed"));
                mid.setRecovered(rs.getInt("recovered"));
                mid.setDeaths(rs.getInt("deaths"));
                mid.setLongitude(rs.getDouble("longitude"));
                mid.setLat(rs.getDouble("lat"));
                mid.setUpdated(rs.getDate("updated"));
                //将对象放到集合中
                courseList.add(mid);
                //打印结果
                mid.printInformation();
                System.out.println("-------"+province+"-------\nSelection is finished");
            }
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
