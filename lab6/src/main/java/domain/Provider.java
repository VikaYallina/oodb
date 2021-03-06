package domain;

import annotation.Column;
import annotation.Entity;

@Entity
public class Provider{
    @Column
    private String companyName;
    @Column
    private String town;
    @Column
    private String email;

    public Provider(String name, String town, String email){
        this.companyName = name;
        this.email = email;
        this.town = town;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return "Provider: " + getCompanyName() +
                ", email=" + getEmail() +
                ", town=" + getTown() +
                '\n';
    }
}
