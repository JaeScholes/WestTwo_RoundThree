import java.util.Date;

public class Epidemic_Province {
        //网页中的信息
        private int id;
        private String province;
        private String country;
        private int confirmed;
        private int recovered;
        private int deaths;
        private double lat;
        //原名是“long” 避免与类名重合 用length代替
        private double longitude;
        private Date updated;


    public Epidemic_Province(int id, String province, String country, int confirmed,
                             int recovered, int deaths, double lat,
                             double longitude, Date updated ){
        //原名是“long” 避免与类名重合 用length代替
        this.id=id;
        this.province=province;
        this.country=country;
        this.confirmed=confirmed;
        this.recovered=recovered;
        this.deaths=deaths;
        this.lat=lat;
        this.longitude = longitude;
        this.updated=updated;

    }

    public Epidemic_Province( ){
        //原名是“long” 避免与类名重合 用length代替
        this.id=0;
        this.province="";
        this.country="";
        this.confirmed=0;
        this.recovered=0;
        this.deaths=0;
        this.lat=0;
        this.longitude =0;
        this.updated=null;
    }


        //get方法
        public int getId() {
            return id;
        }
        public String getProvince(){ return province; }
        public String getCountry() {
            return country;
        }
        public int getConfirmed() {
            return confirmed;
        }
        public int getDeaths() {
            return deaths;
        }
        public double getLat() {
            return lat;
        }
        public Date getUpdated() {
            return updated;
        }
        public double getLongitude() {
            return longitude;
        }
        public int getRecovered() {
            return recovered;
        }
        //set方法
        public void setId(int id) {
               this.id = id;
        }
        public void setProvince(String province){ this.province = province; }
        public void setConfirmed(int confirmed) {
            this.confirmed = confirmed;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public void setDeaths(int deaths) {
            this.deaths = deaths;
        }
        public void setLat(double lat) {
            this.lat = lat;
        }
        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
        public void setRecovered(int recovered) {
            this.recovered = recovered;
        }
        public void setUpdated(Date updated) {
            this.updated = updated;
        }

        //判断存在
    private boolean hasId(){
        if(id!=0){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasProvince(){
        if (province!=""){
            return true;
        }
        else {
            return false;
        }
    }
    private boolean hasConfirmed(){
        if(confirmed!=0){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasCountry(){
        if(country!=""){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasDeaths(){
        if(deaths!=0){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasLat(){
        if(lat!=0){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasLongitude(){
        if(longitude !=0){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasRecovered(){
        if(recovered!=0){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasUpdated(){
        if(updated!=null){
            return true;
        }
        else{
            return false;
        }
    }

    //打印信息
    public void printInformation(){
        String information="";
        if(hasId()){
            information=information+"\nID: "+getId();
        }
        if(hasProvince()){
            information=information+"\nProvince: "+getProvince();
        }
        if(hasCountry()){
            information=information+"\nCountry: "+getCountry();
        }
        if(hasConfirmed()){
            information=information+"\nConfirmed: "+getConfirmed();
        }
        if(hasRecovered()){
            information=information+"\nRecovered: "+getRecovered();
        }
        if(hasDeaths()){
            information=information+"\nDeaths: "+getDeaths();
        }
        if(hasLat()){
            information=information+"\nLat: "+getLat();
        }
        if(hasLongitude()){
            information=information+"\nLength: "+ getLongitude();
        }
        if(hasUpdated()){
            information=information+"\nUpdated:"+getUpdated();
        }
        System.out.println(information);
    }



}
