import java.util.Date;
public class Epidemic_Country {
    //网页中的信息对应的字段
    private int id;
    private String country;
    private int confirmed;
    private int recovered;
    private int deaths;
    private int population;
    private int sq_km_area;
    private double life_expectancy;
    private int elevation_in_meters;
    private String continent;
    private String abbreviation;
    private String location;
    private int iso;
    private String capital_city;
    private double lat;
    //原名是“long” 避免与类名重合 用 longitude代替
    private double longitude;
    private Date updated;

    public Epidemic_Country(int id, String country, int confirmed, int recovered,
                            int deaths, int population, int sq_km_area, double life_expectancy,
                            int elevation_in_meters, String continent, String abbreviation,
                            String location, int iso, String capital_city, double lat,
                            double longitude, Date updated ){
        //原名是“long” 避免与类名重合 用length代替

        this.id=id;
        this.country=country;
        this.confirmed=confirmed;
        this.recovered=recovered;
        this.deaths=deaths;
        this.population=population;
        this.sq_km_area=sq_km_area;
        this.life_expectancy=life_expectancy;
        this.elevation_in_meters=elevation_in_meters;
        this.continent=continent;
        this.abbreviation=abbreviation;
        this.location=location;
        this.iso=iso;
        this.capital_city=capital_city;
        this.lat=lat;
        this.longitude = longitude;
        this.updated=updated;

    }
    public Epidemic_Country( ){
        //原名是“long” 避免与类名重合 用length代替
        this.id=0;
        this.country="";
        this.confirmed=0;
        this.recovered=0;
        this.deaths=0;
        this.population=0;
        this.sq_km_area=0;
        this.life_expectancy=0;
        this.elevation_in_meters=0;
        this.continent="";
        this.abbreviation="";
        this.location="";
        this.iso=0;
        this.capital_city="";
        this.lat=0;
        this.longitude =0;
        this.updated=null;

    }

    //get方法
    public int getId() {
        return id;
    }
    public String getCountry() {
        return country;
    }
    public int getConfirmed() {
        return confirmed;
    }
    public double getLife_expectancy() {
        return life_expectancy;
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
    public int getElevation_in_meters() {
        return elevation_in_meters;
    }
    public int getPopulation() {
        return population;
    }
    public int getRecovered() {
        return recovered;
    }
    public int getSq_km_area() {
        return sq_km_area;
    }
    public String getAbbreviation() {
        return abbreviation;
    }
    public String getCapital_city() {
        return capital_city;
    }
    public String getContinent() {
        return continent;
    }
    public int getIso() {
        return iso;
    }
    public String getLocation() {
        return location;
    }

    //set方法
    public void setId(int id) {
        this.id = id;
    }
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public void setCapital_city(String capital_city) {
        this.capital_city = capital_city;
    }
    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
    public void setElevation_in_meters(int elevation_in_meters) {
        this.elevation_in_meters = elevation_in_meters;
    }
    public void setIso(int iso) {
        this.iso = iso;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public void setLife_expectancy(double life_expectancy) {
        this.life_expectancy = life_expectancy;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }
    public void setSq_km_area(int sq_km_area) {
        this.sq_km_area = sq_km_area;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    //判断是否为空
    private boolean hasId(){
        if(id!=0){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasAbbreviation(){
        if(abbreviation!=""){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasCapital_city(){
        if(capital_city!=""){
            return true;
        }
        else{
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
    private boolean hasContinent(){
        if(continent!=""){
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
    private boolean hasElevation_in_meters(){
        if(elevation_in_meters!=0){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasIso(){
        if(iso!=0){
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
    private boolean hasLife_expectancy(){
        if(life_expectancy!=0){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasLocation(){
        if(location!=""){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean hasPopulation(){
        if(population!=0){
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
    private boolean hasSq_km_area(){
        if(sq_km_area!=0){
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
        if(hasPopulation()){
            information=information+"\nPopulation: "+getPopulation();
        }
        if(hasSq_km_area()){
            information=information+"\nSq_km_area: "+getSq_km_area();
        }
        if(hasLife_expectancy()){
            information=information+"\nLife_expectancy: "+getLife_expectancy();
        }
        if(hasElevation_in_meters()){
            information=information+"\nElevation_in_meters: "+getElevation_in_meters();
        }
        if(hasContinent()){
            information=information+"\nContinent: "+getContinent();
        }
        if(hasAbbreviation()){
            information=information+"\nAbbreviation: "+getAbbreviation();
        }
        if(hasLocation()) {
            information = information + "\nLocation: " + getLocation();
        }
        if(hasIso()){
            information=information+"\nIso: "+getIso();
        }
        if(hasCapital_city()){
            information=information+"\nCapital_city: "+getCapital_city();
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
