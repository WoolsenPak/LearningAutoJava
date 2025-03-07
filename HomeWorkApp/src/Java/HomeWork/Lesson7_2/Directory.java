package HomeWork.Lesson7_2;

public class Directory {
    private String address;
    private String phone;
    private String login;
    private String password;

    public Directory() {

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


    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;

    }

    public Directory[] read() {
        DataBase db = new DataBase();
        Directory[] listDirectory = db.listDirectory;
        return listDirectory;
    }

    public void write(String[] array) {
        Directory directory = new Directory();
        directory.setAddress(array[0]);
        directory.setPhone(array[1]);
        directory.setLogin(array[2]);
        directory.setPassword(array[3]);
        System.out.println("Directory Address: " + directory.getAddress()
                + "\n"+ "Directory Phone: " + directory.getPhone()
                + "\n"+ "Directory Login: " + directory.getLogin()
                + "\n"+ "Directory Password: " + directory.getPassword() );

    }

}