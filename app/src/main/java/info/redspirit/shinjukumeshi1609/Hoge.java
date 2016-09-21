package info.redspirit.shinjukumeshi1609;

/**
 * Created by rj on 16/09/21.
 */
public class Hoge {

    private int id;
    private String name;
    private String address;
    private String phone;
    private String zahyou;
    private String yosan;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getZahyou() {
        return zahyou;
    }
    public void setZahyou(String zahyou) {
        this.zahyou = zahyou;
    }
    public String getYosan() {
        return yosan;
    }
    public void setYosan(String yosan) {
        this.yosan = yosan;
    }


    public String toString() {
        return String.format("店名：%s \n住所:%s", name,address );
    }



}
