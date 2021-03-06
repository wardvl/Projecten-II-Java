/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.learningUtility.Reservation;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ward Vanlerberghe
 */
@Entity
@Table(name = "User")
@XmlRootElement
public class User implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "Discriminator")
    private String discriminator;
    @OneToMany(mappedBy = "userEmailAddress")
    private List<Reservation> reservationList;

    public User() {
    }

    public User(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public User(String emailAddress, String firstName, String lastName, String discriminator) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.discriminator = discriminator;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    @XmlTransient
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailAddress != null ? emailAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof String)) {
            return false;
        }
        if ((this.emailAddress == null && emailAddress != null) || (this.emailAddress != null && !this.emailAddress.equals(emailAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.User[ emailAddress=" + emailAddress + " ]";
    }
    
}
